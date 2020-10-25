package exceptions;

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

    /**
     * {@inheritDoc}
     * 
     * @return Exception-Nachricht
     */
    @Override
    public String getExceptionMessage() {
        return "Es ist ein interner Fehler aufgetreten. Bitte geben Sie diesen an Ihren Administrator weiter.";
    }

}
