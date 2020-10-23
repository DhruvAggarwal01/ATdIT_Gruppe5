package listener;

import java.awt.event.*;

import main.MainPanel;
import main.NavItemPanelChooser;

/**
 * Diese Klasse dient dem Handling von Aktionen, die zum Zurückgehen auf das
 * Overview-Panel führen.
 * 
 * @author Sophie Orth, Monica Alessi, Dhruv Aggarwal, Maik Fichtenkamm, Lucas
 *         Lahr
 */
public class LogoIconMouseAdapter extends MouseAdapter implements ActionListener {

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

    /**
     * Diese Methode setzt das geöffnete Panel auf OverviewPanel.
     * 
     * @param e eingetretenes Event
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        MainPanel.getNavPane().setComponentAt(0, new NavItemPanelChooser("Overview", null, null));
        MainPanel.getNavPane().setSelectedIndex(0);
    }

}
