package test.main.mainTest;

import org.junit.*;

import main.TimeoutTimer;

public class TimeoutTimerTest {
    
    TimeoutTimer timeoutimerTest;

    @Before
    public void init(){
    timeoutimerTest = new TimeoutTimer(30);
    }

    @Test
    public void testSetTimeoutDelay(){
        timeoutimerTest.setTimeoutDelay(40);
        Assert.assertEquals("After changing the delay it should equals to 40",40, timeoutimerTest.getTimeoutDelay());
    }

    @Test
    public void testGetDelay(){
        Assert.assertEquals("The initialized delay should be 30",30, timeoutimerTest.getDelay());
    }

}