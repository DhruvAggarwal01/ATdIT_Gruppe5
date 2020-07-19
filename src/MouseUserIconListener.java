import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.ComponentOrientation;
import java.awt.Cursor;
import java.awt.*;

import javax.swing.Box;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MouseUserIconListener implements MouseListener {

    JMenuBar mb;
    HeaderLine hL;

    MouseUserIconListener(HeaderLine hL, JMenuBar mb) {
        this.hL = hL;
        this.mb = mb;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        hL.setCursor(new Cursor(Cursor.HAND_CURSOR));
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
        hL.userIconWithMenuInJPanel.add(mb, BorderLayout.SOUTH);
        mb.setEnabled(true);
    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}