package main;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

/**
 * Diese Klasse leitet den Aufbau der Anwendung ein.
 * 
 * @author Sophie Orth, Monica Alessi, Dhruv Aggarwal, Maik Fichtenkamm, Lucas
 *         Lahr
 */
public class MainPanel extends JFrame {

    private static final long serialVersionUID = -8417942669407317542L;

    private static String appTitle = "Steinbruch ALBERSWEILER";
    private static NavigationPane navPane;
    private static HeaderPanel headerPanel;
    private Container c;

    /**
     * Konstruktor, der zuständig für den Aufbau des Hauptframe-Fensters ist. Das
     * Fenster setzt sich aus Header, Navigationsleiste und dem dazugehörigen
     * Panel-Feld zusammen.
     */
    public MainPanel() { // User user vorgefertigt einfügen (je nach Bezeichnung Klassenname ändern/je
        // je nach Recht andere NavPane) als Parameter
        c = getContentPane();
        c.setLayout(new BorderLayout());

        headerPanel = new HeaderPanel(appTitle);
        navPane = new NavigationPane(JTabbedPane.LEFT, JTabbedPane.SCROLL_TAB_LAYOUT);

        c.add(headerPanel, BorderLayout.NORTH);
        c.add(navPane, BorderLayout.CENTER);
    }

    /**
     * Getter-Methode für <code>appTitle</code>
     * 
     * @return <code>appTitle</code>
     */
    public static String getAppTitle() {
        return appTitle;
    }

    /**
     * Getter-Methode für <code>navPane</code>
     * 
     * @return <code>navPane</code>
     */
    public static NavigationPane getNavPane() {
        return navPane;
    }

    /**
     * Getter-Methode für <code>headerPanel</code>
     * 
     * @return <code>headerPanel</code>
     */
    public static HeaderPanel getHeaderPanel() {
        return headerPanel;
    }

    /**
     * Setter-Methode für <code>appTitle</code>
     * 
     * @return <code>appTitle</code>
     */
    public static void setAppTitle(String appTitleSet) {
        appTitle = appTitleSet;
    }

    /**
     * Setter-Methode für <code>navPane</code>
     * 
     */
    public static void setNavPane(NavigationPane navPaneSet) {
        navPane = navPaneSet;
    }

    /**
     * Setter-Methode für <code>headerPanel</code>
     * 
     */
    public static void setHeaderPanel(HeaderPanel headerPanelSet) {
        headerPanel = headerPanelSet;
    }
}