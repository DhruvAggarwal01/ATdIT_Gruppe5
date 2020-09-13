package panels;

import javax.swing.JTabbedPane;

import main.Styles;
import subpanels.*;

/**
 * Klasse, die die Navigationsleiste im Feld Produktion darstellt.
 * 
 * @author Sophie Orth, Monica Alessi, Dhruv Aggarwal, Maik Fichtenkamm, Lucas
 *         Lahr
 */
public class NavigationPaneProduction extends JTabbedPane {

    private static final long serialVersionUID = 1L;

    /**
     * Konsturktor, der die Navigationsleitse erzeugt. Dabei gibt es 4 Tabs:
     * Dashboard, QuarryMap, Wgeoptimierung und Leerlaufintervalle
     * 
     * @param tabPlacement    die Platzierung der Tabs relativ zum Inhalt
     * @param tabLayoutPolicy die Richtlinie zum Festlegen von Registerkarten, wenn
     *                        alle Tabs nicht in eine einzelne Ausführung passen
     */
    public NavigationPaneProduction(int tabPlacement, int tabLayoutPolicy) {
        super(tabPlacement, tabLayoutPolicy);

        this.setFont(Styles.NAVPANE_FONT);
        this.setBackground(Styles.SURROUNDING_PANEL_COLOR);

        this.addTab("Dashboard", new Dashboard());
        this.addTab("Karte", new QuarryMapMain());
        this.addTab("Wegoptimierung", new RouteOptimization());
        this.addTab("Leerlaufintervalle", new IdleIntervalls());
    }

}