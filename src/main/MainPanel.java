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

    public static String getAppTitle() {
        return appTitle;
    }

    public static NavigationPane getNavPane() {
        return navPane;
    }

    public static HeaderPanel getHeaderPanel() {
        return headerPanel;
    }

    public static void setAppTitle(String appTitleSet) {
        appTitle = appTitleSet;
    }

    public static void setNavPane(NavigationPane navPaneSet) {
        navPane = navPaneSet;
    }

    public static void setHeaderPanel(HeaderPanel headerPanelSet) {
        headerPanel = headerPanelSet;
    }
}