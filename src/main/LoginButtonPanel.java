package main;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import db_interaction.LogInCredentialsChecker;
import listener.LoginCancelForgottenListener;
import listener.LoginKeyListener;

public class LoginButtonPanel extends JPanel {

    private static final long serialVersionUID = 40424705904401071L;

    private JLabel usernameLabel;
    private JTextField usernameField;
    private JLabel passwordLabel;
    private JPasswordField passwordField;
    private JLabel possibleErrorMessageLabel;
    private JButton loginButton, cancelButton, pswdForgottenButton;

    public LoginButtonPanel(boolean opaque, LayoutManager layout) {
        super(layout);
        setOpaque(opaque);

        KeyListener lKeyListener = new LoginKeyListener(this);
        usernameLabel = new JLabel("Username:");
        usernameField = new JTextField();
        usernameField.addKeyListener(lKeyListener);
        passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField();
        passwordField.addKeyListener(lKeyListener);

        ActionListener lcfListener = new LoginCancelForgottenListener(this);
        loginButton = new JButton("Login");
        loginButton.addActionListener(lcfListener);
        cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(lcfListener);
        pswdForgottenButton = new JButton("Forgot your password?");
        pswdForgottenButton.addActionListener(lcfListener);

        possibleErrorMessageLabel = new JLabel(
                "                                                                                              ");
        possibleErrorMessageLabel.setFont(Styles.ERROR_MSG_FONT);

        add(new JLabel(""));
        add(new JLabel(""));
        add(new JLabel(""));
        add(new JLabel(""));

        add(usernameLabel);
        add(usernameField);
        add(passwordLabel);
        add(passwordField);
        add(loginButton);
        add(cancelButton);
        add(pswdForgottenButton);
        add(possibleErrorMessageLabel);
    }

    public boolean authenticate() {
        String username = usernameField.getText();
        String password = String.valueOf(passwordField.getPassword());

        LogInCredentialsChecker log = new LogInCredentialsChecker(username, password);
        log.setSessionUser();
        possibleErrorMessageLabel.setText(log.possibleErrorString);

        return log.isCredentialsMatching();
    }

    public JTextField getUsernameField() {
        return usernameField;
    }

    public JPasswordField getPasswordField() {
        return passwordField;
    }

    public JLabel getPossibleErrorMessageLabel() {
        return possibleErrorMessageLabel;
    }

    public JButton getLoginButton() {
        return this.loginButton;
    }

    public JButton getCancelButton() {
        return this.cancelButton;
    }

    public JButton getPswdForgottenButton() {
        return this.pswdForgottenButton;
    }

}
