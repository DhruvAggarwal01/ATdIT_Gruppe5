package listener;

import java.awt.event.*;

import main.MainPanel;
import main.NavItemPanelChooser;

/**
 * Diese Klasse tbd
 * 
 * @author Sophie Orth, Monica Alessi, Dhruv Aggarwal, Maik Fichtenkamm, Lucas
 *         Lahr
 */
public class LogoIconMouseAdapter extends MouseAdapter {

    /**
     * tbd
     * 
     * @param e
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        MainPanel.getNavPane().setComponentAt(0, new NavItemPanelChooser("Overview", null, null));
        MainPanel.getNavPane().setSelectedIndex(0);
    }

}
