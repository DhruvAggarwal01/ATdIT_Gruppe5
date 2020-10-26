package exceptions;

/**
 * ist eine Beschreibung, für Exceptions, die bei dem Einstellen des
 * Anwendungsthemes auftreten.
 * 
 * @author Sophie Orth, Monica Alessi, Dhruv Aggarwal, Maik Fichtenkamm, Lucas
 *         Lahr
 */
public class ThemeChangeException extends AbstractCustomException {

    private static final long serialVersionUID = 8451070767710884336L;

    private String exceptionMessage;

    /**
     * setzt je nach gewählter ID, die zugehörige Exception-Nachricht.
     * 
     * @param themeErrorId Theme-Error-ID
     */
    public ThemeChangeException(int themeErrorId) {
        switch (themeErrorId) {
            case 0:
                exceptionMessage = "Nachtmodus lässt sich aktuell nicht de-/aktivieren. Bitte kontaktieren Sie Ihren Administrator für weitere Informationen.";
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
