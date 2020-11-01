package atdit1.group5.exceptions;

import java.util.ResourceBundle;

/**
 * ist eine Beschreibung, für Exceptions, die im Zusammenhang mit dem
 * Login-Prozess auftreten.
 * 
 * @author Sophie Orth, Monica Alessi, Dhruv Aggarwal, Maik Fichtenkamm, Lucas
 *         Lahr
 */
public class LoginException extends AbstractCustomException {

    private static final long serialVersionUID = -7778912288639592607L;
    private ResourceBundle text;
    private String exceptionMessage;

    /**
     * setzt je nach gewählter ID, die zugehörige Exception-Nachricht.
     * 
     * @param loginErrorId Login-Error-ID
     */
    public LoginException(int loginErrorId) {
        switch (loginErrorId) {
            case 0:
                exceptionMessage = text.getString("LoginNotPossible_message");
                break;
            case 1:
                exceptionMessage = text.getString("loginNotValid_message");
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
