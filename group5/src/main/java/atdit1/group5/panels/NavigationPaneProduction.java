package atdit1.group5.panels;

import javax.swing.JTabbedPane;
import java.util.ResourceBundle;

import atdit1.group5.Styles;
import atdit1.group5.subpanels.*;

/**
 * stellt die Navigationsleiste im Feld Produktion dar.
 * 
 * @author Sophie Orth, Monica Alessi, Dhruv Aggarwal, Maik Fichtenkamm, Lucas
 *         Lahr
 */
public class NavigationPaneProduction extends JTabbedPane {

    private static final long serialVersionUID = 6025004272718022771L;
    private ResourceBundle text;

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
        this.text = ResourceBundle.getBundle(("i18n/productionStrings"));

        this.setFont(Styles.NAVPANE_FONT);
        this.setBackground(Styles.SURROUNDING_PANEL_COLOR);

        this.addTab(text.getString("dashboardString"), new Dashboard());
        this.addTab(text.getString("mapString"), new QuarryMapMain());
        this.addTab(text.getString("optimalPathString"), new RouteOptimization());
        this.addTab(text.getString("ideleIntervalString"), new IdleIntervalls());
    }

}