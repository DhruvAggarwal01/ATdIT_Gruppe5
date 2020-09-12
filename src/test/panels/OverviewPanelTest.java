package test.panels;

import org.junit.*;

import panels.OverviewPanel;

public class OverviewPanelTest {

  OverviewPanel overviewPanelTest = new OverviewPanel();

  @Test
  public void testContainsPanels() {
    Assert.assertEquals("Looks how many components where added", 2, overviewPanelTest.getComponentCount());
  }

  @Test
  public void testCountSmallPanels() {
    Assert.assertEquals("Looks how many components where added", 2,
        overviewPanelTest.getSmallPanels().getComponentCount());
  }

}