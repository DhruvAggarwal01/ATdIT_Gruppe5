package test.panels;

import org.junit.*;

import panels.EditOrder;

public class EditOrderTest {

  EditOrder editOrderTest;

  //Initialization of a new EditOrder object
  @Before
  public void init() {
    editOrderTest = new EditOrder(false);
  }

  //Checks with a getter if all 12 components of orderPanel were added correctly
  @Test
  public void testOrderPanelContainsPanels() {
    Assert.assertEquals("Looks how many components where added", 12, editOrderTest.getOrderPanel().getComponentCount());
  }

  //Checks with a getter if the component in editOrder was added correctly
  @Test
  public void testEditOrderContainsPanels() {
    Assert.assertEquals("Looks how many components where added", 1, editOrderTest.getComponentCount());
  }

}
