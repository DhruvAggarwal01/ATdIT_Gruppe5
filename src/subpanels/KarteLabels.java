package subpanels;

import java.awt.*;
import javax.swing.*;

public class KarteLabels extends JPanel {
    private JPanel panel;

    public KarteLabels() {
        this.setLayout(new BorderLayout());
        JPanel panelLabels = new JPanel(new GridLayout(2, 1));
        JLabel text1 = new JLabel("Drücke N um eine Stelle im Bild zu markieren. ");
        JLabel text2 = new JLabel("Notizen über die jeweiligen Standorte kannst du hier anlegen:");
        panel = new JPanel(new GridLayout(0, 1));
        panelLabels.add(text1);
        panelLabels.add(text2);
        this.add(panelLabels, BorderLayout.NORTH);
        this.add(panel, BorderLayout.CENTER);
    }

    public JPanel getPanel() {
        return this.panel;
    }
}
