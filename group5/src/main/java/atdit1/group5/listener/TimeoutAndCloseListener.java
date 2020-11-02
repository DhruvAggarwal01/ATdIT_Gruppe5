package atdit1.group5.listener;

import java.awt.event.*;

import atdit1.group5.dialogs.SettingsDialog;
import atdit1.group5.mainclasses.ActualApp;

/**
 * setzt die Zeit bis es zum Timeout der App kommt und ob diese Einstellung
 * gespeichert werden soll oder nicht.
 * 
 * @author Sophie Orth, Monica Alessi, Dhruv Aggarwal, Maik Fichtenkamm, Lucas
 *         Lahr
 */
public class TimeoutAndCloseListener implements ActionListener {

    private final SettingsDialog settingsDialogView;

    /**
     * stellt eine Referenz auf die Instanz des <code>SettingsDialog</code> mithilfe
     * des Parameters her, um damit weiterzuarbeiten.
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
