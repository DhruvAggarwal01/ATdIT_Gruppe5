package test.db_interaction;

import org.junit.*;

import db_interaction.LogInCredentialsChecker;
import exceptions.DatabaseConnectException;
import exceptions.LoginException;
import exceptions.NoneOfUsersBusinessException;

public class LogInCredentialsCheckerTest {

    @Test
    public void testIsCredentialsMatching() throws IllegalAccessException, DatabaseConnectException {
        LogInCredentialsChecker logInChecker = new LogInCredentialsChecker("max_mustermann", "passwort123");
        boolean isMatchingCredentialsTest = logInChecker.isCredentialsMatching();
        Assert.assertTrue(isMatchingCredentialsTest);
    }

    @Test
    public void testSetSessionUser() throws LoginException, DatabaseConnectException, NoneOfUsersBusinessException {
        LogInCredentialsChecker logInChecker = new LogInCredentialsChecker("max_mustermann", "passwort123");
        logInChecker.setSessionUser();
        Assert.assertEquals("max_mustermann", LogInCredentialsChecker.sessionUser.getUsername());
    }

}
