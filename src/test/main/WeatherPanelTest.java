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

   
}