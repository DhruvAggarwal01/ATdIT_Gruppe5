package main;

import javax.swing.JFrame;

import java.awt.Toolkit;

/**
 * Diese Klasse dient zur Ausführung der Anwendungsapplikation.
 * 
 * @author Sophie Orth, Monica Alessi, Dhruv Aggarwal, Maik Fichtenkamm, Lucas
 *         Lahr
 */
public class Application {

    public static TimeoutTimer timeoutTimer;
    private static JFrame appWindow;
    private static int timeoutDelay = 100000;

    /**
     * 
     * @return
     */
    public static JFrame getAppWindow() {
        return appWindow;
    }

    /**
     * 
     * @return
     */
    public static int getTimeoutDelay() {
        return timeoutDelay;
    }

    /**
     * 
     */
    public static void setTimeoutDelay(int timeoutDelaySet) {
        timeoutDelay = timeoutDelaySet;
    }

    /**
     * Ausgabe der Anwendung in einem Fenster
     * 
     * @param args obligatorischer Eingabeparameter (hier: ungenutzt, d.h.
     *             entspricht <code>null</code>)
     */
    public static void main(String[] args) {
        appWindow = new MainPanel();
        appWindow.setTitle("App: " + MainPanel.getAppTitle());
        appWindow.setMinimumSize(Toolkit.getDefaultToolkit().getScreenSize());
        appWindow.pack();
        appWindow.setLocation(0, 0);
        appWindow.setVisible(true);
        appWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        timeoutTimer = new TimeoutTimer(timeoutDelay);
        timeoutTimer.start();
    }
}