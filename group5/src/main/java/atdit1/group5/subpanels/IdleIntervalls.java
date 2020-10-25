package atdit1.group5.subpanels;

import java.awt.*;
import javax.swing.*;

/**
 * erzeugt das Panel für die Leerlaufintervalle. In dieser Klasse sollen später
 * die Funktionalitäten für die Minimierung der Lauflaufintervalle implementiert
 * werdne. Diese sind NOCH NICHT realisiert worden!
 * 
 * @author Sophie Orth, Monica Alessi, Dhruv Aggarwal, Maik Fichtenkamm, Lucas
 *         Lahr
 */
public class IdleIntervalls extends JPanel {

    private static final long serialVersionUID = -934405642812343386L;

    /**
     * durch Überschreiben der paintComponent Methode kann man das Hintergrundbild,
     * welches vorher von der Library geholt wird, anzeigen lassen.
     */
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image backgroundImage = Toolkit.getDefaultToolkit().getImage("Library/images/Leerlaufintervalle.jpg");
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        g.drawImage(backgroundImage, 0, 0, size.width / 100 * 80, size.height / 100 * 80, this);
    }

}
