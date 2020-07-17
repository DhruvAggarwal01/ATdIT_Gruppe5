import java.util.Set;

import javax.swing.*;

/**
 * 
 */
public class NavigationPane extends JTabbedPane {

    private static final long serialVersionUID = -449442123377295399L;

    /**
     * Der Konstruktor
     * 
     * @param tabPlacement    //JavaDoc der Oberklasse für diesen Parameter
     * @param tabLayoutPolicy
     * @param permGroup
     */
    NavigationPane(int tabPlacement, int tabLayoutPolicy, Set<String> permGroup) {
        super(tabPlacement, tabLayoutPolicy);
        this.setFont(Styles.NAVPANE_FONT);
        // int i = 4;
        for (String s : permGroup) {
            switch (s) {
                // FEATURE 1
                // case "VIEWER":
                // this.addTab("Overview", new JLabel());
                // this.addTab("ToDo's", new JLabel());
                // this.addTab("Produktion", new JPanel());
                // this.addTab("Betriebsmittel", new JPanel());
                // this.addTab("Reporting", new JPanel());
                // this.addTab("", new JPanel());
                // this.setEnabledAt(5, false);
                // this.addTab("Close...", new JPanel());
                // this.setBackgroundAt(6, Color.RED);
                // break;
                // case "GENERIC_WORKER":
                // this.insertTab("HR", null, new JPanel(), null, i++);
                // this.insertTab("Genehmigungen", null, new JPanel(), null, i++);
                // break;
                // case "LOGISTIC_WORKER":
                // this.insertTab("Logistik", null, new JPanel(), null, i++); // oder: mit
                // addTab
                // break;
                // case "ADMIN":
                // this.insertTab("Admin-Settings", null, new JPanel(), null, i++); // oder: mit
                // addTab
                // break;

                // FEATURE 2
                case "VIEWER":
                    this.addTab("Overview", new NavItemPanelChooser("Overview")); // die JPanels werden über
                                                                                  // NavItemPanelChooser je nach Tab
                                                                                  // gewechselt; in this.getName() steht
                                                                                  // hier: "Overview"
                    this.addTab("ToDo's", new NavItemPanelChooser("ToDo's"));
                    this.addTab("Produktion", new NavItemPanelChooser("Produktion"));
                    this.addTab("Betriebsmittel", new NavItemPanelChooser("Betriebsmittel"));
                    this.addTab("Reporting", new NavItemPanelChooser("Reporting"));

                    this.addTab("HR", new NavItemPanelChooser("HR"));
                    this.setEnabledAt(this.indexOfTab("HR"), false);
                    this.addTab("Genehmigungen", new NavItemPanelChooser("Genehmigungen"));
                    this.setEnabledAt(this.indexOfTab("Genehmigungen"), false);
                    this.addTab("Logistik", new NavItemPanelChooser("Logistik"));
                    this.setEnabledAt(this.indexOfTab("Logistik"), false);
                    this.addTab("Admin-Settings", new NavItemPanelChooser("Admin-Settings"));
                    this.setEnabledAt(this.indexOfTab("Admin-Settings"), false);

                    this.addTab("", null); // mit /n bis nach untern Close
                    this.setEnabledAt(this.indexOfTab(""), false);

                    break;
                case "GENERIC_WORKER":
                    this.setEnabledAt(this.indexOfTab("HR"), true);
                    this.setEnabledAt(this.indexOfTab("Genehmigungen"), true);
                    break;
                case "LOGISTIC_WORKER":
                    this.setEnabledAt(this.indexOfTab("Logistik"), true);
                    break;
                case "ADMIN":
                    this.setEnabledAt(this.indexOfTab("Admin-Settings"), true);
                    break;
                default:
                    break;
                // throw new Exception("Keine gültige Permission für Ihren Nutzer. Kontaktieren
                // Sie Ihren Administrator für weitere Hilfe.");
            }
        }
    }
}