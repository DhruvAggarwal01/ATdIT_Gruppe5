package exceptions;

/**
 * @author Sophie Orth, Monica Alessi, Dhruv Aggarwal, Maik Fichtenkamm, Lucas
 *         Lahr
 */
public class NavItemNotFoundException extends AbstractCustomException {

    private static final long serialVersionUID = -7710856467785990920L;

    private String navItemName01, navItemName02, navItemName03;

    /**
     * Konstruktor
     * 
     * @param navItemName01
     * @param navItemName02
     * @param navItemName03
     */
    public NavItemNotFoundException(String navItemName01, String navItemName02, String navItemName03) {
        this.navItemName01 = navItemName01;
        this.navItemName02 = navItemName02;
        this.navItemName03 = navItemName03;
    }

    @Override
    public String getExceptionMessage() {
        return "Navigationsleisten-Element {" + navItemName01 + " / " + navItemName02 + " / " + navItemName03
                + "} wurde nicht gefunden.";
    }

}