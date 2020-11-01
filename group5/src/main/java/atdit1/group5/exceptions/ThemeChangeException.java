package atdit1.group5.exceptions;

import java.util.ResourceBundle;
/**
 * ist eine Beschreibung, für Exceptions, die bei dem Einstellen des
 * Anwendungsthemes auftreten.
 * 
 * @author Sophie Orth, Monica Alessi, Dhruv Aggarwal, Maik Fichtenkamm, Lucas
 *         Lahr
 */
public class ThemeChangeException extends AbstractCustomException {

    private static final long serialVersionUID = 8451070767710884336L;
    private ResourceBundle text;
    private String exceptionMessage;

    /**
     * setzt je nach gewählter ID, die zugehörige Exception-Nachricht.
     * 
     * @param themeErrorId Theme-Error-ID
     */
    public ThemeChangeException(int themeErrorId) {
        this.text = ResourceBundle.getBundle(("i18n/logistik_panels/exceptionStrings"));
        switch (themeErrorId) {
            case 0:
                exceptionMessage = text.getString("themeChangeUnavailable_message");
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
