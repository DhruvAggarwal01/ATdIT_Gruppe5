package test.subpanels;

import org.junit.Assert;
import org.junit.Test;

import subpanels.KarteLabels;

public class KarteLabelsTest {
    
    KarteLabels karteLabelsTest = new KarteLabels();

    @Test
    public void testPanelLabelGetComponentCount(){
        Assert.assertEquals("Shows how many components were add",2, karteLabelsTest.getPanelLabels().getComponentCount());
    }
    @Test
    public void testPanelGetComponentCount(){
        Assert.assertEquals("Shows how many components were add",2, karteLabelsTest.getComponentCount());
    }
    @Test
    public void testGetTextLabels(){
        Assert.assertEquals("Get the text from the Label","Drücke N um eine Stelle im Bild zu markieren. ", karteLabelsTest.getText1().getText());
        Assert.assertEquals("Get the text from the Label","Notizen über die jeweiligen Standorte kannst du hier anlegen:", karteLabelsTest.getText2().getText());
    }
}
