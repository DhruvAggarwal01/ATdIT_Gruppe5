package listener;

import java.awt.Dialog.ModalityType;
import java.awt.event.*;

import javax.swing.*;

import java.io.IOException;

import db_interaction.DBUsersInserter;
import db_interaction.LogInCredentialsChecker;
import dialogs.SettingsDialog;
import dialogs.ProfileDialog;
import main.ActualApp;
import main.HeaderPanel;

/**
 * Diese Klasse tbd
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
     * Je nach gewähltem Menüpunkt wird eine zugehörige Aktion ausgeführt.
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
            LogInCredentialsChecker.sessionUser.setIsLoggedIn(false);
            try {
                DBUsersInserter dbUsersInserter = new DBUsersInserter("databases/USERS.xlsx");
                dbUsersInserter.applyChangedSessionUserToRow();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
            ActualApp.getAppWindow().dispose();
        }
    }
}
