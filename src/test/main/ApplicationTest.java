package test.main;

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
        Assert.assertEquals(3600000, Application.getTimeoutDelay());
    }

    @Test
    public void testTimeoutTimerIsRunning(){
       Application.startTimeoutTimer(1000);
        Assert.assertTrue(Application.getTimeoutTimer().isRunning());;
    }

    @AfterClass
    public static void tearDown() {
        System.out.println("Test wird beendet.");
    }

}