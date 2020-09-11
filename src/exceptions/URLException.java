package exceptions;

public class URLException extends Exception {

    private static final long serialVersionUID = 1L;

    public URLException(int urlExceptionID) {
        super();
        switch (urlExceptionID) {
            case 0:
                System.err.println("URL des Nachrichtenblogs konnte nicht angesteuert werden.");
                break;
            case 1:
                System.err.println("URL des Wetterberichts konnte nicht angesteuert werden.");
                break;
            default:
                System.err.println("URLException aufgetreten");
                break;
        }
    }
}
