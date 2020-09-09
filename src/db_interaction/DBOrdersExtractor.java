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
public class DBOrdersExtractor {

    public FileInputStream usersFile;
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
    public DBOrdersExtractor(String excelFileName) throws IOException {
        usersFile = new FileInputStream(excelFileName);
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
    public Set<Order> getFilteredDBRowsToSet(String columnName, Object filterValue)
            throws IOException, IllegalArgumentException, IllegalAccessException {
        Set<Order> filteredUsers = new HashSet<Order>();

        Sheet usersSheet = usersWorkbook.getSheetAt(0);
        Iterator<Row> rowIterator = usersSheet.iterator();

        while (rowIterator.hasNext()) { // iterate through all rows of the excel sheet (incl. header row)
            Row row = rowIterator.next();
            if (row.getRowNum() == 0) { // header
                continue;
            } else if (isValueInSpecificCell(row.getRowNum(), columnName, filterValue)) {
                Order filteredUser = getRowConvertedToUser(row);
                filteredUsers.add(filteredUser); // row.getRowNum() = filteredUser.getPersonnel_id()
            }
        }
        return filteredUsers;
    }

    /**
     * Diese Methode filtert die Indizes der Tupel heraus, für die das
     * Filterkriterium zutrifft
     * 
     * @param columnName
     * @param filterValue
     * @throws IllegalAccessException
     * @throws IllegalArgumentException
     */
    public Set<Integer> getFilteredRowsIndexes(String columnName, Object filterValue)
            throws IOException, IllegalArgumentException, IllegalAccessException {
        Set<Integer> filteredRowsIndexes = new HashSet<Integer>();

        Sheet usersSheet = usersWorkbook.getSheetAt(0);
        Iterator<Row> rowIterator = usersSheet.iterator();

        while (rowIterator.hasNext()) { // iterate through all rows of the excel sheet (incl. header row)
            Row row = rowIterator.next();
            if (row.getRowNum() == 0) { // header
                continue;
            } else if (isValueInSpecificCell(row.getRowNum(), columnName, filterValue)) {
                filteredRowsIndexes.add(row.getRowNum());
            }
        }
        return filteredRowsIndexes;
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
     * @param toBeConvertedRow
     * @return
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     */
    public Order getRowConvertedToUser(Row toBeConvertedRow) throws IllegalArgumentException, IllegalAccessException {
        Order order = new Order();
        Field[] declaredFields = order.getClass().getDeclaredFields();
        Iterator<Cell> cellIterator = toBeConvertedRow.cellIterator();

        int i = 0;
        while (cellIterator.hasNext() && i < declaredFields.length) {
            Cell cell = cellIterator.next();
            switch (cell.getCellType()) {
                case NUMERIC:
                    declaredFields[i].set(order, (int) cell.getNumericCellValue());
                    break;
                case STRING:
                    declaredFields[i].set(order, cell.getStringCellValue());
                    break;
                case BOOLEAN:
                    declaredFields[i].set(order, cell.getBooleanCellValue());
                default:
                    break;
            }
            i++;
        }
        return order;
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

    // public static void main(String[] args) {
    // try {
    // DBUsersExtractor dbUsersExtractor = new
    // DBUsersExtractor("databases/USERS.xlsx");
    // // System.out.println(dbUsersExtractor.getColumnIndexToName("personnel_id"));
    // Set<User> filteredUserSet =
    // dbUsersExtractor.getFilteredDBRowsToSet("forename", "Laura");

    // System.out.println(Arrays.toString(filteredUserSet.toArray()));
    // System.out.println(User.username);

    // } catch (IOException | IllegalArgumentException | IllegalAccessException e) {
    // e.printStackTrace();
    // }
    // }

}