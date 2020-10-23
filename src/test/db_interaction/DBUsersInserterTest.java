package test.db_interaction;

import java.io.IOException;
import org.junit.*;

import org.apache.poi.ss.usermodel.Row;

import db_interaction.DBGenericExtractor;
import db_interaction.DBGenericInserter;
import db_interaction.LogInCredentialsChecker;
import db_interaction.User;
import exceptions.DatabaseConnectException;
import exceptions.NoneOfUsersBusinessException;

public class DBUsersInserterTest {

    public void executeDBUsersInserter() throws DatabaseConnectException, NoneOfUsersBusinessException {
        DBGenericInserter<User> dbUsersInserter = new DBGenericInserter<User>("databases/DefaultUSERS.xlsx", new User());
        dbUsersInserter.applyChangedGenericToRow("personnel_id", LogInCredentialsChecker.sessionUser.getPersonnel_id(),
                new User());
    }

    @Test
    public void testUserChangesAppliedToDatabase()
            throws IOException, DatabaseConnectException, NoneOfUsersBusinessException {
        LogInCredentialsChecker.sessionUser.setPersonnel_id(1);
        LogInCredentialsChecker.sessionUser.setRole_id(2);
        executeDBUsersInserter();
        DBGenericExtractor<User> dbUsersExtractor = new DBGenericExtractor<User>("databases/DefaultUSERS.xlsx",
                new User());
        Row row = dbUsersExtractor.gensWorkbook.getSheetAt(0).getRow(1);
        int actualRole_id = (int) row.getCell(5).getNumericCellValue();
        Assert.assertEquals("New role_id should be set in database", 2, actualRole_id);
    }
}
