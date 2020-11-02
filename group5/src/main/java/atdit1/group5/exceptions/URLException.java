package atdit1.group5.exceptions;

import java.util.ResourceBundle;

/**
 * ist eine Beschreibung, für Exceptions, die bei dem Aufruf von URLs auftreten.
 * 
 * @author Sophie Orth, Monica Alessi, Dhruv Aggarwal, Maik Fichtenkamm, Lucas
 *         Lahr
 */
public class URLException extends AbstractCustomException {

    private static final long serialVersionUID = -1726043633397881928L;
    private ResourceBundle text;
    private String exceptionMessage;

    /**
     * setzt je nach gewählter ID, die zugehörige Exception-Nachricht mit der URL,
     * durch die diese Exception überhaupt geworfen wurde.
     * 
     * @param urlString  URL, bei der die Excpetion geworfen wurde
     * @param urlErrorId Theme-Error-ID
     */
    public URLException(String urlString, int urlErrorId) {
        this.text = ResourceBundle.getBundle(("i18n/exceptionStrings"));
        switch (urlErrorId) {
            case 0:
                exceptionMessage = "URL '" + urlString + text.getString("URLnotFound_message");
                break;
            case 1:
                exceptionMessage = "URL '" + urlString + text.getString("URLunableToOpen_message");
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