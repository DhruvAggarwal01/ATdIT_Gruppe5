package test.main;

import org.junit.*;

import exceptions.NavItemNotFoundException;
import main.NavItemPanelChooser;
import panels.ReportingPanel;

public class NavItemPanelChooserTest {

    NavItemPanelChooser nipChooserTest1;
    NavItemPanelChooser nipChooserTest2;
    NavItemPanelChooser nipChooserTest3;
    NavItemPanelChooser nipChooserTestException;

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

    @Test(expected = NavItemNotFoundException.class)
    public void testChooserFunctionaliltyFailure() throws NavItemNotFoundException {
        nipChooserTestException = new NavItemPanelChooser("NoPanel", null, null);
        nipChooserTestException.chooserFunctionality();
    }
}
