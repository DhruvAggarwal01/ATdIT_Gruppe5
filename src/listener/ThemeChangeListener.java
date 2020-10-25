package listener;

import javax.swing.*;
import javax.swing.event.*;

import dialogs.SettingsDialog;
import exceptions.ThemeChangeException;
import main.ActualApp;

/**
 * setzt den Nachtmodus-Theme, wenn der Benutzer dies z.B. per JToggleButton
 * einstellt.
 * 
 * @author Sophie Orth, Monica Alessi, Dhruv Aggarwal, Maik Fichtenkamm, Lucas
 *         Lahr
 */
public class ThemeChangeListener implements ChangeListener {

    private final SettingsDialog settingsDialogView;

    /**
     * stellt eine Referenz auf die Instanz des <code>SettingsDialog</code> mithilfe
     * des Parameters her, um damit weiterzuarbeiten.
     * 
     * @param settingsDialogView Instanz von <code>SettingsDialog</code>
     */
    public ThemeChangeListener(SettingsDialog settingsDialogView) {
        this.settingsDialogView = settingsDialogView;
    }

    /**
     * schaltet auf "Knopfdruck" einen Nachtmodus ein bzw. aus.
     * 
     * @param e eingetretenes Event
     */
    @Override
    public void stateChanged(ChangeEvent e) {
        try {
            if (e.getSource() == settingsDialogView.getThemeToggleButton()) {
                if (settingsDialogView.getThemeToggleButton().isSelected()) {
                    settingsDialogView.getThemeToggleButton().setText("On");
                    settingsDialogView.getThemeToggleButton().setIcon(settingsDialogView.nightModeONIcon);
                    try {
                        UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
                        SwingUtilities.updateComponentTreeUI(ActualApp.getAppWindow());
                    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                            | UnsupportedLookAndFeelException excs) {
                        throw new ThemeChangeException(0);
                    }
                } else {
                    settingsDialogView.getThemeToggleButton().setText("Off");
                    settingsDialogView.getThemeToggleButton().setIcon(settingsDialogView.nightModeOFFIcon);
                    try {
                        UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
                        SwingUtilities.updateComponentTreeUI(ActualApp.getAppWindow());
                    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                            | UnsupportedLookAndFeelException excs) {
                        throw new ThemeChangeException(0);
                    }
                }
            }
        } catch (ThemeChangeException tce) {
            JPanel exceptionPanel = tce.getExceptionPanel();
            JOptionPane.showMessageDialog(new JFrame(), exceptionPanel, "Error: " + tce.getClass(),
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}
