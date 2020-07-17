import javax.swing.Box;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.*;

/**
 * 
 */
public class JPanelWithListener extends JPanel implements MouseListener {

    private static final long serialVersionUID = -3779394828066027305L;
    private String actionToPerform;
    JMenuBar mb;

    JPanelWithListener(String actionToPerform, LayoutManager layoutManager) {
        super(layoutManager);
        this.actionToPerform = actionToPerform;
        this.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        switch (actionToPerform) {
            case "GoToOverview":
                System.out.println("GoToOverview");
                MainPanel.getNavPane().setSelectedIndex(0);
                break;
            default:
                break;
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        switch (actionToPerform) {
            case "OpenUserJMenu":
                mb = new JMenuBar();
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
                break;
            default:
                break;
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}