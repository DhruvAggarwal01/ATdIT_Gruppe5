package subpanels;

import java.awt.*;
import javax.swing.*;

import exceptions.InternalException;
import listener.LabelListener;

/**
 * erzeugt das MainPanel für die QuarryMap.
 * 
 * @author Sophie Orth, Monica Alessi, Dhruv Aggarwal, Maik Fichtenkamm, Lucas
 *         Lahr
 */
public class QuarryMapMain extends JPanel {

    private static final long serialVersionUID = -1599519611357870398L;

    /**
     * erzeugt das Main-Panel der QuarryMap. Zu diesem Panel werden die beiden
     * anderen Panels <code>QuarryMap</code> und <code>QuarryMapLabels</code>
     * hinzugefügt.
     */
    public QuarryMapMain() {
        this.setLayout(new BorderLayout());
        try {
            QuarryMap view = new QuarryMap();
            QuarryMapLabels labels = new QuarryMapLabels();

            LabelListener lis = new LabelListener(labels, view);
            view.addKeyListener(lis);

            this.add(view, BorderLayout.CENTER);
            this.add(labels, BorderLayout.EAST);
        } catch (InternalException noube) {
            JPanel exceptionPanel = noube.getExceptionPanel();
            JOptionPane.showMessageDialog(new JFrame(), exceptionPanel, "Error: " + noube.getClass(),
                    JOptionPane.ERROR_MESSAGE);
        }
    }

}
