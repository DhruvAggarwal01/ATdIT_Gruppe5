package atdit1.group5.panels;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.util.ResourceBundle;
import java.util.Set;
import java.util.Iterator;

import atdit1.group5.mainclasses.MainPanel;
import atdit1.group5.mainclasses.NavItemPanelChooser;
import atdit1.group5.Styles;
import atdit1.group5.db_interaction.CalculateOrder;
import atdit1.group5.db_interaction.DBGenericExtractor;
import atdit1.group5.db_interaction.DBOrderInserter;
import atdit1.group5.db_interaction.Order;
import atdit1.group5.listener.BackToOrderOverviewListener;
import atdit1.group5.listener.ResetInputFieldListener;
import atdit1.group5.subpanels.ColorChooser;
import atdit1.group5.subpanels.OrderPanels;
import atdit1.group5.verifiers.OrderAmountInputVerifier;
import atdit1.group5.verifiers.OrderStringVerifier;
import atdit1.group5.usedstrings.LogistikStrings;
import atdit1.group5.exceptions.DatabaseConnectException;
import atdit1.group5.exceptions.InternalException;

/**
 * JPanel, um das bearbeiten/anlegen eines Auftrags zu ermöglichen
 * 
 * @author Sophie Orth, Monica Alessi, Dhruv Aggarwal, Maik Fichtenkamm, Lucas
 *         Lahr
 */
public class EditOrder extends JPanel {

    private static final long serialVersionUID = 2284832758920933892L;

    private final ResourceBundle text;

    private JPanel editPanel;

    private JLabel dummyLabel1;
    private JLabel dummyLabel2;

    private JLabel orderHeaderLabel;
    private JLabel orderStatusLabel;

    private JLabel firmLabel;
    private static JTextField firmField;

    private JLabel stoneTypeLabel;
    private JComboBox<String> stoneSelection;

    private JLabel amountLabel;
    private static JTextField amountField;

    private JLabel dueDateLabel;
    private JTextField dueDateField;

    private JLabel priceLabel;
    private JLabel priceAmountLabel;

    private JLabel phaseLabel;
    private JComboBox<String> phaseSelection;

    private JLabel doneLabel;
    private JCheckBox doneBox;

    private JButton backButton;
    private static JButton saveButton;

    int i;
    String orderSource;
    private static boolean validFirmName;
    private static boolean validAmount;
    private boolean validDate;
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

        this.text = ResourceBundle.getBundle("i18n/logistik_panels/LogistikStrings");

        if (create != true) {
            currentOrder = new Order();
            this.orderSource = OrderPanels.getOrderSource();
            i = Integer.parseInt(this.orderSource.replaceAll("\\D", ""));
        } else {
            i = currentOrder.getOrder_id();
        }

        DBGenericExtractor<Order> dbOrderExtractor;
        Set<Order> rowCurrentOrder;
        if (this.orderSource != null) {
            try {
                dbOrderExtractor = new DBGenericExtractor<Order>(text.getString("ordersDatabaseString"), new Order());
                rowCurrentOrder = dbOrderExtractor.getFilteredDBRowsToSet("order_id", i);
                final Iterator<Order> it = rowCurrentOrder.iterator();
                currentOrder = it.next();
            } catch (DatabaseConnectException dce) {
                JPanel exceptionPanel = dce.getExceptionPanel();
                JOptionPane.showMessageDialog(new JFrame(), exceptionPanel, "Error: " + dce.getClass(),
                        JOptionPane.ERROR_MESSAGE);
            }
        }

        setDisplayedValue(currentOrder);

