package test.main;

import javax.swing.JFrame;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import dialogs.SettingsDialog;
import main.Application;

public class SettingsDialogTest {

    Application applicationtest = new Application();
    JFrame frametest2 =  Application.getAppWindow();
    SettingsDialog settingsDialogTest = new SettingsDialog(frametest2, "test", true);
    
    @Test //tbd
    public void testCountComponentStyleSettingPanek(){
        Assert.assertEquals(2,settingsDialogTest.getStyleSettingsPanel().getComponentCount());
    }
}
