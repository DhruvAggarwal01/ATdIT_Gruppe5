package db_interaction;

import exceptions.DatabaseConnectException;
import exceptions.InternalException;
import main.ActualApp;

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
