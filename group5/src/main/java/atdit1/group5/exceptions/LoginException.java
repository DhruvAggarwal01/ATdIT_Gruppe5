package atdit1.group5.exceptions;

/**
 * ist eine Beschreibung, für Exceptions, die im Zusammenhang mit dem
 * Login-Prozess auftreten.
 * 
 * @author Sophie Orth, Monica Alessi, Dhruv Aggarwal, Maik Fichtenkamm, Lucas
 *         Lahr
 */
public class LoginException extends AbstractCustomException {

    private static final long serialVersionUID = -7778912288639592607L;

    private String exceptionMessage;

    /**
     * setzt je nach gewählter ID, die zugehörige Exception-Nachricht.
     * 
     * @param loginErrorId Login-Error-ID
     */
    public LoginException(int loginErrorId) {
        switch (loginErrorId) {
            case 0:
                exceptionMessage = "Login ist nicht möglich.";
                break;
            case 1:
                exceptionMessage = "Der Benutzername und/oder das Kennwort ist ungültig";
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
    public String getExceptionMessage() {
        return exceptionMessage;
    }
}
