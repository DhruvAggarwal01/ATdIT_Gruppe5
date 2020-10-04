package listener;

import java.awt.event.*;
import javax.swing.*;

import db_interaction.DBUsersInserter;
import db_interaction.LogInCredentialsChecker;
import exceptions.DatabaseConnectException;
import exceptions.NoneOfUsersBusinessException;
import main.ActualApp;
import main.AppRunner;
import main.LoginButtonPanel;

/**
 * Diese Klasse dient der Ausführung jeweiliger Aktionen beim Klicken auf ei
 * Login-/Cancel- oder Password-Forgotten-Button.
 * 
 * @author Sophie Orth, Monica Alessi, Dhruv Aggarwal, Maik Fichtenkamm, Lucas
 *         Lahr
 */
public class LoginCancelForgottenListener implements ActionListener {

    private final LoginButtonPanel loginButtonPanelView;

    /**
     * Konstruktor, der eine Referenz auf die Instanz des
     * <code>LoginButtonPanel</code> mithilfe des Parameters herstellt, um damit
     * weiterzuarbeiten.
     * 
     * @param loginButtonPanelView Instanz von <code>LoginButtonPanel</code>
     */
    public LoginCancelForgottenListener(LoginButtonPanel loginButtonPanelView) {
        this.loginButtonPanelView = loginButtonPanelView;
    }

    /**
     * Diese Methode führt je nach geklicktem Button eine zugehörige Funktion aus.
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
                DBUsersInserter dbUsersInserter = new DBUsersInserter("databases/USERS.xlsx");
                try {
                    dbUsersInserter.applyChangedSessionUserToRow();
                } catch (DatabaseConnectException dce) {
                    JPanel exceptionPanel = dce.getExceptionPanel();
                    JOptionPane.showMessageDialog(new JFrame(), exceptionPanel, "Error: " + dce.getClass(),
                            JOptionPane.ERROR_MESSAGE);
                } catch (NoneOfUsersBusinessException noube) {
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