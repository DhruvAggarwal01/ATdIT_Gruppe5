package listener;

import java.awt.event.*;
import javax.swing.*;

import db_interaction.DBGenericInserter;
import db_interaction.LogInCredentialsChecker;
import db_interaction.User;
import exceptions.DatabaseConnectException;
import exceptions.InternalException;
import main.ActualApp;
import main.AppRunner;
import main.LoginButtonPanel;

/**
 * dient der Ausführung jeweiliger Aktionen beim Klicken auf ei Login-/Cancel-
 * oder Password-Forgotten-Button.
 * 
 * @author Sophie Orth, Monica Alessi, Dhruv Aggarwal, Maik Fichtenkamm, Lucas
 *         Lahr
 */
public class LoginCancelForgottenListener implements ActionListener {

    private final LoginButtonPanel loginButtonPanelView;

    /**
     * stellt eine Referenz auf die Instanz des <code>LoginButtonPanel</code>
     * mithilfe des Parameters her, um damit weiterzuarbeiten.
     * 
     * @param loginButtonPanelView Instanz von <code>LoginButtonPanel</code>
     */
    public LoginCancelForgottenListener(LoginButtonPanel loginButtonPanelView) {
        this.loginButtonPanelView = loginButtonPanelView;
    }

    /**
     * führt je nach geklicktem Button eine zugehörige Funktion aus.
     * 
     * @param e eingetretenes Event
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButtonPanelView.getLoginButton()) {
            loginButtonPanelView.getUsernameField()
                    .setText(loginButtonPanelView.getUsernameField().getText().replace(" ", "")); // delete whitespaces
            if (loginButtonPanelView.authenticate()) {
                AppRunner.getLoginFrame().dispose();
                LogInCredentialsChecker.sessionUser.setIsLoggedIn(true);
                DBGenericInserter<User> dbUsersInserter = new DBGenericInserter<User>("databases/DefaultUSERS.xlsx",
                        new User());
                try {
                    dbUsersInserter.applyChangedGenericToRow("personnel_id",
                            LogInCredentialsChecker.sessionUser.getPersonnel_id(), LogInCredentialsChecker.sessionUser);
                } catch (DatabaseConnectException dce) {
                    JPanel exceptionPanel = dce.getExceptionPanel();
                    JOptionPane.showMessageDialog(new JFrame(), exceptionPanel, "Error: " + dce.getClass(),
                            JOptionPane.ERROR_MESSAGE);
                } catch (InternalException noube) {
                    JPanel exceptionPanel = noube.getExceptionPanel();
                    JOptionPane.showMessageDialog(new JFrame(), exceptionPanel, "Error: " + noube.getClass(),
                            JOptionPane.ERROR_MESSAGE);
                }
                ActualApp.startApp();
            } else {
                loginButtonPanelView.getUsernameField().setText("");
                loginButtonPanelView.getPasswordField().setText("");
            }
        }
        if (e.getSource() == loginButtonPanelView.getCancelButton()) {
            loginButtonPanelView.getUsernameField().setText("");
            loginButtonPanelView.getPasswordField().setText("");
        }
        if (e.getSource() == loginButtonPanelView.getPswdForgottenButton()) {
            loginButtonPanelView.getPossibleErrorMessageLabel()
                    .setText("Bitte wenden Sie sich an Ihren Administrator.");
        }
    }

}