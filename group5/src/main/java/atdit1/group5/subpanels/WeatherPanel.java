package atdit1.group5.subpanels;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.net.*;
import java.util.*;

import com.google.gson.*;
import com.google.gson.reflect.*;

import atdit1.group5.exceptions.URLException;
import atdit1.group5.listener.HyperlinkMouseAdapter;
import atdit1.group5.Styles;

/**
 * richtet ein Panel ein, das die aktuellen Wetterdaten aus der
 * OpenWeatherMap-API extrahiert und anzeigt.
 * 
 * @author Sophie Orth, Monica Alessi, Dhruv Aggarwal, Maik Fichtenkamm, Lucas
 *         Lahr
 */
public class WeatherPanel extends JPanel {

    private static final long serialVersionUID = 4813738149309511564L;

    JTextArea weatherForecastArea;
    String weatherForecastTitle;
    private JLabel weatherForecastTitleLabel;

    /**
     * stellt das Panel UI-seitig ein und die relevanten, ausgewählten
     * Wettervorhersagedaten über einem Hintergrundbild anzeigt.
     * 
     * @param weatherForecastTitle Wettervorhersage-Panel-Titel
     */
    public WeatherPanel(String weatherForecastTitle) throws URLException {
        this.weatherForecastTitle = weatherForecastTitle;
        this.setLayout(new BorderLayout());
        this.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(20, 5, 5, 20),
                BorderFactory.createRaisedBevelBorder()));

        weatherForecastTitleLabel = new JLabel();
        settingsForPanelTitle("https://openweathermap.org/");

        String API_KEY = "9890476df64794ee702e35336d27f69e";
        String LOCATION = "Albersweiler,DE";
        String urlString = "http://api.openweathermap.org/data/2.5/weather?q=" + LOCATION + "&appid=" + API_KEY
                + "&units=metric";

        try {
            StringBuilder result = new StringBuilder();
            URL url = new URL(urlString);
            URLConnection conn = url.openConnection();
            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }

            rd.close();

            Map<String, Object> wholeMap = jsonToMap(result.toString());
            contentAndSettingsForWeatherForecastArea(wholeMap);

            this.add(weatherForecastTitleLabel, BorderLayout.NORTH);
            this.add(weatherForecastArea, BorderLayout.CENTER);

        } catch (IOException ue) {
            throw new URLException(urlString, 0);
        }
    }

    /**
     * stellt Design und Listener für den Panel-Titel ein.
     * 
     * @param urlAddress URL der Homepage der Wettervorhersage
     */
    public void settingsForPanelTitle(String urlAddress) {
        weatherForecastTitleLabel.setFont(Styles.SUBPANEL_TITLE_FONT);
        weatherForecastTitleLabel.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        weatherForecastTitleLabel.setText(weatherForecastTitle);
        weatherForecastTitleLabel.setForeground(Color.BLUE.darker());
        weatherForecastTitleLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        weatherForecastTitleLabel.setToolTipText("To: " + urlAddress);
        weatherForecastTitleLabel.setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 5));
        MouseAdapter hMouseAdapter = new HyperlinkMouseAdapter(urlAddress);
        weatherForecastTitleLabel.addMouseListener(hMouseAdapter);
    }

    /**
     * zeigt die Wettervorhersage strukturiert im erzeugten TextArea an.
     * 
     * @param wholeMap gemappte JSON-Wettervorhersage
     */
    public void contentAndSettingsForWeatherForecastArea(Map<String, Object> wholeMap) {
        Map<String, Object> mainMap = jsonToMap(wholeMap.get("main").toString());
        Map<String, Object> windMap = jsonToMap(wholeMap.get("wind").toString());

        weatherForecastArea = new JTextArea() {

            private static final long serialVersionUID = 2041623386356436152L;

            Image weatherStatusImage = new ImageIcon("group5/src/main/resources/images/OpenWeatherMapLogo.png")
                    .getImage();
            {
                setOpaque(false);
            }

            public void paint(Graphics g) {
                g.drawImage(weatherStatusImage, 0, 0, this);
                super.paint(g);
            }
        };
        weatherForecastArea.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        weatherForecastArea.setText(
                "Current Temperature: " + mainMap.get("temp") + "\nCurrent Humidity: " + mainMap.get("humidity")
                        + "\nWind Speeds: " + windMap.get("speed") + "\nWind Angle: " + windMap.get("deg"));
        weatherForecastArea.setFont(Styles.SUBPANEL_TEXTCOMPONENT_FONT);
        weatherForecastArea.setWrapStyleWord(true);
        weatherForecastArea.setEditable(false);
        weatherForecastArea.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    }

    /**
     * liest eine JSON-File aus und wandelt sie zur weiteren Nutzung in eine Map um.
     * 
     * @param jsonKey Key, nach dem die JSON gefiltert werden soll
     * @return umgewandelte JSON als Map
     */
    public static Map<String, Object> jsonToMap(String jsonKey) {
        Map<String, Object> map = new Gson().fromJson(jsonKey, new TypeToken<HashMap<String, Object>>() {
        }.getType());
        return map;
    }

    /**
     * Getter-Methode für den Wettervorhersage-Titel
     * 
     * @return Wettervorhersage-Titel
     */
    public String getWeatherForecastTitle() {
        return weatherForecastTitle;
    }

    /**
     * Getter-Methode für das Wettervorhersage-Label
     * 
     * @return Wettervorhersage-Label
     */
    public JLabel getWeatherForecastTitleLabel() {
        return weatherForecastTitleLabel;
    }

}