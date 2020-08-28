package main;

import java.awt.Toolkit;

import javax.swing.JFrame;

/**
 * Diese Klasse dient zur Ausführung der Anwendungsapplikation.
 * 
 * @author Sophie Orth, Monica Alessi, Dhruv Aggarwal, Maik Fichtenkamm, Lucas
 *         Lahr
 */
public class Application {

    private static JFrame appWindow;

    public static JFrame getAppWindow() {
        return appWindow;
    }

    /**
     * Ausgabe der Anwendung in einem Fenster
     * 
     * @param args obligatorischer Eingabeparameter (hier: ungenutzt, d.h.
     *             entspricht <code>null</code>)
     */
    public static void main(String[] args) {
        // try {
        //     // tbd: theme setting in JDialog, possible to set by user
        //     // UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel"); 
        //     // UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
        //     // UIManager.setLookAndFeel("com.sun.java.swing.plaf.mac.MacLookAndFeel");
        //     // UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        // } catch (UnsupportedLookAndFeelException e) {
        //     // handle exception
        // } catch (ClassNotFoundException e) {
        //     // handle exception
        // } catch (InstantiationException e) {
        //     // handle exception
        // } catch (IllegalAccessException e) {
        //     // handle exception
        // }
        appWindow = new MainPanel();
        appWindow.setTitle("App: " + MainPanel.getAppTitle());
        appWindow.setMinimumSize(Toolkit.getDefaultToolkit().getScreenSize());
        appWindow.pack();
        appWindow.setLocation(0, 0);
        appWindow.setVisible(true);
        appWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}