package atdit1.group5.exceptions;

import java.util.ResourceBundle;

/**
 * beschreibt eine Exception, die geworfen werden kann, wenn ein Fehler bei der
 * Datenbank-Verbindung aufgetreten ist.
 * 
 * @author Sophie Orth, Monica Alessi, Dhruv Aggarwal, Maik Fichtenkamm, Lucas
 *         Lahr
 */
public class DatabaseConnectException extends AbstractCustomException {

    private static final long serialVersionUID = -6345279862809551814L;
    private ResourceBundle text;
    private String exceptionMessage;

    /**
     * setzt den Exception-Text in die zur Verfügung gestellten globalen Variable.
     * 
     * @param dbConnectErrorId Id des Datenbankverbindungsfehlers
     */
    public DatabaseConnectException(int dbConnectErrorId) {
        this.text = ResourceBundle.getBundle(("i18n/exceptionStrings"));
        switch (dbConnectErrorId) {
            case 0:
                exceptionMessage = text.getString("databaseNotFound_message");
                break;
            case 1:
                exceptionMessage = text.getString("databaseUnableToUpdate_message");
                break;
            case 2:
                exceptionMessage = text.getString("databaseNotAuthorized_message");
                break;
            default:
                break;
        }
    }

    /**
     * {@inheritDoc}
     * 
     * @return Exception-Nachricht
     */
    @Override
    public String getExceptionMessage() {
        return exceptionMessage;
    }

}
