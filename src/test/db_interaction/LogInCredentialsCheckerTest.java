package test.db_interaction;

import org.junit.*;

import db_interaction.LogInCredentialsChecker;

public class LogInCredentialsCheckerTest {

    @Test
    public void testIsCredentialsMatching() {
        LogInCredentialsChecker logInChecker = new LogInCredentialsChecker("max_mustermann", "passwort123");
        boolean isMatchingCredentialsTest = logInChecker.isCredentialsMatching();
        Assert.assertTrue(isMatchingCredentialsTest);
    }

    //Creates a new User and checks if the given name in the constructor is correct
    @Test
    public void testSetSessionUser() {
        LogInCredentialsChecker logInChecker = new LogInCredentialsChecker("max_mustermann", "passwort123");
        logInChecker.setSessionUser();
        Assert.assertEquals("max_mustermann", LogInCredentialsChecker.sessionUser.getUsername());
    }

}
