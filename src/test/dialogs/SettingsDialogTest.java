package test.dialogs;

import javax.swing.JFrame;
import org.junit.*;

import dialogs.SettingsDialog;
import main.ActualApp;

public class SettingsDialogTest {

    ActualApp applicationtest = new ActualApp();
    JFrame frametest2 = ActualApp.getAppWindow();
    SettingsDialog settingsDialogTest = new SettingsDialog(frametest2, "test", true);

    @Test
    public void testCountComponentStyleSettingPanek() {
        Assert.assertEquals("Looks how many components where added", 2,
                settingsDialogTest.getStyleSettingsPanel().getComponentCount());
    }
}