        final JPanel editPanel = createPanel();
        ColorChooser.setPanelBackground(currentOrder, editPanel);
        this.setLayout(new BorderLayout());
        this.add(editPanel, BorderLayout.CENTER);
    }

    /**
     * fügt alle Elemente dem edit-Panel hinzu.
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

        return editPanel;
    }

    /**
     * füllt die EingabeWerte mit den Werten der Bestellung, die bearbeitet werden.
     * 
     * @param currentOrder aktuelle Bestellung die bearbeitet wird
     */
    public void setDisplayedValue(final Order currentOrder) {

        dummyLabel1 = new JLabel("");
        dummyLabel2 = new JLabel("");

        orderHeaderLabel = new JLabel("Order Header");
        orderHeaderLabel.setFont(Styles.ORDER_INFO);
        orderStatusLabel = new JLabel("" + currentOrder.getOrder_id());
        orderStatusLabel.setFont(Styles.ORDER_INFO);

        firmLabel = new JLabel(text.getString("firmString"));
        firmLabel.setFont(Styles.ORDER_INFO);
        firmField = new JTextField(currentOrder.getFirm());
        firmField.setInputVerifier(new OrderStringVerifier());
        firmField.addMouseListener(new ResetInputFieldListener());

        stoneTypeLabel = new JLabel(text.getString("stoneTypeString"));
        stoneTypeLabel.setFont(Styles.ORDER_INFO);
        stoneSelection = new JComboBox<String>();
        stoneSelection.addItem(text.getString("stoneTypeOneString"));
        stoneSelection.addItem(text.getString("stoneTypeTwoSring"));
        stoneSelection.addItem(text.getString("stoneTypeThreeString"));
        stoneSelection.addItem(text.getString("stoneTypeFourString"));
        stoneSelection.addItem(text.getString("stoneTypeFiveString"));

        amountLabel = new JLabel("Menge (in Tonnen):");
        amountLabel.setFont(Styles.ORDER_INFO);
        amountField = new JTextField("" + currentOrder.getAmount());
        amountField.setInputVerifier(new OrderAmountInputVerifier());
        amountField.addMouseListener(new ResetInputFieldListener());

        dueDateLabel = new JLabel(text.getString("dueDateString"));
        dueDateLabel.setFont(Styles.ORDER_INFO);
        dueDateField = new JTextField("" + currentOrder.getDue_date());

        priceLabel = new JLabel(LogistikStrings.getPriceString());
        priceLabel.setFont(Styles.ORDER_INFO);
        priceAmountLabel = new JLabel(text.getString("priceDescription"));
        priceAmountLabel.setFont(Styles.ORDER_INFO);

        phaseLabel = new JLabel(text.getString("phaseString"));
        phaseLabel.setFont(Styles.ORDER_INFO);
        phaseSelection = new JComboBox<String>();
        phaseSelection.addItem(text.getString("phasePlanningString"));
        phaseSelection.addItem(text.getString("phaseBombingString"));
        phaseSelection.addItem(text.getString("phaseTransportString"));
        phaseSelection.addItem(text.getString("phaseDeliveredSttring"));

        doneLabel = new JLabel(text.getString("orderDoneText"));
        doneLabel.setFont(Styles.ORDER_INFO);
        doneBox = new JCheckBox(text.getString("orderDoneText"));

        backButton = new JButton(text.getString("backString"));
        backButton.addActionListener(new BackToOrderOverviewListener());

        saveButton = new JButton(text.getString("saveString"));
        if (create) {
            saveButton.setEnabled(false);
        }
        saveButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent e) {
                saveEditedOrder();
                if (create != true) {
                    MainPanel.getNavPane().setComponentAt(6,
                            new NavItemPanelChooser(text.getString("logisticsString"), "ShowOrder", null));
                } else {
                    MainPanel.getNavPane().setComponentAt(6,
                            new NavItemPanelChooser(text.getString("logisticsString"), null, null));
                }
            }
        });
    }

    /**
     * prüft die Auftragsvalidität
     */
    public static void checkOrderValidity() {

        if (validFirmName && validAmount) {
            saveButton.setEnabled(true);
        } else {
            saveButton.setEnabled(false);
        }

    }

    /**
     * speichert die geändert Werte des aktuellen Auftrags Methode um einen neuen
     * Auftrag anzulegen Methode für InputValidation
     */
    public void saveEditedOrder() {
        setOrder();
        try {
            DBOrderInserter dbOrdersInserter = new DBOrderInserter(text.getString("ordersDatabaseString"), new Order());
            if (create == true) {
                dbOrdersInserter.addNewOrder();
            } else {
                dbOrdersInserter.applyChangedGenericToRow("order_id", EditOrder.currentOrder.getOrder_id(),
                        EditOrder.currentOrder);
            }
        } catch (DatabaseConnectException dce) {
            JPanel exceptionPanel = dce.getExceptionPanel();
            JOptionPane.showMessageDialog(new JFrame(), exceptionPanel, "Error: " + dce.getClass(),
                    JOptionPane.ERROR_MESSAGE);
        } catch (InternalException noube) {
            JPanel exceptionPanel = noube.getExceptionPanel();
            JOptionPane.showMessageDialog(new JFrame(), exceptionPanel, "Error: " + noube.getClass(),
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    
    public static void setValidFirmName(final boolean isValid) {
        validFirmName = isValid;
    }

   
    public static void setValidAmount(final boolean isValid) {
        validAmount = isValid;
    }

    
    public void setOrder() {
        currentOrder.setFirm(firmField.getText());
        currentOrder.setStone_type(stoneSelection.getSelectedItem().toString());
        currentOrder.setAmount(Integer.parseInt(amountField.getText()));
        currentOrder.setDue_date(Integer.parseInt(dueDateField.getText()));
        currentOrder.setPhase(phaseSelection.getSelectedItem().toString());
        currentOrder.setIsDone(doneBox.isSelected());
        currentOrder.setPrice(CalculateOrder.calculatePrice(currentOrder));
    }

    public JPanel getOrderPanel() {
        return editPanel;
    }

}