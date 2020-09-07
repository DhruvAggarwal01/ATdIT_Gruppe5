package test.db_interaction;

import org.junit.*;

import db_interaction.LogInCredentialsChecker;
import db_interaction.User;

public class LogInCredentialsCheckerTest {

    // @Test
    // public void testIsCredentialsMatching() {
    // LogInCredentialsChecker logInChecker = new
    // LogInCredentialsChecker("max_mustermann", "passwort123");
    // Assert.assertTrue(logInChecker.isCredentialsMatching());
    // }

    @Test
    public void testSetSessionUser() {// tbd
        LogInCredentialsChecker logInChecker = new LogInCredentialsChecker("max_mustermann", "passwort123");
        logInChecker.setSessionUser();
        Assert.assertEquals("max_mustermann", User.username);
    }

    // public static void main(String[] args) {
    // LogInCredentialsChecker logInChecker = new
    // LogInCredentialsChecker("max_mustermann", "passwort123");
    // logInChecker.setSessionUser();
    // System.out.println(User.username);
    // }
}
