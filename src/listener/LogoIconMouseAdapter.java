package listener;

import java.awt.event.*;

import main.MainPanel;
import main.NavItemPanelChooser;

/**
 * Diese Klasse dient dem Handling von Klicks auf das Applogo.
 * 
 * @author Sophie Orth, Monica Alessi, Dhruv Aggarwal, Maik Fichtenkamm, Lucas
 *         Lahr
 */
public class LogoIconMouseAdapter extends MouseAdapter {

    /**
     * Diese Methode setzt das geöffnete Panel auf OverviewPanel.
     * 
     * @param e eingetretenes Event
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        MainPanel.getNavPane().setComponentAt(0, new NavItemPanelChooser("Overview", null, null));
        MainPanel.getNavPane().setSelectedIndex(0);
    }

}
