package panels;

import java.awt.*;
import java.awt.event.*;


import javax.swing.*;


import java.io.*;
import java.util.Set;
import java.util.Iterator;

import main.MainPanel;
import main.NavItemPanelChooser;
import main.Styles;
import db_interaction.CalculateOrder;
import db_interaction.DBOrdersInserter;
import db_interaction.DBOrdersExtractor;
import db_interaction.Order;
import listener.BackToOrderOverviewListener;
import subpanels.ColorChooser;
import subpanels.OrderPanels;
import verifiers.OrderAmountInputVerifier;
import verifiers.OrderStringVerifier;

/**
 * JPanel um das bearbeiten/anlegen eines Auftrags zu ermöglichen
 * 
 * @author Sophie Orth, Monica Alessi, Dhruv Aggarwal, Maik Fichtenkamm, Lucas
 *         Lahr
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
    int i;
    String orderSource;
    Boolean create;
    Boolean create2;
    public static Order currentOrder;

    /**
     * 
     * @param create2 Gibt an ob man das EditPanel aufruft um einen Auftrag
     *                anzulegen oder um einen existierenden zu bearbeiten
     */
    public EditOrder(final Boolean create2) {
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
            } catch (final IOException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        setDisplayedValue(currentOrder);

        final JPanel editPanel = createPanel();
        ColorChooser.setPanelBackground(currentOrder, editPanel);
        this.setLayout(new BorderLayout());
        this.add(editPanel, BorderLayout.CENTER);
    }

    /**
     * Fügt alle Elemente dem edit Panel hinzu
     * 
     * @return editPanel
     */
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

        return editPanel;
    }


    /**
     * Füllt die EingabeWerte mit den Werten der Bestellung die bearbeitet werden
     * 
     * @param currentOrder aktuelle Bestellung die bearbeitet wird
     */
    public void setDisplayedValue(final Order currentOrder) {

        dummyLabel1 = new JLabel(" ");
        dummyLabel2 = new JLabel(" ");
        infoLabel1 = new JLabel("Info: Lieferdatum nimmt nur reine ints an, dates to be implemented) ");

        orderHeaderLabel = new JLabel("Order Header");
        orderHeaderLabel.setFont(Styles.ORDER_INFO);

        orderStatusLabel = new JLabel("" + currentOrder.order_id);
        orderStatusLabel.setFont(Styles.ORDER_INFO);

        firmLabel = new JLabel("Firma");
        firmLabel.setFont(Styles.ORDER_INFO);

        firmField = new JTextField(currentOrder.getFirm());
        firmField.setInputVerifier(new OrderStringVerifier());

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
        amountField.setInputVerifier(new OrderAmountInputVerifier());

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
        backButton.addActionListener(new BackToOrderOverviewListener());

        if (create != true) {
            saveButton = new JButton("Speichern");
        } else {
            saveButton = new JButton("Speichern noch nicht möglich");
        }
        saveButton = new JButton("Speichern");

        saveButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent e) {
                
                if (checkOrderValidity()) {
                    saveEditedOrder();
                    if (create != true) {
                        MainPanel.getNavPane().setComponentAt(6,
                                new NavItemPanelChooser("Logistik", "ShowOrder", null));
                    } else {
                        MainPanel.getNavPane().setComponentAt(6, new NavItemPanelChooser("Logistik", null, null));
                    }
                } else {
                   
                    saveButton.setEnabled(false);
                }

            }
        });
    }

    public boolean checkOrderValidity() {
        boolean validFirmName = firmField.isValid();
        boolean validAmount = amountField.isValid();
        // boolean validDate = amountField.isValid();
        return validFirmName && validAmount;
    }

    /**
     * speichert die geändert Werte des aktuellen Auftrags Methode um einen neuen
     * Auftrag anzulegen tbd Methode für InputValidation tbd
     */
    public void saveEditedOrder() {
     
            setOrder();
            try {
                final DBOrdersInserter dbOrdersInserter = new DBOrdersInserter("databases/DefaultCONTRACTS.xlsx");
                if (create == true) {
                    dbOrdersInserter.addNewOrder();
                } else {
                    dbOrdersInserter.applyChangedOrderToRow();
                }
            } catch (final IOException ioe) {
                ioe.printStackTrace();
            }
        

    }

    public void setOrder() {
        currentOrder.setFirm(firmField.getText());
        currentOrder.setStone_type(stoneSelection.getSelectedItem().toString());
        currentOrder.setAmount(Integer.parseInt(amountField.getText()));
        currentOrder.setDue_date(Integer.parseInt(dueDateField.getText()));
        currentOrder.setPhase(phaseSelection.getSelectedItem().toString());
        currentOrder.setDone(doneBox.isSelected());
        currentOrder.setPrice(CalculateOrder.calculatePrice(currentOrder));
    }

    /* ----------------------- Getter/Setter-Methoden --------------------------- */

    public JPanel getOrderPanel() {
        return editPanel;
    }

}