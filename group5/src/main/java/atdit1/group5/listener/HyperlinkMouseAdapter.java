package atdit1.group5.listener;

import java.awt.*;
import java.awt.event.*;
import java.net.*;
import javax.swing.*;

import atdit1.group5.exceptions.URLException;

/**
 * dient der Weiterleitung zu einer bestimmten URL beim Klicken auf eine
 * Swing/AWT-Komponente.
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
     * öffnet beim Klicken auf eine Swing/AWT-Komponente im Browser die URL.
     * 
     * @param e eingetretenes Event
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        try {
            Desktop.getDesktop().browse(new URI(urlString));
        } catch (Exception exc) {
            URLException urlException = new URLException(urlString, 1);
            JPanel exceptionPanel = urlException.getExceptionPanel();
            JOptionPane.showMessageDialog(new JFrame(), exceptionPanel, "Error: " + urlException.getClass(),
                    JOptionPane.ERROR_MESSAGE);
        }
    }

}
