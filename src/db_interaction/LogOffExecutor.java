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
        DBUsersInserter dbUsersInserter = new DBUsersInserter("databases/USERS.xlsx");
        dbUsersInserter.applyChangedSessionUserToRow();

        ActualApp.getAppWindow().dispose();
    }

}
