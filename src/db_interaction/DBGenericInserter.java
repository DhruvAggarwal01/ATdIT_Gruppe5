package db_interaction;

import java.io.*;
import java.lang.reflect.Field;
import java.util.*;

import org.apache.poi.ss.usermodel.*;

import exceptions.DatabaseConnectException;
import exceptions.NoneOfUsersBusinessException;

/**
 * Diese Klasse ist zum Einlesen der Daten aus der Applikation da und verändert
 * dementsprechend die betroffenen Felder in der Contracts-Datenbank.
 * 
 * @author Sophie Orth, Monica Alessi, Dhruv Aggarwal, Maik Fichtenkamm, Lucas
 *         Lahr
 */
public class DBGenericInserter<T> {

    private String excelFileName;
    private Object object;

    Set<Integer> rowIndexesContainingGeneric_Id;

    /**
     * tbd
     * 
     * @param excelFileName
     * @param genericObject
     */
    public DBGenericInserter(String excelFileName, T genericObject) {
        this.excelFileName = excelFileName;
        object = genericObject;
    }

    /**
     * Diese Methode ändert die jeweilig, geänderten Einträge in der Datenbank.
     * 
     * @param columnName    Spaltenname im Excel
     * @param filterValue   Wert, nach dem in der Spalte gefiltert werden soll
     * @param genericObject Objekt, auf dessen Felder die Zeilenelemente angewandet
     *                      werden
     * @throws DatabaseConnectException
     * @throws NoneOfUsersBusinessException
     */
    @SuppressWarnings("unchecked")
    public void applyChangedGenericToRow(String columnName, Object filterValue, Object genericObject)
            throws DatabaseConnectException, NoneOfUsersBusinessException {
        try {
            DBGenericExtractor<T> dbGensExtractor = new DBGenericExtractor<T>(excelFileName, (T) object);
            rowIndexesContainingGeneric_Id = dbGensExtractor.getFilteredRowsIndexes(columnName, filterValue);

            T gen = (T) genericObject;

            if (rowIndexesContainingGeneric_Id.size() == 1) {
                Iterator<Integer> setOfRowsIterator = rowIndexesContainingGeneric_Id.iterator();
                Row sessionUserRowBefore = dbGensExtractor.gensWorkbook.getSheetAt(0).getRow(setOfRowsIterator.next());
                Iterator<Cell> cellIterator = sessionUserRowBefore.cellIterator();

                // auf die Felder des mitgegebenen Objekts werden die dementsprechenden
                // Zeilenelemente angewandt
                Field[] declaredFields = gen.getClass().getDeclaredFields();
                int i = 0;
                while (cellIterator.hasNext() && i < declaredFields.length) {
                    Cell cell = cellIterator.next();
                    declaredFields[i].setAccessible(true);
                    switch (cell.getCellType()) {
                        case NUMERIC:
                            cell.setCellValue((int) declaredFields[i].get(gen));
                            break;
                        case STRING:
                            cell.setCellValue((String) declaredFields[i].get(gen));
                            break;
                        case BOOLEAN:
                            cell.setCellValue((boolean) declaredFields[i].get(gen));
                            break;
                        default:
                            break;
                    }
                    i++;
                }
            }
            FileOutputStream outFile = new FileOutputStream("databases/temp_USERS.xlsx");
            dbGensExtractor.gensWorkbook.write(outFile);
            outFile.close();
            dbGensExtractor.gensWorkbook.close();
        } catch (IllegalAccessException iae) {
            throw new NoneOfUsersBusinessException();
        } catch (IOException ioe) {
            throw new DatabaseConnectException(1);
        }
    }

}
