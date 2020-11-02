package atdit1.group5.db_interaction;

import javax.swing.*;
import java.io.*;
import java.lang.reflect.Field;
import java.util.*;

import org.apache.poi.ss.usermodel.*;

import atdit1.group5.panels.EditOrder;
import atdit1.group5.exceptions.DatabaseConnectException;
import atdit1.group5.exceptions.InternalException;

public class DBOrderInserter extends DBGenericInserter<Order> {

    private String excelFileName;
    private Order genericObject;

    /**
     * {@inheritDoc}
     * 
     * @param excelFileName Name der Excel-Datei (bzw. Pfad dazu)
     * @param genericObject Objekt zum aktuell noch generischen Objekt
     */
    public DBOrderInserter(String excelFileName, Order genericObject) {
        super(excelFileName, genericObject);
        this.excelFileName = excelFileName;
        this.genericObject = genericObject;
    }

    /**
     * ist für das Hinzufügen eines neuen Auftrags zuständig.
     * 
     * @throws DatabaseConnectException
     * @throws InternalException
     */
    public void addNewOrder() throws DatabaseConnectException, InternalException {
        rowIndexesContainingGeneric_Id = new HashSet<Integer>();

        try {
            DBGenericExtractor<Order> dbOrdersExtractor = new DBGenericExtractor<Order>(excelFileName, genericObject);
            Integer number = EditOrder.currentOrder.getOrder_id();

            rowIndexesContainingGeneric_Id.add(number);

            Order order = EditOrder.currentOrder;

            if (rowIndexesContainingGeneric_Id.size() == 1) {
                Sheet worksheet = dbOrdersExtractor.gensWorkbook.getSheetAt(0);
                int lastRow = worksheet.getLastRowNum();
                Row exampleRow = worksheet.getRow(2);
                Row row = worksheet.createRow(++lastRow);
                Iterator<Cell> cellIterator = exampleRow.cellIterator();

                Field[] declaredFields = order.getClass().getDeclaredFields();
                int i = 0;
                int cellcount = 0;
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
            FileOutputStream outFile = new FileOutputStream(excelFileName);
            dbOrdersExtractor.gensWorkbook.write(outFile);
            outFile.close();
            dbOrdersExtractor.gensWorkbook.close();
        } catch (IllegalAccessException iae) {
            throw new InternalException();
        } catch (IOException ioe) {
            throw new DatabaseConnectException(1);
        } catch (DatabaseConnectException dce) {
            JPanel exceptionPanel = dce.getExceptionPanel();
            JOptionPane.showMessageDialog(new JFrame(), exceptionPanel, "Error: " + dce.getClass(),
                    JOptionPane.ERROR_MESSAGE);
        }
    }

}
