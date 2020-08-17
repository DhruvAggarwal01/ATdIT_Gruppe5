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

    public JPanel logoAndHeaderTitle;
    public JLabel logoIconInJLabel;
    public JLabel headerTitleJLabel;
    public AbstractButton userIconButton;
    public JMenuBar mb;
    public JPanel userIconWithMenuInJPanel;

    /**
     * Konstruktor, der zuständig für den Aufbau des Headers zuständig ist. Der
     * Header setzt sich aus Anwenungsicon, -titel und Usericon zusammen.
     * 
     * @param headerTitle der Anwendungsname
     */
    public HeaderPanel(String headerTitle) { // Nutzer nutzer als parameter
        initSetUp();

        logoAndHeaderTitle.add(logoAdder("Library/images/dashboardlogo.png"));
        logoAndHeaderTitle.add(headerTitleAdder(headerTitle));

        userIconWithMenuInJPanel.add(userSymbolAdder("Library/images/userIcon.png"), BorderLayout.EAST);

        this.add(new JLabel());
        this.add(logoAndHeaderTitle);
        this.add(userIconWithMenuInJPanel);
    }

    /**
     * Diese Methode nimmt die initialen Voreinstellungen, wie
     * <code>setLayout</code>, <code>setBorder</code>, vor und stellt die benötigten
     * Subpanels bereit.
     * 
     */
    public void initSetUp() {
        this.setLayout(new GridLayout(1, 3, 0, 0));
        ImageIcon borderLine = new ImageIcon("Library/images/hammerIcon.png"); // --> andere Option mit Bild
        this.setBorder(BorderFactory.createMatteBorder(-1, -1, -1, -1, borderLine));

        logoAndHeaderTitle = new JPanel(new GridLayout(2, 1));
        userIconWithMenuInJPanel = new JPanel(new BorderLayout()); // Listener soll sich nur auf diesen JPanel beziehen
    }

    /**
     * Diese Methode passt das Icon an, verbessert die UX und Interaktion mit einem
     * Benutzer und gibt das Icon, gewrappt durch ein JLabel, wieder zurück.
     * 
     * @param filename
     * @return angepasstes Applogo-Icon
     */
    public JLabel logoAdder(String filename) {
        logoIconInJLabel = resizeToJLabel(filename, 44, 44, JLabel.CENTER);
        logoIconInJLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        logoIconInJLabel.addMouseListener(new MouseLogoIconListener());

        return logoIconInJLabel;
    }

    /**
     * Diese Methode nimmt einen geünschten Titel entgegen, welcher mit einem Font
     * versehen und schließlich, gewrappt durch ein JLabel, wieder zurückgegeben
     * wird.
     * 
     * @param headerTitle
     * @return Label für Titel
     */
    public JLabel headerTitleAdder(String headerTitle) {
        headerTitleJLabel = new JLabel(headerTitle, JLabel.CENTER);
        headerTitleJLabel.setFont(new Font("Serif", Font.BOLD, 36));

        return headerTitleJLabel;
    }

    /**
     * 
     * 
     * @param filename
     * @return
     */
    public JMenuBar userSymbolAdder(String filename) {
        userIconButton = new JMenu();

        ImageIcon userImage = new ImageIcon(filename);
        userIconButton.setIcon(userImage);

        JMenuItem welcomeItem = new JMenuItem("<HTML><U>Willkommen (tbd)UserName!</U></HTML>");
        welcomeItem.setEnabled(false);
        JMenuItem normItem1 = new JMenuItem("Ihr Profil");
        JMenuItem normItem2 = new JMenuItem("Ihre Einstellungen");
        JMenuItem separatorItem = new JMenuItem("--------------------------");
        separatorItem.setEnabled(false);
        JMenuItem normItem3 = new JMenuItem("Hilfe");
        JMenuItem normItem4 = new JMenuItem("Über...");

        userIconButton.add(welcomeItem);
        userIconButton.add(normItem1);
        userIconButton.add(normItem2);
        userIconButton.add(separatorItem);
        userIconButton.add(normItem3);
        userIconButton.add(normItem4);

        mb = new JMenuBar();
        mb.add(userIconButton);

        return mb;
    }

    /**
     * Innere Klasse für den MouseListener speziell für das Applogo-Icon
     */
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
     * @return fit-resized Applogo-Icon
     */
    private static JLabel resizeToJLabel(String filename, int width, int height, int horizontalAlignment) {
        ImageIcon logoIIcon = new ImageIcon(filename);
        Image logoImage = logoIIcon.getImage();
        logoImage = logoImage.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
        logoIIcon = new ImageIcon(logoImage);

        return new JLabel(logoIIcon, horizontalAlignment);
    }

}