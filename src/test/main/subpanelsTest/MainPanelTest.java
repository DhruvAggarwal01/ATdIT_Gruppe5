package test.main.subpanelsTest;

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
        Assert.assertEquals("provides the title of the app","Steinbruch ALBERSWEILER", MainPanel.getAppTitle());
    }

    @Test
    public void testSetHeaderPanel(){
        HeaderPanel panelTesten = new HeaderPanel(null);
        MainPanel.setHeaderPanel(panelTesten);
        Assert.assertFalse("false because a panel exists",MainPanel.getHeaderpanel().equals(null));
    }
 
}