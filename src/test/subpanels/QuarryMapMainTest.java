package test.subpanels;

import org.junit.Assert;
import org.junit.Test;

import subpanels.QuarryMapMain;

public class QuarryMapMainTest {

    QuarryMapMain quarryMapMainTest = new QuarryMapMain();

    @Test
    public void testQuarryMapMainComponentCount() {
        Assert.assertEquals("Checks the amount of components added", 2, quarryMapMainTest.getComponentCount());
    }

}
