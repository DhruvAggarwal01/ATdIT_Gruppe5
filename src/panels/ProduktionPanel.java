package panels;


import java.awt.*;
import javax.swing.*;
import main.MainPanel;

public class ProduktionPanel extends JPanel {
    
    private static NavigationPaneProduction navPane;
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    
    public ProduktionPanel() {
        super();
        this.setLayout(new BorderLayout());
        navPane = new NavigationPaneProduction(JTabbedPane.NORTH, JTabbedPane.VERTICAL);
        this.add(navPane, BorderLayout.CENTER);
    }

    private Container getContentPane() {
        return null;
    }

    

}
