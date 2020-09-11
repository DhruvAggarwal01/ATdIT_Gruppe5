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

    /**
     * Diese Methode erzeugt im Frame ein Login-Panel mit den nötigen
     * Swing/AWT-Komponenten.
     * 
     * @return Panel, das das Login-UI enthält
     */
    private static JPanel createMainPanel() {
        BackgroundImagePanel mainPanel = new BackgroundImagePanel(new BorderLayout());

        JPanel southPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        southPanel.setOpaque(false); // entscheidet, ob das Button-Panel durchsichtig sein soll

        LoginButtonPanel buttonOnTopPanel = new LoginButtonPanel(southPanel.isOpaque(), new GridLayout(6, 2, 5, 5));

        southPanel.add(buttonOnTopPanel);
        mainPanel.add(southPanel, BorderLayout.CENTER);

        return mainPanel;
    }

    /**
     * Diese main-Methode ist die ausführende Methode für die gesamte Anwendung.
     * 
     * @param args obligatorischer Eingabeparameter
     */
    public static void main(String[] args) {
        loginFrame = new JFrame();
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.setTitle("App: " + MainPanel.getAppTitle());
        loginFrame.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        loginFrame.setResizable(false);
        loginFrame.setLocationRelativeTo(null);

        loginFrame.add(createMainPanel());
        loginFrame.setVisible(true);
    }

    /* ----------------------- Getter/Setter-Methoden --------------------------- */
    public static JFrame getLoginFrame() {
        return loginFrame;
    }
}