package main;

import javax.swing.Timer;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TimeoutTimer extends Timer  {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private static int timeoutDelay;

    public TimeoutTimer(int delay) {
        super(delay, new ActionListener() { // delay time should be settable by user in SettingsDialog
            @Override
            public void actionPerformed(ActionEvent e) {
                Application.getAppWindow().dispose();
            }
        });
        timeoutDelay = delay;
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

    
}