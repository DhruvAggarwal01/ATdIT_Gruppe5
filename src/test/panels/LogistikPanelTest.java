package test.panels;

import org.junit.*;

import panels.LogistikPanel;

public class LogistikPanelTest {

    LogistikPanel logistikPanelTest;

    //initialization of a new LogistikPanel object
    
    @Before
    public void init() {
        logistikPanelTest= new LogistikPanel(false);
    }
  
    /*@Test
    public void testButtonPanelContainsComponents() {
    Assert.assertEquals("Looks how many components where added",2,logistikPanelTest.getButtonPanel().getComponentCount());
     }
    @Test
     public void testOrderPanelContainsComponents() {
       Assert.assertEquals("Looks how many components where added", 3, logistikPanelTest.getOrderPanel().getComponentCount());
     }
     @Test
     public void testLogistikPanelContainsComponents(){
         Assert.assertEquals("Looks how many components where added", 2, logistikPanelTest.getComponentCount()); 
     } */

}
