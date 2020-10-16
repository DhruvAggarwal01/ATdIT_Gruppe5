package db_interaction;

import javax.swing.*;

import java.io.*;
import java.lang.reflect.Field;
import java.util.*;

import org.apache.poi.ss.usermodel.*;

import panels.EditOrder;
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
    Set<Integer> rowIndexesContainingOrder_Id;

    int cellcount;

    private String excelFileName;

    public FileOutputStream usersFileOut;
    public Workbook ordersWorkbook;

    private Object object;

    /**
     * Konstruktor
     * 
     * @param excelFileName
     */
    public DBGenericInserter(String excelFileName, T genericObject) {
        this.excelFileName = excelFileName;
        object = genericObject;
    }

    /**
     * Diese Methode ändert die jeweilig, geänderten Einträge in der Datenbank.
     * 
     * @throws DatabaseConnectException
     * @throws NoneOfUsersBusinessException
     */
    public void applyChangedOrderToRow() throws DatabaseConnectException, NoneOfUsersBusinessException {
        try {
            DBOrdersExtractor dbOrdersExtractor = new DBOrdersExtractor(excelFileName);
            Set<Integer> rowIndexesContainingOrder_Id = dbOrdersExtractor.getFilteredRowsIndexes("order_id",
                    EditOrder.currentOrder.getOrder_id());

            Order order = EditOrder.currentOrder; // tbd: diesen unterschiedlichen Teil in eigene Methode auslagern und
                                                  // als Parameter verlangen

            if (rowIndexesContainingOrder_Id.size() == 1) {
                Iterator<Integer> setOfRowsIterator = rowIndexesContainingOrder_Id.iterator();
                Row sessionUserRowBefore = dbOrdersExtractor.ordersWorkbook.getSheetAt(0)
                        .getRow(setOfRowsIterator.next());
                Iterator<Cell> cellIterator = sessionUserRowBefore.cellIterator();

                // tbd:Kommentar
                Field[] declaredFields = order.getClass().getDeclaredFields();
                int i = 0;
                while (cellIterator.hasNext() && i < declaredFields.length) {
                    Cell cell = cellIterator.next();
                    declaredFields[i].setAccessible(true);
                    switch (cell.getCellType()) {
                        case NUMERIC:
                            cell.setCellValue((int) declaredFields[i].get(order));
                            break;
                        case STRING:
                            cell.setCellValue((String) declaredFields[i].get(order));
                            break;
                        case BOOLEAN:
                            cell.setCellValue((boolean) declaredFields[i].get(order));
                            break;
                        default:
                            break;
                    }
                    i++;
                }
            }
            FileOutputStream outFile = new FileOutputStream("databases/DefaultCONTRACTS.xlsx");
            dbOrdersExtractor.ordersWorkbook.write(outFile);
            outFile.close();
            dbOrdersExtractor.ordersWorkbook.close();
        } catch (IllegalAccessException iae) {
            throw new NoneOfUsersBusinessException();
        } catch (IOException ioe) {
            throw new DatabaseConnectException(1);
        }
    }

    /**
     * Diese Methode ist für das Hinzufügen eines neuen Auftrags zuständig.
     * 
     * @throws DatabaseConnectException
     * @throws NoneOfUsersBusinessException
     */
    public void addNewOrder() throws DatabaseConnectException, NoneOfUsersBusinessException {
        rowIndexesContainingOrder_Id = new HashSet<Integer>();

        try {
            DBOrdersExtractor dbOrdersExtractor = new DBOrdersExtractor(excelFileName);
            Integer number = EditOrder.currentOrder.getOrder_id(); // index is int type

            rowIndexesContainingOrder_Id.add(number);

            Order order = new Order();
            order = EditOrder.currentOrder;

            if (rowIndexesContainingOrder_Id.size() == 1) {
                Sheet worksheet = dbOrdersExtractor.ordersWorkbook.getSheetAt(0);
                int lastRow = worksheet.getLastRowNum();
                Row exampleRow = worksheet.getRow(2);
                Row row = worksheet.createRow(++lastRow);
                Iterator<Cell> cellIterator = exampleRow.cellIterator();

                Field[] declaredFields = order.getClass().getDeclaredFields();
                int i = 0;
                cellcount = 0;
                int columns = 0;
                int totalColumns = 9;
                while (cellIterator.hasNext() && i < declaredFields.length && columns <= totalColumns) {

                    Cell cell = cellIterator.next();
                    declaredFields[i].setAccessible(true);
                    switch (cell.getCellType()) {
                        case NUMERIC:
                            row.createCell(cellcount).setCellValue((int) declaredFields[i].get(order));
                            break;
                        case STRING:
                            row.createCell(cellcount).setCellValue((String) declaredFields[i].get(order));
                            break;
                        case BOOLEAN:
                            row.createCell(cellcount).setCellValue((boolean) declaredFields[i].get(order));
                            break;
                        default:
                            break;
                    }
                    i++;
                    cellcount = cellcount + 1;
                }
            }
            FileOutputStream outFile = new FileOutputStream("databases/DefaultCONTRACTS.xlsx"); // Änderungen permanent
            dbOrdersExtractor.ordersWorkbook.write(outFile);
            outFile.close();
            dbOrdersExtractor.ordersWorkbook.close();
        } catch (IllegalAccessException iae) {
            throw new NoneOfUsersBusinessException();
        } catch (IOException ioe) {
            throw new DatabaseConnectException(1);
        } catch (DatabaseConnectException dce) {
            JPanel exceptionPanel = dce.getExceptionPanel();
            JOptionPane.showMessageDialog(new JFrame(), exceptionPanel, "Error: " + dce.getClass(),
                    JOptionPane.ERROR_MESSAGE);
        }
    }

}
