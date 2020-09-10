package listener;

import java.awt.event.*;

import javax.swing.ImageIcon;

import subpanels.DiashowPanel;

/**
 * Diese Klasse tbd
 * 
 * @author Sophie Orth, Monica Alessi, Dhruv Aggarwal, Maik Fichtenkamm, Lucas
 *         Lahr
 */
public class TimerListener implements ActionListener {

    private final DiashowPanel diashowPanelView;

    /**
     * Konstruktor, der eine Referenz auf die Instanz des <code>DiashowPanel</code>
     * mithilfe des Parameters herstellt, um damit weiterzuarbeiten.
     * 
     * @param diashowPanelView Instanz von <code>DiashowPanel</code>
     */
    public TimerListener(DiashowPanel diashowPanelView) {
        this.diashowPanelView = diashowPanelView;
    }

    /**
     * Diese Methode tbd
     * 
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        diashowPanelView.setCounter(diashowPanelView.getCounter() % (diashowPanelView.getImages().length));
        ImageIcon[] tempDiashowImages = diashowPanelView.getImages();
        diashowPanelView.getDiashowLabel().setIcon(tempDiashowImages[diashowPanelView.getCounter()]);
        diashowPanelView.setCounter(diashowPanelView.getCounter() + 1);
    }
}
