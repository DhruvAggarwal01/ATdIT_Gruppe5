package main;

import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;

/**
 * Je nach dem welche Rechte der eingeloggte User innehat, sind Tabs nutzbar
 * bzw. nicht nutzbar.
 * 
 * @author Sophie Orth, Monica Alessi, Dhruv Aggarwal, Maik Fichtenkamm, Lucas
 *         Lahr
 */
public class NavigationPane extends JTabbedPane {

    private static final long serialVersionUID = -449442123377295399L;

    private boolean isAllowedToView;

    /**
     * Konstruktor, der die Tableiste (NavigationPane) aufbaut und eine Exception
     * wirft, wenn aus unerklärlichen Gründen die Rechte unbekannt sind.
     * 
     * permGroup ist inzwischen obsolet und wird aus dem Coding genommen tbd
     * 
     * @param tabPlacement    die Platzierung der Tabs relativ zum Inhalt
     * @param tabLayoutPolicy die Richtlinie zum Festlegen von Registerkarten, wenn
     *                        alle Tabs nicht in eine einzelne Ausführung passen
     */
    public NavigationPane(int tabPlacement, int tabLayoutPolicy) {
        super(tabPlacement, tabLayoutPolicy);
        this.setFont(Styles.NAVPANE_FONT);
        this.setBackground(Styles.SURROUNDING_PANEL_COLOR);

        isAllowedToView = true; // noch hartkodiert --> aus User-DB
        if (isAllowedToView) {
            this.addTab("Overview", new NavItemPanelChooser("Overview", null, null));
            this.addTab("ToDo's", new NavItemPanelChooser("ToDo's", null, null));
            this.addTab("Produktion", new NavItemPanelChooser("Produktion", null, null));
            this.addTab("Betriebsmittel", new NavItemPanelChooser("Betriebsmittel", null, null));
            this.addTab("HR", new NavItemPanelChooser("HR", null, null));
            this.addTab("Genehmigungen", new NavItemPanelChooser("Genehmigungen", null, null));
            this.addTab("Logistik", new NavItemPanelChooser("Logistik", null, null));
        } else {
            showError(
                    "Keine gültige Genehmigung für Ihren Nutzer. Kontaktieren Sie Ihren Administrator für weitere Hilfe.",
                    "Problem.");
        }
    }

    public static void showError(String errorMessage, String title) {
        JOptionPane.showMessageDialog(Application.getAppWindow(), errorMessage, title, JOptionPane.INFORMATION_MESSAGE);
    }
}