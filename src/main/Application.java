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
    private static int timeoutDelay = 3600000;

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

    public static void startTimeoutTimer(int delay) {
        timeoutTimer = new TimeoutTimer(delay);
        timeoutTimer.start();
    }

    public static TimeoutTimer getTimeoutTimer(){
        return timeoutTimer;
    }
    public static void restartTimeoutTimerWithNewDelay(int delay) {
        timeoutTimer.setInitialDelay(delay);
        timeoutTimer.restart();
    }

    /**
     * Ausgabe der Anwendung in einem Fenster
     * 
     * @param args obligatorischer Eingabeparameter der main-Methode
     */
    public static void main(String[] args) {
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