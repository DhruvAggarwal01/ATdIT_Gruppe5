package test.main;

import javax.swing.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.awt.*;

import main.NavItemPanelChooser;
import main.NavigationPane;

public class NavigationPaneTest {

    JFrame testFrame;

    NavigationPane testNavPane;
    Container testContainer;

    //Creates and initialized a new JFrame
    @Before
    public void init() {
        testFrame = new JFrame();
        testFrame.setVisible(true);
    }

    //Checks if the correct amount of tabs, so all 7 tabs, were added
    @Test
    public void testGetTabCount() {
        testNavPane = new NavigationPane(JTabbedPane.LEFT, JTabbedPane.SCROLL_TAB_LAYOUT);
        testFrame.add(testNavPane);
        Assert.assertEquals("Looks how many components where added", 7, testNavPane.getTabCount());
    }

    //Checks if the tab in the index position '0' is set correctly and returns true if the first tab is 'Overview'
    @Test
    public void testIsTabExisting() {
        testNavPane = new NavigationPane(JTabbedPane.LEFT, JTabbedPane.SCROLL_TAB_LAYOUT);
        testFrame.add(testNavPane);
        Assert.assertTrue("First existing tab should be 'Overview'",
                (testNavPane.getTabComponentAt(0)).equals(new NavItemPanelChooser("Overview", null, null)));
    }

    //Checks if the name of the first tab at index '0' is 'Overview'
    @Test
    public void testTabTitle() {
        testNavPane = new NavigationPane(JTabbedPane.LEFT, JTabbedPane.SCROLL_TAB_LAYOUT);
        testFrame.add(testNavPane);
        Assert.assertEquals("The Tab title should be 'Overview'", "Overview", testNavPane.getTitleAt(0));
    }

}