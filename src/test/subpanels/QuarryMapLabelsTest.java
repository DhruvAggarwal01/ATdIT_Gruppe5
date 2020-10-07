package test.subpanels;

import org.junit.Assert;
import org.junit.Test;

import subpanels.QuarryMapLabels;

public class QuarryMapLabelsTest {

   //Creation and initialization of a new QuarryMapLabel object
   
    QuarryMapLabels quarryMapLabelsTest = new QuarryMapLabels();

    //Checks with a getter if all 2 components of panelLabel were added correctly
    @Test
    public void testPanelLabelGetComponentCount() {
        Assert.assertEquals("Shows how many components were add", 2,
                quarryMapLabelsTest.getPanelLabels().getComponentCount());
    }

    //Checks with a getter if all 2 components of quarryMapLabelTest were added correctly
    @Test
    public void testQuarryMapLabelTestGetComponentCount() {
        Assert.assertEquals("Shows how many components were add", 2, quarryMapLabelsTest.getComponentCount());
    }

    //Checks with a getter if the text of the quarryMapLabelTest is initialized correctly
    @Test
    public void testGetTextLabels() {
        Assert.assertEquals("Get the text from the Label", "Drücke N um eine Stelle im Bild zu markieren. ",
                quarryMapLabelsTest.getText1().getText());
    }
}
