package atdit1.group5.listener;

import java.awt.event.*;

import atdit1.group5.mainclasses.MainPanel;
import atdit1.group5.mainclasses.NavItemPanelChooser;

/**
 * dient dem Handling von Aktionen, die zum Zurückgehen auf das Overview-Panel
 * führen.
 * 
 * @author Sophie Orth, Monica Alessi, Dhruv Aggarwal, Maik Fichtenkamm, Lucas
 *         Lahr
 */
public class LogoIconMouseAdapter extends MouseAdapter implements ActionListener {

    /**
     * setzt das geöffnete Panel auf OverviewPanel.
     * 
     * @param e eingetretenes Event
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        MainPanel.getNavPane().setComponentAt(0, new NavItemPanelChooser("Overview", null, null));
        MainPanel.getNavPane().setSelectedIndex(0);
    }

    /**
     * setzt das geöffnete Panel auf OverviewPanel.
     * 
     * @param e eingetretenes Event
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        MainPanel.getNavPane().setComponentAt(0, new NavItemPanelChooser("Overview", null, null));
        MainPanel.getNavPane().setSelectedIndex(0);
    }

}
