package test.main;

import javax.swing.JFrame;

import org.junit.Assert;
import org.junit.Test;
import dialogs.SettingsDialog;

public class SettingsDialogTest {
 
    JFrame frametest2 = new JFrame();
    SettingsDialog settingsDialogTest = new SettingsDialog(frametest2, null, false);
 
    @Test
    public void testCountComponentStyleSettingPanek(){
        Assert.assertEquals(2,settingsDialogTest.getStyleSettingsPanel().getComponentCount());
    }
}
