package subpanels;

import java.awt.*;
import javax.swing.*;


public class RouteOptimization extends JPanel {

    /**
     *
     */
    private static final long serialVersionUID = 9126041066134832083L;
    



    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image backgroundImage = Toolkit.getDefaultToolkit().getImage("Library/images/Wegoptimierung.jpg");
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        g.drawImage(backgroundImage, 0, 0, size.width / 100 * 80, size.height / 100 * 80, this);
    }
}


