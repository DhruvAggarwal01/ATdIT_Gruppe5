package panels;

import java.awt.*;

import javax.swing.*;

import subpanels.DiashowPanel;
import subpanels.ReadRSSPanel;
import subpanels.WeatherPanel;

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

    /**
     * Konstruktor, der tbd
     */
    public OverviewPanel() {
        this.setLayout(new BorderLayout());

        JPanel smallPanels = new JPanel(new GridLayout(1, 2, 30, 30));

        // 1. Panel: News
        JPanel newsPanel = new ReadRSSPanel("Neueste Beiträge aus Albersweiler auf Wochenblatt Reporter",
                "https://www.wochenblatt-reporter.de/albersweiler/rss");

        // 2. Panel: Wetter
        JPanel weatherPanel = new WeatherPanel("Heutige Wetterdaten aus Albersweiler");
        
        // 3. Panel:
        JPanel diashow = new DiashowPanel("Impressionen vom Steinbruch");

        smallPanels.add(newsPanel);
        smallPanels.add(weatherPanel);

        this.add(smallPanels, BorderLayout.NORTH);
        this.add(diashow, BorderLayout.CENTER);
    }

}