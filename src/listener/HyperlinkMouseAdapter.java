package listener;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import javax.swing.*;
import java.net.*;

public class HyperlinkMouseAdapter extends MouseAdapter {

    private final JPanel panelView;
    private final String urlString;

    /**
     * Konstruktor, der eine Referenz auf die Instanz des
     * <code>LoginButtonPanel</code> mithilfe des Parameters herstellt, um damit
     * weiterzuarbeiten.
     * 
     * @param loginButtonPanelView Instanz von <code>JPanel</code>
     */
    public HyperlinkMouseAdapter(JPanel panelView, String urlString) {
        this.panelView = panelView;
        this.urlString = urlString;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        try {
            Desktop.getDesktop().browse(new URI(urlString));
        } catch (IOException | URISyntaxException e1) {
            e1.printStackTrace();
        }
    }

}
