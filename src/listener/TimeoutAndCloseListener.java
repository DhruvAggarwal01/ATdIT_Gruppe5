package listener;

import java.awt.event.*;

import dialogs.SettingsDialog;
import main.ActualApp;

/**
 * Diese Klasse tbd
 * 
 * @author Sophie Orth, Monica Alessi, Dhruv Aggarwal, Maik Fichtenkamm, Lucas
 *         Lahr
 */
public class TimeoutAndCloseListener implements ActionListener {

    private final SettingsDialog settingsDialogView;

    /**
     * Konstruktor, der eine Referenz auf die Instanz des
     * <code>SettingsDialog</code> mithilfe des Parameters herstellt, um damit
     * weiterzuarbeiten.
     * 
     * @param settingsDialogView Instanz von <code>SettingsDialog</code>
     */
    public TimeoutAndCloseListener(SettingsDialog settingsDialogView) {
        this.settingsDialogView = settingsDialogView;
    }

    /**
     * Je nach betätigtem Button wird eine zugehörige Aktion ausgeführt.
     * 
     * @param e eingetretenes Event
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == settingsDialogView.getCloseButton()) {
            settingsDialogView.dispose();
        }
        if (e.getSource() == settingsDialogView.getApplyAndCloseButton()) {
            ActualApp.restartTimeoutTimerWithNewDelay(
                    ((Integer) settingsDialogView.getTimeoutTimeSpinner().getValue()) * 60000);
            settingsDialogView.dispose();
        }
    }

}
