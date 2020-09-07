package test.main.mainTest;

import main.Application;

import org.junit.*;

public class ApplicationTest {
    
    @Before
    public void init() {
        System.out.println("Test wird gestartet.");
    }

    @Test
    public void testGetAppWindowNull() {
        Assert.assertNull("AppWindow should not be initialized yet", Application.getAppWindow());
    }

    @Test
    public void testTimeoutDelay(){
        Assert.assertEquals("Timeout delay should be initialized with int 3600000",3600000, Application.getTimeoutDelay());
    }

    @Test
    public void testTimeoutTimerIsRunning(){
       Application.startTimeoutTimer(1000);
        Assert.assertTrue("Set should change the delay to 1000",Application.getTimeoutTimer().isRunning());;
    }

    @AfterClass
    public static void tearDown() {
        System.out.println("Test wird beendet.");
    }

}