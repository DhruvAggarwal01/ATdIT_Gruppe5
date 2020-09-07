package subpanels;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.io.*;

import java.net.*;

import java.util.*;

import com.google.gson.*;
import com.google.gson.reflect.*;

import main.Styles;

/**
 * Diese Klasse richtet ein Panel ein, das die aktuellen Wetterdaten aus der
 * OpenWeatherMap-API extrahiert und anzeigt.
 * 
 * @author Sophie Orth, Monica Alessi, Dhruv Aggarwal, Maik Fichtenkamm, Lucas
 *         Lahr
 */
public class WeatherPanel extends JPanel {

    private static final long serialVersionUID = 4813738149309511564L;

    JTextArea weatherForecastArea;

    /**
     * Konstruktor, der tbd
     * 
     * @param weatherForecastTitle Wettervorhersage-Panel-Titel
     */
    public WeatherPanel(String weatherForecastTitle) {
        this.setLayout(new BorderLayout());
        String urlAddress = "https://openweathermap.org/"; // hier hartkodiert, da fixe Addresse angesteuert werden soll

        JLabel weatherForecastTitleLabel = new JLabel();
        weatherForecastTitleLabel.setFont(Styles.SUBPANEL_TITLE_FONT);
        weatherForecastTitleLabel.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        weatherForecastTitleLabel.setText(weatherForecastTitle);
        weatherForecastTitleLabel.setForeground(Color.BLUE.darker());
        weatherForecastTitleLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        weatherForecastTitleLabel.setToolTipText("To: " + urlAddress);
        weatherForecastTitleLabel.setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 5));
        weatherForecastTitleLabel.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI(urlAddress));
                } catch (IOException | URISyntaxException e1) {
                    e1.printStackTrace();
                }
            }

        });

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

            Map<String, Object> respMap = jsonToMap(result.toString());
            Map<String, Object> mainMap = jsonToMap(respMap.get("main").toString());
            Map<String, Object> windMap = jsonToMap(respMap.get("wind").toString());

            weatherForecastArea = new JTextArea() {
                private static final long serialVersionUID = 1L;

                Image weatherStatusImage = new ImageIcon("Library/images/OpenWeatherMapLogo.png").getImage();
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

            this.add(weatherForecastTitleLabel, BorderLayout.NORTH);
            this.add(weatherForecastArea, BorderLayout.CENTER);

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        this.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(20, 5, 5, 20),
                BorderFactory.createRaisedBevelBorder()));
    }

    /**
     * Diese Methode tbd
     * 
     * @param jsonKey tbd
     * @return tbd
     */
    public static Map<String, Object> jsonToMap(String jsonKey) {
        Map<String, Object> map = new Gson().fromJson(jsonKey, new TypeToken<HashMap<String, Object>>() {
        }.getType());
        return map;
    }
}