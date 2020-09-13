package exceptions;

/**
 * @author Sophie Orth, Monica Alessi, Dhruv Aggarwal, Maik Fichtenkamm, Lucas
 *         Lahr
 */
public class NavItemNotFoundException extends Exception {

    private static final long serialVersionUID = -6457983960357837166L;

    public NavItemNotFoundException(String navItemName01, String navItemName02, String navItemName03) {
        System.err.println("Navigationsleisten-Element {" + navItemName01 + " / " + navItemName02 + " / "
                + navItemName03 + "} wurde nicht gefunden.");
    }
}
