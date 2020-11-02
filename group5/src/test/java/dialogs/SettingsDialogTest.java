package dialogs;

import javax.swing.JFrame;
import org.junit.*;

import atdit1.group5.dialogs.SettingsDialog;
import atdit1.group5.mainclasses.ActualApp;

public class SettingsDialogTest {

    //Creation and initialization of new ActualApp, JFrame and SettingsDialog objects
    ActualApp applicationtest = new ActualApp();
    JFrame frametest2 = ActualApp.getAppWindow();
    SettingsDialog settingsDialogTest = new SettingsDialog(frametest2, "test", true);

    //Checks if all 2 components of styleSettingPanel were added correctly
    @Test
    public void testCountComponentStyleSettingPanek() {
        Assert.assertEquals("Looks how many components where added", 2,
                settingsDialogTest.getStyleSettingsPanel().getComponentCount());
    }
}
