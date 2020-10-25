package main;

import java.awt.*;
import javax.swing.*;

/**
 * beinhaltet das Hintergrundbild für den Login Screen und zeigt dieses an.
 * 
 * @author Sophie Orth, Monica Alessi, Dhruv Aggarwal, Maik Fichtenkamm, Lucas
 *         Lahr
 */
public class BackgroundImagePanel extends JPanel {

    private static final long serialVersionUID = 6187241176653993435L;

    /**
     * ist zuständig für das BackgroundImagePanel und erzeugt somit dieses mit dem
     * richtigen Layout.
     * 
     * @param layout das richtige Layout für das Panel
     */
    public BackgroundImagePanel(LayoutManager layout) {
        super(layout);
    }

    /**
     * Durch überschreiben der paintComponent Methode kann man das Hintergrundbild,
     * welches vorher von der Library geholt wird, anzeigen lassen.
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image backgroundImage = Toolkit.getDefaultToolkit().getImage("Library/images/LoginScreen.png");
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        g.drawImage(backgroundImage, 0, 0, size.width, size.height, this);
    }

}
