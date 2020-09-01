package test.main;

import org.junit.Assert;
import org.junit.Test;

import subpanels.DiashowPanel;

public class DiashowPanelTest {
  
    DiashowPanel diashowPaneltest = new DiashowPanel("Title");
    
    @Test
    public void testGetPanelTitle(){
        Assert.assertEquals("Title",diashowPaneltest.getTitlePanel());
    }

    @Test
    public void testContainsPanels(){
      Assert.assertEquals(2,diashowPaneltest.getComponentCount());
    }
}