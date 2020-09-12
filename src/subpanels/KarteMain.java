package subpanels;

import java.awt.*;
import javax.swing.*;

public class KarteMain extends JPanel {
    
    public KarteMain(){
        this.setLayout(new BorderLayout());
        Karte view = new Karte();
        KarteLabels labels = new KarteLabels();

       
        
        
        LabelListener lis = new LabelListener(labels, view, this);
        view.addKeyListener(lis);
        this.add(view, BorderLayout.CENTER);
        this.add(labels, BorderLayout.EAST);
    }
}
