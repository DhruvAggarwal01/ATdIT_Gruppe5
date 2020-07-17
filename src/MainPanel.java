import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.HashSet;

/**
 * 
 */
class MainPanel extends JFrame {

    private static final long serialVersionUID = 1L;
    private static String appTitle = "Steinbruch ALBERSWEILER";
    private static JFrame appWindow;
    private static NavigationPane navPane;
    private static HeaderLine headerLin;

    private Container c;

    MainPanel() { // User user vorgefertigt einfügen (je nach Bezeichnung Klassenname ändern/je
                  // nach Recht andere NavPane) als Parameter
        c = getContentPane();
        c.setLayout(new BorderLayout());

        headerLin = new HeaderLine(appTitle);
        c.add(headerLin, BorderLayout.NORTH);
        navPane = new NavigationPane(JTabbedPane.LEFT, JTabbedPane.SCROLL_TAB_LAYOUT,
                new HashSet<String>(Arrays.asList("VIEWER", "VIEWER", "VIEWER")));              //keine Duplikate
        c.add(navPane, BorderLayout.CENTER);
    }

    public static JFrame getAppWindow() {
        return appWindow;
    }

    public static NavigationPane getNavPane() {
        return navPane;
    }

    public static void main(String[] args) {
        appWindow = new MainPanel();
        appWindow.setTitle("App: " + appTitle);
        appWindow.setMinimumSize(Toolkit.getDefaultToolkit().getScreenSize());
        appWindow.pack();
        appWindow.setLocation(0, 0);
        appWindow.setVisible(true);
        appWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}