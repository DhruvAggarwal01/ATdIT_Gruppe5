package subpanels;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.Cursor;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.awt.*;

import java.io.*;

public class ReadRSSPanel extends JPanel {

    private static final long serialVersionUID = -7427825579667861982L;

    JTextArea newsFeedTextField;

    public ReadRSSPanel(String newsTitle, String urlAddress) {
        this.setLayout(new BorderLayout());

        JLabel newsTitleLabel = new JLabel(newsTitle);
        newsTitleLabel.setForeground(Color.BLUE.darker());
        newsTitleLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        newsTitleLabel.setToolTipText("To: " + urlAddress.substring(0, urlAddress.length() - 4));               //entferne das '/rss'
        newsTitleLabel.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI(urlAddress.substring(0, urlAddress.length() - 4)));     //entferne das '/rss'
                } catch (IOException | URISyntaxException e1) {
                    e1.printStackTrace();
                }
            }

        });

        newsFeedTextField = new JTextArea(readRSSFeed(urlAddress));
        newsFeedTextField.setFont(new Font("Consolas", Font.PLAIN, 10));
        newsFeedTextField.setLineWrap(true);
        newsFeedTextField.setWrapStyleWord(true);
        newsFeedTextField.setEditable(false);

        JScrollPane sp = new JScrollPane(newsFeedTextField);

        this.add(newsTitleLabel, BorderLayout.NORTH);
        this.add(sp, BorderLayout.CENTER);
    }

    public static String readRSSFeed(String urlAddress) {
        try {
            URL rssUrl = new URL(urlAddress);
            BufferedReader in = new BufferedReader(new InputStreamReader(rssUrl.openStream()));
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
        } catch (MalformedURLException ue) {
            System.out.println("Malformed URL");
        } catch (IOException ioe) {
            System.out.println("Something went wrong reading the contents");
        }
        return null;
    }
}