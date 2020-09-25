package listener;

import java.awt.event.*;
import main.MainPanel;
import main.NavItemPanelChooser;

public class BackToOrderOverviewListener implements ActionListener {

    @Override
    public void actionPerformed(final ActionEvent e) {
        MainPanel.getNavPane().setComponentAt(6, new NavItemPanelChooser("Logistik", null, null));
        MainPanel.getNavPane().setSelectedIndex(6);
    }

    
}
