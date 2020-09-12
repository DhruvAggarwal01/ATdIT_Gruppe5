package subpanels;

import java.awt.*;
import javax.swing.*;

public class KarteLabels extends JPanel {
    private JPanel panel, panelLabels;
    private JLabel text1,text2;

    public KarteLabels() {
        this.setLayout(new BorderLayout());
        panelLabels = new JPanel(new GridLayout(2, 1));
        text1 = new JLabel("Drücke N um eine Stelle im Bild zu markieren. ");
        text2 = new JLabel("Notizen über die jeweiligen Standorte kannst du hier anlegen:");
        panel = new JPanel(new GridLayout(0, 1));
        panelLabels.add(text1);
        panelLabels.add(text2);
        this.add(panelLabels, BorderLayout.NORTH);
        this.add(panel, BorderLayout.CENTER);
    }

    public JPanel getPanel() {
        return this.panel;
    }
    public JPanel getPanelLabels() {
        return panelLabels;
    }
    public JLabel getText1(){
        return text1;
    }
    public JLabel getText2(){
        return text2;
    }
}
