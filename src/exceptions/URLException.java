package exceptions;

public class URLException extends AbstractCustomException {

    private static final long serialVersionUID = -1726043633397881928L;

    private String exceptionMessage;

    public URLException(String urlString, int urlErrorId) {
        switch (urlErrorId) {
            case 0:
                exceptionMessage = "URL '" + urlString
                        + "' konnte nicht gefunden werden. Bitte überprüfen Sie auf etwaige Internetverbindungsprobleme.";
                break;
            case 1:
                exceptionMessage = "URL '" + urlString
                        + "' konnte nicht geöffnet werden. Bitte überprüfen Sie auf etwaige Probleme mit Ihrer Internet- und/oder Browser-Verbindung.";
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