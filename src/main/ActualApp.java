package main;

import javax.swing.JFrame;

import java.awt.Toolkit;

/**
 * Diese Klasse dient zum Aufbau der eigentlichen Anwendungsapplikation.
 * 
 * @author Sophie Orth, Monica Alessi, Dhruv Aggarwal, Maik Fichtenkamm, Lucas
 *         Lahr
 */
public class ActualApp {

    public static TimeoutTimer timeoutTimer;
    private static JFrame appWindow;
    private static int timeoutDelay = 3600000;

    /**
     * Getter-Methode für <code>appWindow</code>
     * 
     * @return Hauptframe-Instanz der Applikation
     */
    public static JFrame getAppWindow() {
        return appWindow;
    }

    /**
     * Getter-Methode für <code>timeoutDelay</code>
     * 
     * @return Zeit bis zum Timeout der Applikation
     */
    public static int getTimeoutDelay() {
        return timeoutDelay;
    }

    /**
     * Diese Methode startet den Timer für den Timeout der Applikation.
     * 
     * @param delay zu wartende Zeit bis Timeout
     */
    public static void startTimeoutTimer(int delay) {
        timeoutTimer = new TimeoutTimer(delay);
        timeoutTimer.start();
    }

    public static TimeoutTimer getTimeoutTimer(){
        return timeoutTimer;
    }
     /**
     * Diese Methode startet den Timer für den Timeout der Applikation erneut mit
     * seinem eingestellten initialen Delay.
     * 
     * @param delay zu wartende Zeit bis Timeout
     */
    public static void restartTimeoutTimerWithNewDelay(int delay) {
        timeoutTimer.setInitialDelay(delay);
        timeoutTimer.restart();
    }

    /**
     * Diese Methode führt die Applikation aus. Dabei wird ein Hauptframe erzeugt.
     */
    public static void startApp() {
        appWindow = new MainPanel();
        appWindow.setTitle("App: " + MainPanel.getAppTitle());
        appWindow.setMinimumSize(Toolkit.getDefaultToolkit().getScreenSize());
        appWindow.pack();
        appWindow.setLocation(0, 0);
        appWindow.setVisible(true);
        appWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        startTimeoutTimer(timeoutDelay);
    }
}