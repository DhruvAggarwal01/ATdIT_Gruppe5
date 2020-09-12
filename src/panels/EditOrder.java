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
    String orderSource;
    Order currentOrder = new Order();
    private static final long serialVersionUID = 1L;
    DBOrdersExtractor dbOrderExtractor;
    Set<Order> rowCurrentOrder;

    public EditOrder() {
        try {
            dbOrderExtractor = new DBOrdersExtractor("databases/DefaultCONTRACTS.xlsx");

        } catch (IOException e) {
            e.printStackTrace();
        }
     
        this.orderSource = OrderPanels.getOrderSource();
        this.setLayout(new BorderLayout());

        JPanel orderPanel = new JPanel(new GridLayout(11, 2, 10, 10));
        int i = Integer.parseInt(this.orderSource.replaceAll("\\D", ""));
        try {

            rowCurrentOrder = dbOrderExtractor.getFilteredDBRowsToSet("order_id", i);
            final Iterator<Order> it = rowCurrentOrder.iterator();
            currentOrder = it.next();

        } catch (IOException | IllegalArgumentException e) {
            e.printStackTrace();
        }
   switch (currentOrder.status){
       case"overdue":
       orderPanel.setBackground(new Color(252, 130, 136));
       break;
       case"atRisk":
       orderPanel.setBackground(new Color(245, 220, 163));
       break;
       case"onTime":
       orderPanel.setBackground(new Color(188, 234, 174));
       break;
       default:    
        orderPanel.setBackground(new Color(188, 234, 174));
       break;

   } 
   JComboBox<String> stoneSelection = new JComboBox<>();
   stoneSelection.addItem("Weißer Stein");
   stoneSelection.addItem("Roter Stein");
   stoneSelection.addItem("Schwarzer Stein");
   JComboBox<String> phaseSelection = new JComboBox<>();
   phaseSelection.addItem("Planung");
   phaseSelection.addItem("Sprengung");
   phaseSelection.addItem("Transport");
   phaseSelection.addItem("Geliefert");
   JTextField firmField = new JTextField(currentOrder.firm);
   JLabel firmLabel = new JLabel("Firma");
   JTextField amountField = new JTextField("" + currentOrder.amount);
   JTextField dueDateField = new JTextField("" + currentOrder.due_date);
        orderPanel.add(new JLabel("Order Header")).setFont(Styles.ORDER_INFO);
        orderPanel.add(new JLabel("Auftragsnummer wird generiert"));

        orderPanel.add(firmLabel).setFont(Styles.ORDER_INFO);
        orderPanel.add(firmField);
     

        orderPanel.add(new JLabel("Steinart")).setFont(Styles.ORDER_INFO);
        orderPanel.add(stoneSelection);

        orderPanel.add(new JLabel("Menge")).setFont(Styles.ORDER_INFO);
        orderPanel.add(amountField);

        orderPanel.add(new JLabel("Lieferdatum")).setFont(Styles.ORDER_INFO);
        orderPanel.add(dueDateField);

        orderPanel.add(new JLabel("Preis")).setFont(Styles.ORDER_INFO);
        orderPanel.add(new JLabel("wird berechnet")).setFont(Styles.ORDER_INFO);

        orderPanel.add(new JLabel("Status")).setFont(Styles.ORDER_INFO);
        orderPanel.add(phaseSelection);

        orderPanel.add(new JLabel("Auftrag abgeschlossen : ")).setFont(Styles.ORDER_INFO);
        orderPanel.add(new JCheckBox("Auftrag abgeschlossen"));
        JButton backButton = new JButton("Zurück");
        backButton.addActionListener(new ActionListener() {
     
            @Override
            public void actionPerformed(ActionEvent e) {
                MainPanel.getNavPane().setComponentAt(6, new NavItemPanelChooser("Logistik", null, null));
                MainPanel.getNavPane().setSelectedIndex(6);
            }
     
       
        });  
        orderPanel.add(new JLabel("")); 
        orderPanel.add(new JLabel("")); 
        JButton saveOrder = new JButton("Speichern");
        saveOrder.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
                MainPanel.getNavPane().setComponentAt(6, new NavItemPanelChooser("Logistik", "ShowOrder", null));
        
         }});; 
        orderPanel.add(saveOrder);
        orderPanel.add(backButton);

        orderPanel.setFont(Styles.ORDER_INFO);
        this.add(orderPanel, BorderLayout.CENTER);

    }

}