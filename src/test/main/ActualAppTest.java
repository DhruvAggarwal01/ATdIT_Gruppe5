package test.main;

import org.junit.*;

import main.ActualApp;

public class ActualAppTest {

    @Before
    public void init() {
        System.out.println("Test wird gestartet.");
    }

    @Test
    public void testGetAppWindowNull() {
        Assert.assertNull("AppWindow should not be initialized yet", ActualApp.getAppWindow());
    }

    @Test
    public void testTimeoutDelay() {
        Assert.assertEquals("Timeout delay should be initialized with int 3600000", 3600000,
                ActualApp.getTimeoutDelay());
    }

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