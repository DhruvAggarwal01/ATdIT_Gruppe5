package main;

import java.awt.event.*;
import javax.swing.*;

import listener.LogoIconMouseAdapter;
import listener.ProfileMenuItemListener;
import listener.UserIconMouseAdapter;

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

    private AbstractButton userIconButton;
    private JMenuBar mb;
    private JMenuItem normItem1;
    private JMenuItem normItem2;
    private JMenuItem normItem3;
    private JMenuItem normItem4;
    private JMenuItem logOffItem;
    private JMenuItem welcomeItem;

    public JPanel userIconWithMenuInJPanel;

    /**
     * Konstruktor, der zuständig für den Aufbau des Headers zuständig ist. Der
     * Header setzt sich aus Anwendungsicon, -titel und User-Icon zusammen.
     * 
     * @param headerTitle Applikationstitel
     */
    public HeaderPanel(String headerTitle) {
        initSetUp();

        logoAndHeaderTitle.add(logoAdder("Library/images/dashboardlogo.png"));
        logoAndHeaderTitle.add(headerTitleAdder(headerTitle));

        userIconWithMenuInJPanel.add(userSymbolAdder("Library/images/userIcon.png"), java.awt.BorderLayout.EAST);

        this.add(new JLabel());
        this.add(logoAndHeaderTitle);
        this.add(userIconWithMenuInJPanel);
    }

    /**
     * Diese Methode nimmt die initialen Voreinstellungen, wie
     * <code>setLayout</code>, <code>setBorder</code>, vor und stellt die benötigten
     * Subpanels bereit.
     */
    public void initSetUp() {
        this.setLayout(new java.awt.GridLayout(1, 3, 0, 0));
        ImageIcon borderLine = new ImageIcon("Library/images/hammerIcon.png");
        this.setBorder(BorderFactory.createMatteBorder(-1, -1, -1, -1, borderLine));
        this.setBackground(Styles.SURROUNDING_PANEL_COLOR);

        logoAndHeaderTitle = new JPanel(new java.awt.GridLayout(2, 1));
        logoAndHeaderTitle.setBackground(Styles.SURROUNDING_PANEL_COLOR);
        userIconWithMenuInJPanel = new JPanel(new java.awt.BorderLayout());
        userIconWithMenuInJPanel.setBackground(Styles.SURROUNDING_PANEL_COLOR);
    }

    /**
     * Diese Methode passt das Icon an, verbessert die UX mittels Cursor-Anpassung
     * und Interaktion mit einem Benutzer und gibt das Icon, gewrappt durch ein
     * JLabel, wieder zurück.
     * 
     * @param filename Pfad zum Logo-Icon
     * @return angepasstes Logo-Icon
     */
    public JLabel logoAdder(String filename) {
        logoIconInJLabel = resizeToJLabel(filename, 32, 32, JLabel.CENTER);
        logoIconInJLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        MouseAdapter liMouseAdapter = new LogoIconMouseAdapter();
        logoIconInJLabel.addMouseListener(liMouseAdapter);

        return logoIconInJLabel;
    }

    /**
     * Diese Methode nimmt einen gewünschten Titel entgegen, welcher mit einem Font
     * versehen und schließlich, gewrappt durch ein JLabel, wieder zurückgegeben
     * wird.
     * 
     * @param headerTitle Header-Titel
     * @return Label für Titel
     */
    public JLabel headerTitleAdder(String headerTitle) {
        headerTitleJLabel = new JLabel(headerTitle, SwingConstants.CENTER);
        headerTitleJLabel.setFont(Styles.APPHEADING);

        return headerTitleJLabel;
    }

    /**
     * Diese Methode baut ein User-Menü mit den nötigen Menü-Items auf und setzt als
     * "Menüheader" ein User-Icon.
     * 
     * @param userIconFile Pfad zum User-Icon
     * @return User-Icon-Menü innerhalb einer JMenuBar
     */
    public JMenuBar userSymbolAdder(String userIconFile) {
        userIconButton = new JMenu();
        ImageIcon userImage = new ImageIcon(userIconFile);
        userIconButton.setIcon(userImage);

        MouseAdapter uiMouseAdapter = new UserIconMouseAdapter(this);
        userIconButton.addMouseListener(uiMouseAdapter);

        ImageIcon profileIcon = new ImageIcon(new ImageIcon("Library/images/profileIcon.png").getImage()
                .getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH));
        ImageIcon settingsIcon = new ImageIcon(new ImageIcon("Library/images/settingsIcon.png").getImage()
                .getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH));
        ImageIcon helpIcon = new ImageIcon(new ImageIcon("Library/images/helpIcon.png").getImage().getScaledInstance(20,
                20, java.awt.Image.SCALE_SMOOTH));
        ImageIcon aboutIcon = new ImageIcon(new ImageIcon("Library/images/aboutIcon.png").getImage()
                .getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH));

        ActionListener pmiListener = new ProfileMenuItemListener(this);
        normItem1 = new JMenuItem("Ihr Profil", profileIcon);
        normItem1.addActionListener(pmiListener);
        normItem2 = new JMenuItem("Ihre Einstellungen", settingsIcon);
        normItem2.addActionListener(pmiListener);
        JMenuItem separatorItem = new JMenuItem("--------------------------");
        separatorItem.setEnabled(false);
        normItem3 = new JMenuItem("Hilfe", helpIcon);
        normItem4 = new JMenuItem("Über...", aboutIcon);
        logOffItem = new JMenuItem("Ausloggen und Beenden...");
        logOffItem.addActionListener(pmiListener);

        userIconButton.add(normItem1);
        userIconButton.add(normItem2);
        userIconButton.add(separatorItem);
        userIconButton.add(normItem3);
        userIconButton.add(normItem4);
        userIconButton.add(logOffItem);

        mb = new JMenuBar();
        mb.setBackground(Styles.SURROUNDING_PANEL_COLOR);
        mb.add(userIconButton);

        return mb;
    }

    /**
     * Diese Methode setzt die Größe eines Bildes <code>filename</code> auf
     * <code>width</code> x <code>height</code>. Danach wird das Bild in ein JLabel
     * gegeben, um dieses wiederum z.B. zur Ausgabe nutzen zu können.
     * 
     * @param filename Pfad zum Bild
     * @param width    einzustellende Breite des Bildes
     * @param height   einzustellende Höhe des Bildes
     * @return Größe-angepasstes Applogo-Icon
     */
    private static JLabel resizeToJLabel(String filename, int width, int height, int horizontalAlignment) {
        ImageIcon logoIIcon = new ImageIcon(filename);
        java.awt.Image logoImage = logoIIcon.getImage();
        logoImage = logoImage.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
        logoIIcon = new ImageIcon(logoImage);

        return new JLabel(logoIIcon, horizontalAlignment);
    }

    /**
     * Getter-Methode für das Headertitel-Label
     * 
     * @return Headertitel-Label
     */
    public JLabel getHeaderTitleJLabel() {
        return headerTitleJLabel;
    }

    /**
     * Getter-Methode für den Usericon-Button
     * 
     * @return Usericon-Button
     */
    public AbstractButton getUserIconButton() {
        return this.userIconButton;
    }

    /**
     * Getter-Methode für das Welcome-Menüelement
     * 
     * @return Welcome-Menüelement
     */
    public JMenuItem getWelcomeItem() {
        return this.welcomeItem;
    }

    /**
     * Setter-Methode für das Welcome-Menüelement
     * 
     * @param welcomeItem Welcome-Menüelement
     */
    public void setWelcomeItem(JMenuItem welcomeItem) {
        this.welcomeItem = welcomeItem;
    }

    /**
     * Getter-Methode für das erste Menüelement
     * 
     * @return erstes Menüelement
     */
    public JMenuItem getNormItem1() {
        return normItem1;
    }

    /**
     * Getter-Methode für das zweite Menüelement
     * 
     * @return zweites Menüelement
     */
    public JMenuItem getNormItem2() {
        return normItem2;
    }

    /**
     * Getter-Methode für das dritte Menüelement
     * 
     * @return drittes Menüelement
     */
    public JMenuItem getNormItem3() {
        return normItem3;
    }

    /**
     * Getter-Methode für das vierte Menüelement
     * 
     * @return viertes Menüelement
     */
    public JMenuItem getNormItem4() {
        return normItem4;
    }

    /**
     * Getter-Methode für das Logoff-Menüelement
     * 
     * @return Logoff-Menüelement
     */
    public JMenuItem getLogOffItem() {
        return logOffItem;
    }
}