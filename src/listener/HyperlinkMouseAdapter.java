package listener;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.*;

public class HyperlinkMouseAdapter extends MouseAdapter {

    private final String urlString;

    /**
     * Konstruktor, der eine Referenz auf die Instanz des <code></code> mithilfe des
     * Parameters herstellt, um damit weiterzuarbeiten.
     * 
     * @param urlString
     */
    public HyperlinkMouseAdapter(String urlString) {
        this.urlString = urlString;
    }

    /**
     * tbd
     * 
     * @param e
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        try {
            Desktop.getDesktop().browse(new URI(urlString));
        } catch (IOException | URISyntaxException e1) {
            e1.printStackTrace();
        }
    }

}
