package subpanels;

import java.awt.*;
import javax.swing.*;

public class KarteMain extends JPanel {
    
    public KarteMain(){
        this.setLayout(new BorderLayout());
        Karte karte = new Karte();
        KarteLabels labels = new KarteLabels();

        this.add(karte, BorderLayout.CENTER);
        this.add(labels, BorderLayout.EAST);
    }
}
