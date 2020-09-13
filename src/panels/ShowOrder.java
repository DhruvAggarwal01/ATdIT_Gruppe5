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
        if(this.orderSource != null){
        this.orderSource = OrderPanels.getOrderSource();}
        else{
            this.orderSource = ""+ currentOrder.order_id;
        }
        this.setLayout(new BorderLayout());
        JPanel orderPanel = new JPanel(new GridLayout(13, 2, 10, 10));
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

   JLabel orderHeader = new JLabel(this.orderSource);
   orderHeader.setFont(Styles.ORDER_INFO_HEAD);
   JLabel orderStatus = new JLabel(currentOrder.status);
   orderStatus.setFont(Styles.ORDER_INFO_HEAD);   

   orderPanel.add(orderHeader);
   orderPanel.add(orderStatus);

    orderPanel.add(new JLabel("Firma:")).setFont(Styles.ORDER_INFO);
   orderPanel.add(new JLabel(currentOrder.getFirm())).setFont(Styles.ORDER_INFO);

   orderPanel.add(new JSeparator(JSeparator.HORIZONTAL));
   orderPanel.add(new JSeparator(JSeparator.HORIZONTAL));

   orderPanel.add(new JLabel("Steinart")).setFont(Styles.ORDER_INFO);
   orderPanel.add(new JLabel(currentOrder.stone_type)).setFont(Styles.ORDER_INFO);

   orderPanel.add(new JLabel("Menge")).setFont(Styles.ORDER_INFO);
   orderPanel.add(new JLabel(" "+ currentOrder.amount)).setFont(Styles.ORDER_INFO);

   orderPanel.add(new JLabel("Preis")).setFont(Styles.ORDER_INFO);
   orderPanel.add(new JLabel(""+ currentOrder.price)).setFont(Styles.ORDER_INFO);

   orderPanel.add(new JSeparator(JSeparator.HORIZONTAL));
   orderPanel.add(new JSeparator(JSeparator.HORIZONTAL));

   orderPanel.add(new JLabel("Lieferdatum")).setFont(Styles.ORDER_INFO);
   orderPanel.add(new JLabel(" "+ currentOrder.due_date)).setFont(Styles.ORDER_INFO);


   orderPanel.add(new JLabel("Phase")).setFont(Styles.ORDER_INFO);
    orderPanel.add(new JLabel(currentOrder.phase)).setFont(Styles.ORDER_INFO);

    orderPanel.add(new JLabel("Auftrag abgeschlossen : ")).setFont(Styles.ORDER_INFO);
    orderPanel.add(new JLabel("Auftrag noch nicht abgeschlossen")).setFont(Styles.ORDER_INFO);

    orderPanel.add(new JSeparator(JSeparator.HORIZONTAL));
    orderPanel.add(new JSeparator(JSeparator.HORIZONTAL));
 JButton backButton = new JButton("Zurück");
   backButton.addActionListener(new ActionListener() {

       @Override
       public void actionPerformed(ActionEvent e) {
           MainPanel.getNavPane().setComponentAt(6, new NavItemPanelChooser("Logistik", null, null));
           MainPanel.getNavPane().setSelectedIndex(6);
       }

  
   });  
   orderPanel.add(backButton);
   JButton editButton = new JButton("Auftrag bearbeiten");
   editButton.addActionListener(new ActionListener() {

    @Override
    public void actionPerformed(ActionEvent e) {
        
        MainPanel.getNavPane().setComponentAt(6, new NavItemPanelChooser("Logistik", "EditOrder", null));

 }}); 
 orderPanel.add(editButton);
    orderPanel.add(new JLabel("")); 
    orderPanel.add(new JLabel("")); 
        this.add(orderPanel, BorderLayout.CENTER);
  
    }

}