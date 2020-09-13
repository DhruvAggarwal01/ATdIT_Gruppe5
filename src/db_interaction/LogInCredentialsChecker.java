package db_interaction;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.poi.ss.usermodel.Row;

import exceptions.LoginException;

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

    public String possibleErrorString;

    DBUsersExtractor dbUsersExtractor;
    Set<Integer> rowIndexesContainingUsername;
    Set<Integer> rowIndexesContainingPassword;
    Set<Integer> rowIndexesMatchingCredentials;
    public static User sessionUser;

    private String username, password;

    public LogInCredentialsChecker(String username, String password) {
        this.username = username;
        this.password = password;
        try {
            dbUsersExtractor = new DBUsersExtractor("databases/USERS.xlsx");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public User getLoggedInUser() {
        try {
            if (isCredentialsMatching()) {
                Iterator<Integer> setOfRowsIterator = rowIndexesMatchingCredentials.iterator();
                Row sessionUserRow = dbUsersExtractor.usersWorkbook.getSheetAt(0).getRow(setOfRowsIterator.next());

                return dbUsersExtractor.getRowConvertedToUser(sessionUserRow);
            } else {
                possibleErrorString = "Der Benutzername und/oder das Kennwort ist ungültig";
                throw new LoginException(1);
            }
        } catch (LoginException | IllegalArgumentException | IllegalAccessException e) {
        }
        return null;
    }

    public void setSessionUser() {
        sessionUser = getLoggedInUser();
    }

    public boolean isCredentialsMatching() {
        try {
            rowIndexesContainingUsername = dbUsersExtractor.getFilteredRowsIndexes("username", username);
            rowIndexesContainingPassword = dbUsersExtractor.getFilteredRowsIndexes("password", password);
        } catch (IllegalArgumentException | IllegalAccessException | IOException e) {
            e.printStackTrace();
        }
        rowIndexesContainingUsername.retainAll(rowIndexesContainingPassword);
        rowIndexesMatchingCredentials = rowIndexesContainingUsername; // Umbenennung
        return rowIndexesMatchingCredentials.size() == 1;
    }
}