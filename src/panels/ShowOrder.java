package panels;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import db_interaction.DBOrdersExtractor;
import db_interaction.Order;

import java.io.*;
import java.util.Set;
import java.util.Iterator;

import subpanels.OrderPanels;
import main.MainPanel;
import main.NavItemPanelChooser;
import main.Styles;

public class ShowOrder extends JPanel {

    private static final long serialVersionUID = 1L;

    String orderSource;
    Order currentOrder = new Order();
    private JPanel showOrderPanel;

    private DBOrdersExtractor dbOrderExtractor;
    Set<Order> rowCurrentOrder;

    // passt den Hintergrund des EditOrder Panels dem Status der Bestellung an
    public void setStatusBackground(final Order currentOrder, final JPanel showOrderPanel) {

        switch (currentOrder.status) {
            case "overdue":
                showOrderPanel.setBackground(new Color(252, 130, 136));
                break;
            case "atRisk":
                showOrderPanel.setBackground(new Color(245, 220, 163));
                break;
            case "onTime":
                showOrderPanel.setBackground(new Color(188, 234, 174));
                break;
            default:
                showOrderPanel.setBackground(new Color(188, 234, 174));
                break;
        }
    }

    public void getCurrentOrder(){
        this.orderSource = OrderPanels.getOrderSource();
        int i = Integer.parseInt(this.orderSource.replaceAll("\\D", ""));
  
        try {
            dbOrderExtractor = new DBOrdersExtractor("databases/DefaultCONTRACTS.xlsx");
            rowCurrentOrder = dbOrderExtractor.getFilteredDBRowsToSet("order_id", i);
            final Iterator<Order> it = rowCurrentOrder.iterator();
            currentOrder = it.next();

        } catch (IOException | IllegalArgumentException e) {
            e.printStackTrace();
        }

    }
    public void createShowshowOrderPanel(){

        showOrderPanel = new JPanel(new GridLayout(13, 2, 10, 10));
     
        setStatusBackground(currentOrder, showOrderPanel);

        JLabel orderHeader = new JLabel(this.orderSource);
        orderHeader.setFont(Styles.ORDER_INFO_HEAD);
        JLabel orderStatus = new JLabel(currentOrder.status);
        orderStatus.setFont(Styles.ORDER_INFO_HEAD);

        showOrderPanel.add(orderHeader);
        showOrderPanel.add(orderStatus);

        showOrderPanel.add(new JLabel("Firma:")).setFont(Styles.ORDER_INFO);
        showOrderPanel.add(new JLabel(currentOrder.getFirm())).setFont(Styles.ORDER_INFO);

        showOrderPanel.add(new JSeparator(JSeparator.HORIZONTAL));
        showOrderPanel.add(new JSeparator(JSeparator.HORIZONTAL));

        showOrderPanel.add(new JLabel("Steinart")).setFont(Styles.ORDER_INFO);
        showOrderPanel.add(new JLabel(currentOrder.stone_type)).setFont(Styles.ORDER_INFO);

        showOrderPanel.add(new JLabel("Menge")).setFont(Styles.ORDER_INFO);
        showOrderPanel.add(new JLabel(" " + currentOrder.amount + "  Tonnen")).setFont(Styles.ORDER_INFO);

        showOrderPanel.add(new JLabel("Preis")).setFont(Styles.ORDER_INFO);
        showOrderPanel.add(new JLabel("" + currentOrder.price + "  €")).setFont(Styles.ORDER_INFO);

        showOrderPanel.add(new JSeparator(JSeparator.HORIZONTAL));
        showOrderPanel.add(new JSeparator(JSeparator.HORIZONTAL));

        showOrderPanel.add(new JLabel("Lieferdatum")).setFont(Styles.ORDER_INFO);
        showOrderPanel.add(new JLabel(" " + currentOrder.due_date)).setFont(Styles.ORDER_INFO);

        showOrderPanel.add(new JLabel("Phase")).setFont(Styles.ORDER_INFO);
        showOrderPanel.add(new JLabel(currentOrder.phase)).setFont(Styles.ORDER_INFO);

        showOrderPanel.add(new JLabel("Auftrag abgeschlossen : ")).setFont(Styles.ORDER_INFO);
        if(currentOrder.done){
            showOrderPanel.add(new JLabel("Der Auftrag ist abgeschlossen")).setFont(Styles.ORDER_INFO);
        }else{
        showOrderPanel.add(new JLabel("Der istAuftrag noch nicht abgeschlossen")).setFont(Styles.ORDER_INFO);}

        showOrderPanel.add(new JSeparator(JSeparator.HORIZONTAL));
        showOrderPanel.add(new JSeparator(JSeparator.HORIZONTAL));

        JButton backButton = new JButton("Zurück");  
        showOrderPanel.add(backButton);
        JButton editButton = new JButton("Auftrag bearbeiten");        
        showOrderPanel.add(editButton);

       backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainPanel.getNavPane().setComponentAt(6, new NavItemPanelChooser("Logistik", null, null));
                MainPanel.getNavPane().setSelectedIndex(6);
            }
        });
       
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainPanel.getNavPane().setComponentAt(6, new NavItemPanelChooser("Logistik", "EditOrder", null));
            }
        });

        showOrderPanel.add(new JLabel(""));
        showOrderPanel.add(new JLabel(""));

    }

    public ShowOrder() {
        this.setLayout(new BorderLayout());
        getCurrentOrder();
        createShowshowOrderPanel();
        this.add(showOrderPanel, BorderLayout.CENTER);
     
 

    }

}