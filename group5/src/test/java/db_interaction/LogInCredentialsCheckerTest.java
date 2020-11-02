package db_interaction;

import org.junit.*;

import atdit1.group5.db_interaction.LogInCredentialsChecker;
import atdit1.group5.exceptions.DatabaseConnectException;
import atdit1.group5.exceptions.LoginException;
import atdit1.group5.exceptions.InternalException;

public class LogInCredentialsCheckerTest {

    @Test
    public void testIsCredentialsMatching() throws IllegalAccessException, DatabaseConnectException {
        LogInCredentialsChecker logInChecker = new LogInCredentialsChecker("max_mustermann", "passwort123");
        boolean isMatchingCredentialsTest = logInChecker.isCredentialsMatching();
        Assert.assertTrue(isMatchingCredentialsTest);
    }

    //Creates a new User and checks if the given name in the constructor is correct
    @Test
    public void testSetSessionUser() throws LoginException, DatabaseConnectException, InternalException {
        LogInCredentialsChecker logInChecker = new LogInCredentialsChecker("max_mustermann", "passwort123");
        logInChecker.setSessionUser();
        Assert.assertEquals("max_mustermann", LogInCredentialsChecker.sessionUser.getUsername());
    }

}
