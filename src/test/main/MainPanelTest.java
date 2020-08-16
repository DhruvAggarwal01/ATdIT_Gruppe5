package test.main;

import org.junit.*;

import main.MainPanel;
import main.NavItemPanelChooser;

public class MainPanelTest {

    MainPanel mainPanel;

    @Before
    public void init() {
        mainPanel = new MainPanel();
        mainPanel.setVisible(true);
    }

    @Test
    public void testHomeScreenOnFirstScreen() {
        Assert.assertTrue("Overview-Panel of JTabbedPane should be set as initial screen",
                MainPanel.getNavPane().getSelectedComponent().equals(new NavItemPanelChooser("Overview", null, null)));
    }

}