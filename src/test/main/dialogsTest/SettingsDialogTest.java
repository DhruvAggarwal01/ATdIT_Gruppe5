package test.main.dialogsTest;

import javax.swing.JFrame;

import org.junit.*;
import dialogs.SettingsDialog;
import main.Application;

public class SettingsDialogTest {

    Application applicationtest = new Application();
    JFrame frametest2 =  Application.getAppWindow();
    SettingsDialog settingsDialogTest = new SettingsDialog(frametest2, "test", true);
    
    @Test //tbd
    public void testCountComponentStyleSettingPanek(){
        Assert.assertEquals("Looks how many components where added",2,settingsDialogTest.getStyleSettingsPanel().getComponentCount());
    }
}
