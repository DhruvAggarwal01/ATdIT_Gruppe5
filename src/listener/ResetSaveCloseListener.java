package listener;

import java.awt.event.*;
import javax.swing.*;

import db_interaction.DBUsersInserter;
import dialogs.ProfileDialog;
import exceptions.DatabaseConnectException;
import exceptions.NoneOfUsersBusinessException;

/**
 * Diese Klasse dient der Ausführung jeweiliger Aktionen beim Klicken auf ein
 * Reset Entries-/Save- oder Close-Button.
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
                DBUsersInserter dbUsersInserter = new DBUsersInserter("databases/USERS.xlsx");
                dbUsersInserter.applyChangedSessionUserToRow();
            }
            if (e.getSource() == profileDialogView.getSaveAndCloseButton()) {
                profileDialogView.saveEntriesOfTextFields();
                DBUsersInserter dbUsersInserter = new DBUsersInserter("databases/USERS.xlsx");
                dbUsersInserter.applyChangedSessionUserToRow();
                if (profileDialogView.getPossibleErrorMessageLabel().getText().equals("")) {
                    profileDialogView.dispose();
                }
            }
        } catch (DatabaseConnectException dce) {
            JPanel exceptionPanel = dce.getExceptionPanel();
            JOptionPane.showMessageDialog(new JFrame(), exceptionPanel, "Error: " + dce.getClass(),
                    JOptionPane.ERROR_MESSAGE);
        } catch (NoneOfUsersBusinessException noube) {
            JPanel exceptionPanel = noube.getExceptionPanel();
            JOptionPane.showMessageDialog(new JFrame(), exceptionPanel, "Error: " + noube.getClass(),
                    JOptionPane.ERROR_MESSAGE);
        }
    }

}
