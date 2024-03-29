package atdit1.group5.subpanels;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

import javax.imageio.ImageIO;
import java.io.*;
import java.util.ArrayList;

import atdit1.group5.exceptions.InternalException;
import atdit1.group5.listener.ZoomMouseListener;

/**
 * ereugt ein "zoomable Panel" und ist an diesem GitHub stark orientiert:
 * https://github.com/Thanasis1101/Zoomable-Java-Panel
 * 
 * @author Sophie Orth, Monica Alessi, Dhruv Aggarwal, Maik Fichtenkamm, Lucas
 *         Lahr
 */
public class QuarryMap extends JPanel {

    private static final long serialVersionUID = -794208964734151914L;
    private BufferedImage img;
    private ArrayList<Rectangle> liste = new ArrayList<Rectangle>();
    private double zoomFactor = 1;
    private double prevZoomFactor = 1;
    private boolean zoomer;
    private boolean dragger;
    private boolean released;
    private double xOffset = 0;
    private double yOffset = 0;
    private int xDiff;
    private int yDiff;
    private Point startPoint;

    /**
     * erzeugt das Panel und fügt die Listener dazu.
     * 
     * @throws InternalException
     */
    public QuarryMap() throws InternalException {
        getImage();
        ZoomMouseListener lis = new ZoomMouseListener(this);
        addMouseListener(lis);
        addMouseMotionListener(lis);

        addMouseWheelListener(lis);
        this.setFocusable(true);
        this.requestFocusInWindow();
    }

    /**
     * holt das Bild, was den Steinbruch von oben zeigen soll, aus der Library.
     * 
     * @throws InternalException
     */
    private void getImage() throws InternalException {
        try {
            img = ImageIO.read(new File("group5/src/main/resources/images/Steinbruch1.jpg"));
        } catch (IOException e) {
            throw new InternalException();
        }
    }

    /**
     * überschreibt die paint-Methode, um zu gewährleisten, dass das Bild immer an
     * die richtige Stelle geschrieben wird.
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);

        Graphics2D g2 = (Graphics2D) g;

        if (zoomer) {
            AffineTransform at = new AffineTransform();

            double xRel = MouseInfo.getPointerInfo().getLocation().getX() - getLocationOnScreen().getX();
            double yRel = MouseInfo.getPointerInfo().getLocation().getY() - getLocationOnScreen().getY();

            double zoomDiv = zoomFactor / prevZoomFactor;

            xOffset = (zoomDiv) * (xOffset) + (1 - zoomDiv) * xRel;
            yOffset = (zoomDiv) * (yOffset) + (1 - zoomDiv) * yRel;

            at.translate(xOffset, yOffset);
            at.scale(zoomFactor, zoomFactor);
            prevZoomFactor = zoomFactor;
            g2.transform(at);
            zoomer = false;
        }

        if (dragger) {
            AffineTransform at = new AffineTransform();
            at.translate(xOffset + xDiff, yOffset + yDiff);
            at.scale(zoomFactor, zoomFactor);
            g2.transform(at);

            if (released) {
                xOffset += xDiff;
                yOffset += yDiff;
                dragger = false;
            }

        }
        // hier wird das Bild richtig gezeichnet.
        g2.drawImage(img, 0, 0, this);
        this.requestFocusInWindow();
        // drawRectangles(g2); diese Methode ist noch nicht zu Ende implementiert!
    }

    /**
     * sollte verantwortlich sein um Rechtecke in dem Bild vom Steinbruch zeichnen
     * zu können und somit die Standorte markieren zu können! Diese Funktionalität
     * ist jedoch noch nicht fertig implementiert!
     * 
     * @param g2
     */
    // public void drawRectangles(Graphics2D g2) {
    // if (!liste.isEmpty())
    // g2.drawRect(liste.get(0).getX() - 5, liste.get(0).getY() - 5, 10, 10);
    // }

    /**
     * Setter-Methode für den Zoomfaktor
     * 
     * @param zoomFactor
     */
    public void setZoomFactor(double zoomFactor) {
        this.zoomFactor *= zoomFactor;
    }

    /**
     * Setter-Methode für die Variable zoomer
     * 
     * @param zoomer
     */
    public void setZoomer(boolean zoomer) {
        this.zoomer = zoomer;
    }

    /**
     * Setter-Methode für die Variable dragger
     * 
     * @param dragger
     */
    public void setDragger(boolean dragger) {
        this.dragger = dragger;
    }

    /**
     * Setter-Methode für die Variable released
     * 
     * @param released
     */
    public void setReleased(boolean released) {
        this.released = released;
    }

    /**
     * Setter-Methode für xDiff
     * 
     * @param xDiff
     */
    public void setXDiff(int xDiff) {
        this.xDiff = xDiff;
    }

    /**
     * Setter-Methode für yDiff
     * 
     * @param yDiff
     */
    public void setYDiff(int yDiff) {
        this.yDiff = yDiff;
    }

    /**
     * Setter-Methode für den Startpunkt
     * 
     * @param startPoint
     */
    public void setStartPoint(Point startPoint) {
        this.startPoint = startPoint;
    }

    /**
     * Getter-Methode für den Startpunkt
     * 
     * @return startPoint
     */
    public Point getStartPoint() {
        return this.startPoint;
    }

    /**
     * Getter-Methode für die Liste von Rechtecken
     * 
     * @return liste
     */
    public ArrayList<Rectangle> getList() {
        return this.liste;
    }

}