package subpanels;

import org.junit.*;

import atdit1.group5.subpanels.QuarryMapMain;

public class QuarryMapMainTest {

    // Cration and initialization of a new QuarryMapMain object
    QuarryMapMain quarryMapMainTest = new QuarryMapMain();

    // Checks with a getter if all 2 components of quarryMapMainTest were added
    // correctly
    @Test
    public void testQuarryMapMainComponentCount() {
        Assert.assertEquals("Checks the amount of components added", 2, quarryMapMainTest.getComponentCount());
    }

}
