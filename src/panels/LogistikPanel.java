package panels;

import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import subpanels.OrderPanels;
import main.MainPanel;
import main.NavItemPanelChooser;

import db_interaction.DBOrdersExtractor;
import db_interaction.Order;

import java.util.HashSet;
import java.util.Set;

/**
 * Diese Klasse baut ein Panel auf, welches alle unfertigen Aufträge nach ihrem
 * Status geordnet aufzeigt (und bietet die Möglichkeit diese zu filtern und
 * einen neuen Auftrag anzulegen - tbd)
 * 
 * implementiert die Methoden: createLogisticsPanel, setOrderPanels,
 * getUnfinishedOrders,initCreateOrder, getMaxOrderID
 * 
 * @author Sophie Orth, Monica Alessi, Dhruv Aggarwal, Maik Fichtenkamm, Lucas
 *         Lahr
 */
public class LogistikPanel extends JPanel {

    private static final long serialVersionUID = 1L;
    private Integer maxOrderID;
    private Set<Order> onTimeOrders;
    private Set<Order> atRiskOrders;
    private Set<Order> overdueOrders;
    private Set<Integer> setAllOrders;
    private JPanel buttonPanel;
    private JPanel orderPanel;
    private JButton createOrder;

    private JPanel onTimePanel;
    private JPanel atRiskPanel;
    private JPanel overduePanel;
    DBOrdersExtractor dbOrderExtractor;

    /**
     * bestimmt den Aufbau des LogistikPanels
     */
    public void createLogisticsPanel() {

        this.setLayout(new BorderLayout());

        buttonPanel = new JPanel(new GridLayout(1, 2, 300, 300));
        orderPanel = new JPanel(new GridLayout(1, 3, 10, 10));

        createOrder = new JButton("create Order");
        buttonPanel.add(new JButton("search"));
        buttonPanel.add(createOrder);

        orderPanel.add(onTimePanel);
        orderPanel.add(atRiskPanel);
        orderPanel.add(overduePanel);

        this.add(buttonPanel, BorderLayout.NORTH);
        this.add(orderPanel, BorderLayout.CENTER);

    }

    /**
     * holt alle nicht fertigen Orders in Kategorien sortiert & Konstuiert je
     * Kategorie ein OrderPanel
     */
    public void setOrderPanels() {

        onTimeOrders = getUnfinishedOrders("onTime");
        atRiskOrders = getUnfinishedOrders("atRisk");
        overdueOrders = getUnfinishedOrders("overdue");

        onTimePanel = new OrderPanels(onTimeOrders, "Order on Time", "These Ordes are on Time!", 188, 234, 174);
        atRiskPanel = new OrderPanels(atRiskOrders, "Order at Risk", "These Ordes are at Risk of delivering on Time!",
                245, 220, 163);
        overduePanel = new OrderPanels(overdueOrders, "Order Overdue", "These Ordes are overdue!", 252, 130, 136);
    }

    /**
     * 
     * @param status
     * @return Set<Order> gefiltert nach status
     */
    public Set<Order> getUnfinishedOrders(final String status) {

        Set<Order> specificStatusOrders = new HashSet<Order>();
        Set<Order> unfinishedOrders = new HashSet<Order>();

        try {
            unfinishedOrders = dbOrderExtractor.getFilteredDBRowsToSet("done", false);
            specificStatusOrders = dbOrderExtractor.getFilteredDBRowsToSet("status", status);
            unfinishedOrders.retainAll(specificStatusOrders);
        } catch (IOException | IllegalArgumentException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return unfinishedOrders;
    }

    /**
     * weist currentOrder eine neuen Auftrag zu &
     */
    public void initCreateOrder() {
        maxOrderID = getMaxOrderID();
        createOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {

                EditOrder.currentOrder = new Order();
                EditOrder.currentOrder.setOrder_id(maxOrderID);
                MainPanel.getNavPane().setComponentAt(6, new NavItemPanelChooser("Logistik", "CreateOrder", null));

            }
        });
    }

    /**
     * Berechnet den int Wer der ersten OrderId ist die noch nicht in Verwendung
     * ist.
     * 
     * @return maxOrderId
     */
    public int getMaxOrderID() {
        maxOrderID = 0;
        try {
            setAllOrders = dbOrderExtractor.getFilteredRowsIndexes("rowcount", 1);
            maxOrderID = setAllOrders.size() + 1;

        } catch (final IOException | IllegalAccessException a) {
            a.printStackTrace();
        }
        return maxOrderID;
    }

    /**
     * Konstruktur für das Logistik Panel
     */
    public LogistikPanel() {
        try {
            dbOrderExtractor = new DBOrdersExtractor("databases/DefaultCONTRACTS.xlsx");
        } catch (final IOException a) {
            a.printStackTrace();
        }
        setOrderPanels();
        createLogisticsPanel();
        initCreateOrder();

    }
}