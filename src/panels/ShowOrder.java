package panels;


import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.Set;
import java.util.Iterator;

import db_interaction.DBOrdersExtractor;
import db_interaction.Order;
import subpanels.OrderPanels;
import main.MainPanel;
import main.NavItemPanelChooser;
import main.Styles;

import usedstrings.LogistikStrings;
import exceptions.DatabaseConnectException;

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

    private DBOrdersExtractor dbOrderExtractor;
    Set<Order> rowCurrentOrder;

    /**
     * passt den Hintergrund des EditOrder Panels dem Status der Bestellung an
     * 
     * @param currentOrder currentOrder Auftrag für den das EditPanel geöffnet wurde
     * @param orderPanel   Panel, dessen Hintergrundfarbe geändert werden soll
     */
    public void setStatusBackground(final Order currentOrder, final JPanel showOrderPanel) {

        switch (currentOrder.status) {
            case "overdue":
                showOrderPanel.setBackground(new java.awt.Color(252, 130, 136));
                break;
            case "atRisk":
                showOrderPanel.setBackground(new java.awt.Color(245, 220, 163));
                break;
            case "onTime":
                showOrderPanel.setBackground(new java.awt.Color(188, 234, 174));
                break;
            default:
                showOrderPanel.setBackground(new java.awt.Color(188, 234, 174));
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
            dbOrderExtractor = new DBOrdersExtractor(LogistikStrings.getOrdersDatabaseString());
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

        showOrderPanel = new JPanel(new java.awt.GridLayout(13, 2, 10, 10));

        setStatusBackground(currentOrder, showOrderPanel);

        JLabel orderHeader = new JLabel(this.orderSource);
        orderHeader.setFont(Styles.ORDER_INFO_HEAD);
        JLabel orderStatus = new JLabel(currentOrder.status);
        orderStatus.setFont(Styles.ORDER_INFO_HEAD);

        showOrderPanel.add(orderHeader);
        showOrderPanel.add(orderStatus);

        showOrderPanel.add(new JLabel(LogistikStrings.getFirmString())).setFont(Styles.ORDER_INFO);
        showOrderPanel.add(new JLabel(currentOrder.getFirm())).setFont(Styles.ORDER_INFO);

        showOrderPanel.add(new JSeparator(JSeparator.HORIZONTAL));
        showOrderPanel.add(new JSeparator(JSeparator.HORIZONTAL));

        showOrderPanel.add(new JLabel(LogistikStrings.getStoneTypeString())).setFont(Styles.ORDER_INFO);
        showOrderPanel.add(new JLabel(currentOrder.stone_type)).setFont(Styles.ORDER_INFO);

        showOrderPanel.add(new JLabel(LogistikStrings.getAmountString())).setFont(Styles.ORDER_INFO);
        showOrderPanel.add(new JLabel(currentOrder.amount + LogistikStrings.getTonString())).setFont(Styles.ORDER_INFO);

        showOrderPanel.add(new JLabel(LogistikStrings.getPriceString())).setFont(Styles.ORDER_INFO);
        showOrderPanel.add(new JLabel(currentOrder.price + LogistikStrings.getEuroSign())).setFont(Styles.ORDER_INFO);

        showOrderPanel.add(new JSeparator(JSeparator.HORIZONTAL));
        showOrderPanel.add(new JSeparator(JSeparator.HORIZONTAL));

        showOrderPanel.add(new JLabel(LogistikStrings.getDueDateString())).setFont(Styles.ORDER_INFO);
        showOrderPanel.add(new JLabel(" " + currentOrder.due_date)).setFont(Styles.ORDER_INFO);

        showOrderPanel.add(new JLabel(LogistikStrings.getPhaseString())).setFont(Styles.ORDER_INFO);
        showOrderPanel.add(new JLabel(currentOrder.phase)).setFont(Styles.ORDER_INFO);

        showOrderPanel.add(new JLabel(LogistikStrings.getOrderDoneText())).setFont(Styles.ORDER_INFO);
        if (currentOrder.done) {
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
        this.setLayout(new java.awt.BorderLayout());
        getCurrentOrder();
        createShowshowOrderPanel();
        this.add(showOrderPanel, java.awt.BorderLayout.CENTER);
    }

}