package test.subpanels;

import org.junit.Assert;
import org.junit.Test;

import subpanels.QuarryMapLabels;

public class QuarryMapLabelsTest {

    QuarryMapLabels quarryMapLabelsTest = new QuarryMapLabels();

    @Test
    public void testPanelLabelGetComponentCount() {
        Assert.assertEquals("Shows how many components were add", 2,
                quarryMapLabelsTest.getPanelLabels().getComponentCount());
    }

    @Test
    public void testPanelGetComponentCount() {
        Assert.assertEquals("Shows how many components were add", 2, quarryMapLabelsTest.getComponentCount());
    }

    @Test
    public void testGetTextLabels() {
        Assert.assertEquals("Get the text from the Label", "Drücke N um eine Stelle im Bild zu markieren. ",
                quarryMapLabelsTest.getText1().getText());
    }
}
