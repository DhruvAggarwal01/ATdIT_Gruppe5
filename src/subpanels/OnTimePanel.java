package subpanels;

import java.net.*;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.io.*;

import main.MainPanel;
import main.NavItemPanelChooser;
import main.Styles;

/**
 * Diese Klasse baut ein Panel auf, das Nachrichten aus einem RSS-Feed anzeigen
 * kann.
 */
public class OnTimePanel extends JPanel {

    private static final long serialVersionUID = -7427825579667861982L;


    /**
     * Konstruktor, der tbd
     * 
     * @param newsTitle Nachrichten-Panel-Titel
     * @param rssUrl    URL zum RSS-Nachrichtenfeed
     */
    public OnTimePanel(String newsTitle) {
        this.setLayout(new BorderLayout());
        Object size1 = this.getSize();

        JLabel newsTiLabel = new JLabel(size1.toString());
        JLabel newsTitleLabel = new JLabel(newsTitle);
        newsTitleLabel.setFont(Styles.SUBPANEL_TITLE_FONT);
        newsTitleLabel.setForeground(Color.BLUE.darker());
        newsTitleLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        newsTitleLabel.setToolTipText("To: " );
        newsTitleLabel.setBorder(BorderFactory.createEmptyBorder(5, 5, 0, 0));
        newsTitleLabel.addMouseListener(new MouseAdapter() {
        
          
        });this.add(newsTitleLabel, BorderLayout.NORTH);
        this.add(newsTiLabel, BorderLayout.NORTH);}

      
    /**
     * Innere Klasse tbd
     */
    class MouseClickListener extends MouseAdapter {

        /**
         * Diese Methode tbd
         */
        @Override
        public void mouseClicked(MouseEvent e) {
            MainPanel.getNavPane().setComponentAt(0, new NavItemPanelChooser("Overview", "Reporting", null));
        }

    }
}