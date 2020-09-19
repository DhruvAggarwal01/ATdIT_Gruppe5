package db_interaction;

import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.*;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.Sheet;

import panels.EditOrder;

/**
 * Diese Klasse ist zum Einlesen der Daten aus der Applikation da und verändert
 * dementsprechend die betroffenen Felder in der Contracts-Datenbank.
 * 
 * @author Sophie Orth, Monica Alessi, Dhruv Aggarwal, Maik Fichtenkamm, Lucas
 *         Lahr
 */
public class DBOrdersInserter {
    Set<Integer> rowIndexesContainingOrder_Id;

    int cellcount;

    private String excelFileName;

    public FileOutputStream usersFileOut;
    public Workbook ordersWorkbook;

    /**
     * Konstruktor
     * 
     * @param excelFileName
     * @throws IOException
     */
    public DBOrdersInserter(String excelFileName) throws IOException {
        this.excelFileName = excelFileName;
    }

    /**
     * Diese Methode ändert die jeweilig, geänderten Einträge in der Datenbank.
     */
    public void applyChangedOrderToRow() {
        try {
            DBOrdersExtractor dbOrdersExtractor = new DBOrdersExtractor(excelFileName);
            Set<Integer> rowIndexesContainingOrder_Id = dbOrdersExtractor.getFilteredRowsIndexes("order_id",
                    EditOrder.currentOrder.getOrder_id());

            Order order = new Order();
            order = EditOrder.currentOrder;

            if (rowIndexesContainingOrder_Id.size() == 1) {
                Iterator<Integer> setOfRowsIterator = rowIndexesContainingOrder_Id.iterator();
                Row sessionUserRowBefore = dbOrdersExtractor.ordersWorkbook.getSheetAt(0)
                        .getRow(setOfRowsIterator.next());
                Iterator<Cell> cellIterator = sessionUserRowBefore.cellIterator();

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
        } catch (IllegalArgumentException | IllegalAccessException | IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Diese Methode ist für das Hinzufügen eines neuen Auftrags zuständig.
     */
    public void addNewOrder() {
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
        } catch (IllegalArgumentException | IllegalAccessException | IOException e) {
            e.printStackTrace();
        }
    }

}
