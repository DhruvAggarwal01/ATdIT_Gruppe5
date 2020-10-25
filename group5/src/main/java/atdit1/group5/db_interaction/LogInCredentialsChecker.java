package atdit1.group5.db_interaction;

import javax.swing.*;
import java.util.*;

import org.apache.poi.ss.usermodel.Row;

import atdit1.group5.exceptions.DatabaseConnectException;
import atdit1.group5.exceptions.LoginException;
import atdit1.group5.exceptions.InternalException;

/**
 * überprüft die Eingabe im Welcome-Screen {@link src.WelcomeScreen} und
 * extrahiert bei erfolgreichen LogIn-Eingaben die zugehörigen User-Daten aus
 * der Excel-Datenbank in eine SessionUser-Instanz. +Ausloggen
 * 
 * @author Sophie Orth, Monica Alessi, Dhruv Aggarwal, Maik Fichtenkamm, Lucas
 *         Lahr
 */
public class LogInCredentialsChecker {

    DBGenericExtractor<User> dbUsersExtractor;
    Set<Integer> rowIndexesContainingUsername;
    Set<Integer> rowIndexesContainingPassword;
    Set<Integer> rowIndexesMatchingCredentials;

    public static User sessionUser = new User();

    private String username, password;

    /**
     * instanziiert den Datenbank-Extraktor mit dem passenden Extraktor-Objekt.
     * 
     * @param username Benutzername
     * @param password Passwort
     */
    public LogInCredentialsChecker(String username, String password) {
        this.username = username;
        this.password = password;
        try {
            dbUsersExtractor = new DBGenericExtractor<User>("databases/DefaultUSERS.xlsx", new User());
        } catch (DatabaseConnectException dce) {
            JPanel exceptionPanel = dce.getExceptionPanel();
            JOptionPane.showMessageDialog(new JFrame(), exceptionPanel, "Error: " + dce.getClass(),
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Setter-Methode für die statische SessionUser-Instanz.
     * 
     * @throws LoginException
     * @throws InternalException
     */
    public void setSessionUser() throws LoginException, InternalException {
        try {
            sessionUser = getLoggedInUser();
        } catch (IllegalAccessException iae) {
            throw new InternalException();
        }
    }

    /**
     * gibt den einzuloggenden Benutzer zurück.
     * 
     * @return einzuloggender Benutzer
     * @throws LoginException
     * @throws InternalException
     * @throws IllegalAccessException
     */
    public User getLoggedInUser() throws LoginException, InternalException, IllegalAccessException {
        if (isCredentialsMatching()) {
            Iterator<Integer> setOfRowsIterator = rowIndexesMatchingCredentials.iterator();
            Row sessionUserRow = dbUsersExtractor.gensWorkbook.getSheetAt(0).getRow(setOfRowsIterator.next());
            return dbUsersExtractor.getRowConvertedToGen(sessionUserRow);
        } else {
            throw new LoginException(1);
        }
    }

    /**
     * prüft, ob Nutzername und Passwort zueinander passen. Dabei darf ein
     * Benutzername-Passwort-Paar nur einmal in der Datenbank existieren.
     * 
     * @return <true>, wenn Nutzername und Passwort einmalig zueinander passen und
     *         vice versa
     * @throws IllegalAccessException
     */
    public boolean isCredentialsMatching() throws IllegalAccessException {
        rowIndexesContainingUsername = dbUsersExtractor.getFilteredRowsIndexes("username", username);
        rowIndexesContainingPassword = dbUsersExtractor.getFilteredRowsIndexes("password", password);
        rowIndexesContainingUsername.retainAll(rowIndexesContainingPassword);
        rowIndexesMatchingCredentials = rowIndexesContainingUsername; // Umbenennung
        return rowIndexesMatchingCredentials.size() == 1;
    }
}