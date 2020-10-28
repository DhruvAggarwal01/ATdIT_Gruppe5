package atdit1.group5.panels;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

import atdit1.group5.subpanels.OrderPanels;
import atdit1.group5.mainclasses.MainPanel;
import atdit1.group5.mainclasses.NavItemPanelChooser;
import atdit1.group5.db_interaction.DBGenericExtractor;
import atdit1.group5.db_interaction.Order;
import atdit1.group5.db_interaction.OrdersSorter;
import atdit1.group5.usedstrings.LogistikStrings;
import atdit1.group5.exceptions.DatabaseConnectException;

/**
 * baut ein Panel auf, welches alle unfertigen Aufträge nach ihrem Status
 * geordnet aufzeigt (und bietet die Möglichkeit diese zu filtern und einen
 * neuen Auftrag anzulegen)
 * 
 * implementiert die Methoden: createLogisticsPanel, setOrderPanels,
 * getUnfinishedOrders,initCreateOrder, getMaxOrderID
 * 
 * @author Sophie Orth, Monica Alessi, Dhruv Aggarwal, Maik Fichtenkamm, Lucas
 *         Lahr
 */
public class LogistikPanel extends JPanel {

    private static final long serialVersionUID = -3153446847438152606L;

    private final ResourceBundle text;

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
    DBGenericExtractor<Order> dbOrderExtractor;

    /**
     * Konstruktur für das Logistik-Panel
     * 
     * @param DisplayAllOrders
     */
    public LogistikPanel(Boolean DisplayAllOrders) {
        this.text = ResourceBundle.getBundle("i18n/logistik_panels/LogistikStrings");
        try {
            dbOrderExtractor = new DBGenericExtractor<Order>(text.getString("ordersDatabaseString"), new Order());
        } catch (DatabaseConnectException dce) {
            JPanel exceptionPanel = dce.getExceptionPanel();
            JOptionPane.showMessageDialog(new JFrame(), exceptionPanel, "Error: " + dce.getClass(),
                    JOptionPane.ERROR_MESSAGE);
        }
        setOrderPanels(DisplayAllOrders);
        createLogisticsPanel();
        initCreateOrder();
    }

    /**
     * bestimmt den Aufbau des Logistik-Panels.
     */
    public void createLogisticsPanel() {

        this.setLayout(new BorderLayout());

        buttonPanel = new JPanel(new GridLayout(1, 3, 300, 300));
        orderPanel = new JPanel(new GridLayout(1, 3, 10, 10));

        createOrder = new JButton(LogistikStrings.getCreateOrderText());
        searchButton = new JButton(LogistikStrings.getSearchOrderText());
        searchButton = new JButton(text.getString("searchOrderText"));

        doneOrdersBox = new JCheckBox(LogistikStrings.getDisplayAllText());
        doneOrdersBox = new JCheckBox(text.getString("displayAllText"));

        doneOrdersBox.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Boolean displayAll = doneOrdersBox.isSelected();
                if (displayAll) {

                    MainPanel.getNavPane().setComponentAt(6, new NavItemPanelChooser(text.getString("logisticsString"),
                            text.getString("displayAllString"), null));
                    MainPanel.getNavPane().setSelectedIndex(6);
                    doneOrdersBox.setSelected(true);
                } else if (!displayAll) {

                    MainPanel.getNavPane().setComponentAt(6,
                            new NavItemPanelChooser(text.getString("logisticsString"), null, null));
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
     * 
     * @param displayAll Wahrheitswert, ob alle Aufträge angezeigt werden sollen
     */
    public void setOrderPanels(Boolean displayAll) {

        if (displayAll) {
            this.onTimeOrders = OrdersSorter.getAllOrders(text.getString("onTimeString"));
            this.atRiskOrders = OrdersSorter.getAllOrders(text.getString("atRiskString"));
            this.overdueOrders = OrdersSorter.getAllOrders(text.getString("overdueString"));
        } else {
            this.onTimeOrders = OrdersSorter.getUnfinishedOrders(text.getString("onTimeString"));
            this.atRiskOrders = OrdersSorter.getUnfinishedOrders(text.getString("atRiskString"));
            this.overdueOrders = OrdersSorter.getUnfinishedOrders(text.getString("overdueString"));
        }

        onTimePanel = new OrderPanels(onTimeOrders, text.getString("onTimeText"), text.getString("onTimeDescription"),
                188, 234, 174);
        atRiskPanel = new OrderPanels(atRiskOrders, text.getString("atRiskText"), text.getString("atRiskDescription"),
                245, 220, 163);
        overduePanel = new OrderPanels(overdueOrders, text.getString("overdueText"),
                text.getString("overdueDescription"), 252, 130, 136);
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
                        new NavItemPanelChooser(text.getString("logisticsString"), "CreateOrder", null));
            }
        });
    }

    /**
     * berechnet den int Wer der ersten OrderId ist die noch nicht in Verwendung
     * ist.
     * 
     * @return maxOrderId
     */
    public int getMaxOrderID() {
        maxOrderID = 0;
        setAllOrders = dbOrderExtractor.getFilteredRowsIndexes("rowcount", 1);
        maxOrderID = setAllOrders.size() + 1;
        return maxOrderID;
    }

}