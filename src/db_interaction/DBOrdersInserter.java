
package db_interaction;

import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.Set;
import db_interaction.DBOrdersExtractor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import panels.EditOrder;

public class DBOrdersInserter {
    



    private String excelFileName;

    public FileOutputStream usersFileOut;
    public Workbook usersWorkbook;

    public DBOrdersInserter(String excelFileName) throws IOException {
        this.excelFileName = excelFileName;
    }

    public void applyChangedOrderToRow() {
        try {
            DBOrdersExtractor dbOrdersExtractor = new DBOrdersExtractor(excelFileName);
            Set<Integer> rowIndexesContainingPersonnel_id = dbOrdersExtractor.getFilteredRowsIndexes("order_id",
            EditOrder.currentOrder.getOrder_id());

            Order order = new Order();
            order = EditOrder.currentOrder;

            if (rowIndexesContainingPersonnel_id.size() == 1) {
                Iterator<Integer> setOfRowsIterator = rowIndexesContainingPersonnel_id.iterator();
                Row sessionUserRowBefore = dbOrdersExtractor.usersWorkbook.getSheetAt(0)
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
            FileOutputStream outFile = new FileOutputStream("databases/DefaultCONTRACTS.xlsx"); // Änderungen nur temporär
            dbOrdersExtractor.usersWorkbook.write(outFile);
            outFile.close();
            dbOrdersExtractor.usersWorkbook.close();
        } catch (IllegalArgumentException | IllegalAccessException | IOException e) {
            e.printStackTrace();
        }
    }

}