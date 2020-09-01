package db_interaction;

import java.io.*;
import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * Diese Klasse stellt mehrere Filterfunktionen bereit, die das Auslesen der
 * Daten aus der Users-Datenbank nach bestimmten Kriterien (nach Nutzername,
 * Passwort, etc.) ermöglichen.
 */
public class DBUsersExtractor {

    public Workbook usersWorkbook;

    // Filter-Algorithmus:
    // 1. In Zeile 1 iterieren bis Spalte personnel_id gefunden (nihct einfach
    // Spalte angeben, weil sich in der DB theoretisch die Spaltenanordnung ändern
    // kann)
    // 2. In dieser Spalte iterieren bis gesuchte personnel_id gefunden wurde
    // 3. Diese Zeile merken, dann in 1. Zeile iterieren bis Spalte password
    // gefunden (kann auch in Schritt 1 schon gemerkt werden)--> auch merken
    // 4. Mit diesen beiden Werten Passwort-Zelle von betroffenem personnel (mit
    // personnel_id) mit Passwort abgleichen

    // isValueInSpecificCell: nutzbar, wenn username im loginscreen überprüft wurde
    // (getFilteredDBRowsToMap) und man über key der hashmap in der/den Zeilen nach
    // dem Passwort suchen will

    /**
     * 
     * @param excelFileName
     * @throws IOException
     */
    public DBUsersExtractor(String excelFileName) throws IOException {
        FileInputStream usersFile = new FileInputStream(new File(excelFileName));
        usersWorkbook = new XSSFWorkbook(usersFile);
    }

    /**
     * Diese Methode filtert die Tupel heraus, für die das Kriterium zutrifft
     * 
     * @param columnName
     * @param filterValue
     * @throws IllegalAccessException
     * @throws IllegalArgumentException
     */
    public Set<User> getFilteredDBRowsToSet(String columnName, Object filterValue)
            throws IOException, IllegalArgumentException, IllegalAccessException {
        Set<User> filteredUsers = new HashSet<User>();

        Sheet usersSheet = usersWorkbook.getSheetAt(0);
        Iterator<Row> rowIterator = usersSheet.iterator();

        while (rowIterator.hasNext()) { // iterate through all rows of the excel sheet (incl. header row)
            Row row = rowIterator.next();
            if (row.getRowNum() == 0) { // header
                continue;
            } else if (isValueInSpecificCell(row.getRowNum(), columnName, filterValue)) {
                User filteredUser = getRowConvertedToUser(row);
                filteredUsers.add(filteredUser); // row.getRowNum() = filteredUser.getPersonnel_id()
            }
        }
        return filteredUsers;
    }

    /**
     * 
     * @param rowIndex
     * @param columnName
     * @param filterValue
     * @return
     */
    public boolean isValueInSpecificCell(int rowIndex, String columnName, Object filterValue) {
        Sheet usersSheet = usersWorkbook.getSheetAt(0);
        Row row = usersSheet.getRow(rowIndex);
        Cell specificCell = row.getCell(getColumnIndexToName(columnName));
        Object cellValue = null;
        switch (specificCell.getCellType()) {
            case NUMERIC:
                cellValue = (int) specificCell.getNumericCellValue();
                break;
            case STRING:
                cellValue = specificCell.getStringCellValue();
                break;
            case BOOLEAN:
                cellValue = specificCell.getBooleanCellValue();
                break;
            default:
                break;
        }
        return filterValue.equals(cellValue);
    }

    /**
     * 
     * @param columnName
     * @return
     */
    public int getColumnIndexToName(String columnName) {
        int columnIndex = 0;

        Sheet usersSheet = usersWorkbook.getSheetAt(0);
        Row headerRow = usersSheet.getRow(0);
        Iterator<Cell> cellIterator = headerRow.cellIterator();

        while (cellIterator.hasNext()) {
            Cell headerCell = cellIterator.next();
            String cellValue = "";
            switch (headerCell.getCellType()) {
                case STRING:
                    cellValue = headerCell.getStringCellValue();
                    break;
                default:
                    break;
            }
            if (cellValue.equals(columnName)) {
                columnIndex = headerCell.getColumnIndex();
            }
        }
        return columnIndex;
    }

    /**
     * 
     * @param toBeConvertedRow
     * @return
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     */
    public User getRowConvertedToUser(Row toBeConvertedRow) throws IllegalArgumentException, IllegalAccessException {
        User user = new User(0, null, null, null, null, null, 0, null, null, 0, false);
        Field[] declaredFields = user.getClass().getDeclaredFields();
        Iterator<Cell> cellIterator = toBeConvertedRow.cellIterator();

        int i = 0;
        while (cellIterator.hasNext() && i < declaredFields.length) {
            Cell cell = cellIterator.next();
            switch (cell.getCellType()) {
                case NUMERIC:
                    declaredFields[i].set(user, (int) cell.getNumericCellValue());
                    break;
                case STRING:
                    declaredFields[i].set(user, cell.getStringCellValue());
                    break;
                case BOOLEAN:
                    declaredFields[i].set(user, cell.getBooleanCellValue());
                default:
                    break;
            }
            i++;
        }
        return user;
    }

}