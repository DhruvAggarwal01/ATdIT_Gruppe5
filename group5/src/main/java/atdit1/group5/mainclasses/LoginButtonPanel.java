package atdit1.group5.mainclasses;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ResourceBundle;

import atdit1.group5.db_interaction.LogInCredentialsChecker;
import atdit1.group5.exceptions.LoginException;
import atdit1.group5.exceptions.InternalException;
import atdit1.group5.listener.LoginCancelForgottenListener;
import atdit1.group5.listener.LoginKeyListener;
import atdit1.group5.Styles;

/**
 * erzeugt ein Panel mit den nötigen mit den nötigen Swing/AWT-Komponenten für
 * den Login Prozess.
 * 
 * @author Sophie Orth, Monica Alessi, Dhruv Aggarwal, Maik Fichtenkamm, Lucas
 *         Lahr
 */
public class LoginButtonPanel extends JPanel {

    private static final long serialVersionUID = 40424705904401071L;
    private ResourceBundle text;

    private JLabel usernameLabel;
    private JTextField usernameField;
    private JLabel passwordLabel;
    private JPasswordField passwordField;
    private JLabel possibleErrorMessageLabel;
    private JButton loginButton, cancelButton, pswdForgottenButton;

    /**
     * erzeugt das LoginButtonPanel, das die nötigen Swing/AWT-Komponenten initiiert
     * und zum JFrame dazufügt.
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
     * initialisiert die Swing/AWT-Komponenten und fügt die nötigen Listener den
     * Komponenten hinzu.
     */
    public void init() {
        this.text = ResourceBundle.getBundle(("i18n/loginStrings"));

        KeyListener lKeyListener = new LoginKeyListener(this);
        usernameLabel = new JLabel(text.getString("usernameString"));
        usernameField = new JTextField();
        usernameField.addKeyListener(lKeyListener);
        passwordLabel = new JLabel(text.getString("passwordString"));
        passwordField = new JPasswordField();
        passwordField.addKeyListener(lKeyListener);

        ActionListener lcfListener = new LoginCancelForgottenListener(this);
        loginButton = new JButton(text.getString("loginString"));
        loginButton.addActionListener(lcfListener);
        cancelButton = new JButton(text.getString("cancelString"));
        cancelButton.addActionListener(lcfListener);
        pswdForgottenButton = new JButton(text.getString("forgotPasswordText"));
        pswdForgottenButton.addActionListener(lcfListener);

        possibleErrorMessageLabel = new JLabel(
                "                                                                                                                 ");
        possibleErrorMessageLabel.setFont(Styles.ERROR_MSG_FONT);
    }

    /**
     * fügt die initialisierten Komponenten dem Panel hinzu.
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

    /**
     * überprüft die Korrektheit der Eingaben des Benutzernames und des Passwortes.
     * 
     * 
     * @return Bei richtiger Eingabe wird true zurückgegeben, sonst false
     */
    public boolean authenticate() {
        String username = usernameField.getText();
        String password = String.valueOf(passwordField.getPassword());

        try {
            LogInCredentialsChecker log = new LogInCredentialsChecker(username, password);
            log.setSessionUser();
        } catch (InternalException noube) {
            JPanel exceptionPanel = noube.getExceptionPanel();
            JOptionPane.showMessageDialog(new JFrame(), exceptionPanel, "Error: " + noube.getClass(),
                    JOptionPane.ERROR_MESSAGE);
            return false;
        } catch (LoginException le) {
            String exceptionMessage = le.getExceptionMessage();
            possibleErrorMessageLabel.setText(exceptionMessage);
            return false;
        }
        return true;
    }

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
