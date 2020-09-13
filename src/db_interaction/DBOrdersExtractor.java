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
 * Daten aus der Contracts-Datenbank nach bestimmten Kriterien (nach OrderID,
 * status, etc.) ermöglichen.
 * 
 * @author Sophie Orth, Monica Alessi, Dhruv Aggarwal, Maik Fichtenkamm, Lucas
 *         Lahr
 */
public class DBOrdersExtractor {

    public FileInputStream ordersFile;
    public Workbook ordersWorkbook;

    /**
     * Konstruktor
     * 
     * @param excelFileName
     * @throws IOException
     */
    public DBOrdersExtractor(String excelFileName) throws IOException {
        ordersFile = new FileInputStream(excelFileName);
        ordersWorkbook = new XSSFWorkbook(ordersFile);
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
        Set<Order> filteredOrders = new HashSet<Order>();

        Sheet ordersSheet = ordersWorkbook.getSheetAt(0);
        Iterator<Row> rowIterator = ordersSheet.iterator();

        while (rowIterator.hasNext()) { // iterate through all rows of the excel sheet (incl. header row)
            Row row = rowIterator.next();
            if (row.getRowNum() == 0) { // header
                continue;
            } else if (isValueInSpecificCell(row.getRowNum(), columnName, filterValue)) {
                Order filteredUser = getRowConvertedToUser(row);
                filteredOrders.add(filteredUser); // row.getRowNum() = filteredUser.getPersonnel_id()
            }
        }
        return filteredOrders;
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

        Sheet ordersSheet = ordersWorkbook.getSheetAt(0);
        Iterator<Row> rowIterator = ordersSheet.iterator();

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
     * Diese Methode
     * 
     * @param rowIndex
     * @param columnName
     * @param filterValue
     * @return
     */
    public boolean isValueInSpecificCell(int rowIndex, String columnName, Object filterValue) {
        Sheet ordersSheet = ordersWorkbook.getSheetAt(0);
        Row row = ordersSheet.getRow(rowIndex);
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
     * Diese Methode
     * 
     * @param toBeConvertedRow
     * @return
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     */
    public Order getRowConvertedToUser(Row toBeConvertedRow) throws IllegalArgumentException {
        Order order = new Order();
        Field[] declaredFields = order.getClass().getDeclaredFields();
        Iterator<Cell> cellIterator = toBeConvertedRow.cellIterator();

        int i = 0;
        while (cellIterator.hasNext() && i < declaredFields.length) {
            Cell cell = cellIterator.next();
            switch (cell.getCellType()) {
                case NUMERIC:
                    try {
                        declaredFields[i].set(order, (int) cell.getNumericCellValue());
                    } catch (IllegalAccessException e) {

                        e.printStackTrace();
                    }
                    break;
                case STRING:
                    try {
                        declaredFields[i].set(order, cell.getStringCellValue());
                    } catch (IllegalAccessException e) {

                        e.printStackTrace();
                    }
                    break;
                case BOOLEAN:
                    try {
                        declaredFields[i].set(order, cell.getBooleanCellValue());
                    } catch (IllegalAccessException e) {

                        e.printStackTrace();
                    }
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

        Sheet ordersSheet = ordersWorkbook.getSheetAt(0);
        Row headerRow = ordersSheet.getRow(0);
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