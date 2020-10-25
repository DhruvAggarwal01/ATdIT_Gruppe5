package listener;

import java.awt.event.*;
import main.MainPanel;
import main.NavItemPanelChooser;

/**
 * stellt die Funktionalität in Form eines Listeners zur Verfügung, um zurück
 * zur Overview-Page zu gelangen.
 * 
 * @author Sophie Orth, Monica Alessi, Dhruv Aggarwal, Maik Fichtenkamm, Lucas
 *         Lahr
 */
public class BackToOrderOverviewListener implements ActionListener {

    /**
     * {@inheritDoc}
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        MainPanel.getNavPane().setComponentAt(6, new NavItemPanelChooser("Logistik", null, null));
        MainPanel.getNavPane().setSelectedIndex(6);
    }

}
