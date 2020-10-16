package main;

import java.awt.Graphics;
import javax.swing.*;

/**
 * Diese Klasse beinhaltet das Hintergrundbild für den Login Screen und zeigt
 * dieses an.
 * 
 * @author Sophie Orth, Monica Alessi, Dhruv Aggarwal, Maik Fichtenkamm, Lucas
 *         Lahr
 */
public class BackgroundImagePanel extends JPanel {

    private static final long serialVersionUID = 6187241176653993435L;

    /**
     * Konstruktor, der zuständig für das BackgroundImagePanel ist und somit dieses
     * erzeugt mit dem richtigen Layout.
     * 
     * @param layout das richtige Layout für das Panel
     */
    public BackgroundImagePanel(java.awt.LayoutManager layout) {
        super(layout);
    }

    /**
     * Durch überschreiben der paintComponent Methode kann man das Hintergrundbild,
     * welches vorher von der Library geholt wird, anzeigen lassen.
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        java.awt.Image backgroundImage = java.awt.Toolkit.getDefaultToolkit()
                .getImage("Library/images/LoginScreen.png");
        java.awt.Dimension size = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        g.drawImage(backgroundImage, 0, 0, size.width, size.height, this);
    }
}
