import java.awt.*;
import javax.swing.*;

/**
 * 
 */
public class HeaderLine extends JPanel {

    private static final long serialVersionUID = 5730113640200437491L;

    HeaderLine(String headerTitle) { // Nutzer nutzer als parameter
        this.setLayout(new GridLayout(1, 3, 0, 0));
        ImageIcon borderLine = new ImageIcon("Library/images/hammerIcon.png"); // --> andere Option mit Bild
        this.setBorder(BorderFactory.createMatteBorder(-1, -1, -1, -1, borderLine));
        // this.setBorder(BorderFactory.createEtchedBorder());
        JPanel logoAndHeaderTitle = new JPanel(new GridLayout(2, 1));

        // 1a. DashboardHauptlogo
        JLabel logoIconInJLabel = resizeToJLabel("Library/images/dashboardlogo.png", 44, 44, JLabel.CENTER);
        JPanel logoIconInJPanel = new JPanelWithListener("GoToOverview", new BorderLayout()); // Listener soll sich nur
                                                                                              // auf diesen JPanel
                                                                                              // beziehen
        logoIconInJPanel.add(logoIconInJLabel); // JPanel, um MouseListener hinzufügen zu können

        // 1b. DashboardTitelText
        JLabel headerTitleJLabel = new JLabel(headerTitle, JLabel.CENTER);
        headerTitleJLabel.setFont(new Font("Serif", Font.BOLD, 36)); // eigenen Font in Styles verwenden? tbd mit try
                                                                     // catch

        // 1. Zentral-oberes Element aus Logo und Titel
        logoAndHeaderTitle.add(logoIconInJPanel);
        logoAndHeaderTitle.add(headerTitleJLabel);

        // 2. User-Symbol rechts oben
        JLabel userIcon = resizeToJLabel("Library/images/userIcon.png", 60, 60, JLabel.RIGHT);
        JPanel userIconInJPanel = new JPanelWithListener("OpenUserJMenu", new BorderLayout()); // Listener soll sich nur
                                                                                               // auf diesen JPanel
                                                                                               // beziehen
        userIconInJPanel.add(userIcon, BorderLayout.EAST);

        this.add(new JLabel()); // Leeres Element links oben
        this.add(logoAndHeaderTitle); // 1.
        this.add(userIconInJPanel); // 2.
    }

    /**
     * Diese Methode setzt die Größe eines Bildes <code>filename</code> auf
     * <code>width</code> x <code>height</code>. Danach wird das Bild in ein JLabel
     * gegeben, um dieses wiederum z.B. zur Ausgabe nutzen zu können.
     * 
     * @param filename
     * @param width
     * @param height
     * @return
     */
    private static JLabel resizeToJLabel(String filename, int width, int height, int horizontalAlignment) {
        ImageIcon logoIIcon = new ImageIcon(filename);
        Image logoImage = logoIIcon.getImage();
        logoImage = logoImage.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
        logoIIcon = new ImageIcon(logoImage);
        return new JLabel(logoIIcon, horizontalAlignment);
    }

}