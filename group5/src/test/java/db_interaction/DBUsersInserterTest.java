package db_interaction;

import java.io.IOException;
import org.junit.*;

import org.apache.poi.ss.usermodel.Row;

import atdit1.group5.db_interaction.DBGenericExtractor;
import atdit1.group5.db_interaction.DBGenericInserter;
import atdit1.group5.db_interaction.LogInCredentialsChecker;
import atdit1.group5.db_interaction.User;
import atdit1.group5.exceptions.DatabaseConnectException;
import atdit1.group5.exceptions.InternalException;

public class DBUsersInserterTest {

    public void executeDBUsersInserter() throws DatabaseConnectException, InternalException {
        DBGenericInserter<User> dbUsersInserter = new DBGenericInserter<User>("group5/src/main/resources/databases/DefaultUSERS.xlsx", new User());
        dbUsersInserter.applyChangedGenericToRow("personnel_id", LogInCredentialsChecker.sessionUser.getPersonnel_id(),
                new User());
    }

    @Test
    public void testUserChangesAppliedToDatabase()
            throws IOException, DatabaseConnectException, InternalException {
        LogInCredentialsChecker.sessionUser.setPersonnel_id(1);
        LogInCredentialsChecker.sessionUser.setRole_id(2);
        executeDBUsersInserter();
        DBGenericExtractor<User> dbUsersExtractor = new DBGenericExtractor<User>("group5/src/main/resources/databases/DefaultUSERS.xlsx",
                new User());
        Row row = dbUsersExtractor.gensWorkbook.getSheetAt(0).getRow(1);
        int actualRole_id = (int) row.getCell(5).getNumericCellValue();
        Assert.assertEquals("New role_id should be set in database", 2, actualRole_id);
    }
}
