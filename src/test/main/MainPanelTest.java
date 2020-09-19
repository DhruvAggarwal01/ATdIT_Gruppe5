package test.main;

import org.junit.*;

import main.HeaderPanel;
import main.MainPanel;
import main.NavItemPanelChooser;

public class MainPanelTest {

    MainPanel mainPanel;

    @Before
    public void init() {
        mainPanel = new MainPanel();
        mainPanel.setVisible(true);
    }

    //Checks if the right homeScreen is initialized so if the first panel a user can see is the overview panel
    @Test
    public void testHomeScreenOnFirstScreen() {
        Assert.assertTrue("Overview-Panel of JTabbedPane should be set as initial screen",
                MainPanel.getNavPane().getSelectedComponent().equals(new NavItemPanelChooser("Overview", null, null)));
    }

    //Checks if the AppTitle is initialized correctly
    @Test
    public void testAppTitle() {
        Assert.assertEquals("provides the title of the app", "Steinbruch ALBERSWEILER", MainPanel.getAppTitle());
    }

    //Checks if the HeaderPanel equals null and should return false because a headerPanel was initializied before
    @Test
    public void testSetHeaderPanel() {
        HeaderPanel panelTesten = new HeaderPanel(null);
        MainPanel.setHeaderPanel(panelTesten);
        Assert.assertFalse("false because a panel exists", MainPanel.getHeaderPanel().equals(null));
    }

}