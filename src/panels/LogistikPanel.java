package panels;
import java.awt.*;
import javax.swing.*;
import subpanels.OrderPanels;




public class LogistikPanel extends JPanel {

    private static final long serialVersionUID = 1L;

    /**
     * Konstruktor, der tbd
     * 
     * @return
     */
    public LogistikPanel() {
        this.setLayout(new BorderLayout());
       
        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 300, 300));
        JPanel orderPanel = new JPanel(new GridLayout(1, 3, 10, 10));


        // 1. Panel: onTime
        JPanel onTimePanel = new OrderPanels("Order on Time", "These Ordes are on Time!", 188, 234, 174);
        // 2. Panel: atRisk
        JPanel atRiskPanel = new OrderPanels("Order at Risk", "These Ordes are at Risk of delivering on Time!", 245, 220, 163);
        // 3. Panel: overdue
        JPanel overduePanel = new OrderPanels("Order Overdue", "These Ordes are overdue!", 252, 130, 136);


        buttonPanel.add(new JButton("search"));
        buttonPanel.add(new JButton("create Order"));
        this.add(buttonPanel, BorderLayout.NORTH);
        this.add(orderPanel, BorderLayout.CENTER);
        orderPanel.add(onTimePanel);
        orderPanel.add(atRiskPanel);
        orderPanel.add(overduePanel);

    
    
    }

}