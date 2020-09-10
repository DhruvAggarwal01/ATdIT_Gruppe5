package listener;

import javax.swing.*;
import javax.swing.event.*;

import dialogs.SettingsDialog;
import main.ActualApp;

/**
 * Diese Klasse tbd
 * 
 * @author Sophie Orth, Monica Alessi, Dhruv Aggarwal, Maik Fichtenkamm, Lucas
 *         Lahr
 */
public class ThemeChangeListener implements ChangeListener {

    private final SettingsDialog settingsDialogView;

    /**
     * Konstruktor, der eine Referenz auf die Instanz des
     * <code>SettingsDialog</code> mithilfe des Parameters herstellt, um damit
     * weiterzuarbeiten.
     * 
     * @param settingsDialogView Instanz von <code>SettingsDialog</code>
     */
    public ThemeChangeListener(SettingsDialog settingsDialogView) {
        this.settingsDialogView = settingsDialogView;
    }

    /**
     * Diese Klasse schaltet auf "Knopfdruck" einen Nachtmodus ein bzw. aus.
     * 
     * @param e eingetretenes Event
     */
    @Override
    public void stateChanged(ChangeEvent e) {
        if (e.getSource() == settingsDialogView.getThemeToggleButton()) {
            if (settingsDialogView.getThemeToggleButton().isSelected()) {
                settingsDialogView.getThemeToggleButton().setText("On");
                settingsDialogView.getThemeToggleButton().setIcon(settingsDialogView.nightModeONIcon);

                try {
                    UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
                    SwingUtilities.updateComponentTreeUI(ActualApp.getAppWindow());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                        | UnsupportedLookAndFeelException e1) {
                    e1.printStackTrace();
                }

            } else {
                settingsDialogView.getThemeToggleButton().setText("Off");
                settingsDialogView.getThemeToggleButton().setIcon(settingsDialogView.nightModeOFFIcon);

                try {
                    UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
                    SwingUtilities.updateComponentTreeUI(ActualApp.getAppWindow());
                } catch (UnsupportedLookAndFeelException e1) {
                } catch (ClassNotFoundException e2) {
                } catch (InstantiationException e3) {
                } catch (IllegalAccessException e4) {
                }
            }
        }
    }
}
