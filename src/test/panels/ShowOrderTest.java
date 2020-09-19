package test.panels;

import org.junit.*;

import panels.ShowOrder;

public class ShowOrderTest {
    
    ShowOrder showOrderTest = new ShowOrder();
    
    // @Test
    // public void testOrderPanelContainsComponents(){
    //     Assert.assertEquals("Shows how many components were add",12, showOrderTest.getOrderPanel().getComponentCount());
    // }

    //Checks with a getter if the component in showOrder was added correctly
    @Test
    public void testShowOrderContainsComponents(){
        Assert.assertEquals("Shows how many components were add",1, showOrderTest.getComponentCount());
    }
}
