package test.db_interaction;

import java.io.IOException;
import org.junit.*;

import org.apache.poi.ss.usermodel.Row;

import db_interaction.DBUsersExtractor;
import db_interaction.DBUsersInserter;
import db_interaction.LogInCredentialsChecker;
import exceptions.DatabaseConnectException;
import exceptions.NoneOfUsersBusinessException;

public class DBUsersInserterTest {

    public void executeDBUsersInserter() throws DatabaseConnectException, NoneOfUsersBusinessException {
        DBUsersInserter dbUsersInserter = new DBUsersInserter("databases/USERS.xlsx");
        dbUsersInserter.applyChangedSessionUserToRow();
    }

    @Test
    public void testUserChangesAppliedToDatabase()
            throws IOException, DatabaseConnectException, NoneOfUsersBusinessException {
        LogInCredentialsChecker.sessionUser.setPersonnel_id(1);
        LogInCredentialsChecker.sessionUser.setRole_id(2);
        executeDBUsersInserter();
        DBUsersExtractor dbUsersExtractor = new DBUsersExtractor("databases/temp_USERS.xlsx");
        Row row = dbUsersExtractor.usersWorkbook.getSheetAt(0).getRow(1);
        int actualRole_id = (int) row.getCell(5).getNumericCellValue();
        Assert.assertEquals("New role_id should be set in database", 2, actualRole_id);
    }
}
