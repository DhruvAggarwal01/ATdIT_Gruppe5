package test.main;

import javax.swing.JFrame;

import org.junit.Assert;
import org.junit.Test;

import dialogs.ProfileDialog;

public class ProfileDialogTest {
 
    JFrame frametest = new JFrame();
    ProfileDialog profileDialogTest = new ProfileDialog(frametest, null, false);

    @Test
    public void test(){
        System.out.println(profileDialogTest.getChangePswdPanel().getComponentCount());
    }

    @Test
    public void testCountComponentPersonalInfoPanel(){
        Assert.assertEquals(12,profileDialogTest.getPersonalInfoPanel().getComponentCount());
    }

    @Test
    public void testCountComponentContentPanel(){
        Assert.assertEquals(6,profileDialogTest.getContentPanel().getComponentCount());
    }

    @Test
    public void testCountComponentRsscPanel(){
        Assert.assertEquals(3,profileDialogTest.getRsscPanel().getComponentCount());
    }

    @Test
    public void testCountComponentChangePswdPanel(){
        Assert.assertEquals(3,profileDialogTest.getChangePswdPanel().getComponentCount());
    }
}