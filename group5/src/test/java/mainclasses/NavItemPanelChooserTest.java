package mainclasses;

import org.junit.*;

import atdit1.group5.exceptions.NavItemNotFoundException;
import atdit1.group5.mainclasses.NavItemPanelChooser;
import atdit1.group5.panels.ReportingPanel;

public class NavItemPanelChooserTest {

    NavItemPanelChooser nipChooserTest1;
    NavItemPanelChooser nipChooserTest2;
    NavItemPanelChooser nipChooserTest3;
    NavItemPanelChooser nipChooserTestException;

    //Creates and initialized two new NavItemPanelChooser objects
    @Before
    public void init() {
        nipChooserTest1 = new NavItemPanelChooser("Overview", null, null);
        nipChooserTest2 = new NavItemPanelChooser("Overview", "Reporting", null);
    }

    //Checks if the PanelExplorerTextToLevel1 is initialized correctly as 'Overview'
    @Test
    public void testPanelExplorerTextToLevel1() {
        Assert.assertEquals("Overview", nipChooserTest1.getPanelExplorerTitle());
    }

    //Checks if the panelExplorerTextToLevel2 is initialized correctly as 'Overview > Reporting'
    @Test
    public void testPanelExplorerTextToLevel2() {
        Assert.assertEquals("Overview > Reporting", nipChooserTest2.getPanelExplorerTitle());
    }

    @Test
    public void testChooserFunctionaliltySuccess() {
        ReportingPanel reportingPanelInstance = new ReportingPanel();
        Assert.assertEquals(reportingPanelInstance.getClass(), nipChooserTest2.getComponent(0).getClass());
    }

    //Checks if the Exception is caught correctly
    @Test(expected = NavItemNotFoundException.class)
    public void testChooserFunctionaliltyFailure() throws NavItemNotFoundException {
        nipChooserTestException = new NavItemPanelChooser("NoPanel", null, null);
        nipChooserTestException.chooserFunctionality();
    }
}
