package test.db_interaction;

import org.junit.*;

import db_interaction.User;

public class UserTest {

    @Test
    public void testGetInitPublicStaticVariable() {
        User user = new User();
        Assert.assertEquals("", user.getUsername());
    }

    @Test
    public void testSetAndGetPublicStaticVariable() {
        User user = new User();
        user.setUsername("test_testtest");
        Assert.assertEquals("test_testtest", user.getUsername());
        user.setUsername(""); // zurückgesetzt zu initialem Wert
    }

    @Test
    public void testToString() {
        User user = new User();
        Assert.assertEquals(
                "{personnel_id: 0 ; username:  ; forename:  ; surname:  ; street_nr:  ; zip: 0 ; city:  ; email: ..._...@.... ; password: ********** ; role_id: 1 ; isLoggedIn: false}",
                user.toString());
    }

}
