package test.main;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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
        Assert.assertEquals(40, timeoutimerTest.getTimeoutDelay());
    }

    @Test
    public void testGetDelay(){
        Assert.assertEquals(30, timeoutimerTest.getDelay());
    }

}