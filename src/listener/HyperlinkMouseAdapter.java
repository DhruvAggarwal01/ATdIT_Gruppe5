package listener;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.*;

/**
 * Diese Klasse dient der Weiterleitung zu einer bestimmten URL beim Klicken auf
 * eine Swing/AWT-Komponente.
 * 
 * @author Sophie Orth, Monica Alessi, Dhruv Aggarwal, Maik Fichtenkamm, Lucas
 *         Lahr
 */
public class HyperlinkMouseAdapter extends MouseAdapter {

    private final String urlString;

    /**
     * Konstruktor, der die URL zur weiterzuleitenden Webseite verarbeitet.
     * 
     * @param urlString
     */
    public HyperlinkMouseAdapter(String urlString) {
        this.urlString = urlString;
    }

    /**
     * Diese Methode öffnet beim Klicken auf eine Swing/AWT-Komponente im Browser
     * die URL.
     * 
     * @param e eingetretenes Event
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("CLICK");
        try {
            Desktop.getDesktop().browse(new URI(urlString));
        } catch (IOException | URISyntaxException e1) {
            e1.printStackTrace();
        }
    }

}
