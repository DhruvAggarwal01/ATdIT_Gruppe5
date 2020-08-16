package main;

import java.util.Set;

import javax.swing.*;

/**
 * Je nach dem welche Rechte der eingeloggte User innehat, sind Tabs nutzbar
 * bzw. nicht nutzbar.
 * 
 * @author Sophie Orth, Monica Alessi, Dhruv Aggarwal, Maik Fichtenkamm, Lucas
 *         Lahr
 */
public class NavigationPane extends JTabbedPane {

    private static final long serialVersionUID = -449442123377295399L;

    /**
     * Konstruktor, der die Tableiste (NavigationPane) aufbaut und eine Exception
     * wirft, wenn aus unerklärlichen Gründen die Rechte unbekannt sind.
     * 
     * permGroup ist inzwischen obsolet und wird aus dem Coding genommen tbd
     * 
     * @param tabPlacement    die Platzierung der Tabs relativ zum Inhalt
     * @param tabLayoutPolicy die Richtlinie zum Festlegen von Registerkarten, wenn
     *                        alle Tabs nicht in eine einzelne Ausführung passen
     * @param permGroup       die Rechte, die ein Nutzer innehat
     */
    public NavigationPane(int tabPlacement, int tabLayoutPolicy, Set<String> permGroup) {
        super(tabPlacement, tabLayoutPolicy);
        this.setFont(Styles.NAVPANE_FONT);
        // int i = 0;
        for (String s : permGroup) {
            switch (s) {
                case "VIEWER":
                    this.addTab("Overview", new NavItemPanelChooser("Overview", null, null));
                    this.addTab("ToDo's", new NavItemPanelChooser("ToDo's", null, null));
                    this.addTab("Produktion", new NavItemPanelChooser("Produktion", null, null));
                    this.addTab("Betriebsmittel", new NavItemPanelChooser("Betriebsmittel", null, null));
                    this.addTab("Reporting", new NavItemPanelChooser("Reporting", null, null));
                    break;
                case "GENERIC_WORKER":
                    this.addTab("HR", new NavItemPanelChooser("HR", null, null));
                    this.addTab("Genehmigungen", new NavItemPanelChooser("Genehmigungen", null, null));
                    break;
                case "LOGISTIC_WORKER":
                    this.addTab("Logistik", new NavItemPanelChooser("Logistik", null, null));
                    break;
                default:
                    break;
                // throw new Exception("Keine gültige Permission für Ihren Nutzer. Kontaktieren
                // Sie Ihren Administrator für weitere Hilfe.");
            }
        }
    }

}