package db_interaction;

import java.io.*;
import java.lang.reflect.Field;
import java.util.*;

import org.apache.poi.ss.usermodel.*;

import exceptions.DatabaseConnectException;
import exceptions.NoneOfUsersBusinessException;

/**
 * Diese Klasse ist zum Einlesen der Daten aus der Applikation da und verändert
 * dementsprechend die betroffenen Felder in der Users-Datenbank.
 * 
 * @author Sophie Orth, Monica Alessi, Dhruv Aggarwal, Maik Fichtenkamm, Lucas
 *         Lahr
 */
public class DBUsersInserter {

    private String excelFileName;

    public FileOutputStream usersFileOut;
    public Workbook usersWorkbook;

    /**
     * 
     * @param excelFileName
     */
    public DBUsersInserter(String excelFileName) {
        this.excelFileName = excelFileName;
    }

    /**
     * 
     * @throws DatabaseConnectException
     * @throws NoneOfUsersBusinessException
     */
    public void applyChangedSessionUserToRow() throws DatabaseConnectException, NoneOfUsersBusinessException {
        try {
            DBUsersExtractor dbUsersExtractor = new DBUsersExtractor(excelFileName);
            Set<Integer> rowIndexesContainingPersonnel_id = dbUsersExtractor.getFilteredRowsIndexes("personnel_id",
                    LogInCredentialsChecker.sessionUser.getPersonnel_id());

            User user = new User();

            if (rowIndexesContainingPersonnel_id.size() == 1) {
                Iterator<Integer> setOfRowsIterator = rowIndexesContainingPersonnel_id.iterator();
                Row sessionUserRowBefore = dbUsersExtractor.usersWorkbook.getSheetAt(0)
                        .getRow(setOfRowsIterator.next());
                Iterator<Cell> cellIterator = sessionUserRowBefore.cellIterator();

                Field[] declaredFields = user.getClass().getDeclaredFields();
                int i = 0;
                while (cellIterator.hasNext() && i < declaredFields.length) {
                    Cell cell = cellIterator.next();
                    declaredFields[i].setAccessible(true);
                    switch (cell.getCellType()) {
                        case NUMERIC:
                            cell.setCellValue((int) declaredFields[i].get(user));
                            break;
                        case STRING:
                            cell.setCellValue((String) declaredFields[i].get(user));
                            break;
                        case BOOLEAN:
                            cell.setCellValue((boolean) declaredFields[i].get(user));
                            break;
                        default:
                            break;
                    }
                    i++;
                }
            }
            FileOutputStream outFile = new FileOutputStream("databases/temp_USERS.xlsx"); // Änderungen nur temporär
            dbUsersExtractor.usersWorkbook.write(outFile);
            outFile.close();
            dbUsersExtractor.usersWorkbook.close();
        } catch (IllegalAccessException iae) {
            throw new NoneOfUsersBusinessException();
        } catch (IOException ioe) {
            throw new DatabaseConnectException(1);
        }
    }

}