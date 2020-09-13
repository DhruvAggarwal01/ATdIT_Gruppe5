
package db_interaction;

import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.Set;
import java.util.HashSet;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import panels.EditOrder;

import org.apache.poi.ss.usermodel.Sheet;

/**
 * Diese Klasse ist zum Einlesen der Daten aus der Applikation da und verändert
 * dementsprechend die betroffenen Felder in der Contracts-Datenbank.
 * 
 * @author Sophie Orth, Monica Alessi, Dhruv Aggarwal, Maik Fichtenkamm, Lucas
 *         Lahr
 */
public class DBOrdersInserter {
    Set<Integer> rowIndexesContainingPersonnel_id;

    int cellcount;

    private String excelFileName;

    public FileOutputStream usersFileOut;
    public Workbook ordersWorkbook;

    /**
     * Kosntruktor
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
            Set<Integer> rowIndexesContainingPersonnel_id = dbOrdersExtractor.getFilteredRowsIndexes("order_id",
                    EditOrder.currentOrder.getOrder_id());

            Order order = new Order();
            order = EditOrder.currentOrder;

            if (rowIndexesContainingPersonnel_id.size() == 1) {
                Iterator<Integer> setOfRowsIterator = rowIndexesContainingPersonnel_id.iterator();
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

            FileOutputStream outFile = new FileOutputStream("databases/DefaultCONTRACTS.xlsx"); // Änderungen nur
                                                                                                // temporär
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
        rowIndexesContainingPersonnel_id = new HashSet<Integer>();

        try {
            DBOrdersExtractor dbOrdersExtractor = new DBOrdersExtractor(excelFileName);
            Integer number = EditOrder.currentOrder.getOrder_id(); // index is int type

            rowIndexesContainingPersonnel_id.add(number);

            Order order = new Order();
            order = EditOrder.currentOrder;

            if (rowIndexesContainingPersonnel_id.size() == 1) {
                Sheet worksheet = dbOrdersExtractor.ordersWorkbook.getSheetAt(0);
                int lastRow = worksheet.getLastRowNum();
                Row row = worksheet.createRow(++lastRow);
                Row row2 = worksheet.getRow(lastRow);
                Iterator<Cell> cellIterator = row2.cellIterator();

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
                            ;
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
