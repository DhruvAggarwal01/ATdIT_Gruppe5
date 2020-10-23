package panels;


import javax.swing.*;

import exceptions.URLException;
import subpanels.DiashowPanel;
import subpanels.ReadRSSPanel;
import subpanels.WeatherPanel;

import java.awt.*;

/**
 * Diese Klasse baut ein Panel auf, das, im Sinne eines Dashboards, mehrere
 * Subpanels anzeigt und damit einen visuellen Überblick über generelle Themen
 * verschafft.
 * 
 * @author Sophie Orth, Monica Alessi, Dhruv Aggarwal, Maik Fichtenkamm, Lucas
 *         Lahr
 */
public class OverviewPanel extends JPanel {

    private static final long serialVersionUID = 1L;

    private JPanel smallPanels, newsPanel, weatherPanel, diashow;

    /**
     * Konstruktor, der die Subpanels erzeugt und hinzufügt.
     */
    public OverviewPanel() {
        this.setLayout(new BorderLayout());

        smallPanels = new JPanel(new GridLayout(1, 2, 30, 30));

        // Abfangen etwaiger Abruffehler (falsche URL/ schlechte Internetverbindung)
        try {
            newsPanel = new ReadRSSPanel("Neueste Beiträge aus Albersweiler auf Wochenblatt Reporter",
                    "https://www.wochenblatt-reporter.de/albersweiler/rss");
            smallPanels.add(newsPanel);
        } catch (URLException ue) {
            JPanel exceptionPanel = ue.getExceptionPanel();
            JOptionPane.showMessageDialog(new JFrame(), exceptionPanel, "Error: " + ue.getClass(),
                    JOptionPane.ERROR_MESSAGE);
            smallPanels.add(exceptionPanel);
        }
        try {
            weatherPanel = new WeatherPanel("Heutige Wetterdaten aus Albersweiler");
            smallPanels.add(weatherPanel);
        } catch (URLException ue) {
            JPanel exceptionPanel = ue.getExceptionPanel();
            JOptionPane.showMessageDialog(new JFrame(), exceptionPanel, "Error: " + ue.getClass(),
                    JOptionPane.ERROR_MESSAGE);
            smallPanels.add(exceptionPanel);
        }

        diashow = new DiashowPanel("Impressionen vom Steinbruch");

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