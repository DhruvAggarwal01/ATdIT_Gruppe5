package exceptions;

/**
 * ist eine Beschreibung, für Exceptions, die bei dem Aufruf von URLs auftreten.
 * 
 * @author Sophie Orth, Monica Alessi, Dhruv Aggarwal, Maik Fichtenkamm, Lucas
 *         Lahr
 */
public class URLException extends AbstractCustomException {

    private static final long serialVersionUID = -1726043633397881928L;

    private String exceptionMessage;

    /**
     * setzt je nach gewählter ID, die zugehörige Exception-Nachricht mit der URL,
     * durch die diese Exception überhaupt geworfen wurde.
     * 
     * @param urlString  URL, bei der die Excpetion geworfen wurde
     * @param urlErrorId Theme-Error-ID
     */
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

    /**
     * {@inheritDoc}
     * 
     * @return Nachricht-Nachricht
     */
    @Override
    public String getExceptionMessage() {
        return exceptionMessage;
    }

}