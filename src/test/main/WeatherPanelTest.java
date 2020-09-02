package test.main;

import org.junit.Assert;
import org.junit.Test;

import subpanels.WeatherPanel;

public class WeatherPanelTest {
 
    WeatherPanel weatherPanelTest = new WeatherPanel("weatherForecastTitle");

    @Test
    public void testGetPanelTitle(){
        Assert.assertEquals("weatherForecastTitle",weatherPanelTest.getTitlePanel());
    }

    @Test
    public void testGetComponentCount(){
        Assert.assertEquals(2, weatherPanelTest.getComponentCount());
    }

    @Test
    public void testWeatherForecastTitlelLabel(){
        Assert.assertEquals("To: https://openweathermap.org/", weatherPanelTest.getWeatherForecastTitleLabel().getToolTipText());
        Assert.assertEquals("weatherForecastTitle", weatherPanelTest.getWeatherForecastTitleLabel().getText());
    }
   
}