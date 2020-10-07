package test.db_interaction;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.junit.*;

import db_interaction.DBUsersExtractor;
import db_interaction.User;
import exceptions.DatabaseConnectException;

public class DBUsersExtractorTest {

  //Gets the right Column to the given Name (String)
    @Test
    public void testGetColumnIndexToName() throws DatabaseConnectException {
        DBUsersExtractor dbUsersExtractor = new DBUsersExtractor("databases/USERS.xlsx");
        Assert.assertEquals(1, dbUsersExtractor.getColumnIndexToName("personnel_id"));
    }

    //Checks if a specific value is in the data base
    @Test
    public void testIsValueInSpecificCell() throws DatabaseConnectException {
        DBUsersExtractor dbUsersExtractor = new DBUsersExtractor("databases/USERS.xlsx");
        Assert.assertTrue(dbUsersExtractor.isValueInSpecificCell(2, "forename", "Max"));
    }

    //Checks if the filter for the data base is implemented correctly
    @Test
    public void testGetFilteredDBRowsToSetSingle()
            throws IllegalArgumentException, IllegalAccessException, DatabaseConnectException {
        DBUsersExtractor dbUsersExtractor = new DBUsersExtractor("databases/USERS.xlsx");
        Set<User> filteredUserSet = dbUsersExtractor.getFilteredDBRowsToSet("forename", "Laura");
        Assert.assertEquals(
                "[{personnel_id: 2 ; username: laura_koch ; forename: Laura ; surname: Koch ; street_nr: Hauptstraße 3 ; zip: 75196 ; city: Remchingen ; email: laura.koch@example.com ; password: passwort123 ; role_id: 1 ; isLoggedIn: false}]",
                Arrays.toString(filteredUserSet.toArray()));
    }

    @Test
    public void testGetFilteredDBRowsToSetPlural()
            throws IllegalArgumentException, IllegalAccessException, DatabaseConnectException {
        DBUsersExtractor dbUsersExtractor = new DBUsersExtractor("databases/USERS.xlsx");
        Set<User> filteredUserSet = dbUsersExtractor.getFilteredDBRowsToSet("forename", "Max");
        Assert.assertEquals(
                "[{personnel_id: 1 ; username: max_mustermann ; forename: Max ; surname: Mustermann ; street_nr: Musterstraße 5 ; zip: 77777 ; city: Musterstadt ; email: max.mustermann@example.com ; password: passwort123 ; role_id: 1 ; isLoggedIn: false}, {personnel_id: 3 ; username: max_schmidt ; forename: Max ; surname: Schmidt ; street_nr: Schillerstraße 6 ; zip: 68549 ; city: Ilvesheim ; email: max.schmidt@example.com ; password: passwort123 ; role_id: 1 ; isLoggedIn: false}]",
                Arrays.toString(filteredUserSet.toArray()));
    }

    @Test
    public void testgetFilteredRowsIndexes()
            throws IllegalArgumentException, IllegalAccessException, DatabaseConnectException {
        DBUsersExtractor dbUsersExtractor = new DBUsersExtractor("databases/USERS.xlsx");
        Set<Integer> filteredUserSet = dbUsersExtractor.getFilteredRowsIndexes("username", "max_mustermann");
        Iterator<Integer> setOfRowsIterator = filteredUserSet.iterator();
        while (setOfRowsIterator.hasNext()) {
            // System.out.println(setOfRowsIterator.next().intValue());
        }

    }

    @Test
    public void testGetRowConvertedToUser()
            throws DatabaseConnectException, IllegalArgumentException, IllegalAccessException {
        DBUsersExtractor dbUsersExtractor = new DBUsersExtractor("databases/USERS.xlsx");
        Sheet usersSheet = dbUsersExtractor.usersWorkbook.getSheetAt(0);
        Row row = usersSheet.getRow(1);
        Assert.assertEquals(
                "[{personnel_id: 1 ; username: max_mustermann ; forename: Max ; surname: Mustermann ; street_nr: Musterstraße 5 ; zip: 77777 ; city: Musterstadt ; email: max.mustermann@example.com ; password: passwort123 ; role_id: 1 ; isLoggedIn: false}]",
                dbUsersExtractor.getRowConvertedToUser(row).toString());
    }

}
