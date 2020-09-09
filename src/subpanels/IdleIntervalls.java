package subpanels;


import java.awt.*;
import javax.swing.*;
import main.MainPanel;

public class IdleIntervalls extends JPanel{

    /**
     *
     */
    private static final long serialVersionUID = -934405642812343386L;
    
    public IdleIntervalls(){

    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image backgroundImage = Toolkit.getDefaultToolkit().getImage("Library/images/Leerlaufintervalle.jpg");
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        g.drawImage(backgroundImage, 0, 0, size.width / 100 * 80, size.height / 100 * 80, this);
    }
}
