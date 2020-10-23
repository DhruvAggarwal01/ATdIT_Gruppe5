package test.subpanels;

import org.junit.*;

import exceptions.URLException;
import subpanels.WeatherPanel;

public class WeatherPanelTest {

    WeatherPanel weatherPanelTest;

    // Creation of a new WeatherPanel and initialization with a title
    @Before
    public void init() throws URLException {
        weatherPanelTest = new WeatherPanel("weatherForecastTitle");
    }

    // Checks with a getter if the title of the weatherPanel is initialized
    // correctly
    @Test
    public void testGetWeatherPanelTestTitle() {
        Assert.assertEquals("looks at the title of the Panel", "weatherForecastTitle",
                weatherPanelTest.getWeatherForecastTitle());
    }

    // Checks with a getter if all 2 components of weatherPanelTest were added
    // correctly
    @Test
    public void testGetWeatherPanelTestComponentCount() {
        Assert.assertEquals("Looks how many components where added", 2, weatherPanelTest.getComponentCount());
    }

    // Checks with getters if the title and the tooltipText of the weatherPanelTest
    // were initialized correctly
    @Test
    public void testWeatherForecastTitlelLabel() {
        Assert.assertEquals("looks if the tooltiptext ist correct", "To: https://openweathermap.org/",
                weatherPanelTest.getWeatherForecastTitleLabel().getToolTipText());
        Assert.assertEquals("looks if the title is correct", "weatherForecastTitle",
                weatherPanelTest.getWeatherForecastTitleLabel().getText());
    }

}