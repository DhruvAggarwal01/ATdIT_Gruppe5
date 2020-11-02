package atdit1.group5.mainclasses;

import javax.swing.*;
import java.util.ResourceBundle;

import atdit1.group5.Styles;

/**
 * enthält die Tabs der Applikation. Dabei werden über die Klasse
 * <code>NavItemPanelChooser</code> die jeweilig anzuzeigenden Panels
 * aufgerufen.
 * 
 * @author Sophie Orth, Monica Alessi, Dhruv Aggarwal, Maik Fichtenkamm, Lucas
 *         Lahr
 */
public class NavigationPane extends JTabbedPane {

    private static final long serialVersionUID = -449442123377295399L;
    private ResourceBundle text;
    /**
     * Konstruktor, der die Tableiste (NavigationPane) aufbaut und eine Exception
     * wirft, wenn aus unerklärlichen Gründen die Rechte unbekannt sind.
     * 
     * @param tabPlacement    die Platzierung der Tabs relativ zum Inhalt
     * @param tabLayoutPolicy die Richtlinie zum Festlegen von Registerkarten, wenn
     *                        alle Tabs nicht in eine einzelne Ausführung passen
     */
    public NavigationPane(int tabPlacement, int tabLayoutPolicy) {
        super(tabPlacement, tabLayoutPolicy);
        this.text = ResourceBundle.getBundle(("i18n/mainAppStrings"));

        this.setFont(Styles.NAVPANE_FONT);
        this.setBackground(Styles.SURROUNDING_PANEL_COLOR);

        this.addTab(text.getString("overviewString"), new NavItemPanelChooser("Overview", null, null));
        this.addTab( text.getString("todosString") + "'s", new NavItemPanelChooser("ToDo's", null, null));
        this.addTab(text.getString("productionString"), new NavItemPanelChooser("Produktion", null, null));
        this.addTab(text.getString("operatingResourcesString"), new NavItemPanelChooser("Betriebsmittel", null, null));
        this.addTab(text.getString("hrString"), new NavItemPanelChooser("HR", null, null));
        this.addTab(text.getString("permitsString"), new NavItemPanelChooser("Genehmigungen", null, null));
        this.addTab(text.getString("logisticString"), new NavItemPanelChooser("Logistik", null, null));
        // this.addTab("ErrorTab", new NavItemPanelChooser("Error", null, null));
    }

}