package panels;
import java.awt.*;
import javax.swing.*;
import subpanels.OrderPanels;




public class LogistikPanel extends JPanel {

    private static final long serialVersionUID = 1L;
    private JPanel buttonPanel;
    private JPanel orderPanel;
    private JPanel onTimePanel;
    private JPanel atRiskPanel;
    private JPanel overduePanel;
  

    /**
     * Konstruktor, der tbd
     * 
     * @return
     */
    public LogistikPanel() {
        this.setLayout(new BorderLayout());
       
        buttonPanel = new JPanel(new GridLayout(1, 2, 300, 300));
        orderPanel = new JPanel(new GridLayout(1, 3, 10, 10));


        // 1. Panel: onTime
        onTimePanel = new OrderPanels("Order on Time", "These Ordes are on Time!", 188, 234, 174);
        // 2. Panel: atRisk
        atRiskPanel = new OrderPanels("Order at Risk", "These Ordes are at Risk of delivering on Time!", 245, 220, 163);
        // 3. Panel: overdue
        overduePanel = new OrderPanels("Order Overdue", "These Ordes are overdue!", 252, 130, 136);


        buttonPanel.add(new JButton("search"));
        buttonPanel.add(new JButton("create Order"));
        this.add(buttonPanel, BorderLayout.NORTH);
        this.add(orderPanel, BorderLayout.CENTER);
        orderPanel.add(onTimePanel);
        orderPanel.add(atRiskPanel);
        orderPanel.add(overduePanel);
    
    
    }

    public JPanel getButtonPanel(){
        return buttonPanel;
    }

    public JPanel getOnTimePanel(){
        return onTimePanel;
    }

    public JPanel getOrderPanel(){
        return orderPanel;
    }

    public JPanel getAtRiskPanel(){
        return atRiskPanel;
    }

    public JPanel getOverduePanel(){
        return overduePanel;
    }

}