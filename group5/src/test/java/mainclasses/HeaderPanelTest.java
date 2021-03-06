package mainclasses;

import java.awt.*;

import java.awt.event.*;
import javax.swing.*;
import org.junit.*;

import atdit1.group5.mainclasses.HeaderPanel;
import atdit1.group5.mainclasses.MainPanel;
import atdit1.group5.mainclasses.NavItemPanelChooser;

public class HeaderPanelTest {

    MainPanel mainPanel;
    JMenuBar testMenuBar;
    JMenu testMenu;

    // Creation and initialization of a new MainPanel object
    @Before
    public void init() {
        mainPanel = new MainPanel();
        mainPanel.setVisible(true);
        testMenuBar = (JMenuBar) MainPanel.getHeaderPanel().userIconWithMenuInJPanel.getComponent(0);
        testMenu = (JMenu) testMenuBar.getComponent(0);
    }

    // Checks if the Logo and Title are visible and returns true
    @Test
    public void testShowingLogoAndTitle() {
        Assert.assertTrue("True if logo and title are being shown",
                MainPanel.getHeaderPanel().logoAndHeaderTitle.isShowing());
    }

    // Checks if the UserIconMenu is visible and returns true
    @Test
    public void testShowingUserIconMenu() {
        Assert.assertTrue("true if user icon is being shown",
                MainPanel.getHeaderPanel().userIconWithMenuInJPanel.isShowing());
    }

    @Test
    public void testGoToOverviewOnClick() throws AWTException {
        MainPanel.getNavPane().setSelectedIndex(2); // (int) (Math.random() *
        // MainPanel.getNavPane().getComponentCount()));
        Robot testingBot = new Robot();
        int x = MainPanel.getHeaderPanel().logoAndHeaderTitle.getComponent(0).getX();
        int y = MainPanel.getHeaderPanel().logoAndHeaderTitle.getComponent(0).getY();
        testingBot.mouseMove(x, y);
        testingBot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        testingBot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        testingBot.delay(1000);
        Assert.assertTrue("Overview-Panel should be set after clicking on App logo",
                MainPanel.getNavPane().getSelectedComponent().equals(new NavItemPanelChooser("Overview", null, null)));
    }

    @Test
    public void testProfileMenuDeselected() throws AWTException {
        testMenu.setSelected(true);
        Robot testingBot = new Robot();
        testingBot.mouseMove(60, 0);
        testingBot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        testingBot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Assert.assertFalse("Profile Menu is deselected after clicking somewhere else", testMenu.isSelected());
    }

    // Checks if the profileMenu is initialized correctly, which should return false
    // because it is initialized as not selected
    @Test
    public void testProfileMenuNotSelected() {
        Assert.assertFalse("Profile Menu is not selected initially", testMenu.isSelected());
    }

    // Creates a new HeaderPanel with the title 'Test' and checks if the title is
    // set correctly with a getter
    @Test
    public void testHeaderTitleAdder() {
        HeaderPanel panelTest = new HeaderPanel("Test");
        panelTest.headerTitleAdder("Test");
        Assert.assertEquals("gives the title of the header panel", "Test", panelTest.getHeaderTitleJLabel().getText());
    }

    @AfterClass
    public static void tearDown() {
        System.out.println("Test wird beendet.");
    }
}