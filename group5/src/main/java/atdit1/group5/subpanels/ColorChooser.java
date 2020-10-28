package atdit1.group5.subpanels;

import java.awt.*;
import javax.swing.*;

import atdit1.group5.db_interaction.Order;

/**
 * passt den Hintergrund des EditOrder Panels dem Status der Bestellung an.
 * 
 * @author Sophie Orth, Monica Alessi, Dhruv Aggarwal, Maik Fichtenkamm, Lucas
 *         Lahr
 */
public class ColorChooser {

    /**
     * passt den Hintergrund des EditOrder Panels dem Status der Bestellung an.
     * 
     * @param currentOrder Auftrag für den das EditPanel geöffnet wurde
     * @param orderPanel   Panel, dessen Hintergrundfarbe geändert werden soll
     */
    public static void setPanelBackground(final Order currentOrder, final JPanel orderPanel) {

        switch (currentOrder.getStatus()) {
            case "overdue":
                orderPanel.setBackground(new Color(252, 130, 136));
                break;
            case "atRisk":
                orderPanel.setBackground(new Color(245, 220, 163));
                break;
            case "onTime":
                orderPanel.setBackground(new Color(188, 234, 174));
                break;
            default:
                orderPanel.setBackground(new Color(188, 234, 174));
                break;
        }
    }

}
