package main;

import java.awt.*;
import javax.swing.*;

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
    public MainPanel() {
        c = getContentPane();
        c.setLayout(new BorderLayout());

        headerPanel = new HeaderPanel("<html><p>" + appTitle + "</p></html>");
        navPane = new NavigationPane(JTabbedPane.LEFT, JTabbedPane.SCROLL_TAB_LAYOUT);

        c.add(headerPanel, BorderLayout.NORTH);
        c.add(navPane, BorderLayout.CENTER);
    }

    /* ----------------------- Getter/Setter-Methoden --------------------------- */
    /**
     * Getter-Methode für den Apptitel
     * 
     * @return Apptitel
     */
    public static String getAppTitle() {
        return appTitle;
    }

    /**
     * Setter-Methode für den Apptitel
     * 
     * @param appTitleSet Apptitel
     */
    public static void setAppTitle(String appTitleSet) {
        appTitle = appTitleSet;
    }

    /**
     * Getter-Methode für die Navigationsleiste
     * 
     * @return Navigationsleiste
     */
    public static NavigationPane getNavPane() {
        return navPane;
    }

    /**
     * Setter-Methode für die Navigationsleiste
     * 
     * @param navPaneSet Navigationsleiste
     */
    public static void setNavPane(NavigationPane navPaneSet) {
        navPane = navPaneSet;
    }

    /**
     * Getter-Methode für den Headerpanel
     * 
     * @return Headerpanel
     */
    public static HeaderPanel getHeaderPanel() {
        return headerPanel;
    }

    /**
     * Setter-Methode für den Headerpanel
     * 
     * @param headerPanelSet Headerpanel
     */
    public static void setHeaderPanel(HeaderPanel headerPanelSet) {
        headerPanel = headerPanelSet;
    }
}