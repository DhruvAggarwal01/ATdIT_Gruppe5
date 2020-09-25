package main;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import db_interaction.LogInCredentialsChecker;
import exceptions.LoginException;
import listener.LoginCancelForgottenListener;
import listener.LoginKeyListener;

/**
 * Diese Klasse erzeugt ein Panel mit den nötigen mit den nötigen
 * Swing/AWT-Komponenten für den Login Prozess.
 * 
 * @author Sophie Orth, Monica Alessi, Dhruv Aggarwal, Maik Fichtenkamm, Lucas
 *         Lahr
 */
public class LoginButtonPanel extends JPanel {

    private static final long serialVersionUID = 40424705904401071L;

    private JLabel usernameLabel;
    private JTextField usernameField;
    private JLabel passwordLabel;
    private JPasswordField passwordField;
    private JLabel possibleErrorMessageLabel;
    private JButton loginButton, cancelButton, pswdForgottenButton;

    /**
     * Konstruktor, der das LoginButtonPanel erzeugt, die nötigen
     * Swing/AWT-Komponenten initiiert und zum JFrame dazufügt.
     * 
     * @param opaque gewährleistet, dass das Panel durchsichtig ist
     * @param layout setzt das richtige Layout des Panels
     */
    public LoginButtonPanel(boolean opaque, LayoutManager layout) {
        super(layout);
        setOpaque(opaque);

        init();
        addComponents();
    }

    /**
     * Diese Methode initialisiert die Swing/AWT-Komponenten und fügt die nötigen
     * Listener den Komponenten hinzu.
     */
    public void init() {
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
                "                                                                                                                 ");
        possibleErrorMessageLabel.setFont(Styles.ERROR_MSG_FONT);
    }

    /**
     * Diese Methode fügt die initialisierten Komponenten dem Panel hinzu.
     */
    public void addComponents() {
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
        try {
            log.setSessionUser();
        } catch (LoginException le) {
            String exceptionMessage = le.getExceptionMessage();
            possibleErrorMessageLabel.setText(exceptionMessage);
            return false;
        }
        return true;
    }

    /* ----------------------- Getter/Setter-Methoden --------------------------- */
    /**
     * Getter-Methode für das Text-Eingabefeld "Benutzername"
     * 
     * @return Text-Eingabefeld "Benutzername"
     */
    public JTextField getUsernameField() {
        return usernameField;
    }

    /**
     * Getter-Methode für das Passwort-Eingabefeld
     * 
     * @return Passwort-Eingabefeld
     */
    public JPasswordField getPasswordField() {
        return passwordField;
    }

    /**
     * Getter-Methode für das mögliche Errorlabel
     * 
     * @return mögliches Errorlabel
     */
    public JLabel getPossibleErrorMessageLabel() {
        return possibleErrorMessageLabel;
    }

    /**
     * Getter-Methode für den "Login"-Button
     * 
     * @return "Login"-Button
     */
    public JButton getLoginButton() {
        return this.loginButton;
    }

    /**
     * Getter-Methode für den "Abbrechen"-Button
     * 
     * @return "Abbrechen"-Button
     */
    public JButton getCancelButton() {
        return this.cancelButton;
    }

    /**
     * Getter-Methode für den "Passwort vergessen"-Button
     * 
     * @return "Passwort vergessen"-Button
     */
    public JButton getPswdForgottenButton() {
        return this.pswdForgottenButton;
    }
}