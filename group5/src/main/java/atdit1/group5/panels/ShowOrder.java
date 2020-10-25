package atdit1.group5.panels;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Set;
import java.util.Iterator;

import atdit1.group5.db_interaction.DBGenericExtractor;
import atdit1.group5.db_interaction.Order;
import atdit1.group5.subpanels.OrderPanels;
import atdit1.group5.mainclasses.MainPanel;
import atdit1.group5.mainclasses.NavItemPanelChooser;
import atdit1.group5.mainclasses.Styles;

import usedstrings.LogistikStrings;
import atdit1.group5.exceptions.DatabaseConnectException;

/**
 * JPanel um das anzeigen eines Auftrags zu ermöglichen
 * 
 * @author Sophie Orth, Monica Alessi, Dhruv Aggarwal, Maik Fichtenkamm, Lucas
 *         Lahr
 */
public class ShowOrder extends JPanel {

    private static final long serialVersionUID = 1L;

    String orderSource;
    Order currentOrder = new Order();
    private JPanel showOrderPanel;

    private DBGenericExtractor<Order> dbOrderExtractor;
    Set<Order> rowCurrentOrder;

    /**
     * passt den Hintergrund des EditOrder Panels dem Status der Bestellung an
     * 
     * @param currentOrder currentOrder Auftrag für den das EditPanel geöffnet wurde
     * @param orderPanel   Panel, dessen Hintergrundfarbe geändert werden soll
     */
    public void setStatusBackground(final Order currentOrder, final JPanel showOrderPanel) {

        switch (currentOrder.getStatus()) {
            case "overdue":
                showOrderPanel.setBackground(new Color(252, 130, 136));
                break;
            case "atRisk":
                showOrderPanel.setBackground(new Color(245, 220, 163));
                break;
            case "onTime":
                showOrderPanel.setBackground(new Color(188, 234, 174));
                break;
            default:
                showOrderPanel.setBackground(new Color(188, 234, 174));
                break;
        }
    }

    /**
     * weist currentOrder den richtigen Auftrag zu
     */
    public void getCurrentOrder() {
        this.orderSource = OrderPanels.getOrderSource();
        int i = Integer.parseInt(this.orderSource.replaceAll("\\D", ""));

        try {
            dbOrderExtractor = new DBGenericExtractor<Order>(LogistikStrings.getOrdersDatabaseString(), currentOrder);
            rowCurrentOrder = dbOrderExtractor.getFilteredDBRowsToSet("order_id", i);
            final Iterator<Order> it = rowCurrentOrder.iterator();
            currentOrder = it.next();

        } catch (DatabaseConnectException dce) {
            JPanel exceptionPanel = dce.getExceptionPanel();
            JOptionPane.showMessageDialog(new JFrame(), exceptionPanel, "Error: " + dce.getClass(),
                    JOptionPane.ERROR_MESSAGE);
        }

    }

    /**
     * erstellt das Panel, und alle JLabel
     */
    public void createShowshowOrderPanel() {

        showOrderPanel = new JPanel(new GridLayout(13, 2, 10, 10));

        setStatusBackground(currentOrder, showOrderPanel);

        JLabel orderHeader = new JLabel(this.orderSource);
        orderHeader.setFont(Styles.ORDER_INFO_HEAD);
        JLabel orderStatus = new JLabel(currentOrder.getStatus());
        orderStatus.setFont(Styles.ORDER_INFO_HEAD);

        showOrderPanel.add(orderHeader);
        showOrderPanel.add(orderStatus);

        showOrderPanel.add(new JLabel(LogistikStrings.getFirmString())).setFont(Styles.ORDER_INFO);
        showOrderPanel.add(new JLabel(currentOrder.getFirm())).setFont(Styles.ORDER_INFO);

        showOrderPanel.add(new JSeparator(JSeparator.HORIZONTAL));
        showOrderPanel.add(new JSeparator(JSeparator.HORIZONTAL));

        showOrderPanel.add(new JLabel(LogistikStrings.getStoneTypeString())).setFont(Styles.ORDER_INFO);
        showOrderPanel.add(new JLabel(currentOrder.getStone_type())).setFont(Styles.ORDER_INFO);

        showOrderPanel.add(new JLabel(LogistikStrings.getAmountString())).setFont(Styles.ORDER_INFO);
        showOrderPanel.add(new JLabel(currentOrder.getAmount() + " " + LogistikStrings.getTonString()))
                .setFont(Styles.ORDER_INFO);

        showOrderPanel.add(new JLabel(LogistikStrings.getPriceString())).setFont(Styles.ORDER_INFO);
        showOrderPanel.add(new JLabel(currentOrder.getPrice() + LogistikStrings.getEuroSign()))
                .setFont(Styles.ORDER_INFO);

        showOrderPanel.add(new JSeparator(JSeparator.HORIZONTAL));
        showOrderPanel.add(new JSeparator(JSeparator.HORIZONTAL));

        showOrderPanel.add(new JLabel(LogistikStrings.getDueDateString())).setFont(Styles.ORDER_INFO);
        showOrderPanel.add(new JLabel(" " + currentOrder.getDue_date())).setFont(Styles.ORDER_INFO);

        showOrderPanel.add(new JLabel(LogistikStrings.getPhaseString())).setFont(Styles.ORDER_INFO);
        showOrderPanel.add(new JLabel(currentOrder.getPhase())).setFont(Styles.ORDER_INFO);

        showOrderPanel.add(new JLabel(LogistikStrings.getOrderDoneText())).setFont(Styles.ORDER_INFO);
        if (currentOrder.getIsDone()) {
            showOrderPanel.add(new JLabel(LogistikStrings.getOrderDoneDescription())).setFont(Styles.ORDER_INFO);
        } else {
            showOrderPanel.add(new JLabel(LogistikStrings.getOrderNotDoneDescription())).setFont(Styles.ORDER_INFO);
        }

        showOrderPanel.add(new JSeparator(JSeparator.HORIZONTAL));
        showOrderPanel.add(new JSeparator(JSeparator.HORIZONTAL));

        JButton backButton = new JButton(LogistikStrings.getBackString());
        showOrderPanel.add(backButton);
        JButton editButton = new JButton(LogistikStrings.getEditOrderText());
        showOrderPanel.add(editButton);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainPanel.getNavPane().setComponentAt(6,
                        new NavItemPanelChooser(LogistikStrings.getLogisticsString(), null, null));
                MainPanel.getNavPane().setSelectedIndex(6);
            }
        });

        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainPanel.getNavPane().setComponentAt(6, new NavItemPanelChooser(LogistikStrings.getLogisticsString(),
                        LogistikStrings.getEditOrderString(), null));
            }
        });

        showOrderPanel.add(new JLabel(LogistikStrings.getEmptyString()));
        showOrderPanel.add(new JLabel(LogistikStrings.getEmptyString()));

    }

    /**
     * Konstruktor für das ShowOrder Panel
     */
    public ShowOrder() {
        this.setLayout(new BorderLayout());
        getCurrentOrder();
        createShowshowOrderPanel();
        this.add(showOrderPanel, BorderLayout.CENTER);
    }

}