package atdit1.group5.panels;

import java.awt.*;
import javax.swing.*;
import java.util.ResourceBundle;

import atdit1.group5.exceptions.URLException;
import atdit1.group5.subpanels.DiashowPanel;
import atdit1.group5.subpanels.ReadRSSPanel;
import atdit1.group5.subpanels.WeatherPanel;

/**
 * baut ein Panel auf, das, im Sinne eines Dashboards, mehrere Subpanels anzeigt
 * und damit einen visuellen Überblick über generelle Themen verschafft.
 * 
 * @author Sophie Orth, Monica Alessi, Dhruv Aggarwal, Maik Fichtenkamm, Lucas
 *         Lahr
 */
public class OverviewPanel extends JPanel {

    private static final long serialVersionUID = 5616023884647257894L;
    private ResourceBundle text;

    private JPanel smallPanels, newsPanel, weatherPanel, diashow;

    /**
     * erzeugt und fügt die Subpanels hinzu.
     */
    public OverviewPanel() {
        this.setLayout(new BorderLayout());
        this.text = ResourceBundle.getBundle(("i18n/mainAppStrings"));
        smallPanels = new JPanel(new GridLayout(1, 2, 30, 30));

        // Abfangen etwaiger Abruffehler (falsche URL/ schlechte Internetverbindung)
        try {
            newsPanel = new ReadRSSPanel(text.getString("newsText"),
                    "https://www.wochenblatt-reporter.de/albersweiler/rss");
            smallPanels.add(newsPanel);
        } catch (URLException ue) {
            JPanel exceptionPanel = ue.getExceptionPanel();
            JOptionPane.showMessageDialog(new JFrame(), exceptionPanel, "Error: " + ue.getClass(),
                    JOptionPane.ERROR_MESSAGE);
            smallPanels.add(exceptionPanel);
        }
        try {
            weatherPanel = new WeatherPanel(text.getString("weatherText"));
            smallPanels.add(weatherPanel);
        } catch (URLException ue) {
            JPanel exceptionPanel = ue.getExceptionPanel();
            JOptionPane.showMessageDialog(new JFrame(), exceptionPanel, "Error: " + ue.getClass(),
                    JOptionPane.ERROR_MESSAGE);
            smallPanels.add(exceptionPanel);
        }

        diashow = new DiashowPanel(text.getString("diashowText"));

        this.add(smallPanels, BorderLayout.NORTH);
        this.add(diashow, BorderLayout.CENTER);
    }

    /**
     * Getter-Methode für das Wettervorhersage-Panel
     * 
     * @return Wettervorhersage-Panel
     */
    public JPanel getWeatherPanel() {
        return weatherPanel;
    }

    /**
     * Getter-Methode für das Diashow-Panel
     * 
     * @return Diashow-Panel
     */
    public JPanel getDiashowPanel() {
        return diashow;
    }

    /**
     * Getter-Methode für das Nachrichten-Panel
     * 
     * @return Nachrichten-Panel
     */
    public JPanel getNewsPanel() {
        return newsPanel;
    }

    /**
     * Getter-Methode für die zwei kleineren Panels
     * 
     * @return zwei kleinere Panels
     */
    public JPanel getSmallPanels() {
        return smallPanels;
    }

}