package panels;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.io.*;
import java.util.*;

import subpanels.OrderPanels;
import main.MainPanel;
import main.NavItemPanelChooser;
import db_interaction.DBOrdersExtractor;
import db_interaction.Order;
import db_interaction.OrdersSorter;
import usedstrings.LogistikStrings;

/**
 * Diese Klasse baut ein Panel auf, welches alle unfertigen Aufträge nach ihrem
 * Status geordnet aufzeigt (und bietet die Möglichkeit diese zu filtern und
 * einen neuen Auftrag anzulegen - tbd)
 * 
 * implementiert die Methoden: createLogisticsPanel, setOrderPanels,
 * getUnfinishedOrders,initCreateOrder, getMaxOrderID
 * 
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
    private JButton searchButton;
    private JCheckBox doneOrdersBox;

    private JPanel onTimePanel;
    private JPanel atRiskPanel;
    private JPanel overduePanel;
    DBOrdersExtractor dbOrderExtractor;

    /**
     * bestimmt den Aufbau des LogistikPanels
     */
    public void createLogisticsPanel() {

        this.setLayout(new BorderLayout());

        buttonPanel = new JPanel(new GridLayout(1, 3, 300, 300));
        orderPanel = new JPanel(new GridLayout(1, 3, 10, 10));

        createOrder = new JButton(LogistikStrings.getCreateOrderText());
        searchButton = new JButton(LogistikStrings.getSearchOrderText());

        doneOrdersBox = new JCheckBox(LogistikStrings.getDisplayAllText());

        doneOrdersBox.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Boolean displayAll = doneOrdersBox.isSelected();
                if (displayAll) {

                    MainPanel.getNavPane().setComponentAt(6, new NavItemPanelChooser(
                            LogistikStrings.getLogisticsString(), LogistikStrings.getDisplayAllString(), null));
                    MainPanel.getNavPane().setSelectedIndex(6);
                    doneOrdersBox.setSelected(true);
                } else if (!displayAll) {

                    MainPanel.getNavPane().setComponentAt(6,
                            new NavItemPanelChooser(LogistikStrings.getLogisticsString(), null, null));
                    MainPanel.getNavPane().setSelectedIndex(6);
                }
            }

        });
        buttonPanel.add(searchButton);
        buttonPanel.add(doneOrdersBox);
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
    public void setOrderPanels(Boolean displayAll) {

        if (displayAll) {
            this.onTimeOrders = OrdersSorter.getAllOrders(LogistikStrings.getOnTimeString());
            this.atRiskOrders = OrdersSorter.getAllOrders(LogistikStrings.getAtRiskString());
            this.overdueOrders = OrdersSorter.getAllOrders(LogistikStrings.getOverdueString());
        } else {
            this.onTimeOrders = OrdersSorter.getUnfinishedOrders(LogistikStrings.getOnTimeString());
            this.atRiskOrders = OrdersSorter.getUnfinishedOrders(LogistikStrings.getAtRiskString());
            this.overdueOrders = OrdersSorter.getUnfinishedOrders(LogistikStrings.getOverdueString());
        }

        onTimePanel = new OrderPanels(onTimeOrders, LogistikStrings.getOnTimeText(),
                LogistikStrings.getOnTimeDescription(), 188, 234, 174);
        atRiskPanel = new OrderPanels(atRiskOrders, LogistikStrings.getAtRiskText(),
                LogistikStrings.getAtRiskDescription(), 245, 220, 163);
        overduePanel = new OrderPanels(overdueOrders, LogistikStrings.getOverdueText(),
                LogistikStrings.getOverdueDescription(), 252, 130, 136);
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
                MainPanel.getNavPane().setComponentAt(6,
                        new NavItemPanelChooser(LogistikStrings.getLogisticsString(), "CreateOrder", null));

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

    public LogistikPanel(Boolean DisplayAllOrders) {
        try {
            dbOrderExtractor = new DBOrdersExtractor(LogistikStrings.getOrdersDatabaseString());
        } catch (final IOException a) {
            a.printStackTrace();
        }

        setOrderPanels(DisplayAllOrders);
        createLogisticsPanel();
        initCreateOrder();

    }
}