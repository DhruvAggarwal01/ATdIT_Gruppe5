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
public class ShowOrder extends JPanel {
    String orderSource;
    Order currentOrder = new Order();
    private static final long serialVersionUID = 1L;
    DBOrdersExtractor dbOrderExtractor;
    Set<Order> rowCurrentOrder;

    public ShowOrder() {
        try {
            dbOrderExtractor = new DBOrdersExtractor("databases/DefaultCONTRACTS.xlsx");

        } catch (IOException e) {
            e.printStackTrace();
        }
     
        this.orderSource = OrderPanels.getOrderSource();
        this.setLayout(new BorderLayout());
        JPanel orderPanel = new JPanel(new GridLayout(6, 2, 10, 10));
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
       default: break;
   }
   orderPanel.add(new JLabel("Order Header"));
   orderPanel.add(new JLabel("overdue"));

   orderPanel.add(new JLabel("Steinart"));
   orderPanel.add(new JLabel(this.orderSource));

   orderPanel.add(new JLabel("Menge"));
   orderPanel.add(new JLabel("Steinart"));

   orderPanel.add(new JLabel("Lieferdatum"));
   orderPanel.add(new JLabel("Steinart"));

   orderPanel.add(new JLabel("Status"));
   orderPanel.add(new JLabel("Steinart"));
 JButton backButton = new JButton("Zurück");
   backButton.addActionListener(new ActionListener() {

       @Override
       public void actionPerformed(ActionEvent e) {
           MainPanel.getNavPane().setComponentAt(6, new NavItemPanelChooser("Logistik", null, null));
           MainPanel.getNavPane().setSelectedIndex(6);
       }

  
   });   orderPanel.add(new JLabel("Auftragsstatus"));
   orderPanel.add(backButton);

        this.add(orderPanel, BorderLayout.CENTER);

    }

}