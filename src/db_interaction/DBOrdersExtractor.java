package db_interaction;

import java.io.*;
import java.lang.reflect.Field;
import java.util.*;
import javax.swing.*;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import exceptions.DatabaseConnectException;
import exceptions.NoneOfUsersBusinessException;

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
     * Diser Konstruktor instanziiert <code>ordersWorkbook</code> mit dem passenden
     * Excel-Workbook.
     * 
     * @param excelFileName Name der Excel-Datei
     * @throws DatabaseConnectException
     */
    public DBOrdersExtractor(String excelFileName) throws DatabaseConnectException {
        try {
            ordersFile = new FileInputStream(excelFileName);
            ordersWorkbook = new XSSFWorkbook(ordersFile);
        } catch (IOException e) {
            throw new DatabaseConnectException(0);
        }
    }

    /**
     * Diese Methode filtert die Tupel heraus, für die das Kriterium zutrifft
     * 
     * @param columnName  Spaltenname im Excel
     * @param filterValue Wert/Objekt, nach dem in der Spalte gefiltert werden soll
     */
    public Set<Order> getFilteredDBRowsToSet(String columnName, Object filterValue) {
        Set<Order> filteredOrders = new HashSet<Order>();

        Sheet ordersSheet = ordersWorkbook.getSheetAt(0);
        Iterator<Row> rowIterator = ordersSheet.iterator();

        try {
            while (rowIterator.hasNext()) { // iterate through all rows of the excel sheet (incl. header row)
                Row row = rowIterator.next();
                if (row.getRowNum() == 0) { // header
                    continue;
                } else if (isValueInSpecificCell(row.getRowNum(), columnName, filterValue)) {
                    Order filteredUser = getRowConvertedToOrder(row);
                    filteredOrders.add(filteredUser); // row.getRowNum() = filteredUser.getPersonnel_id()
                }
            }
        } catch (NoneOfUsersBusinessException noube) {
            JPanel exceptionPanel = noube.getExceptionPanel();
            JOptionPane.showMessageDialog(new JFrame(), exceptionPanel, "Error: " + noube.getClass(),
                    JOptionPane.ERROR_MESSAGE);
        }
        return filteredOrders;
    }

    /**
     * Diese Methode filtert die Indizes der Tupel heraus, für die das
     * Filterkriterium zutrifft
     * 
     * @param columnName  Spaltenname im Excel
     * @param filterValue Wert/Objekt, nach dem in der Spalte gefiltert werden soll
     */
    public Set<Integer> getFilteredRowsIndexes(String columnName, Object filterValue) {
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
     * Diese Methode wandelt eine Excel-Zeile in ein Order-Objekt um
     * 
     * @param toBeConvertedRow in Order-Objekt umzuwandelnde Zeile
     * @return entsprechende Zeile zur Excel-Zeile
     * @throws NoneOfUsersBusinessException
     */
    public Order getRowConvertedToOrder(Row toBeConvertedRow) throws NoneOfUsersBusinessException {
        Order order = new Order();
        Field[] declaredFields = order.getClass().getDeclaredFields();
        Iterator<Cell> cellIterator = toBeConvertedRow.cellIterator();

        try {
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
        } catch (IllegalAccessException iae) {
            throw new NoneOfUsersBusinessException();
        }
        return order;
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