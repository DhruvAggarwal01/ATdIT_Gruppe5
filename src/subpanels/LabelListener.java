package subpanels;

import java.awt.*;
import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class LabelListener extends KeyAdapter {
    private KarteLabels kartelabels;
    private static int count  = 0;
    private Karte view;
    private JPanel kartePanel;
    private KarteMain main;

    public LabelListener(KarteLabels kartelabels, Karte view, KarteMain main) {
        this.kartelabels = kartelabels;
        this.view = view;
        kartePanel = kartelabels.getPanel();
        this.main = main;
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_N) {
            PointerInfo pi = MouseInfo.getPointerInfo();
            Point p = pi.getLocation();
            Rectangle r = new Rectangle(p);

            view.getList().add(r);
            createLabels();

        }

    }

    public void createLabels() {
        JTextArea textarea = new JTextArea("Standort " + (++count) + ":");
        textarea.setBorder(BorderFactory.createEtchedBorder());
        textarea.setLineWrap(true);
        textarea.setWrapStyleWord(true);
        kartePanel.add(textarea);
        kartePanel.revalidate();
        
    }
}
