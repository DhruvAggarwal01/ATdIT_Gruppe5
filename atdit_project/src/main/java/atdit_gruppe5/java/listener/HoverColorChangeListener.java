package listener;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import main.MainPanel;
import main.NavItemPanelChooser;
import subpanels.OrderPanels;

/**
 * @author Sophie Orth, Monica Alessi, Dhruv Aggarwal, Maik Fichtenkamm, Lucas
 *         Lahr
 */
public class HoverColorChangeListener extends MouseAdapter {

    /**
     * 
     * @param a
     */
    public void changeColor(Object a) {
        JPanel theLabel = (JPanel) a;
        Color color = theLabel.getBackground();
        Integer r1 = color.getRed() + 30;
        Integer g1 = color.getGreen() + 30;
        Integer b1 = color.getBlue() + 30;
        theLabel.setBackground(new Color(r1, g1, b1));
    };

    /**
     * 
     * @param a
     */
    public void changeColorBack(Object a) {
        JPanel theLabel = (JPanel) a;
        Color color = theLabel.getBackground();
        Integer r1 = color.getRed() - 30;
        Integer g1 = color.getGreen() - 30;
        Integer b1 = color.getBlue() - 30;
        theLabel.setBackground(new Color(r1, g1, b1));
    };

    /**
     * Diese Methode
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        e.getSource();
        final JPanel mysource = (JPanel) e.getSource();
        final JLabel myOrderID = (JLabel) mysource.getComponent(0);
        final String orderPanel = myOrderID.getText();
        OrderPanels.setOrderSource(orderPanel);
        MainPanel.getNavPane().setComponentAt(6, new NavItemPanelChooser("Logistik", "ShowOrder", null));
    }

    /**
     * 
     */
    @Override
    public void mouseEntered(MouseEvent e) {
        this.changeColor(e.getSource());
    }

    /**
     * 
     */
    @Override
    public void mouseExited(MouseEvent e) {
        this.changeColorBack(e.getSource());
    }

}
