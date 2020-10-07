package test.main;

import org.junit.*;

import main.TimeoutTimer;

public class TimeoutTimerTest {

    TimeoutTimer timeoutimerTest;

    //Creates and initializate a new TimeoutTimer object
    @Before
    public void init() {
        timeoutimerTest = new TimeoutTimer(30);
    }

    //Checks with a getter if the setter changes the timeoutDelay correctly
    @Test
    public void testSetTimeoutDelay() {
        timeoutimerTest.setTimeoutDelay(40);
        Assert.assertEquals("After changing the delay it should equals to 40", 40, timeoutimerTest.getTimeoutDelay());
    }

    //checks with a getter if the timeoutDelay is initialized correctly
    @Test
    public void testGetDelay() {
        Assert.assertEquals("The initialized delay should be 30", 30, timeoutimerTest.getDelay());
    }

}