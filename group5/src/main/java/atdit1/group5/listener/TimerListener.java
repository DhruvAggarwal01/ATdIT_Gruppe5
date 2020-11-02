package atdit1.group5.listener;

import java.awt.event.*;
import javax.swing.ImageIcon;

import atdit1.group5.subpanels.DiashowPanel;

/**
 * dient der Implementierung einer Diashow, indem mehrere Bilder durchlaufen
 * werden.
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
     * springt bei jedem Aufruf zum nächsten Bild-Array-Element und bei Erreichen
     * des Endes wieder mit dem ersten Bild fortfährt.
     * 
     * @param e eingetretenes Event
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        diashowPanelView.setCounter(diashowPanelView.getCounter() % (diashowPanelView.getImages().length));
        ImageIcon[] tempDiashowImages = diashowPanelView.getImages();
        diashowPanelView.getDiashowLabel().setIcon(tempDiashowImages[diashowPanelView.getCounter()]);
        diashowPanelView.setCounter(diashowPanelView.getCounter() + 1);
    }

}
