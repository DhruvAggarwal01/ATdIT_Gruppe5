package test.panels;

import org.junit.Assert;
import org.junit.Test;

import panels.ProduktionPanel;

public class ProduktionPanelTest {

    ProduktionPanel produktionPanelTest = new ProduktionPanel();

    @Test
    public void testGetComponentProductionPanel() {
        Assert.assertEquals("Gets the component amount of the Production Panel", 1,
                produktionPanelTest.getComponentCount());
    }
}
