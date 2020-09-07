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

    private static Dimension size = Toolkit.getDefaultToolkit().getScreenSize();

    private static JPanel createMainPanel() {
        BackgroundImagePanel mainPanel = new BackgroundImagePanel(new BorderLayout());

        JPanel southPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        southPanel.setOpaque(false); // entscheidet, ob das Button-Panel durchsichtig sein soll
        southPanel.add(new ButtonPanel(southPanel.isOpaque(), new GridLayout(4, 2, 5, 5)));

        mainPanel.add(southPanel, BorderLayout.CENTER);

        return mainPanel;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("BackgroundImage-Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("App: " + MainPanel.getAppTitle());
        frame.add(createMainPanel());
        frame.setSize(size.width, size.height);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}