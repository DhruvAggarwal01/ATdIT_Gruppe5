package atdit1.group5.listener;

import java.awt.*;
import java.awt.event.*;

import atdit1.group5.subpanels.*;

/**
 * Klasse, die vom MouseAdapter erbt und ein Listener ist, der dafür
 * verantwortlich ist die QuarryMap vom Steinbruch richtig auszurichten.
 * 
 * @author Sophie Orth, Monica Alessi, Dhruv Aggarwal, Maik Fichtenkamm, Lucas
 *         Lahr
 */
public class ZoomMouseListener extends MouseAdapter {
    private final QuarryMap view;

    /**
     * erzeugt den Listener und initialisiert die Variable.
     * 
     * @param view die QuarryMap vom Steinbruch.
     */
    public ZoomMouseListener(QuarryMap view) {
        this.view = view;
    }

    /**
     * Die folgenden Methoden sind dafür verantwrotlich, das Bild der QuarryMap
     * richtig auszurichten!
     */
    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {

        view.setZoomer(true);

        // Zoom in
        if (e.getWheelRotation() < 0) {
            view.setZoomFactor(1.1);
            view.repaint();
        }
        // Zoom out
        if (e.getWheelRotation() > 0) {
            view.setZoomFactor(0.9);
            view.repaint();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void mouseDragged(MouseEvent e) {
        Point curPoint = e.getLocationOnScreen();
        view.setXDiff(curPoint.x - view.getStartPoint().x);
        view.setYDiff(curPoint.y - view.getStartPoint().y);

        view.setDragger(true);
        view.repaint();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void mousePressed(MouseEvent e) {
        view.setReleased(false);
        view.setStartPoint(MouseInfo.getPointerInfo().getLocation());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void mouseReleased(MouseEvent e) {
        view.setReleased(true);
        view.repaint();
    }

}