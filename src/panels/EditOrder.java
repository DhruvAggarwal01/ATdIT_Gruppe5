package panels;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import db_interaction.DBOrdersExtractor;
import db_interaction.Order;
import java.awt.*;
import javax.swing.*;
import subpanels.OrderPanels;
import java.util.HashSet;
import java.io.*;
import java.util.Set;
import java.util.Iterator;
import main.MainPanel;
import main.NavItemPanelChooser;
import main.Styles;
import db_interaction.DBOrdersInserter;


/**
 * 
 */
public class EditOrder extends JPanel {

    private static final long serialVersionUID = 1L;
    private JPanel editPanel;

    private JLabel dummyLabel1;
    private JLabel dummyLabel2;

    private JLabel orderHeaderLabel;
    private JLabel orderStatusLabel;

    private JLabel firmLabel;
    private JTextField firmField;

    private JLabel stoneTypeLabel;
    private JComboBox<String> stoneSelection;

    private JLabel amountLabel;
    private JTextField amountField;

    private JLabel dueDateLabel;
    private JTextField dueDateField;

    private JLabel priceLabel;
    private JLabel priceAmountLabel;

    private JLabel phaseLabel;
    private JComboBox<String> phaseSelection;

    private JLabel doneLabel;
    private JCheckBox doneBox;

    private JButton backButton;
    private JButton saveButton;

    private JLabel infoLabel1;
    private JLabel infoLabel2;
    int i;
    String orderSource;
    Boolean create;
    Boolean create2;
    public static Order currentOrder;

    /**
     * 
     * @param create2
     */
    public EditOrder(Boolean create2) {
        this.create = create2;
        if (create != true) {
            currentOrder = new Order();
            this.orderSource = OrderPanels.getOrderSource();

            i = Integer.parseInt(this.orderSource.replaceAll("\\D", ""));
        }

        else {
            i = currentOrder.order_id;
        }
        DBOrdersExtractor dbOrderExtractor;

        Set<Order> rowCurrentOrder;
        if (this.orderSource != null) {
            try {
                dbOrderExtractor = new DBOrdersExtractor("databases/DefaultCONTRACTS.xlsx");
                rowCurrentOrder = dbOrderExtractor.getFilteredDBRowsToSet("order_id", i);
                final Iterator<Order> it = rowCurrentOrder.iterator();
                currentOrder = it.next();
            } catch (final IOException e) {
                e.printStackTrace();
            }
        }

        setDisplayedValue(currentOrder);

        final JPanel editPanel = createPanel();
        setStatusBackground(currentOrder, editPanel);
        this.setLayout(new BorderLayout());
        this.add(editPanel, BorderLayout.CENTER);
    }

    // Fügt alle Elemente dem Panel hinzu
    public JPanel createPanel() {

        final JPanel editPanel = new JPanel(new GridLayout(11, 2, 10, 10));

        editPanel.add(orderHeaderLabel);
        editPanel.add(orderStatusLabel);

        editPanel.add(firmLabel);
        editPanel.add(firmField);

        editPanel.add(stoneTypeLabel);
        editPanel.add(stoneSelection);

        editPanel.add(amountLabel);
        editPanel.add(amountField);

        editPanel.add(dueDateLabel);
        editPanel.add(dueDateField);

        editPanel.add(priceLabel);
        editPanel.add(priceAmountLabel);

        editPanel.add(phaseLabel);
        editPanel.add(phaseSelection);

        editPanel.add(doneLabel);
        editPanel.add(doneBox);

        editPanel.add(dummyLabel1);
        editPanel.add(dummyLabel2);

        editPanel.add(backButton);
        editPanel.add(saveButton);

        editPanel.add(infoLabel1);
        editPanel.add(infoLabel2);

        return editPanel;
    }

    // passt den Hintergrund des EditOrder Panels dem Status der Bestellung an
    public void setStatusBackground(final Order currentOrder, final JPanel orderPanel) {

        switch (currentOrder.status) {
            case "overdue":
                orderPanel.setBackground(new Color(252, 130, 136));
                break;
            case "atRisk":
                orderPanel.setBackground(new Color(245, 220, 163));
                break;
            case "onTime":
                orderPanel.setBackground(new Color(188, 234, 174));
                break;
            default:
                orderPanel.setBackground(new Color(188, 234, 174));
                break;
        }
    }

