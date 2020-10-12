package exceptions;

/**
 * Diese Klasse tbd
 * 
 * @author Sophie Orth, Monica Alessi, Dhruv Aggarwal, Maik Fichtenkamm, Lucas
 *         Lahr
 */
public class LoginException extends AbstractCustomException {

    private static final long serialVersionUID = -7778912288639592607L;

    private String exceptionMessage;

    /**
     * Konstruktor
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
     * 
     */
    public String getExceptionMessage() {
        return exceptionMessage;
    }
}
