package atdit1.group5.exceptions;

import java.util.ResourceBundle;
/**
 * ist eine Beschreibung, für Exceptions, die im Zusammenhang mit dem Aufbau der
 * Navigationselemente auftreten.
 * 
 * @author Sophie Orth, Monica Alessi, Dhruv Aggarwal, Maik Fichtenkamm, Lucas
 *         Lahr
 */
public class NavItemNotFoundException extends AbstractCustomException {

    private static final long serialVersionUID = -7710856467785990920L;
    private String navItemName01, navItemName02, navItemName03;
    private ResourceBundle text;
    /**
     * initialisiert die Namen der 3-Ebenen-Navigationselemente.
     * 
     * @param navItemName01
     * @param navItemName02
     * @param navItemName03
     */
    public NavItemNotFoundException(String navItemName01, String navItemName02, String navItemName03) {
        this.text = ResourceBundle.getBundle(("i18n/logistik_panels/LogistikStrings"));
        this.navItemName01 = navItemName01;
        this.navItemName02 = navItemName02;
        this.navItemName03 = navItemName03;
    }

    /**
     * {@inheritDoc}
     * 
     * @return Exception-Nachricht
     */
    @Override
    public String getExceptionMessage() {
        return text.getString("notFoudStartmessage") + " { " + navItemName01 + " / " + navItemName02 + " / " + navItemName03
                + "} " +   text.getString("notFoudEnd_message");
    }

}