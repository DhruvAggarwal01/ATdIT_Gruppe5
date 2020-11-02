package atdit1.group5.subpanels;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.util.ResourceBundle;

import atdit1.group5.listener.HoverColorChangeListener;
import atdit1.group5.db_interaction.DBGenericExtractor;
import atdit1.group5.db_interaction.Order;
import atdit1.group5.Styles;
import atdit1.group5.exceptions.DatabaseConnectException;

/**
 * baut ein Panel für die Aufträge der Datenbankanbindung auf
 * 
 * @author Sophie Orth, Monica Alessi, Dhruv Aggarwal, Maik Fichtenkamm, Lucas
 *         Lahr
 */
public class OrderPanels extends JPanel {

    private static final long serialVersionUID = -7427825579667861982L;
    private ResourceBundle text;

    Order currentOrder = new Order();
    DBGenericExtractor<Order> dbOrderExtractor;
    static String sourceOrder;

    /**
     * extrahiert Auftragsdaten
     * 
     * @param orders
     * @param Title
     * @param ToolTip
     * @param rgbRed
     * @param rgbGreen
     * @param rgbBlue
     */
    public OrderPanels(final Set<Order> orders, final String Title, final String ToolTip, final Integer rgbRed,
            final Integer rgbGreen, final Integer rgbBlue) {
        this.text = ResourceBundle.getBundle(("i18n/logistikStrings"));
        try {
            dbOrderExtractor = new DBGenericExtractor<Order>((text.getString("ordersDatabaseString")), currentOrder);
        } catch (DatabaseConnectException dce) {
            JPanel exceptionPanel = dce.getExceptionPanel();
            JOptionPane.showMessageDialog(new JFrame(), exceptionPanel, "Error: " + dce.getClass(),
                    JOptionPane.ERROR_MESSAGE);
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
            final JLabel labelID2 = new JLabel(text.getString("orderNumberString")+ " " + currentOrder.getOrder_id() + " " + text.getString("firmString") + " " + currentOrder.getFirm());

            final HoverColorChangeListener mouseCL = new HoverColorChangeListener();

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

    /**
     * Setter-Methode für den Auftragsquelle-Namen
     * 
     * @param source Auftragsquelle-Name
     */
    public static String setOrderSource(String source) {
        return sourceOrder = source;
    }

    /**
     * Getter-Methode für den Auftragsquelle-Namen
     * 
     * @return Auftragsquelle-Name
     */
    public static String getOrderSource() {
        return sourceOrder;
    }

}
