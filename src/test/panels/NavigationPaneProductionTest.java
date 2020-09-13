package test.panels;

import org.junit.*;

import panels.NavigationPaneProduction;

public class NavigationPaneProductionTest {

    NavigationPaneProduction navigationPaneProductionTest = new NavigationPaneProduction(0, 0);

    @Test
    public void testGetTabCount() {
        Assert.assertEquals(4, navigationPaneProductionTest.getTabCount());
    }

    @Test
    public void testGetTabAtIndex() {
        System.out.println(navigationPaneProductionTest.getTitleAt(1));
    }

}
