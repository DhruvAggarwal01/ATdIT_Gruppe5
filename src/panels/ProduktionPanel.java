package panels;


import javax.swing.*;

/**
 * Diese Klasse erzeugt ein Panel für das Feld Produktion in der
 * Navigationsleiste
 * 
 * @author Sophie Orth, Monica Alessi, Dhruv Aggarwal, Maik Fichtenkamm, Lucas
 *         Lahr
 */
public class ProduktionPanel extends JPanel {

    private NavigationPaneProduction navPane;
    private static final long serialVersionUID = 1L;

    /**
     * Konstruktor, der das Layout richtig setzt, die Navigationsleiste
     * <code>navPane</code> des Panels erzeugt und diese zum Panel dazufügt.
     */
    public ProduktionPanel() {
        super();
        this.setLayout(new java.awt.BorderLayout());
        navPane = new NavigationPaneProduction(JTabbedPane.NORTH, JTabbedPane.VERTICAL);
        this.add(navPane, java.awt.BorderLayout.CENTER);
    }

}
