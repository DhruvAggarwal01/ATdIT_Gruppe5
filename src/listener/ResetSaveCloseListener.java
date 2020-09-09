package listener;

import java.awt.event.*;
import java.io.IOException;

import db_interaction.DBUsersInserter;
import dialogs.ProfileDialog;

/**
 * Diese Klasse implementiert einen ActionListener für die in
 * <code>ProfileDialog</code> angezeigten Buttons.
 */
public class ResetSaveCloseListener implements ActionListener {

    private final ProfileDialog profileDialogView;

    /**
     * Konstruktor, der eine Referenz auf die Instanz des <code>ProfileDialog</code>
     * mithilfe des Parameters herstellt, um damit weiterzuarbeiten.
     * 
     * @param profileDialogView Instanz von <code>ProfileDialog</code>
     */
    public ResetSaveCloseListener(ProfileDialog profileDialogView) {
        this.profileDialogView = profileDialogView;
    }

    /**
     * Je nach betätigtem Button wird eine zugehörige Aktion ausgeführt.
     * 
     * @param e eingetretenes Event
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == profileDialogView.getResetEntriesButton()) {
            profileDialogView.setInitDBUsersData();
        }
        if (e.getSource() == profileDialogView.getSaveButton()) {
            profileDialogView.saveEntriesOfTextFields();
            try {
                DBUsersInserter dbUsersInserter = new DBUsersInserter("databases/USERS.xlsx");
                dbUsersInserter.applyChangedSessionUserToRow();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
        if (e.getSource() == profileDialogView.getSaveAndCloseButton()) {
            profileDialogView.saveEntriesOfTextFields();
            try {
                DBUsersInserter dbUsersInserter = new DBUsersInserter("databases/USERS.xlsx");
                dbUsersInserter.applyChangedSessionUserToRow();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
            if (profileDialogView.getPossibleErrorMessageLabel().getText().equals("")) {
                profileDialogView.dispose();
            }
        }
    }

}
