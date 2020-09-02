package db_interaction;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.poi.ss.usermodel.Row;

/**
 * Diese Klasse überprüft die Eingabe im Welcome-Screen
 * {@link src.WelcomeScreen} und extrahiert bei erfolgreichen LogIn-Eingaben die
 * zugehörigen User-Daten aus der Excel-Datenbank in eine SessionUser-Instanz.
 * +Ausloggen
 */
public class LogInCredentialsChecker {

    private String username, password;

    DBUsersExtractor dbUsersExtractor;
    String possibleErrorString; // eventuell im Ui slebst wie: String possibleErrorString =
                                // (logInCredentialsChecker.isCredentialsMatching() ? "Der Benutzername und/oder
                                // das Kennwort
                                // ist ungültig" : ""); jlabel.setText(possibleErrorString);
    Set<Integer> rowIndexesContainingUsername;
    Set<Integer> rowIndexesContainingPassword;

    public LogInCredentialsChecker(String username, String password) {
        this.username = username;
        this.password = password;
        try {
            dbUsersExtractor = new DBUsersExtractor("databases/Users.xlsx");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public User getLoggedInUser() {
        try {
            Set<Integer> rowIndexesMatchingCredentials = rowIndexesContainingUsername; // Umbenennung
            if (isCredentialsMatching()) { // nur ein User besitzt die geprüften Credentials
                                           // (Normalfall)
                Iterator<Integer> setOfRowsIterator = rowIndexesMatchingCredentials.iterator();
                Row sessionUserRow = dbUsersExtractor.usersWorkbook.getSheetAt(0).getRow(setOfRowsIterator.next());
                return dbUsersExtractor.getRowConvertedToUser(sessionUserRow);
            } else {
                possibleErrorString = "Der Benutzername und/oder das Kennwort ist ungültig"; // siehe Kommentar oben
                // eventuell zu löschen
                return null;
            }
        } catch (IllegalArgumentException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean isCredentialsMatching() {
        try {
            rowIndexesContainingUsername = dbUsersExtractor.getFilteredDBRowsIndexes("username", username);
            rowIndexesContainingPassword = dbUsersExtractor.getFilteredDBRowsIndexes("password", password);
        } catch (IllegalArgumentException | IllegalAccessException | IOException e) {
            e.printStackTrace();
        }
        return (rowIndexesContainingUsername.retainAll(rowIndexesContainingPassword)
                && rowIndexesContainingUsername.size() == 1);
    }

    public static void main(String[] args) {
        LogInCredentialsChecker log = new LogInCredentialsChecker("max_mustermann", "passwort123");
        System.out.println(log.getLoggedInUser());

        // System.out.println(User.username);
    }
}