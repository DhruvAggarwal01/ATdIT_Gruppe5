package db_interaction;

import java.io.IOException;

import main.ActualApp;

public class LogOffExecutor {

    public void logOffAndDispose() {
        LogInCredentialsChecker.sessionUser.setIsLoggedIn(false);
        try {
            DBUsersInserter dbUsersInserter = new DBUsersInserter("databases/USERS.xlsx");
            dbUsersInserter.applyChangedSessionUserToRow();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        ActualApp.getAppWindow().dispose();
    }

}
