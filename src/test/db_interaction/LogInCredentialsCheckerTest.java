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

    @Test
    public void testSetSessionUser() {// tbd
        LogInCredentialsChecker logInChecker = new LogInCredentialsChecker("max_mustermann", "passwort123");
        logInChecker.setSessionUser();
        Assert.assertEquals("max_mustermann", LogInCredentialsChecker.sessionUser.getUsername());
    }

    // public static void main(String[] args) {
    // LogInCredentialsChecker logInChecker = new
    // LogInCredentialsChecker("max_mustermann", "passwort123");
    // logInChecker.setSessionUser();
    // System.out.println(LogInCredentialsChecker.sessionUser.getUsername());
    // }
}
