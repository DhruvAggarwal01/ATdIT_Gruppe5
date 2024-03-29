package dialogs;

import javax.swing.JFrame;

import org.junit.*;

import atdit1.group5.dialogs.ProfileDialog;

public class ProfileDialogTest {

    // Creation and initialization of a new JFrame and ProfileDialog object
    JFrame frametest = new JFrame();
    ProfileDialog profileDialogTest = new ProfileDialog(frametest, null, false);

    // Checks if all the 12 added components of the personalInfoPanel were added
    // correctly
    @Test
    public void testCountComponentPersonalInfoPanel() {
        Assert.assertEquals("Looks how many components where added", 12,
                profileDialogTest.getPersonalInfoPanel().getComponentCount());
    }

    // Checks if all the 6 components in contentPanel were added correctly
    @Test
    public void testCountComponentContentPanel() {
        Assert.assertEquals("Looks how many components where added", 6,
                profileDialogTest.getContentPanel().getComponentCount());
    }

    // Checks if all the 3 components in rsscPanel were added correctly
    @Test
    public void testCountComponentRsscPanel() {
        Assert.assertEquals("Looks how many components where added", 3,
                profileDialogTest.getRsscPanel().getComponentCount());
    }

    // Checks if all the 3 components in changePswdPanel were added correctly
    @Test
    public void testCountComponentChangePswdPanel() {
        Assert.assertEquals("Looks how many components where added", 3,
                profileDialogTest.getChangePswdPanel().getComponentCount());
    }
}