package test.subpanels;

import org.junit.Assert;
import org.junit.Test;

import subpanels.KarteMain;

public class KarteMainTest {
    
    KarteMain karteMainTest = new KarteMain();

    @Test
    public void testKarteMainComponentCount(){
        Assert.assertEquals("Checks the amount of components added",2, karteMainTest.getComponentCount());
    }

}
