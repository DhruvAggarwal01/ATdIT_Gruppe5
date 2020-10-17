package db_interaction;

import exceptions.DatabaseConnectException;
import exceptions.NoneOfUsersBusinessException;
import main.ActualApp;

/**
 * Diese Klasse tbd
 * 
 * @author Sophie Orth, Monica Alessi, Dhruv Aggarwal, Maik Fichtenkamm, Lucas
 *         Lahr
 */
public class LogOffExecutor {

    public void logOffAndDispose() throws DatabaseConnectException, NoneOfUsersBusinessException {
        LogInCredentialsChecker.sessionUser.setIsLoggedIn(false);
        DBGenericInserter<User> dbUsersInserter = new DBGenericInserter<User>("databases/DefaultUSERS.xlsx", new User());
        dbUsersInserter.applyChangedGenericToRow("personnel_id", LogInCredentialsChecker.sessionUser.getPersonnel_id(),
                new User());

        ActualApp.getAppWindow().dispose();
    }

}
