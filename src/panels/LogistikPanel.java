package panels;
import java.awt.*;
import javax.swing.*;
import subpanels.DiashowPanel;
import subpanels.OnTimePanel;
import subpanels.WeatherPanel;



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
        JPanel orderPanel = new JPanel(new GridLayout(1, 3, 300, 300));


        // 1. Panel: onTime
        JPanel onTimePanel = new OnTimePanel("Order on Time");
        // 2. Panel: atRisk
        JPanel atRiskPanel = new OnTimePanel("Order at Risk");
        // 3. Panel: overdue
        JPanel overduePanel = new OnTimePanel("Order Overdue");


        buttonPanel.add(new JButton("search"));
        buttonPanel.add(new JButton("create Order"));
        this.add(buttonPanel, BorderLayout.NORTH);
        this.add(orderPanel, BorderLayout.CENTER);
        orderPanel.add(onTimePanel);
        orderPanel.add(atRiskPanel);
        orderPanel.add(overduePanel);

    
    
    }

}