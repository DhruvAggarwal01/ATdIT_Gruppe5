package panels;

import java.awt.*;
import javax.swing.*;
import subpanels.OrderPanels;

public class ShowOrder extends JPanel {
    
    private static final long serialVersionUID = 1L;
    JPanel orderPanel;
    
    public ShowOrder() {

        this.setLayout(new BorderLayout());
        orderPanel = new JPanel(new GridLayout(6, 2, 10, 10));

        orderPanel.add(new JLabel("Order Header"));
        orderPanel.add(new JLabel("overdue"));

        orderPanel.add(new JLabel("Steinart"));
        orderPanel.add(new JLabel("Steinart"));
       

        orderPanel.add(new JLabel("Menge"));
        orderPanel.add(new JLabel("Steinart"));

        orderPanel.add(new JLabel("Lieferdatum"));
        orderPanel.add(new JLabel("Steinart"));


        orderPanel.add(new JLabel("Status"));
        orderPanel.add(new JLabel("Steinart"));

        orderPanel.add(new JLabel("Auftragsstatus"));
        orderPanel.add(new JButton("Auftrag bearbeiten"));
    

 
        this.add(orderPanel, BorderLayout.CENTER);
    

    }

    public JPanel getOrderPanel(){
        return orderPanel;
    }

}