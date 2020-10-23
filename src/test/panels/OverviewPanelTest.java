package test.panels;

import org.junit.*;

import panels.OverviewPanel;

public class OverviewPanelTest {

  OverviewPanel overviewPanelTest;

  //Creation and initialization of a new OverviewPanelTest object
  @Before
  public void init() {
    overviewPanelTest = new OverviewPanel();
  }

  //Checks with a getter if all 2 components of overviewPanel were added correctly
  @Test
  public void testOverviewPanelContainsPanels() {
    Assert.assertEquals("Looks how many components where added", 2, overviewPanelTest.getComponentCount());
  }

  //Checks with a getter if all 2 components of smallPanels were added correctly
  @Test
  public void testCountComponentsSmallPanels() {
    Assert.assertEquals("Looks how many components where added", 2,
        overviewPanelTest.getSmallPanels().getComponentCount());
  }

}