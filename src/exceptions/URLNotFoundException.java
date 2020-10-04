package exceptions;

public class URLNotFoundException extends AbstractCustomException {

    private static final long serialVersionUID = -1726043633397881928L;

    private String urlString;

    public URLNotFoundException(String urlString) {
        this.urlString = urlString;
    }

    @Override
    public String getExceptionMessage() {
        return "URL '" + urlString
                + "' konnte nicht gefunden werden. Bitte überprüfen Sie eventuell Ihre Internetverbindung.";
    }

}