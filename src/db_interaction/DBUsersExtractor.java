package db_interaction;

import java.io.*;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * Diese Klasse stellt mehrere Filterfunktionen bereit, die das Auslesen der
 * Daten aus der Users-Datenbank nach bestimmten Kriterien (nach Nutzername,
 * Passwort, etc.) ermöglichen.
 */
public class DBUsersExtractor {

    // Filter-Algorithmus:
    // 1. In Zeile 1 iterieren bis Spalte personnel_id gefunden (nihct einfach
    // Spalte angeben, weil sich in der DB theoretisch die Spaltenanordnung ändern
    // kann)
    // 2. In dieser Spalte iterieren bis gesuchte personnel_id gefunden wurde
    // 3. Diese Zeile merken, dann in 1. Zeile iterieren bis Spalte password
    // gefunden (kann auch in Schritt 1 schon gemerkt werden)--> auch merken
    // 4. Mit diesen beiden Werten Passwort-Zelle von betroffenem personnel (mit
    // personnel_id) mit Passwort abgleichen

    /**
     * Diese Methode filtert die Tupel heraus, für die das Kriterium zutrifft
     * 
     * @param columnName
     * @param filterValue
     */
    public Map<Integer, User> getFilteredDBRowsToMap(String columnName, Object filterValue) throws IOException {
        FileInputStream usersFile = new FileInputStream(new File("test.xlsx"));
        try (Workbook usersWorkbook = new XSSFWorkbook(usersFile);) { // AutoClosable
            Sheet usersSheet = usersWorkbook.getSheetAt(0);

            Map<Integer, User> filteredUsers = new HashMap<Integer, User>(); // key: row index of filtered user ; User:
                                                                             // filtered user

            Iterator<Row> rowIterator = usersSheet.iterator();

            int columnIndex = 0; // getColumnIndex(columnName)

            while (rowIterator.hasNext()) { // iterate through all rows of the excel sheet (incl. header row)
                Row row = rowIterator.next();
                if (row.getRowNum() == 0) { // check on header row for param columnName and get its column index
                    Iterator<Cell> cellIterator = row.cellIterator();
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
                        if (cellValue == columnName) {
                            columnIndex = headerCell.getColumnIndex();
                        }
                    }
                } else {
                    Cell cellWithColumnIndex = row.getCell(columnIndex);
                    Object cellValue = null;
                    switch (cellWithColumnIndex.getCellType()) {
                        case NUMERIC:
                            cellValue = (int) cellWithColumnIndex.getNumericCellValue();
                            break;
                        case STRING:
                            cellValue = cellWithColumnIndex.getStringCellValue();
                            break;
                        default:
                            break;
                    }
                    if (cellValue == filterValue) {
                        // User filteredUser = getRowConvertedToUser(row);
                        // filteredUsers.put(cellWithColumnIndex.getRowIndex(), filteredUser);
                        // return filteredUsers;
                    }
                }
            }
            return null;
        }
    }

    public boolean isValueInSpecificRow(int rowIndex, String columnName, Object filterValue) { // nutzbar wenn
                                                                                               // benutzername im
                                                                                               // loginscreen überprüft
                                                                                               // wurde und man über key
                                                                                               // der hashmap in der/den
                                                                                               // Zeilen nach dem
                                                                                               // Passwort suchen will
        return false;
    }

    public int getColumnIndex(String columnName) { // if-Schleife aus erster Methode angepasst übernehmen
        return 0;
    }

    public User getRowConvertedToUser(Row toBeConvertedRow) throws IllegalArgumentException, IllegalAccessException {
        User user = new User(0, null, null, null, null, null, null, null, null, 0, false);
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

    public static void main(String[] args) {
        // DBUsersExtractor dbUsersExtractor = new DBUsersExtractor();
        try  {
            XSSFWorkbook usersWorkbook = new XSSFWorkbook("databases/Users.xlsx");
        //     // Sheet usersSheet = usersWorkbook.getSheetAt(0);
        //     // Row row = usersSheet.getRow(1);

        //     // System.out.println(dbUsersExtractor.getRowConvertedToUser(row).toString());
        }  catch (IOException e) {
            e.printStackTrace();

        }
    }
}