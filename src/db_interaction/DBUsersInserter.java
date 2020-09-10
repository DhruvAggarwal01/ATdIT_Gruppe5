package db_interaction;

import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;

/**
 * Diese Klasse ist zum Einlesen der Daten aus der Applikation da und verändert
 * dementsprechend die betroffenen Felder in der Users-Datenbank.
 */
public class DBUsersInserter {

    private String excelFileName;

    public FileOutputStream usersFileOut;
    public Workbook usersWorkbook;

    public DBUsersInserter(String excelFileName) throws IOException {
        this.excelFileName = excelFileName;
    }

    public void applyChangedSessionUserToRow() {
        try {
            DBUsersExtractor dbUsersExtractor = new DBUsersExtractor(excelFileName);
            Set<Integer> rowIndexesContainingPersonnel_id = dbUsersExtractor.getFilteredRowsIndexes("personnel_id",
                    User.personnel_id);

            User user = new User();

            if (rowIndexesContainingPersonnel_id.size() == 1) {
                Iterator<Integer> setOfRowsIterator = rowIndexesContainingPersonnel_id.iterator();
                Row sessionUserRowBefore = dbUsersExtractor.usersWorkbook.getSheetAt(0)
                        .getRow(setOfRowsIterator.next());
                Iterator<Cell> cellIterator = sessionUserRowBefore.cellIterator();

                Field[] declaredFields = user.getClass().getDeclaredFields();
                int i = 0;
                while (cellIterator.hasNext() && i < declaredFields.length) {
                    Cell cell = cellIterator.next();
                    switch (cell.getCellType()) {
                        case NUMERIC:
                            cell.setCellValue((int) declaredFields[i].get(user));
                            break;
                        case STRING:
                            cell.setCellValue((String) declaredFields[i].get(user));
                            break;
                        case BOOLEAN:
                            cell.setCellValue((boolean) declaredFields[i].get(user));
                            break;
                        default:
                            break;
                    }
                    i++;
                }
            }
            FileOutputStream outFile = new FileOutputStream("databases/temp_USERS.xlsx"); // Änderungen nur temporär
            dbUsersExtractor.usersWorkbook.write(outFile);
            outFile.close();
            dbUsersExtractor.usersWorkbook.close();
        } catch (IllegalArgumentException | IllegalAccessException | IOException e) {
            e.printStackTrace();
        }
    }

}