import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Cursor;

public class MouseLogoIconListener implements MouseListener {

    HeaderLine hL;

    MouseLogoIconListener(HeaderLine hL) {
        this.hL = hL;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("GoToOverview");
        MainPanel.getNavPane().setSelectedIndex(0);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        hL.setCursor(new Cursor(Cursor.HAND_CURSOR));

    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub

    }

}