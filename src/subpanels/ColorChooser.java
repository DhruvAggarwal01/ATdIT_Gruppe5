package subpanels;


import javax.swing.*;

import db_interaction.Order;

/**
 * @author Sophie Orth, Monica Alessi, Dhruv Aggarwal, Maik Fichtenkamm, Lucas
 *         Lahr
 */
public class ColorChooser {

    /**
     * passt den Hintergrund des EditOrder Panels dem Status der Bestellung an
     * 
     * @param currentOrder Auftrag für den das EditPanel geöffnet wurde
     * @param orderPanel   Panel, dessen Hintergrundfarbe geändert werden soll
     */
    public static void setPanelBackground(final Order currentOrder, final JPanel orderPanel) {

        switch (currentOrder.status) {
            case "overdue":
                orderPanel.setBackground(new java.awt.Color(252, 130, 136));
                break;
            case "atRisk":
                orderPanel.setBackground(new java.awt.Color(245, 220, 163));
                break;
            case "onTime":
                orderPanel.setBackground(new java.awt.Color(188, 234, 174));
                break;
            default:
                orderPanel.setBackground(new java.awt.Color(188, 234, 174));
                break;
        }
    }

}