    // Füllt die EingabeWerte mit den Werten der Bestellung die bearbeitet werden
    // soll
    public void setDisplayedValue(final Order currentOrder) {

        dummyLabel1 = new JLabel(" ");
         dummyLabel2 = new JLabel(" ");
        infoLabel1 = new JLabel("Info: Lieferdatum nimmt nur reine ints an, dates to be implemented) ");
        infoLabel2 = new JLabel("info: Input Validation wird noch implementiert");

        orderHeaderLabel = new JLabel("Order Header");
        orderHeaderLabel.setFont(Styles.ORDER_INFO);

        orderStatusLabel = new JLabel("" + currentOrder.order_id);
        orderStatusLabel.setFont(Styles.ORDER_INFO);

        firmLabel = new JLabel("Firma (nur reine Strings eingeben)");
        firmLabel.setFont(Styles.ORDER_INFO);

        firmField = new JTextField(currentOrder.getFirm());

        stoneTypeLabel = new JLabel("Steinart");
        stoneTypeLabel.setFont(Styles.ORDER_INFO);

        stoneSelection = new JComboBox<String>();
        stoneSelection.addItem("Sandstein");
        stoneSelection.addItem("Kalkstein");
        stoneSelection.addItem("Granite");
        stoneSelection.addItem("Basalte");
        stoneSelection.addItem("Schiefer");

        amountLabel = new JLabel("Menge (in Tonnen):");
        amountLabel.setFont(Styles.ORDER_INFO);

        amountField = new JTextField("" + currentOrder.amount);

        dueDateLabel = new JLabel("Lieferdatum ");
        dueDateLabel.setFont(Styles.ORDER_INFO);

        dueDateField = new JTextField("" + currentOrder.due_date);

        priceLabel = new JLabel("Preis");
        priceLabel.setFont(Styles.ORDER_INFO);
        priceAmountLabel = new JLabel("wird berechnet");
        priceAmountLabel.setFont(Styles.ORDER_INFO);

        phaseLabel = new JLabel("Phase");
        phaseLabel.setFont(Styles.ORDER_INFO);
        phaseSelection = new JComboBox<String>();
        phaseSelection.addItem("Planung");
        phaseSelection.addItem("Sprengung");
        phaseSelection.addItem("Transport");
        phaseSelection.addItem("Geliefert");

        doneLabel = new JLabel("Auftrag abgeschlossen");
        doneLabel.setFont(Styles.ORDER_INFO);
        doneBox = new JCheckBox("Auftrag abgeschlossen");

        backButton = new JButton("Zurück");
        backButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent e) {
                MainPanel.getNavPane().setComponentAt(6, new NavItemPanelChooser("Logistik", null, null));
                MainPanel.getNavPane().setSelectedIndex(6);
            }

        });

        if (create != true) {
            saveButton = new JButton("Speichern");
        } else {
            saveButton = new JButton("Speichern noch nicht möglich");
        }
        saveButton = new JButton("Speichern");
        saveButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent e) {
                saveEditedOrder();
                if (create != true) {
                    MainPanel.getNavPane().setComponentAt(6, new NavItemPanelChooser("Logistik", "ShowOrder", null));
                } else {
                    MainPanel.getNavPane().setComponentAt(6, new NavItemPanelChooser("Logistik", null, null));
                }

            }
        });
    }

    public void saveEditedOrder() {
        currentOrder.setFirm(firmField.getText());
        currentOrder.setStone_type(stoneSelection.getSelectedItem().toString());
        currentOrder.setAmount(Integer.parseInt(amountField.getText()));
        currentOrder.setDue_date(Integer.parseInt(dueDateField.getText()));
        currentOrder.setPhase(phaseSelection.getSelectedItem().toString());
        currentOrder.setDone(doneBox.isSelected());
        currentOrder.setPrice(calculatePrice(currentOrder));
        try {
            final DBOrdersInserter dbOrdersInserter = new DBOrdersInserter("databases/DefaultCONTRACTS.xlsx");
            // if (create == true) {
            // dbOrdersInserter.addNewOrder();
            // } else {
            dbOrdersInserter.applyChangedOrderToRow();
            // }
        } catch (final IOException ioe) {
            ioe.printStackTrace();
        }

    }

    public JPanel getOrderPanel(){
        return editPanel;
    }
    public int calculatePrice(Order currentOrder)  {    
        int price = 0;
        int amount = currentOrder.amount;
        switch (currentOrder.stone_type) {
            case "Sandstein":
                price = amount * 75;
                break;
            case "Kalkstein":
            price = amount * 130;
                break;
            case "Granite":
                price = amount * 150;
                break;
            case "Basalte":
            price = amount * 300;
                break;
            case "Schiefer":
            price = amount * 400;
                break;
            default:
            price = amount * 0;
                break;
        } 
        return price;
}

}