package main;

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
     * Diese main-Methode ist die ausführende Methode für die gesamte Anwendung.
     * 
     * @param args obligatorischer Eingabeparameter
     */
    public static void main(String[] args) {
        loginFrame = new JFrame();
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.setTitle("App: " + MainPanel.getAppTitle());
        loginFrame.setSize(java.awt.Toolkit.getDefaultToolkit().getScreenSize());
        loginFrame.setResizable(false);
        loginFrame.setLocationRelativeTo(null);

        loginFrame.add(createMainPanel());
        loginFrame.setVisible(true);
    }

    /**
     * Diese Methode erzeugt im Frame ein Login-Panel mit den nötigen
     * Swing/AWT-Komponenten und sorgt dafür, dass diese richtig ausgerichtet
     * werden.
     * 
     * @return Panel, das das Login-UI enthält
     */
    private static JPanel createMainPanel() {
        BackgroundImagePanel mainPanel = new BackgroundImagePanel(new java.awt.BorderLayout());

        JPanel structurePanel = new JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER));
        structurePanel.setOpaque(false); // entscheidet, ob das Button-Panel durchsichtig sein soll

        LoginButtonPanel buttonOnTopPanel = new LoginButtonPanel(structurePanel.isOpaque(),
                new java.awt.GridLayout(6, 2, 5, 5));

        structurePanel.add(buttonOnTopPanel);
        mainPanel.add(structurePanel, java.awt.BorderLayout.CENTER);

        return mainPanel;
    }

    /**
     * Getter-Methode für den Login-Frame
     * 
     * @return Login-Frame
     */
    public static JFrame getLoginFrame() {
        return loginFrame;
    }
}