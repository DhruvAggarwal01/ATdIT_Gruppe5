package atdit1.group5.exceptions;

import java.util.ResourceBundle;

/**
 * ist eine Beschreibung für Exceptions, die auf jedenfall vom Administrator
 * behandelt werden müssen. Der Benutzer erhält nur die Anweisung den Fehler an
 * ihn weiterzuleiten.
 * 
 * @author Sophie Orth, Monica Alessi, Dhruv Aggarwal, Maik Fichtenkamm, Lucas
 *         Lahr
 */
public class InternalException extends AbstractCustomException {

    private static final long serialVersionUID = -7708693454111868203L;
    private ResourceBundle text;
    /**
     * {@inheritDoc}
     * 
     * @return Exception-Nachricht
     */
    @Override
    public String getExceptionMessage() {
        this.text = ResourceBundle.getBundle(("i18n/exceptionStrings"));
        return  text.getString("ThemeChangeUnavailable_message");
    }

}
