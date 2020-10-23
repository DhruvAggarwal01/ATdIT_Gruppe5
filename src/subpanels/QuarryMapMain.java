package subpanels;


import javax.swing.*;

import listener.LabelListener;

/**
 * Klasse, die das MainPanel für die QuarryMap erzeugt.
 * 
 * @author Sophie Orth, Monica Alessi, Dhruv Aggarwal, Maik Fichtenkamm, Lucas
 *         Lahr
 */
public class QuarryMapMain extends JPanel {

    private static final long serialVersionUID = -1599519611357870398L;

    /**
     * Konstruktor, der das Main-Panel der QuarryMap erzeugt. Zu diesem Panel werden
     * die beiden anderen Panels <code>QuarryMap</code> und
     * <code>QuarryMapLabels</code> hinzugefügt.
     */
    public QuarryMapMain() {
        this.setLayout(new java.awt.BorderLayout());
        QuarryMap view = new QuarryMap();
        QuarryMapLabels labels = new QuarryMapLabels();

        LabelListener lis = new LabelListener(labels, view);
        view.addKeyListener(lis);
        this.add(view, java.awt.BorderLayout.CENTER);
        this.add(labels, java.awt.BorderLayout.EAST);
    }
}
