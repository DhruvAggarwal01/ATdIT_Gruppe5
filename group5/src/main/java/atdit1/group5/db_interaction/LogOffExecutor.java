package atdit1.group5.db_interaction;

import atdit1.group5.exceptions.DatabaseConnectException;
import atdit1.group5.exceptions.InternalException;
import atdit1.group5.mainclasses.ActualApp;

/**
 * dient der Ausloggen-Funktion aus der Anwendung.
 * 
 * @author Sophie Orth, Monica Alessi, Dhruv Aggarwal, Maik Fichtenkamm, Lucas
 *         Lahr
 */
public class LogOffExecutor {

    /**
     * loggt den Benutzer aus der Anwendung aus und schließt die laufende Anwendung.
     * 
     * @throws DatabaseConnectException
     * @throws InternalException
     */
    public void logOffAndDispose() throws DatabaseConnectException, InternalException {
        LogInCredentialsChecker.sessionUser.setIsLoggedIn(false);
        DBGenericInserter<User> dbUsersInserter = new DBGenericInserter<User>("databases/DefaultUSERS.xlsx",
                new User());
        dbUsersInserter.applyChangedGenericToRow("personnel_id", LogInCredentialsChecker.sessionUser.getPersonnel_id(),
                LogInCredentialsChecker.sessionUser);

        ActualApp.getAppWindow().dispose();
    }

}
