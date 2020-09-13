package listener;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import subpanels.*;

/**
 * Klasse, die vom MouseAdapter erbt und ein Listener ist, der dafür
 * verantwrotlich ist die Karte vom Steinbruch richtig auszurichten.
 */
public class ZoomMouseListener extends MouseAdapter {
    private final QuarryMap view;

    /**
     * Konstruktor, der den Listener erzeugt und die Variable initialisiert.
     * 
     * @param view die Karte vom Steinbruch.
     */
    public ZoomMouseListener(QuarryMap view) {
        this.view = view;
    }

    /**
     * Die folgenden Methoden sind dafür verantwrotlich, das Bild der Karte richtig auszurichten!
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

    @Override
    public void mouseDragged(MouseEvent e) {
        Point curPoint = e.getLocationOnScreen();
        view.setXDiff(curPoint.x - view.getStartPoint().x);
        view.setYDiff(curPoint.y - view.getStartPoint().y);

        view.setDragger(true);
        view.repaint();

    }

    @Override
    public void mousePressed(MouseEvent e) {
        view.setReleased(false);
        view.setStartPoint(MouseInfo.getPointerInfo().getLocation());
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        view.setReleased(true);
        view.repaint();
    }

}