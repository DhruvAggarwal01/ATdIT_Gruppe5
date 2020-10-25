package atdit1.group5.panels;

import javax.swing.JTabbedPane;

import atdit1.group5.mainclasses.Styles;
import atdit1.group5.subpanels.*;

/**
 * stellt die Navigationsleiste im Feld Produktion dar.
 * 
 * @author Sophie Orth, Monica Alessi, Dhruv Aggarwal, Maik Fichtenkamm, Lucas
 *         Lahr
 */
public class NavigationPaneProduction extends JTabbedPane {

    private static final long serialVersionUID = 1L;

    /**
     * erzeugt die Navigationsleiste. Dabei gibt es 4 Tabs: Dashboard, QuarryMap,
     * Wgeoptimierung und Leerlaufintervalle
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