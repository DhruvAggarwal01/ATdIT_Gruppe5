package exceptions;

import java.awt.*;
import javax.swing.*;

/**
 * @author Sophie Orth, Monica Alessi, Dhruv Aggarwal, Maik Fichtenkamm, Lucas
 *         Lahr
 */
public class NavItemNotFoundException extends Exception {

    private static final long serialVersionUID = -6457983960357837166L;

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

    public String getExceptionMessage() {
        return "Navigationsleisten-Element {" + navItemName01 + " / " + navItemName02 + " / " + navItemName03
                + "} wurde nicht gefunden.";
    }

    public JPanel getExceptionPanel() {
        JPanel exceptionPanel = new JPanel(new BorderLayout());
        ImageIcon errorMsgIcon = new ImageIcon(new ImageIcon("Library/images/errorIcon.png").getImage()
                .getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH));
        exceptionPanel.add(new JLabel(getExceptionMessage(), errorMsgIcon, SwingUtilities.CENTER));
        return exceptionPanel;
    }
}
