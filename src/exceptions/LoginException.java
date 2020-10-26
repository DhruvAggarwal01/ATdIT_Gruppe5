package exceptions;

/**
 * @author Sophie Orth, Monica Alessi, Dhruv Aggarwal, Maik Fichtenkamm, Lucas
 *         Lahr
 */
public class LoginException extends Exception {

    private static final long serialVersionUID = -7778912288639592607L;

    /**
     * Konstruktor
     */
    public LoginException(int loginErrorId) {
        switch (loginErrorId) {
            case 0:
                System.err.println("Login ist nicht möglich.");
                break;
            case 1:
                System.err.println("Der Benutzername und/oder das Kennwort ist ungültig");
                break;
            default:
                break;
        }
    }
}