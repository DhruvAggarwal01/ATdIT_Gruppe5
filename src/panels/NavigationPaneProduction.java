package panels;

import java.awt.*;
import javax.swing.*;
import javax.swing.JTabbedPane;
import main.Styles;
import subpanels.*;




public class NavigationPaneProduction extends JTabbedPane {
   
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public NavigationPaneProduction(int topAlignment, int tabLayoutPolicy) {
        super(topAlignment, tabLayoutPolicy);

        this.setFont(Styles.NAVPANE_FONT);
        this.setBackground(Styles.SURROUNDING_PANEL_COLOR);

        this.addTab("Dashboard", new Dashboard());
        this.addTab("Karte", new KarteMain());
        this.addTab("Wegoptimierung", new RouteOptimization());
        this.addTab("Leerlaufintervalle", new IdleIntervalls());
        
    }
    
    


}