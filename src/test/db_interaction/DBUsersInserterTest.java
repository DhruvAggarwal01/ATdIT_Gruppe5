package test.db_interaction;

import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.junit.*;

import db_interaction.DBUsersExtractor;
import db_interaction.DBUsersInserter;
import db_interaction.LogInCredentialsChecker;

public class DBUsersInserterTest {

    public void executeDBUsersInserter() {
        try {
            DBUsersInserter dbUsersInserter = new DBUsersInserter("databases/USERS.xlsx");
            dbUsersInserter.applyChangedSessionUserToRow();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testUserChangesAppliedToDatabase() throws IOException { // tbd
        LogInCredentialsChecker.sessionUser.setPersonnel_id(1);
        LogInCredentialsChecker.sessionUser.setRole_id(2);
        executeDBUsersInserter();
        DBUsersExtractor dbUsersExtractor = new DBUsersExtractor("databases/temp_USERS.xlsx");
        Row row = dbUsersExtractor.usersWorkbook.getSheetAt(0).getRow(1);
        int actualRole_id = (int) row.getCell(5).getNumericCellValue();
        Assert.assertEquals("New role_id should be set in database", 2, actualRole_id);
    }
}
