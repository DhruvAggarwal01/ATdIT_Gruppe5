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
class MainPanel extends JFrame {

    private static final long serialVersionUID = -8417942669407317542L;

    private static String appTitle = "Steinbruch ALBERSWEILER";
    private static NavigationPane navPane;
    private static HeaderLine headerLine;

    private Container c;

    /**
     * tbd after User config is done
     */
    MainPanel() { // User user vorgefertigt einfügen (je nach Bezeichnung Klassenname ändern/je
                  // nach Recht andere NavPane) als Parameter
        c = getContentPane();
        c.setLayout(new BorderLayout());

        headerLine = new HeaderLine(appTitle);
        c.add(headerLine, BorderLayout.NORTH);
        navPane = new NavigationPane(JTabbedPane.LEFT, JTabbedPane.SCROLL_TAB_LAYOUT,
                new HashSet<String>(Arrays.asList("VIEWER", "VIEWER", "VIEWER"))); // keine Duplikate
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
     * Getter-Methode für <code>headerLine</code>
     * 
     * @return <code>headerLine</code>
     */
    public static HeaderLine getHeaderLine() {
        return headerLine;
    }

}