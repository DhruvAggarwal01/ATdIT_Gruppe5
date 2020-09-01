package test.main;

import org.junit.Assert;
import org.junit.Test;

import panels.OverviewPanel;

public class OverviewPanelTest {
    
    OverviewPanel overviewPanelTest = new OverviewPanel();

    @Test
    public void testContainsPanels(){
      Assert.assertEquals(2,overviewPanelTest.getComponentCount());
    }

    @Test
    public void testCountSmallPanels(){
        Assert.assertEquals(2,overviewPanelTest.getSmallPanels().getComponentCount());
    }

   @Test
    public void test(){
        System.out.println(overviewPanelTest.getweatherPanel().getName());
    }

}