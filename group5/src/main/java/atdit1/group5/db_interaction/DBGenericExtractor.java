package atdit1.group5.db_interaction;

import java.io.*;
import java.lang.reflect.Field;
import java.util.*;
import javax.swing.*;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import atdit1.group5.exceptions.DatabaseConnectException;
import atdit1.group5.exceptions.InternalException;

/**
 * stellt mehrere Filterfunktionen bereit, die das Auslesen der Daten aus der
 * Contracts-Datenbank nach bestimmten Kriterien (nach OrderID, status, etc.)
 * ermöglichen.
 * 
 * @author Sophie Orth, Monica Alessi, Dhruv Aggarwal, Maik Fichtenkamm, Lucas
 *         Lahr
 */
public class DBGenericExtractor<T> {

    public FileInputStream gensFile;
    public Workbook gensWorkbook;

    private Object object;

    /**
     * instanziiert <code>gensWorkbook</code> mit dem passenden Excel-Workbook.
     * 
     * @param excelFileName Name der Excel-Datei (bzw. Pfad dazu)
     * @throws DatabaseConnectException
     */
    public DBGenericExtractor(String excelFileName, T genericObject) throws DatabaseConnectException {
        object = genericObject;
        try {
            gensFile = new FileInputStream(excelFileName);
            gensWorkbook = new XSSFWorkbook(gensFile);
        } catch (IOException e) {
            throw new DatabaseConnectException(0);
        }
    }

    /**
     * filtert die Tupel heraus, für die das Kriterium zutrifft
     * 
     * @param columnName  Spaltenname im Excel
     * @param filterValue Wert/Objekt, nach dem in der Spalte gefiltert werden soll
     */
    public Set<T> getFilteredDBRowsToSet(String columnName, Object filterValue) {
        Set<T> filteredGens = new HashSet<T>();

        Sheet gensSheet = gensWorkbook.getSheetAt(0);
        Iterator<Row> rowIterator = gensSheet.iterator();

        try {
            while (rowIterator.hasNext()) { // iterate through all rows of the excel sheet (incl. header row)
                Row row = rowIterator.next();
                if (row.getRowNum() == 0) { // header
                    continue;
                } else if (isValueInSpecificCell(row.getRowNum(), columnName, filterValue)) {
                    T filteredGen = getRowConvertedToGen(row);
                    filteredGens.add(filteredGen); // row.getRowNum() = filteredUser.getPersonnel_id()
                }
            }
        } catch (InternalException noube) {
            JPanel exceptionPanel = noube.getExceptionPanel();
            JOptionPane.showMessageDialog(new JFrame(), exceptionPanel, "Error: " + noube.getClass(),
                    JOptionPane.ERROR_MESSAGE);
        }
        return filteredGens;
    }

    /**
     * filtert die Indizes der Tupel heraus, für die das Filterkriterium zutrifft
     * 
     * @param columnName  Spaltenname im Excel
     * @param filterValue Wert/Objekt, nach dem in der Spalte gefiltert werden soll
     */
    public Set<Integer> getFilteredRowsIndexes(String columnName, Object filterValue) {
        Set<Integer> filteredRowsIndexes = new HashSet<Integer>();

        Sheet gensSheet = gensWorkbook.getSheetAt(0);
        Iterator<Row> rowIterator = gensSheet.iterator();

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
     * überprüft, ob ein Wert/Objekt in der entsprechenden Excel-Zelle enthalten
     * ist.
     * 
     * @param rowIndex    Zeilenindex im Excel
     * @param columnName  Spaltenname im Excel
     * @param filterValue Wert/Objekt, nach dem in der Spalte gefiltert werden soll
     * @return <code>true</code>, wenn geprüfter Wert in der entsprechenden Zeile
     *         enthalten ist und v.v.
     */
    public boolean isValueInSpecificCell(int rowIndex, String columnName, Object filterValue) {
        Sheet gensSheet = gensWorkbook.getSheetAt(0);
        Row row = gensSheet.getRow(rowIndex);
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
     * wandelt eine Excel-Zeile in ein Order-Objekt um
     * 
     * @param toBeConvertedRow in Order-Objekt umzuwandelnde Zeile
     * @return entsprechende Zeile zur Excel-Zeile
     * @throws InternalException
     */
    @SuppressWarnings("unchecked")
    public T getRowConvertedToGen(Row toBeConvertedRow) throws InternalException {
        Field[] declaredFields = object.getClass().getDeclaredFields();
        Iterator<Cell> cellIterator = toBeConvertedRow.cellIterator();

        Object genObj = null;
        if (object.getClass().equals(new User().getClass())) {
            genObj = new User();
        } else if (object.getClass().equals(new Order().getClass())) {
            genObj = new Order();
        } else {
            throw new InternalException();
        }

        try {
            int i = 0;
            while (cellIterator.hasNext() && i < declaredFields.length) {
                Cell cell = cellIterator.next();
                declaredFields[i].setAccessible(true);
                switch (cell.getCellType()) {
                    case NUMERIC:
                        declaredFields[i].set(genObj, (int) cell.getNumericCellValue());
                        break;
                    case STRING:
                        declaredFields[i].set(genObj, cell.getStringCellValue());
                        break;
                    case BOOLEAN:
                        declaredFields[i].set(genObj, cell.getBooleanCellValue());
                        break;
                    default:
                        break;
                }
                i++;
            }
        } catch (IllegalAccessException iae) {
            throw new InternalException();
        }
        return (T) genObj;
    }

    /**
     * gibt den Excel-Spaltenindex zum mitgegebenen Excel-Spaltennamen zurück.
     * 
     * @param columnName Spaltenname im Excel
     * @return Excel-Spaltenindex zum mitgegebenen Excel-Spaltennamen
     */
    public int getColumnIndexToName(String columnName) {
        int columnIndex = 0;

        Sheet gensSheet = gensWorkbook.getSheetAt(0);
        Row headerRow = gensSheet.getRow(0);
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
