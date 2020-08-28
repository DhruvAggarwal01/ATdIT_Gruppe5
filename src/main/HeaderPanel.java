package main;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Dialog.ModalityType;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import dialogs.ProfileDialog;
import dialogs.SettingsDialog;

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
     * Header setzt sich aus Anwendungsicon, -titel und User-Icon zusammen.
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
        ImageIcon borderLine = new ImageIcon("Library/images/hammerIcon.png");
        this.setBorder(BorderFactory.createMatteBorder(-1, -1, -1, -1, borderLine));
        this.setBackground(Styles.SURROUNDING_PANEL_COLOR);

        logoAndHeaderTitle = new JPanel(new GridLayout(2, 1));
        logoAndHeaderTitle.setBackground(Styles.SURROUNDING_PANEL_COLOR);
        userIconWithMenuInJPanel = new JPanel(new BorderLayout());
        userIconWithMenuInJPanel.setBackground(Styles.SURROUNDING_PANEL_COLOR);
    }

    /**
     * Diese Methode passt das Icon an, verbessert die UX und Interaktion mit einem
     * Benutzer und gibt das Icon, gewrappt durch ein JLabel, wieder zurück.
     * 
     * @param filename
     * @return angepasstes Applogo-Icon
     */
    public JLabel logoAdder(String filename) {
        logoIconInJLabel = resizeToJLabel(filename, 32, 32, JLabel.CENTER);
        logoIconInJLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        logoIconInJLabel.addMouseListener(new MouseLogoIconListener());

        return logoIconInJLabel;
    }

    /**
     * Diese Methode nimmt einen gewünschten Titel entgegen, welcher mit einem Font
     * versehen und schließlich, gewrappt durch ein JLabel, wieder zurückgegeben
     * wird.
     * 
     * @param headerTitle
     * @return Label für Titel
     */
    public JLabel headerTitleAdder(String headerTitle) {
        headerTitleJLabel = new JLabel(headerTitle, SwingConstants.CENTER);
        headerTitleJLabel.setFont(Styles.APPHEADING);

        return headerTitleJLabel;
    }

    public JLabel getHeaderTitleJLabel(){
        return headerTitleJLabel;
    }

    /**
     * Diese Methode baut ein User-Menü mit den nötigen Menü-Items auf und setzt als
     * "Menüheader" ein User-Icon.
     * 
     * @param userIconFile
     * @return User-Icon-Menü innerhalb einer JMenuBar
     */
    public JMenuBar userSymbolAdder(String userIconFile) {
        userIconButton = new JMenu();

        ImageIcon userImage = new ImageIcon(userIconFile);
        userIconButton.setIcon(userImage);

        JMenuItem welcomeItem = new JMenuItem("<HTML><U>Willkommen (tbd)UserName!</U></HTML>");
        welcomeItem.setEnabled(false);

        ImageIcon profileIcon = new ImageIcon(new ImageIcon("Library/images/profileIcon.png").getImage()
                .getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH));
        ImageIcon settingsIcon = new ImageIcon(new ImageIcon("Library/images/settingsIcon.png").getImage()
                .getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH));
        ImageIcon helpIcon = new ImageIcon(new ImageIcon("Library/images/helpIcon.png").getImage().getScaledInstance(20,
                20, java.awt.Image.SCALE_SMOOTH));
        ImageIcon aboutIcon = new ImageIcon(new ImageIcon("Library/images/aboutIcon.png").getImage()
                .getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH));

        JMenuItem normItem1 = new JMenuItem("Ihr Profil", profileIcon);
        normItem1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        JDialog profileDialog = new ProfileDialog(Application.getAppWindow(), normItem1.getText(),
                                true);
                        profileDialog.setModalityType(ModalityType.APPLICATION_MODAL);
                        profileDialog.setUndecorated(true);
                        profileDialog.setVisible(true);
                    }
                });

            }
        });
        JMenuItem normItem2 = new JMenuItem("Ihre Einstellungen", settingsIcon);
        normItem2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        JDialog settingsDialog = new SettingsDialog(Application.getAppWindow(), normItem2.getText(),
                                true);
                        settingsDialog.setModalityType(ModalityType.APPLICATION_MODAL);
                        settingsDialog.setUndecorated(true);
                        settingsDialog.setVisible(true);
                    }
                });

            }
        });
        JMenuItem separatorItem = new JMenuItem("--------------------------");
        separatorItem.setEnabled(false);
        JMenuItem normItem3 = new JMenuItem("Hilfe", helpIcon);
        JMenuItem normItem4 = new JMenuItem("Über...", aboutIcon);
        JMenuItem logOffItem = new JMenuItem("Ausloggen...");

        userIconButton.add(welcomeItem);
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
     * @return Größe-angepasstes Applogo-Icon
     */
    private static JLabel resizeToJLabel(String filename, int width, int height, int horizontalAlignment) {
        ImageIcon logoIIcon = new ImageIcon(filename);
        Image logoImage = logoIIcon.getImage();
        logoImage = logoImage.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
        logoIIcon = new ImageIcon(logoImage);

        return new JLabel(logoIIcon, horizontalAlignment);
    }
}