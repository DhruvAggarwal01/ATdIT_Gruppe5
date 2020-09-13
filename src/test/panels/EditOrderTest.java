package test.panels;

import org.junit.*;

import panels.EditOrder;

public class EditOrderTest {

  EditOrder editOrderTest;

  @Before
  public void init() {
    editOrderTest= new EditOrder(false);
  }

    @Test
  public void testOrderPanelContainsPanels() {
    Assert.assertEquals("Looks how many components where added", 12, editOrderTest.getOrderPanel().getComponentCount());
  }

  @Test
  public void testEditOrderContainsPanels() {
    Assert.assertEquals("Looks how many components where added", 1, editOrderTest.getComponentCount());
  }

}
