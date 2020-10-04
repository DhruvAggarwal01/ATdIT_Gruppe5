package exceptions;

public class ThemeChangeException extends AbstractCustomException {

    private static final long serialVersionUID = 8451070767710884336L;

    private String exceptionMessage;

    public ThemeChangeException(int themeErrorId) {
        switch (themeErrorId) {
            case 0:
                exceptionMessage = "Nachtmodus lässt sich aktuell nicht de-/aktivieren. Bitte kontaktieren Sie Ihren Administrator für weitere Informationen.";
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
