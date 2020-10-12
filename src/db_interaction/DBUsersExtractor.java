package db_interaction;

import java.io.*;
import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import exceptions.DatabaseConnectException;

/**
 * Diese Klasse stellt mehrere Filterfunktionen bereit, die das Auslesen der
 * Daten aus der Users-Datenbank nach bestimmten Kriterien (nach Nutzername,
 * Passwort, etc.) ermöglichen.
 * 
 * @author Sophie Orth, Monica Alessi, Dhruv Aggarwal, Maik Fichtenkamm, Lucas
 *         Lahr
 */
public class DBUsersExtractor {

    public FileInputStream usersFile;
    public Workbook usersWorkbook;

    /**
     * Diser Konstruktor instanziiert <code>usersWorkbook</code> mit dem passenden
     * Excel-Workbook.
     * 
     * @param excelFileName Name der Excel-Datei
     * @throws DatabaseConnectException
     */
    public DBUsersExtractor(String excelFileName) throws DatabaseConnectException {
        try {
            usersFile = new FileInputStream(excelFileName);
            usersWorkbook = new XSSFWorkbook(usersFile);
        } catch (IOException e) {
            throw new DatabaseConnectException(0);
        }
    }

    /**
     * Diese Methode filtert die Tupel heraus, für die das Kriterium zutrifft
     * 
     * @param columnName  Spaltenname im Excel
     * @param filterValue Wert/Objekt, nach dem in der Spalte gefiltert werden soll
     * @throws IllegalAccessException
     * @throws IllegalArgumentException
     */
    public Set<User> getFilteredDBRowsToSet(String columnName, Object filterValue)
            throws IllegalArgumentException, IllegalAccessException {
        Set<User> filteredUsers = new HashSet<User>();

        Sheet usersSheet = usersWorkbook.getSheetAt(0);
        Iterator<Row> rowIterator = usersSheet.iterator();

        while (rowIterator.hasNext()) { // iterate through all rows of the excel sheet (incl. header row)
            Row row = rowIterator.next();
            if (row.getRowNum() == 0) { // header
                continue;
            } else if (isValueInSpecificCell(row.getRowNum(), columnName, filterValue)) {
                User filteredUser = getRowConvertedToUser(row);
                filteredUsers.add(filteredUser);
            }
        }
        return filteredUsers;
    }

    /**
     * Diese Methode filtert die Indizes der Tupel heraus, für die das
     * Filterkriterium zutrifft
     * 
     * @param columnName  Spaltenname im Excel
     * @param filterValue Wert/Objekt, nach dem in der Spalte gefiltert werden soll
     * @throws IllegalAccessException
     * @throws IllegalArgumentException
     */
    public Set<Integer> getFilteredRowsIndexes(String columnName, Object filterValue)
            throws IllegalArgumentException, IllegalAccessException {
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
     * Diese Methode überprüft, ob ein Wert/Objekt in der entsprechenden Excel-Zelle
     * enthalten ist.
     * 
     * @param rowIndex    Zeilenindex im Excel
     * @param columnName  Spaltenname im Excel
     * @param filterValue Wert/Objekt, nach dem in der Spalte gefiltert werden soll
     * @return <code>true</code>, wenn geprüfter Wert in der entsprechenden Zeile
     *         enthalten ist und v.v.
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
     * Diese Methode wandelt eine Excel-Zeile in ein User-Objekt um
     * 
     * @param toBeConvertedRow in User-Objekt umzuwandelnde Zeile
     * @return entsprechende Zeile zur Excel-Zeile
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     */
    public User getRowConvertedToUser(Row toBeConvertedRow) throws IllegalArgumentException, IllegalAccessException { // tbd:
                                                                                                                      // bei
                                                                                                                      // Zusammenfassuén
                                                                                                                      // von
                                                                                                                      // User/Order-Extraxtor,
                                                                                                                      // kann
                                                                                                                      // man
                                                                                                                      // hier
                                                                                                                      // statt
                                                                                                                      // User
                                                                                                                      // generische
                                                                                                                      // Klasse
                                                                                                                      // T
                                                                                                                      // verwenden
        User user = new User();
        Field[] declaredFields = user.getClass().getDeclaredFields();
        Iterator<Cell> cellIterator = toBeConvertedRow.cellIterator();

        int i = 0;
        while (cellIterator.hasNext() && i < declaredFields.length) {
            Cell cell = cellIterator.next();
            declaredFields[i].setAccessible(true);
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

    /**
     * Diese Methode gibt den Excel-Spaltenindex zum mitgegebenen Excel-Spaltennamen
     * zurück.
     * 
     * @param columnName Spaltenname im Excel
     * @return Excel-Spaltenindex zum mitgegebenen Excel-Spaltennamen
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

}