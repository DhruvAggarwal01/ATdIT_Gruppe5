package test.db_interaction;

import org.junit.*;

import db_interaction.User;

public class UserTest {

    @Test
    public void testGetInitPublicStaticVariable() {
        Assert.assertEquals("", User.username);
    }

    @Test
    public void testSetAndGetPublicStaticVariable() {
        User.username = "test_testtest";
        Assert.assertEquals("test_testtest", User.username);
        User.username = ""; // zurückgesetzt zu initialem Wert
    }

    @Test
    public void testToString() {
        User user = new User();
        Assert.assertEquals(
                "{personnel_id: 0 ; username:  ; forename:  ; surname:  ; street_nr:  ; zip: 0 ; city:  ; email: ..._...@.... ; password: ********** ; role_id: 1 ; isLoggedIn: false}",
                user.toString());
    }

}
