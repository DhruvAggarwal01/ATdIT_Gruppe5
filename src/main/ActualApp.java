package main;

import javax.swing.*;
import java.awt.Toolkit;

/**
 * Diese Klasse dient zum Aufbau der eigentlichen Anwendungsapplikation.
 * 
 * @author Sophie Orth, Monica Alessi, Dhruv Aggarwal, Maik Fichtenkamm, Lucas
 *         Lahr
 */
public class ActualApp {

    public static TimeoutTimer timeoutTimer;
    private static int timeoutDelay = 3600000;
    private static JFrame appWindow;

    /**
     * Diese Methode startet den Timer für den Timeout der Applikation.
     * 
     * @param delay zu wartende Zeit bis Timeout
     */
    public static void startTimeoutTimer(int delay) {
        timeoutTimer = new TimeoutTimer(delay);
        timeoutTimer.start();
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

    
    /**
     * Getter-Methode für den Timeout-Timer
     * 
     * @return Timeout-Timer
     */
    public static TimeoutTimer getTimeoutTimer() {
        return timeoutTimer;
    }

    /**
     * Getter-Methode für die Zeit bis zum Timeout
     * 
     * @return Zeit bis zum Timeout
     */
    public static int getTimeoutDelay() {
        return timeoutDelay;
    }

    /**
     * Getter-Methode für den Anwendungsframe
     * 
     * @return Anwendungsframe
     */
    public static JFrame getAppWindow() {
        return appWindow;
    }

}