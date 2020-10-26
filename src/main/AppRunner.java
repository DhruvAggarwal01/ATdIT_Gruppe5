package main;

import java.awt.*;
import javax.swing.*;

/**
 * startet einen LoginScreen und wenn der User einen richtigen Benutzernamen und
 * Passwort eingibt, schließt sie den LoginScreen und startet die eigentliche
 * Applikation <code>ActualApp</code>.
 * 
 * @author Sophie Orth, Monica Alessi, Dhruv Aggarwal, Maik Fichtenkamm, Lucas
 *         Lahr
 */
public class AppRunner {

    public static JFrame loginFrame;

    /**
     * führt die gesamte Anwendung aus und ist damit der Startpunkt.
     * 
     * @param args obligatorischer Eingabeparameter
     */
    public static void main(String[] args) {
        loginFrame = new JFrame();
        loginFrame.setTitle("App: " + MainPanel.getAppTitle());
        loginFrame.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        loginFrame.setResizable(false);
        loginFrame.setLocationRelativeTo(null);
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.add(createMainPanel());
        loginFrame.setVisible(true);
    }

    /**
     * erzeugt im Frame ein Login-Panel mit den nötigen Swing/AWT-Komponenten und
     * sorgt dafür, dass diese richtig ausgerichtet werden.
     * 
     * @return Panel, das das Login-UI enthält
     */
    private static JPanel createMainPanel() {
        BackgroundImagePanel mainPanel = new BackgroundImagePanel(new BorderLayout());

        JPanel structurePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        structurePanel.setOpaque(false); // entscheidet, ob das Button-Panel durchsichtig sein soll

        LoginButtonPanel buttonOnTopPanel = new LoginButtonPanel(structurePanel.isOpaque(), new GridLayout(6, 2, 5, 5));

        structurePanel.add(buttonOnTopPanel);
        mainPanel.add(structurePanel, BorderLayout.CENTER);

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