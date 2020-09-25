package listener;

import java.awt.Dialog.ModalityType;
import java.awt.event.*;
import javax.swing.*;

import db_interaction.LogOffExecutor;
import dialogs.SettingsDialog;
import dialogs.ProfileDialog;
import main.ActualApp;
import main.HeaderPanel;

/**
 * Diese Klasse dient der Ausführung jeweiliger Aktionen beim Klicken auf eines
 * der Menüpunkte.
 * 
 * @author Sophie Orth, Monica Alessi, Dhruv Aggarwal, Maik Fichtenkamm, Lucas
 *         Lahr
 */
public class ProfileMenuItemListener implements ActionListener {

    private final HeaderPanel headerPanelView;

    /**
     * Konstruktor, der eine Referenz auf die Instanz des <code>HeaderPanel</code>
     * mithilfe des Parameters herstellt, um damit weiterzuarbeiten.
     * 
     * @param headerPanelView Instanz von <code>HeaderPanel</code>
     */
    public ProfileMenuItemListener(HeaderPanel headerPanelView) {
        this.headerPanelView = headerPanelView;
    }

    /**
     * Diese Methode führt je nach gewähltem Menüpunkt eine zugehörige Aktion aus.
     * 
     * @param e eingetretenes Event
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == headerPanelView.getNormItem1()) {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    JDialog profileDialog = new ProfileDialog(ActualApp.getAppWindow(),
                            headerPanelView.getNormItem1().getText(), true);
                    profileDialog.setModalityType(ModalityType.APPLICATION_MODAL);
                    profileDialog.setUndecorated(true);
                    profileDialog.setVisible(true);
                }
            });
        }
        if (e.getSource() == headerPanelView.getNormItem2()) {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    JDialog settingsDialog = new SettingsDialog(ActualApp.getAppWindow(),
                            headerPanelView.getNormItem2().getText(), true);
                    settingsDialog.setModalityType(ModalityType.APPLICATION_MODAL);
                    settingsDialog.setUndecorated(true);
                    settingsDialog.setVisible(true);
                }
            });
        }
        if (e.getSource() == headerPanelView.getLogOffItem()) {
            LogOffExecutor logOffExecutor = new LogOffExecutor();
            logOffExecutor.logOffAndDispose();
        }
    }
}
