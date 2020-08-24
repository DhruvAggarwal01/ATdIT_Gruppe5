package dialogs;

import javax.swing.*;
import java.awt.*;

public class ProfileDialog extends JDialog {

    private static final long serialVersionUID = 1L;
    
    Container c;

    public ProfileDialog(JFrame owner){
        c = getContentPane();
        c.setLayout(new GridLayout(5, 1, 20, 0));
        c.add(new JLabel("Name"));
        c.add(new JLabel("Email"));
        c.add(new JPasswordField(""));
    }
}