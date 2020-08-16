package main;

import java.awt.*;
import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.Cursor;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * Diese Klasse baut den Header der Anwendung auf, welcher über den gesamten
 * Ausführzeitraum zu sehen ist.
 * 
 * @author Sophie Orth, Monica Alessi, Dhruv Aggarwal, Maik Fichtenkamm, Lucas
 *         Lahr
 */
public class HeaderPanel extends JPanel {

    private static final long serialVersionUID = 5730113640200437491L;

    public JMenuBar mb;
    public JPanel logoAndHeaderTitle;
    public JLabel logoIconInJLabel;
    public JPanel userIconWithMenuInJPanel;

    /**
     * Konstruktor, der zuständig für den Aufbau des Headers zuständig ist. Der
     * Header setzt sich aus Anwenungsicon, -titel und Usericon zusammen.
     * 
     * @param headerTitle der Anwendungsname
     */
    public HeaderPanel(String headerTitle) { // Nutzer nutzer als parameter
        this.setLayout(new GridLayout(1, 3, 0, 0));
        ImageIcon borderLine = new ImageIcon("Library/images/hammerIcon.png"); // --> andere Option mit Bild
        this.setBorder(BorderFactory.createMatteBorder(-1, -1, -1, -1, borderLine));
        logoAndHeaderTitle = new JPanel(new GridLayout(2, 1));
        userIconWithMenuInJPanel = new JPanel(new BorderLayout()); // Listener soll sich nur auf diesen JPanel beziehen

        // 1a. Anwendungslogo
        logoIconInJLabel = resizeToJLabel("Library/images/dashboardlogo.png", 44, 44, JLabel.CENTER);
        logoIconInJLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        MouseLogoIconListener mLIL = new MouseLogoIconListener();
        logoIconInJLabel.addMouseListener(mLIL);

        // 1b. Anwendungstitel-Text
        JLabel headerTitleJLabel = new JLabel(headerTitle, JLabel.CENTER);
        headerTitleJLabel.setFont(new Font("Serif", Font.BOLD, 36));

        // 1. Zusammenfügung von 1a. und 1b.
        logoAndHeaderTitle.add(logoIconInJLabel);
        logoAndHeaderTitle.add(headerTitleJLabel);

        // 2a. User-Symbol rechts oben
        JLabel userIcon = resizeToJLabel("Library/images/userIcon.png", 60, 60, JLabel.RIGHT);
        userIcon.setCursor(new Cursor(Cursor.HAND_CURSOR));

        AbstractButton userIconButton = new JMenu();
        ImageIcon userImage = new ImageIcon("Library/images/userIcon.png");
        userIconButton.setIcon(userImage);
        JMenuItem welcomeItem = new JMenuItem("<HTML><U>Willkommen (tbd)UserName!</U></HTML>");
        welcomeItem.setEnabled(false);
        userIconButton.add(welcomeItem);
        userIconButton.add(new JMenuItem("Ihr Profil"));
        userIconButton.add(new JMenuItem("Ihre Einstellungen"));
        JMenuItem separatorItem = new JMenuItem("--------------------------");
        separatorItem.setEnabled(false);
        userIconButton.add(separatorItem);
        userIconButton.add(new JMenuItem("Hilfe"));
        userIconButton.add(new JMenuItem("Über..."));
        mb = new JMenuBar();
        mb.add(userIconButton);

        userIconWithMenuInJPanel.add(mb, BorderLayout.EAST);

        this.add(new JLabel()); // Leeres Element links oben
        this.add(logoAndHeaderTitle); // 1.
        this.add(userIconWithMenuInJPanel); // 2.
    }

    class MouseLogoIconListener extends MouseAdapter {

        @Override
        public void mouseClicked(MouseEvent e) {
            MainPanel.getNavPane().setComponentAt(0, new NavItemPanelChooser("Overview", null, null));
            MainPanel.getNavPane().setSelectedIndex(0);
        }

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