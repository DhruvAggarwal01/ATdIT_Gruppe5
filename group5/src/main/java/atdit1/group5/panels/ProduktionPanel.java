package atdit1.group5.panels;

import java.awt.*;
import javax.swing.*;

/**
 * erzeugt ein Panel für das Feld Produktion in der Navigationsleiste
 * 
 * @author Sophie Orth, Monica Alessi, Dhruv Aggarwal, Maik Fichtenkamm, Lucas
 *         Lahr
 */
public class ProduktionPanel extends JPanel {

    private NavigationPaneProduction navPane;
    private static final long serialVersionUID = 1L;

    /**
     * setzt das Layout richtig, erzeugt die Navigationsleiste <code>navPane</code>
     * des Panels und fügt diese zum Panel hinzu.
     */
    public ProduktionPanel() {
        super();
        this.setLayout(new BorderLayout());
        navPane = new NavigationPaneProduction(JTabbedPane.NORTH, JTabbedPane.VERTICAL);
        this.add(navPane, BorderLayout.CENTER);
    }

}