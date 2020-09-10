package subpanels;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import main.Styles;
import main.MainPanel;
import main.NavItemPanelChooser;
import java.io.*;
import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import db_interaction.DBOrdersExtractor;
import db_interaction.Order;
import java.util.Iterator;

/**

 */
public class OrderPanels extends JPanel {
    DBOrdersExtractor dbOrderExtractor;
    private static final long serialVersionUID = -7427825579667861982L;
    Order currentOrder = new Order();

    public OrderPanels(Set<Order> orders, String Title, String ToolTip, Integer rgbRed, Integer rgbGreen,
            Integer rgbBlue) {

        try {
            dbOrderExtractor = new DBOrdersExtractor("databases/DefaultCONTRACTS.xlsx");

        } catch (IOException e) {
            e.printStackTrace();
        }

        this.setLayout(new GridLayout(8, 0, 10, 10));
        this.setBackground(new Color(rgbRed, rgbGreen, rgbBlue));

        JLabel onTimeLabel = new JLabel(Title);
        onTimeLabel.setFont(Styles.SUBPANEL_TITLE_FONT2);
        onTimeLabel.setForeground(Color.BLACK);
        onTimeLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        onTimeLabel.setToolTipText(ToolTip);
        onTimeLabel.setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 0));
        onTimeLabel.addMouseListener(new MouseAdapter() {
        });
        this.add(onTimeLabel);
        int size = orders.size();

        // anstatt 5 objekarray.length aus db
        Iterator<Order> it = orders.iterator();
        for (int i = 0; i < size; i++) {

            currentOrder = it.next();

            JPanel labelID = new JPanel();
            // String name = Order.order_id + "-" + Order.firm; // auslagern
            JLabel labelID2 = new JLabel("Auftragsnummer: " + currentOrder.order_id + "  Firma: " + currentOrder.firm);

            MouseClickListener mouseCL = new MouseClickListener();

            labelID.addMouseListener(mouseCL);
            labelID.setBackground(new Color(rgbRed - 75, rgbGreen - 75, rgbBlue - 75));
            labelID.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5),
                    BorderFactory.createRaisedBevelBorder()));

            labelID.add(labelID2);

            this.add(labelID);

        }

        this.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5),
                BorderFactory.createRaisedBevelBorder()));

    }

}

class MouseClickListener extends MouseAdapter {
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
        MainPanel.getNavPane().setComponentAt(6, new NavItemPanelChooser("Logistik", "EditOrder", null));
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
