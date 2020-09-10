package listener;

import java.awt.event.*;
import java.io.IOException;

import db_interaction.DBUsersInserter;
import db_interaction.User;
import main.ActualApp;
import main.AppRunner;
import main.LoginButtonPanel;

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
     * tbd
     * 
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButtonPanelView.getLoginButton()) {
            loginButtonPanelView.getUsernameField()
                    .setText(loginButtonPanelView.getUsernameField().getText().replace(" ", "")); // delete whitespaces
            if (loginButtonPanelView.authenticate()) {
                AppRunner.loginFrame.dispose();
                User.isLoggedIn = true;
                try {
                    DBUsersInserter dbUsersInserter = new DBUsersInserter("databases/USERS.xlsx");
                    dbUsersInserter.applyChangedSessionUserToRow();
                } catch (IOException ioe) {
                    ioe.printStackTrace();
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