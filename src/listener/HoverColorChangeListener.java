package listener;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import main.MainPanel;
import subpanels.OrderPanels;
import main.NavItemPanelChooser;

public class HoverColorChangeListener  extends MouseAdapter {
    public void changeColor(Object a) {
        JPanel theLabel = (JPanel) a;
        Color color = theLabel.getBackground();
        Integer r1 = color.getRed() + 30;
        Integer g1 = color.getGreen() + 30;
        Integer b1 = color.getBlue() + 30;
        theLabel.setBackground(new Color(r1, g1, b1));
    };

    public void changeColor2(Object a) {
        JPanel theLabel = (JPanel) a;
        Color color = theLabel.getBackground();
        Integer r1 = color.getRed() - 30;
        Integer g1 = color.getGreen() - 30;
        Integer b1 = color.getBlue() - 30;
        theLabel.setBackground(new Color(r1, g1, b1));
    };

    /**
     * Diese Methode tbd
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

    @Override
    public void mouseEntered(MouseEvent e) {
        this.changeColor(e.getSource());
    }

    @Override
    public void mouseExited(MouseEvent e) {
        this.changeColor2(e.getSource());
    }

}
