package test.db_interaction;

import org.junit.*;

import db_interaction.LogInCredentialsChecker;
import exceptions.LoginException;

public class LogInCredentialsCheckerTest {

    @Test
    public void testIsCredentialsMatching() {
        LogInCredentialsChecker logInChecker = new LogInCredentialsChecker("max_mustermann", "passwort123");
        boolean isMatchingCredentialsTest = logInChecker.isCredentialsMatching();
        Assert.assertTrue(isMatchingCredentialsTest);
    }

    @Test
    public void testSetSessionUser() throws LoginException {
        LogInCredentialsChecker logInChecker = new LogInCredentialsChecker("max_mustermann", "passwort123");
        logInChecker.setSessionUser();
        Assert.assertEquals("max_mustermann", LogInCredentialsChecker.sessionUser.getUsername());
    }

}
