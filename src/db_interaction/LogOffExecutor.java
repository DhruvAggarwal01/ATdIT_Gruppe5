package db_interaction;

import exceptions.DatabaseConnectException;
import exceptions.InternalException;
import main.ActualApp;

/**
 * Diese Klasse tbd
 * 
 * @author Sophie Orth, Monica Alessi, Dhruv Aggarwal, Maik Fichtenkamm, Lucas
 *         Lahr
 */
public class LogOffExecutor {

    public void logOffAndDispose() throws DatabaseConnectException, InternalException {
        LogInCredentialsChecker.sessionUser.setIsLoggedIn(false);
        DBGenericInserter<User> dbUsersInserter = new DBGenericInserter<User>("databases/DefaultUSERS.xlsx",
                new User());
        dbUsersInserter.applyChangedGenericToRow("personnel_id", LogInCredentialsChecker.sessionUser.getPersonnel_id(),
                LogInCredentialsChecker.sessionUser);

        ActualApp.getAppWindow().dispose();
    }

}
