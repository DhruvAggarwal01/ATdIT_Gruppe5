package atdit1.group5.listener;

import java.awt.event.*;
import javax.swing.*;

import atdit1.group5.db_interaction.DBGenericInserter;
import atdit1.group5.db_interaction.LogInCredentialsChecker;
import atdit1.group5.db_interaction.User;
import atdit1.group5.dialogs.ProfileDialog;
import atdit1.group5.exceptions.DatabaseConnectException;
import atdit1.group5.exceptions.InternalException;

/**
 * dient der Ausführung jeweiliger Aktionen beim Klicken auf ein Reset
 * Entries-/Save- oder Close-Button.
 * 
 * @author Sophie Orth, Monica Alessi, Dhruv Aggarwal, Maik Fichtenkamm, Lucas
 *         Lahr
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
        try {
            if (e.getSource() == profileDialogView.getResetEntriesButton()) {
                profileDialogView.setInitDBUsersData();
            }
            if (e.getSource() == profileDialogView.getSaveButton()) {
                profileDialogView.saveEntriesOfTextFields();
                DBGenericInserter<User> dbUsersInserter = new DBGenericInserter<User>("databases/DefaultUSERS.xlsx",
                        new User());
                dbUsersInserter.applyChangedGenericToRow("personnel_id",
                        LogInCredentialsChecker.sessionUser.getPersonnel_id(), LogInCredentialsChecker.sessionUser);
            }
            if (e.getSource() == profileDialogView.getSaveAndCloseButton()) {
                profileDialogView.saveEntriesOfTextFields();
                DBGenericInserter<User> dbUsersInserter = new DBGenericInserter<User>("databases/DefaultUSERS.xlsx",
                        new User());
                dbUsersInserter.applyChangedGenericToRow("personnel_id",
                        LogInCredentialsChecker.sessionUser.getPersonnel_id(), LogInCredentialsChecker.sessionUser);
                if (profileDialogView.getPossibleErrorMessageLabel().getText().equals("")) {
                    profileDialogView.dispose();
                }
            }
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

}
