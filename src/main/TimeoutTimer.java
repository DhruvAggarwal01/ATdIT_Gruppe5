package main;

import javax.swing.*;
import java.awt.event.*;

/**
 * dient zur Verwaltung des TimeoutTimers der Applikation.
 * 
 * @author Sophie Orth, Monica Alessi, Dhruv Aggarwal, Maik Fichtenkamm, Lucas
 *         Lahr
 */
public class TimeoutTimer extends Timer {

    private static final long serialVersionUID = -3664432331102685606L;
    private static int timeoutDelay;

    /**
     * setzt über den super-Konstruktor delay und ActionListener.
     * 
     * @param delay zu wartende Zeit bis Timeout
     */
    public TimeoutTimer(int delay) {
        super(delay, new ActionListener() { // delay time should be settable by user in SettingsDialog
            @Override
            public void actionPerformed(ActionEvent e) {
                ActualApp.getAppWindow().dispose();
            }
        });
        timeoutDelay = delay;
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
     * Setter-Methode für die Zeit bis zum Timeout
     * 
     * @param timeoutDelaySet Zeit bis zum Timeout
     */
    public static void setTimeoutDelay(int timeoutDelaySet) {
        timeoutDelay = timeoutDelaySet;
    }

}