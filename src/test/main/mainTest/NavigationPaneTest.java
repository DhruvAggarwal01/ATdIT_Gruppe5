package test.main.mainTest;

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

    @Before
    public void init() {
        testFrame = new JFrame();
        testFrame.setVisible(true);
    }

    @Test
    public void testGetTabCount() {
        testNavPane = new NavigationPane(JTabbedPane.LEFT, JTabbedPane.SCROLL_TAB_LAYOUT);
        testFrame.add(testNavPane);
        Assert.assertEquals("Looks how many components where added",7, testNavPane.getTabCount());
    }

    @Test //tbd
    public void testIsTabExisting() {
        testNavPane = new NavigationPane(JTabbedPane.LEFT, JTabbedPane.SCROLL_TAB_LAYOUT);
        testFrame.add(testNavPane);
        Assert.assertTrue("First existing tab should be 'Overview'",(testNavPane.getTabComponentAt(0)).equals(new NavItemPanelChooser("Overview", null, null)));
    }

    @Test
    public void testTabTitle() {
        testNavPane = new NavigationPane(JTabbedPane.LEFT, JTabbedPane.SCROLL_TAB_LAYOUT);
        testFrame.add(testNavPane);
        Assert.assertEquals("The Tab title should be 'Overview'","Overview", testNavPane.getTitleAt(0));
    }

}