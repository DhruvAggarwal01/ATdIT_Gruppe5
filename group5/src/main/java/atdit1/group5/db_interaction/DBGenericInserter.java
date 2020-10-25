package atdit1.group5.db_interaction;

import java.io.*;
import java.lang.reflect.Field;
import java.util.*;

import org.apache.poi.ss.usermodel.*;

import atdit1.group5.exceptions.DatabaseConnectException;
import atdit1.group5.exceptions.InternalException;

/**
 * ist zum Einlesen der Daten aus der Applikation da und verändert
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
     * instanziiert Objektattribute jeweils mit Excel-Dateipfad und dazugehörigen
     * Objekt zum aktuell noch generischen Objekt.
     * 
     * @param excelFileName Name der Excel-Datei (bzw. Pfad dazu)
     * @param genericObject Objekt zum aktuell noch generischen Objekt
     */
    public DBGenericInserter(String excelFileName, T genericObject) {
        this.excelFileName = excelFileName;
        object = genericObject;
    }

    /**
     * ändert die jeweilig, geänderten Einträge in der Datenbank.
     * 
     * @param columnName    Spaltenname im Excel
     * @param filterValue   Wert, nach dem in der Spalte gefiltert werden soll
     * @param genericObject Objekt, auf dessen Felder die Zeilenelemente angewandet
     *                      werden
     * @throws DatabaseConnectException
     * @throws InternalException
     */
    @SuppressWarnings("unchecked")
    public void applyChangedGenericToRow(String columnName, Object filterValue, Object genericObject)
            throws DatabaseConnectException, InternalException {
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
            FileOutputStream outFile = new FileOutputStream(excelFileName);
            dbGensExtractor.gensWorkbook.write(outFile);
            outFile.close();
            dbGensExtractor.gensWorkbook.close();
        } catch (IllegalAccessException iae) {
            throw new InternalException();
        } catch (IOException ioe) {
            throw new DatabaseConnectException(1);
        }
    }

}
