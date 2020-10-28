package panels;

import org.junit.*;

import atdit1.group5.panels.NavigationPaneProduction;

public class NavigationPaneProductionTest {

    //Creation and initialization of a NavigationPaneProduction object

    NavigationPaneProduction navigationPaneProductionTest = new NavigationPaneProduction(0, 0);

    //Checks with a getter if all 4 tabs were added correctly
    @Test
    public void testGetTabCount() {
        Assert.assertEquals(4, navigationPaneProductionTest.getTabCount());
    }

}
