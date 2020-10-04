package test.subpanels;

import org.junit.*;

import exceptions.URLException;
import subpanels.WeatherPanel;

public class WeatherPanelTest {

    WeatherPanel weatherPanelTest;

    @Before
    public void init() throws URLException {
        weatherPanelTest = new WeatherPanel("weatherForecastTitle");
    }

    @Test
    public void testGetPanelTitle() {
        Assert.assertEquals("looks at the title of the Panel", "weatherForecastTitle",
                weatherPanelTest.getWeatherForecastTitle());
    }

    @Test
    public void testGetComponentCount() {
        Assert.assertEquals("Looks how many components where added", 2, weatherPanelTest.getComponentCount());
    }

    @Test
    public void testWeatherForecastTitlelLabel() {
        Assert.assertEquals("looks if the tooltiptext ist correct", "To: https://openweathermap.org/",
                weatherPanelTest.getWeatherForecastTitleLabel().getToolTipText());
        Assert.assertEquals("looks if the title is correct", "weatherForecastTitle",
                weatherPanelTest.getWeatherForecastTitleLabel().getText());
    }

}