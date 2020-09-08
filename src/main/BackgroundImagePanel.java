package main;

import java.awt.*;
import javax.swing.*;
import java.awt.Graphics;

public class BackgroundImagePanel extends JPanel {

    private static final long serialVersionUID = 6187241176653993435L;

    public BackgroundImagePanel(LayoutManager layout) {
        super(layout);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image backgroundImage = Toolkit.getDefaultToolkit().getImage("Library/images/LoginScreen.png");
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        g.drawImage(backgroundImage, 0, 0, size.width, size.height, this);
    }
}
