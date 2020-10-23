package subpanels;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import javax.swing.*;

import exceptions.URLException;
import listener.HyperlinkMouseAdapter;
import main.MainPanel;
import main.NavItemPanelChooser;
import main.Styles;

/**
 * Diese Klasse baut ein Panel auf, das Nachrichten aus einem RSS-Feed anzeigt.
 * 
 * @author Sophie Orth, Monica Alessi, Dhruv Aggarwal, Maik Fichtenkamm, Lucas
 *         Lahr
 */
public class ReadRSSPanel extends JPanel {

    private static final long serialVersionUID = -7427825579667861982L;

    JTextArea newsFeedTextField;

    /**
     * Konstruktor, der das Panel UI-seitig einstellt und den ausgelesenen RSS Feed
     * anzeigt.
     * 
     * @param newsTitle Nachrichten-Panel-Titel
     * @param rssUrl    URL zum RSS-Nachrichtenfeed
     */
    public ReadRSSPanel(String newsTitle, String rssUrl) throws URLException {
        this.setLayout(new BorderLayout());

        JLabel newsTitleLabel = new JLabel(newsTitle);
        newsTitleLabel.setFont(Styles.SUBPANEL_TITLE_FONT);
        newsTitleLabel.setForeground(Color.BLUE.darker());
        newsTitleLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        newsTitleLabel.setToolTipText("To: " + rssUrl.substring(0, rssUrl.length() - 4)); // entferne das '/rss'
        newsTitleLabel.setBorder(BorderFactory.createEmptyBorder(5, 5, 0, 0));
        MouseAdapter hMouseAdapter = new HyperlinkMouseAdapter(rssUrl.substring(0, rssUrl.length() - 4));
        newsTitleLabel.addMouseListener(hMouseAdapter);

        newsFeedTextField = new JTextArea(readRSSFeed(rssUrl)) {

            private static final long serialVersionUID = -1968962839234170862L;

            Image weatherStatusImage = new ImageIcon("Library/images/emptyTransparent.png").getImage();
            {
                setOpaque(false);
            }

            public void paint(Graphics g) {
                g.drawImage(weatherStatusImage, 0, 0, this);
                super.paint(g);
            }
        };
        newsFeedTextField.replaceRange("", 0, newsTitle.length());
        newsFeedTextField.setFont(Styles.SUBPANEL_TEXTCOMPONENT_FONT);
        newsFeedTextField.setWrapStyleWord(true);
        newsFeedTextField.setEditable(false);

        JScrollPane sp = new JScrollPane(newsFeedTextField);
        sp.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Reporting-Weiterleitung
        JPanel reportingPanel = new JPanel();
        reportingPanel.setBorder(BorderFactory.createRaisedBevelBorder());
        JLabel reportingLabel = new JLabel("<HTML><U>zum Reporting</U></HTML>", JLabel.CENTER);
        reportingLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        reportingPanel.add(reportingLabel, BorderLayout.CENTER);
        MouseAdapter mCL = new MouseClickListener();
        reportingPanel.addMouseListener(mCL);

        this.add(newsTitleLabel, BorderLayout.NORTH);
        this.add(sp, BorderLayout.CENTER);
        this.add(reportingPanel, BorderLayout.SOUTH);

        this.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(20, 20, 5, 5),
                BorderFactory.createRaisedBevelBorder()));
    }

    /**
     * Diese Methode liest einen RSS Feed aus der URL <code>rssUrl</code> aus und
     * gibt diesen als String zurück.
     * 
     * @param rssUrl URL des RSS Feed
     * @return gelesener RSS Feed als String
     */
    public String readRSSFeed(String rssUrl) throws URLException {
        try {
            URL rssUrlAddress = new URL(rssUrl);
            BufferedReader in = new BufferedReader(new InputStreamReader(rssUrlAddress.openStream()));
            String sourceCode = "";
            String line;
            while ((line = in.readLine()) != null) {
                int titleEndIndex = 0;
                int titleStartIndex = 0;
                while (titleStartIndex >= 0) {
                    titleStartIndex = line.indexOf("<title>", titleEndIndex);
                    if (titleStartIndex >= 0) {
                        titleEndIndex = line.indexOf("</title>", titleStartIndex);
                        sourceCode += line.substring(titleStartIndex + "<title>".length(), titleEndIndex) + "\n";
                    }
                }
            }
            in.close();
            return sourceCode;
        } catch (IOException e) {
            throw new URLException(rssUrl, 0);
        }
    }

    /**
     * Innere Klasse für die Demo-Weiterleitung auf die nächste Ebene "Reporting"
     */
    class MouseClickListener extends MouseAdapter {

        /**
         * Diese Methode setzt das angezeigte Panel auf ReportingPanel beim Klicken auf
         * eine Swing/AWT-Komponente.
         * 
         * @param e eingetretenes Event
         */
        @Override
        public void mouseClicked(MouseEvent e) {
            MainPanel.getNavPane().setComponentAt(0, new NavItemPanelChooser("Overview", "Reporting", null));
        }

    }
}