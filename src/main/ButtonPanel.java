package main;

import java.awt.*;
import javax.swing.*;

import db_interaction.LogInCredentialsChecker;

import java.awt.event.*;

public class ButtonPanel extends JPanel implements ActionListener {

    private static final long serialVersionUID = 40424705904401071L;

    private JLabel usernameLabel;
    private JTextField usernameField;
    private JLabel passwordLabel;
    private JPasswordField passwordField;
    private JLabel possibleErrorMessageLabel;
    private JButton loginButton, cancelButton, pswdForgottenButton;

    public ButtonPanel(boolean opaque, LayoutManager layout) {
        super(layout);
        setOpaque(opaque);

        usernameLabel = new JLabel("Username:");
        usernameField = new JTextField();
        passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField();

        loginButton = new JButton("Login");
        loginButton.addActionListener(this);
        cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(this);
        pswdForgottenButton = new JButton("Forgot your password?");
        pswdForgottenButton.addActionListener(this);

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

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            usernameField.setText(usernameField.getText().replace(" ", "")); // delete whitespaces
            if (authenticate()) {
                AppRunner.loginFrame.dispose();
                ActualApp.startApp();
            } else {
                usernameField.setText("");
                passwordField.setText("");
            }
        }
        if (e.getSource() == cancelButton) {
            usernameField.setText("");
            passwordField.setText("");
        }
        if (e.getSource() == pswdForgottenButton) {
            possibleErrorMessageLabel.setText("Bitte wenden Sie sich an Ihren Administrator.");
        }
    }

}
