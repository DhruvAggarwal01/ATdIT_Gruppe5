package panels;

import java.awt.*;
import javax.swing.*;
import subpanels.OrderPanels;
import panels.EditOrder;
import java.util.Set;
import main.MainPanel;
import main.NavItemPanelChooser;
import db_interaction.DBOrdersExtractor;
import db_interaction.Order;
import java.io.*;
import java.util.HashSet;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogistikPanel extends JPanel {

    private static final long serialVersionUID = 1L;
    Integer maxOrderID;
    Set<Order> onTimeOrders;
    Set<Order> atRiskOrders;
    Set<Order> overdueOrders;

    DBOrdersExtractor dbOrderExtractor;

    public LogistikPanel() {
        try {
            dbOrderExtractor = new DBOrdersExtractor("databases/DefaultCONTRACTS.xlsx");
           // Set<Integer> setAllOrders = dbOrderExtractor.getFilteredRowsIndexes("rowcount", 1);

            maxOrderID = 7;;
        } catch (final IOException a) {
            a.printStackTrace();
        }
        onTimeOrders = getUnfinishedOrders("onTime");
        atRiskOrders = getUnfinishedOrders("atRisk");
        overdueOrders = getUnfinishedOrders("overdue");

        this.setLayout(new BorderLayout());

        final JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 300, 300));
        final JPanel orderPanel = new JPanel(new GridLayout(1, 3, 10, 10));

        JButton createOrder = new JButton("create Order");

        createOrder.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
            
                    Set<Integer> setAllOrders = dbOrderExtractor.getFilteredRowsIndexes("rowcount", 1);

                    maxOrderID = setAllOrders.size() + 1;
                } catch (final IOException a) {
                    a.printStackTrace();
                }
                EditOrder.currentOrder = new Order();
                EditOrder.currentOrder.setOrder_id(maxOrderID);
                MainPanel.getNavPane().setComponentAt(6, new NavItemPanelChooser("Logistik", "CreateOrder", null));

            }
        });

        buttonPanel.add(new JButton("search"));
        buttonPanel.add(createOrder);

        // 1. Panel: onTime
        final JPanel onTimePanel = new OrderPanels(onTimeOrders, "Order on Time", "These Ordes are on Time!", 188, 234,
                174);
        // 2. Panel: atRisk
        final JPanel atRiskPanel = new OrderPanels(atRiskOrders, "Order at Risk",
                "These Ordes are at Risk of delivering on Time!", 245, 220, 163);
        // 3. Panel: overdue
        final JPanel overduePanel = new OrderPanels(overdueOrders, "Order Overdue", "These Ordes are overdue!", 252,
                130, 136);

        this.add(buttonPanel, BorderLayout.NORTH);
        this.add(orderPanel, BorderLayout.CENTER);
        orderPanel.add(onTimePanel);
        orderPanel.add(atRiskPanel);
        orderPanel.add(overduePanel);

    }

    public Set<Order> getUnfinishedOrders(final String status) {

        Set<Order> itsOnTimeOrders = new HashSet<Order>();
        Set<Order> unfinishedOrders = new HashSet<Order>();

        try {
            unfinishedOrders = dbOrderExtractor.getFilteredDBRowsToSet("done", false);
            itsOnTimeOrders = dbOrderExtractor.getFilteredDBRowsToSet("status", status);
        } catch (IOException | IllegalArgumentException e) {
            e.printStackTrace();
        }

        unfinishedOrders.retainAll(itsOnTimeOrders);

        return unfinishedOrders;
    }
}