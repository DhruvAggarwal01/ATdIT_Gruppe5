import java.awt.*;
import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Diese Klasse baut den Header der Anwendung auf, welcher über den gesamten
 * Ausführzeitraum zu sehen ist.
 * 
 * @author Sophie Orth, Monica Alessi, Dhruv Aggarwal, Maik Fichtenkamm, Lucas
 *         Lahr
 */
public class HeaderLine extends JPanel implements MouseListener {

    private static final long serialVersionUID = 5730113640200437491L;

    JMenuBar mb;
    JPanel logoAndHeaderTitle;
    JPanel userIconWithMenuInJPanel;

    /**
     * Konstruktor, der zuständig für den Aufbau des Headers zuständig ist. Der
     * Header setzt sich aus Anwenungsicon, -titel und Usericon zusammen.
     * 
     * @param headerTitle der Anwendungsname
     */
    HeaderLine(String headerTitle) { // Nutzer nutzer als parameter
        this.setLayout(new GridLayout(1, 3, 0, 0));
        ImageIcon borderLine = new ImageIcon("Library/images/hammerIcon.png"); // --> andere Option mit Bild
        this.setBorder(BorderFactory.createMatteBorder(-1, -1, -1, -1, borderLine));
        // this.setBorder(BorderFactory.createEtchedBorder());
        logoAndHeaderTitle = new JPanel(new GridLayout(2, 1));
        userIconWithMenuInJPanel = new JPanel(new BorderLayout()); // Listener soll sich nur auf diesen JPanel beziehen

        // 1a. Anwendungslogo
        JLabel logoIconInJLabel = resizeToJLabel("Library/images/dashboardlogo.png", 44, 44, JLabel.CENTER);
        MouseLogoIconListener mLIL = new MouseLogoIconListener(this);
        logoIconInJLabel.addMouseListener(mLIL);

        // 1b. Anwendungstitel-Text
        JLabel headerTitleJLabel = new JLabel(headerTitle, JLabel.CENTER);
        headerTitleJLabel.setFont(new Font("Serif", Font.BOLD, 36)); // eigenen Font in Styles verwenden? tbd mit
                                                                     // try-catch

        // 1. Zusammenfügung von 1a. und 1b.
        logoAndHeaderTitle.add(logoIconInJLabel);
        logoAndHeaderTitle.add(headerTitleJLabel);

        // 2a. User-Symbol rechts oben
        JLabel userIcon = resizeToJLabel("Library/images/userIcon.png", 60, 60, JLabel.RIGHT);

        mb = new JMenuBar();
        mb.setVisible(true);
        mb.add(Box.createHorizontalGlue());

        MouseUserIconListener mUIL = new MouseUserIconListener(this, mb);
        userIcon.addMouseListener(mUIL);

        userIconWithMenuInJPanel.add(userIcon, BorderLayout.NORTH);
        // userIconWithMenuInJPanel.add(mb, 1);

        this.add(new JLabel()); // Leeres Element links oben
        this.add(logoAndHeaderTitle); // 1.
        this.add(userIconWithMenuInJPanel); // 2.
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

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("GoToOverview");
        MainPanel.getNavPane().setSelectedIndex(0);
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        mb = new JMenuBar();
        mb.setVisible(true);

        mb.add(Box.createHorizontalGlue());
        JMenu menu = new JMenu("UserName");
        menu.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

        menu.add(new JMenuItem("Ihr Profil"));
        menu.add(new JMenuItem("Ihre Einstellungen"));
        menu.addSeparator();
        menu.add(new JMenuItem("Hilfe"));
        menu.add(new JMenuItem("Über..."));

        mb.add(menu);
        this.add(mb, BorderLayout.SOUTH);
        System.out.println("OpenUserJMenu");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub

    }

}