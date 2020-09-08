package main;

import java.awt.*;
import javax.swing.*;

/**
 * Klasse, die einen LoginScreen startet und wenn der User einen richtigen
 * Benutzernamen und Passwort eingibt, den LoginScreen schließt und die
 * eigentliche Applikation <code>ActualApp</code> startet:
 * 
 * @author Sophie Orth, Monica Alessi, Dhruv Aggarwal, Maik Fichtenkamm, Lucas
 *         Lahr
 */
public class AppRunner {

    public static JFrame loginFrame;

    private static JPanel createMainPanel() {
        BackgroundImagePanel mainPanel = new BackgroundImagePanel(new BorderLayout());

        JPanel southPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        southPanel.setOpaque(false); // entscheidet, ob das Button-Panel durchsichtig sein soll

        LoginButtonPanel buttonOnTopPanel = new LoginButtonPanel(southPanel.isOpaque(), new GridLayout(6, 2, 5, 5));

        southPanel.add(buttonOnTopPanel);

        mainPanel.add(southPanel, BorderLayout.CENTER);

        return mainPanel;
    }

    public static void main(String[] args) {
        loginFrame = new JFrame();
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.setTitle("App: " + MainPanel.getAppTitle());
        loginFrame.add(createMainPanel());
        loginFrame.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        loginFrame.setResizable(false);
        loginFrame.setLocationRelativeTo(null);
        loginFrame.setVisible(true);
    }

}