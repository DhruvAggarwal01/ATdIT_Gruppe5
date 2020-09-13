package test.subpanels;

import org.junit.Assert;
import org.junit.Test;

import subpanels.OrderPanels;

public class OrderPanelsTest {
    
    OrderPanels orderPanelsTest = new OrderPanels("Title", "ToolTipText", 255,255,255);

    @Test
    public void testGetTitle(){
      Assert.assertEquals("Gets the Title","Title", orderPanelsTest.getOnTimeLabel().getText());
    }

    @Test
    public void testGetToolTipText(){
        Assert.assertEquals("Returns the tool tip text","ToolTipText", orderPanelsTest.getOnTimeLabel().getToolTipText());
    }
}
