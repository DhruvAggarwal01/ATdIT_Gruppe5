package subpanels;

import java.awt.*;
import javax.swing.*;

/**
 * @author Sophie Orth, Monica Alessi, Dhruv Aggarwal, Maik Fichtenkamm, Lucas
 *         Lahr
 */
public class Dashboard extends JPanel {

    private static final long serialVersionUID = -7460647121711245494L;

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image backgroundImage = Toolkit.getDefaultToolkit().getImage("Library/images/ProductionPanel.png");
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        g.drawImage(backgroundImage, 0, 0, size.width / 100 * 80, size.height / 100 * 80, this);
    }

}
