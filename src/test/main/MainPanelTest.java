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
 
    @Test
    public void testHomeScreenOnFirstScreen() {
        Assert.assertTrue("Overview-Panel of JTabbedPane should be set as initial screen",
                MainPanel.getNavPane().getSelectedComponent().equals(new NavItemPanelChooser("Overview", null, null)));
    }
 
    @Test
    public void testAppTitle() {
        Assert.assertEquals("Steinbruch ALBERSWEILER", MainPanel.getAppTitle());
    }

    @Test
    public void testSetHeaderPanel(){
        HeaderPanel panelTesten = new HeaderPanel(null);
        MainPanel.setHeaderPanel(panelTesten);
        Assert.assertFalse(MainPanel.getHeaderPanel().equals(null));
    }
 
}