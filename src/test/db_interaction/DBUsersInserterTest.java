package test.db_interaction;

import java.io.IOException;

import org.junit.*;

import db_interaction.DBUsersInserter;

public class DBUsersInserterTest {

    @Before
    public void init() {
        try {
            DBUsersInserter dbUsersInserter = new DBUsersInserter("databases/USERS.xlsx");
            dbUsersInserter.applyChangedSessionUserToRow();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDidItHappen() {
    }
}
