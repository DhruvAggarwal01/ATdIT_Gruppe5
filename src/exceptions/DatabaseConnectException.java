package exceptions;

public class DatabaseConnectException extends AbstractCustomException {

    private static final long serialVersionUID = -6345279862809551814L;

    private String exceptionMessage;

    public DatabaseConnectException(int dbConnectErrorId) {
        switch (dbConnectErrorId) {
            case 0:
                exceptionMessage = "Es konnte keine Verbindung zur angegebenen Datenbank hergestellt werden. Prüfen Sie, ob der angegebene Pfad korrekt ist. Wenden Sie sich ansonsten an Ihren Administrator.";
                break;
            case 1:
                exceptionMessage = "In die angegebene Datenbank konnten keine aktualisierten Daten gespeichert werden. Prüfen Sie, ob der angegebene Pfad korrekt ist. Wenden Sie sich ansonsten an Ihren Administrator.";
                break;
            case 2:
                exceptionMessage = "Sie haben keine Berechtigung, um auf die angegebene Datenbank zuzugreifen. Wenden Sie sich für weitere Informationen an Ihren Administrator.";
                break;
            default:
                break;
        }
    }

    @Override
    public String getExceptionMessage() {
        return exceptionMessage;
    }

}
