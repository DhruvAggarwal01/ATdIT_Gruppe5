package db_interaction;

import javax.swing.*;
import java.util.*;

import org.apache.poi.ss.usermodel.Row;

import exceptions.DatabaseConnectException;
import exceptions.LoginException;
import exceptions.NoneOfUsersBusinessException;

/**
 * Diese Klasse überprüft die Eingabe im Welcome-Screen
 * {@link src.WelcomeScreen} und extrahiert bei erfolgreichen LogIn-Eingaben die
 * zugehörigen User-Daten aus der Excel-Datenbank in eine SessionUser-Instanz.
 * +Ausloggen
 * 
 * @author Sophie Orth, Monica Alessi, Dhruv Aggarwal, Maik Fichtenkamm, Lucas
 *         Lahr
 */
public class LogInCredentialsChecker {

    DBUsersExtractor dbUsersExtractor;
    Set<Integer> rowIndexesContainingUsername;
    Set<Integer> rowIndexesContainingPassword;
    Set<Integer> rowIndexesMatchingCredentials;
    public static User sessionUser = new User();

    private String username, password;

    /**
     * 
     */
    public LogInCredentialsChecker(String username, String password) {
        this.username = username;
        this.password = password;
        try {
            dbUsersExtractor = new DBUsersExtractor("databases/USERS.xlsx");
        } catch (DatabaseConnectException dce) {
            JPanel exceptionPanel = dce.getExceptionPanel();
            JOptionPane.showMessageDialog(new JFrame(), exceptionPanel, "Error: " + dce.getClass(),
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * 
     */
    public void setSessionUser() throws LoginException, NoneOfUsersBusinessException {
        try {
            sessionUser = getLoggedInUser();
        } catch (IllegalAccessException iae) {
            throw new NoneOfUsersBusinessException();
        }
    }

    /**
     * 
     */
    public User getLoggedInUser() throws LoginException, NoneOfUsersBusinessException, IllegalAccessException {
        if (isCredentialsMatching()) {
            Iterator<Integer> setOfRowsIterator = rowIndexesMatchingCredentials.iterator();
            Row sessionUserRow = dbUsersExtractor.usersWorkbook.getSheetAt(0).getRow(setOfRowsIterator.next());
            return dbUsersExtractor.getRowConvertedToUser(sessionUserRow);
        } else {
            throw new LoginException(1);
        }
    }

    /**
     * 
     * @return
     */
    public boolean isCredentialsMatching() throws IllegalAccessException {
        rowIndexesContainingUsername = dbUsersExtractor.getFilteredRowsIndexes("username", username);
        rowIndexesContainingPassword = dbUsersExtractor.getFilteredRowsIndexes("password", password);
        rowIndexesContainingUsername.retainAll(rowIndexesContainingPassword);
        rowIndexesMatchingCredentials = rowIndexesContainingUsername; // Umbenennung
        return rowIndexesMatchingCredentials.size() == 1;
    }
}