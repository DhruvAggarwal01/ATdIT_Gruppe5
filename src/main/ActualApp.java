package main;

import java.awt.*;
import javax.swing.*;

import db_interaction.LogOffExecutor;
import exceptions.DatabaseConnectException;
import exceptions.InternalException;

/**
 * dient zum Aufbau der eigentlichen Anwendungsapplikation.
 * 
 * @author Sophie Orth, Monica Alessi, Dhruv Aggarwal, Maik Fichtenkamm, Lucas
 *         Lahr
 */
public class ActualApp {

    public static TimeoutTimer timeoutTimer;
    private static int timeoutDelay = 3600000;
    private static JFrame appWindow;

    /**
     * startet den Timer für den Timeout der Applikation.
     * 
     * @param delay zu wartende Zeit bis Timeout
     */
    public static void startTimeoutTimer(int delay) {
        timeoutTimer = new TimeoutTimer(delay);
        timeoutTimer.start();
    }

    /**
     * startet den Timer für den Timeout der Applikation erneut mit seinem
     * eingestellten initialen Delay.
     * 
     * @param delay zu wartende Zeit bis Timeout
     */
    public static void restartTimeoutTimerWithNewDelay(int delay) {
        timeoutTimer.setInitialDelay(delay);
        timeoutTimer.restart();
    }

    /**
     * führt die Applikation aus. Dabei wird ein Hauptframe erzeugt.
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

        appWindow.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                LogOffExecutor logOffExecutor = new LogOffExecutor();
                try {
                    logOffExecutor.logOffAndDispose();
                } catch (DatabaseConnectException dce) {
                    JPanel exceptionPanel = dce.getExceptionPanel();
                    JOptionPane.showMessageDialog(new JFrame(), exceptionPanel, "Error: " + dce.getClass(),
                            JOptionPane.ERROR_MESSAGE);
                } catch (InternalException noube) {
                    JPanel exceptionPanel = noube.getExceptionPanel();
                    JOptionPane.showMessageDialog(new JFrame(), exceptionPanel, "Error: " + noube.getClass(),
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
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