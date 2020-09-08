package panels;

import java.awt.*;
import javax.swing.*;
import subpanels.OrderPanels;

public class EditOrder extends JPanel {
    
    private static final long serialVersionUID = 1L;
    
    public EditOrder() {

        this.setLayout(new BorderLayout());
        JPanel orderPanel = new JPanel(new GridLayout(6, 2, 10, 10));

        orderPanel.add(new JLabel("Order Header"));
        orderPanel.add(new JLabel("overdue"));

        orderPanel.add(new JLabel("Steinart"));
        orderPanel.add(new JTextField());
       

        orderPanel.add(new JLabel("Menge"));
        orderPanel.add(new JTextField());

        orderPanel.add(new JLabel("Lieferdatum"));
        orderPanel.add(new JTextField());


        orderPanel.add(new JLabel("Status"));
        orderPanel.add(new JComboBox<>());

        orderPanel.add(new JLabel("Auftragsstatus"));
        orderPanel.add(new JButton("Auftrag bearbeiten"));
    

 
        this.add(orderPanel, BorderLayout.CENTER);
    

    }

}