package subpanels;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;

public class Karte extends JPanel {

    /**
     * An diesem GitHub stark orientiert:
     * https://github.com/Thanasis1101/Zoomable-Java-Panel
     */
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

    public Karte() {
        getImage();
        ZoomMouseListener lis = new ZoomMouseListener(this);
        addMouseListener(lis);
        addMouseMotionListener(lis);
        
        addMouseWheelListener(lis);
        this.setFocusable(true);
        this.requestFocusInWindow();
        
        // System.out.println(requestFocusInWindow()); //tbd: löschen, wenn nicht mehr gebraucht
    }

    private void getImage() {
        try {
            img = ImageIO.read(new File("Library/images/Steinbruch1.jpg"));
        } catch (IOException e) {
            e.getStackTrace();
        }
    }

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
        // All drawings go here
        g2.drawImage(img, 0, 0, this);
        this.requestFocusInWindow();
        //drawRectangles(g2);
    }

    /**
     * Diese Methode sollte verantwortlich sein um Rechtecke in einem Bild zeichnen zu können und somit die Standorte markieren zu können!
     * @param g2
     */
    public void drawRectangles(Graphics2D g2){
        if (!liste.isEmpty())
            g2.drawRect(liste.get(0).getX() - 5, liste.get(0).getY() - 5, 10, 10 );
    }

   

    public void setZoomFactor(double zoomFactor) {
        this.zoomFactor *= zoomFactor;
    }

    public void setZoomer(boolean zoomer) {
        this.zoomer = zoomer;
    }

    public void setDragger(boolean dragger) {
        this.dragger = dragger;
    }

    public void setReleased(boolean released) {
        this.released = released;
    }

    public void setXDiff(int xDiff) {
        this.xDiff = xDiff;
    }

    public void setYDiff(int yDiff) {
        this.yDiff = yDiff;
    }

    public void setStartPoint(Point startPoint) {
        this.startPoint = startPoint;
    }

    public Point getStartPoint() {
        return this.startPoint;
    }

    public ArrayList<Rectangle> getList() {
        return this.liste;
    }
}