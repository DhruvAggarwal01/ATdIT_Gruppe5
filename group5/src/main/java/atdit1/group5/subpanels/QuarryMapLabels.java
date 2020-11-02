package atdit1.group5.subpanels;

import java.awt.*;
import javax.swing.*;
import java.util.ResourceBundle;
/**
 * erzeugt ein JPanel für die Notizen in der QuarryMap mit den nötigen
 * Swing/AWT-Komponenten.
 * 
 * @author Sophie Orth, Monica Alessi, Dhruv Aggarwal, Maik Fichtenkamm, Lucas
 *         Lahr
 */
public class QuarryMapLabels extends JPanel {

    private static final long serialVersionUID = -5283312412383786193L;
    private JPanel panel, panelLabels;
    private JLabel text1;
    private ResourceBundle text;

    /**
     * setzt das Layout, der Swing/AWT-Komponenten initialisiert und diese zum Panel
     * dazufügt.
     */
    public QuarryMapLabels() {
        this.text = ResourceBundle.getBundle(("i18n/productionStrings"));
        this.setLayout(new BorderLayout());
        panelLabels = new JPanel(new GridLayout(1, 1));
        text1 = new JLabel(text.getString("createLocationText"));
        panel = new JPanel(new GridLayout(0, 1));
        panelLabels.add(text1);
        this.add(panelLabels, BorderLayout.NORTH);
        this.add(panel, BorderLayout.CENTER);
    }

    /**
     * Getter-Methode für das Panel
     * 
     * @return JPanel
     */
    public JPanel getPanel() {
        return this.panel;
    }

    /**
     * Getter-Methode für das Panel-LabelListener
     * 
     * @return Panel-Label
     */
    public JPanel getPanelLabels() {
        return this.panelLabels;
    }

    /**
     * Getter-Methode für Text1
     * 
     * @return Text1
     */
    public JLabel getText1() {
        return this.text1;
    }

}
