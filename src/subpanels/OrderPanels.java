package subpanels;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import main.Styles;
import main.MainPanel;
import main.NavItemPanelChooser;
import java.io.*;

import java.util.Iterator;
import java.util.Set;
import db_interaction.DBOrdersExtractor;
import db_interaction.Order;

/**

 */
public class OrderPanels extends JPanel {
    DBOrdersExtractor dbOrderExtractor;
    private static final long serialVersionUID = -7427825579667861982L;
    Order currentOrder = new Order();

    public OrderPanels(final Set<Order> orders, final String Title, final String ToolTip, final Integer rgbRed,
            final Integer rgbGreen, final Integer rgbBlue) {

        try {
            dbOrderExtractor = new DBOrdersExtractor("databases/DefaultCONTRACTS.xlsx");

        } catch (final IOException e) {
            e.printStackTrace();
        }

        this.setLayout(new GridLayout(8, 0, 10, 10));
        this.setBackground(new Color(rgbRed, rgbGreen, rgbBlue));

        final JLabel onTimeLabel = new JLabel(Title);
        onTimeLabel.setFont(Styles.SUBPANEL_TITLE_FONT2);
        onTimeLabel.setForeground(Color.BLACK);
        onTimeLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        onTimeLabel.setToolTipText(ToolTip);
        onTimeLabel.setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 0));
        onTimeLabel.addMouseListener(new MouseAdapter() {
        });
        this.add(onTimeLabel);
        final int size = orders.size();

        // anstatt 5 objekarray.length aus db
        final Iterator<Order> it = orders.iterator();
        for (int i = 0; i < size; i++) {

            currentOrder = it.next();

            final JPanel labelID = new JPanel();
            // String name = Order.order_id + "-" + Order.firm; // auslagern
            final JLabel labelID2 = new JLabel(
                    "Auftragsnummer: " + currentOrder.order_id + "  Firma: " + currentOrder.firm);

            final MouseClickListener mouseCL = new MouseClickListener();

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

    static String sourceOrder;

    public static String setOrderSource(String source) {
        return sourceOrder = source;
    }

    public static String getOrderSource() {
        return sourceOrder;
    }
}

class MouseClickListener extends MouseAdapter {

    public void changeColor(final Object a) {
        final JPanel theLabel = (JPanel) a;
        final Color color = theLabel.getBackground();
        final Integer r1 = color.getRed() + 30;
        final Integer g1 = color.getGreen() + 30;
        final Integer b1 = color.getBlue() + 30;
        theLabel.setBackground(new Color(r1, g1, b1));
    };

    public void changeColor2(final Object a) {
        final JPanel theLabel = (JPanel) a;
        final Color color = theLabel.getBackground();
        final Integer r1 = color.getRed() - 30;
        final Integer g1 = color.getGreen() - 30;
        final Integer b1 = color.getBlue() - 30;
        theLabel.setBackground(new Color(r1, g1, b1));
    };

    /**
     * Diese Methode tbd
     */
    @Override
    public void mouseClicked(final MouseEvent e) {

        e.getSource();
        final JPanel mysource = (JPanel) e.getSource();
        final JLabel myOrderID = (JLabel) mysource.getComponent(0);
        final String orderPanel = myOrderID.getText();
        OrderPanels.setOrderSource(orderPanel);
        MainPanel.getNavPane().setComponentAt(6, new NavItemPanelChooser("Logistik", "ShowOrder", null));
    }

    @Override
    public void mouseEntered(final MouseEvent e) {
        this.changeColor(e.getSource());
    }

    @Override
    public void mouseExited(final MouseEvent e) {
        this.changeColor2(e.getSource());
    }

}
