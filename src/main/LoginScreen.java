package main;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Graphics;

/**
 * Klasse, die einen LoginScreen startet und wenn der User einen richtigen
 * Benutzernamen und Passwort eingibt, den LoginScreen schließt und die
 * eigentliche Applikation startet:
 * 
 * @author Sophie Orth, Monica Alessi, Dhruv Aggarwal, Maik Fichtenkamm, Lucas
 *         Lahr
 */
public class LoginScreen {

    private static final long serialVersionUID = -7948772298520160976L;
    Dimension size = Toolkit.getDefaultToolkit().getScreenSize();

    /**
     * 
     */
    public LoginScreen() {

        JFrame frame = new JFrame("BackgroundImage-Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("App: " + MainPanel.getAppTitle());
        frame.add(createMainPanel());
        frame.setSize(size.width, size.height);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private JPanel createMainPanel() {
        BackgroundImagePanel mainPanel = new BackgroundImagePanel(new BorderLayout());

        JPanel southPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        southPanel.setOpaque(false); // entscheidet, ob das Button-Panel durchsichtig sein soll
        southPanel.add(new ButtonPanel(southPanel.isOpaque(), new GridLayout(4, 2, 5, 5)));

        mainPanel.add(southPanel, BorderLayout.CENTER);

        return mainPanel;
    }

    public static void main(String[] args) {
        new LoginScreen();
    }

    


}