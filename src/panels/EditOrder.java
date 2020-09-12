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

public class EditOrder extends JPanel {

    private static final long serialVersionUID = 1L;

    private JLabel dummyLabel;

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

    String orderSource;

    public EditOrder() {
        Order currentOrder = new Order();
        DBOrdersExtractor dbOrderExtractor;
        this.orderSource = OrderPanels.getOrderSource();

        final int i = Integer.parseInt(this.orderSource.replaceAll("\\D", ""));

        Set<Order> rowCurrentOrder;

        try {
            dbOrderExtractor = new DBOrdersExtractor("databases/DefaultCONTRACTS.xlsx");
            rowCurrentOrder = dbOrderExtractor.getFilteredDBRowsToSet("order_id", i);
            final Iterator<Order> it = rowCurrentOrder.iterator();
            currentOrder = it.next();
        } catch (final IOException e) {
            e.printStackTrace();
        }
       
        setDisplayedValue(currentOrder);
       
JPanel editPanel =  createPanel();
  setStatusBackground(currentOrder, editPanel);
        this.setLayout(new BorderLayout());
        this.add(editPanel, BorderLayout.CENTER);
    }

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

        editPanel.add(dummyLabel);
        editPanel.add(dummyLabel);

        editPanel.add(backButton);
        editPanel.add(saveButton);

        editPanel.add(dummyLabel);
        editPanel.add(dummyLabel);

        return editPanel;
    }

    public void setStatusBackground(Order currentOrder, JPanel orderPanel) {

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

    public void setDisplayedValue(Order currentOrder) {

        dummyLabel = new JLabel("");

        orderHeaderLabel = new JLabel("Order Header");
        orderHeaderLabel.setFont(Styles.ORDER_INFO);

        orderStatusLabel = new JLabel("Auftragsnummer wird generiert");
        orderStatusLabel.setFont(Styles.ORDER_INFO);

        firmLabel = new JLabel("Firma");
        firmLabel.setFont(Styles.ORDER_INFO);

        firmField = new JTextField(currentOrder.firm);

        stoneTypeLabel = new JLabel("Steinart");
        orderStatusLabel.setFont(Styles.ORDER_INFO);

        stoneSelection = new JComboBox<String>();
        stoneSelection.addItem("Weißer Stein");
        stoneSelection.addItem("Roter Stein");
        stoneSelection.addItem("Schwarzer Stein");

        amountLabel = new JLabel("Menge:");
        amountLabel.setFont(Styles.ORDER_INFO);

        amountField = new JTextField(currentOrder.amount);

        dueDateLabel = new JLabel("Lieferdatum");
        dueDateLabel.setFont(Styles.ORDER_INFO);

        dueDateField = new JTextField(currentOrder.due_date);

        priceLabel = new JLabel("Preis");
        priceAmountLabel = new JLabel("wird berechnet");

        phaseLabel = new JLabel("Phase");
        phaseSelection = new JComboBox<String>();
        phaseSelection.addItem("Planung");
        phaseSelection.addItem("Sprengung");
        phaseSelection.addItem("Transport");
        phaseSelection.addItem("Geliefert");

        doneLabel = new JLabel("Auftrag abgeschlossen");
        doneBox = new JCheckBox("Auftrag abgeschlossen");

        backButton = new JButton("Zurück");
        backButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent e) {
                MainPanel.getNavPane().setComponentAt(6, new NavItemPanelChooser("Logistik", null, null));
                MainPanel.getNavPane().setSelectedIndex(6);
            }

        });

        saveButton = new JButton("Speichern");
        saveButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent e) {

                MainPanel.getNavPane().setComponentAt(6, new NavItemPanelChooser("Logistik", "ShowOrder", null));

            }
        });
    }



    public void saveEditedOrder() {

      

    }
    // public void save(){
    // if (true) { // Validator einfügen
    // //
    // currentOrder.setFirm(firmField.getText());
    // currentOrder.setAmount(Integer.parseInt(amountField.getText()));
    // currentOrder.setDue_date(Integer.parseInt(dueDateField.getText()));

    // } else {

    // final ImageIcon errorMsgIcon = new ImageIcon(new
    // ImageIcon("Library/images/errorIcon.png").getImage()
    // .getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH));
    // }}
}