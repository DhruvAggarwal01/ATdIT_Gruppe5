package test.panels;

import org.junit.*;

import panels.ProduktionPanel;

public class ProduktionPanelTest {

    // Creation and initialization of a new ProduktionPanel object
    ProduktionPanel produktionPanelTest = new ProduktionPanel();

    // Checks with a getter if the component in productionPanel was added corrrectly
    @Test
    public void testGetComponentProductionPanel() {
        Assert.assertEquals("Gets the component amount of the Production Panel", 1,
                produktionPanelTest.getComponentCount());
    }
}
