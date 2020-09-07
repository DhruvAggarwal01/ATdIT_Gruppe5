package main;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class ButtonPanel extends JPanel implements ActionListener {

    private static final long serialVersionUID = 40424705904401071L;

    private JLabel userLabel, passwordLabel, antwort;
    private JButton login, cancel, vergessen;
    private JTextField usernameText;
    private JPasswordField passwordText;

    public ButtonPanel(boolean opaque, LayoutManager layout) {
        super(layout);

        userLabel = new JLabel("Username:");
        passwordLabel = new JLabel("Password:");
        usernameText = new JTextField();        //tbd: whitespace löschen lassen (automatisch)
        passwordText = new JPasswordField();
        login = new JButton("Login");
        cancel = new JButton("Cancel");
        vergessen = new JButton("Password forgotten");
        antwort = new JLabel("");

        setOpaque(opaque);
        add(userLabel);
        add(usernameText);
        add(passwordLabel);
        add(passwordText);
        add(login);
        add(cancel);
        add(vergessen);
        add(antwort);

        login.addActionListener(this);
        cancel.addActionListener(this);
        vergessen.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == login) {
            if (authenticate()) {
                Application.startApp();
            } else {
                antwort.setText("Falscher Benutzername oder Passwort! Bitte erneut eingeben.");
            }
        }
        if (e.getSource() == cancel) {
            usernameText.setText("");
            passwordText.setText("");
        }
        if (e.getSource() == cancel) {
            // Dankenbankanbindung?
        }
    }

    public boolean authenticate() {
        // read in
        String username = usernameText.getText();
        String password = String.valueOf(passwordText.getPassword());
        // hardcoded username and password: hier Datenbankanbindung
        return (username.equals("bob") && password.equals("secret")); // tbd

    }
}
