package mainclasses;

import org.junit.*;

import atdit1.group5.mainclasses.ActualApp;

public class ActualAppTest {

    @Before
    public void init() {
        System.out.println("Test wird gestartet.");
    }


    // Gets the appWindow with a getter which should not be initialized
    @Test
    public void testGetAppWindowNull() {
        Assert.assertNull("AppWindow should not be initialized yet", ActualApp.getAppWindow());
    }

    // Checks with a getter if the initialized timeoutDelay of int 3600000 is initialized correctly
    @Test
    public void testTimeoutDelay() {
        Assert.assertEquals("Timeout delay should be initialized with int 3600000", 3600000,
                ActualApp.getTimeoutDelay());
    }

    //Checks with a getter if the setter changes the timeoutTimer correctly 
    @Test
    public void testTimeoutTimerIsRunning() {
        ActualApp.startTimeoutTimer(1000);
        Assert.assertTrue("Set should change the delay to 1000", ActualApp.getTimeoutTimer().isRunning());
        ;
    }

    @AfterClass
    public static void tearDown() {
        System.out.println("Test wird beendet.");
    }

}