package test.main.subpanelsTest;

import org.junit.*;

import subpanels.DiashowPanel;

public class DiashowPanelTest {
  
    DiashowPanel diashowPaneltest = new DiashowPanel("Title");
    
    @Test
    public void testGetPanelTitle(){
        Assert.assertEquals("Give the title of the diashow panel","Title",diashowPaneltest.getTitlePanel());
    }

    @Test
    public void testContainsPanels(){
      Assert.assertEquals("Looks how many components where added",2,diashowPaneltest.getComponentCount());
    }
}