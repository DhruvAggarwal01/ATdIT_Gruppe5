package main;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.HashSet;

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
    private static HeaderPane headerPane;

    private Container c;

    /**
     * tbd after User config is done
     */
    public MainPanel() { // User user vorgefertigt einfügen (je nach Bezeichnung Klassenname ändern/je
        // je nach Recht andere NavPane) als Parameter
        c = getContentPane();
        c.setLayout(new BorderLayout());

        headerPane = new HeaderPane(appTitle);
        c.add(headerPane, BorderLayout.NORTH);
        navPane = new NavigationPane(JTabbedPane.LEFT, JTabbedPane.SCROLL_TAB_LAYOUT,
                new HashSet<String>(Arrays.asList("VIEWER", "LOGISTIC_WORKER", "VIEWER"))); // keine Duplikate; werden
                                                                                            // so aus DB übernommen
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
     * Getter-Methode für <code>headerPane</code>
     * 
     * @return <code>headerPane</code>
     */
    public static HeaderPane getHeaderPane() {
        return headerPane;
    }

}