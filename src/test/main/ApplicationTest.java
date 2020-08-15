package test.main;

import main.Application;

import org.junit.*;

public class ApplicationTest {
    
    @Before
    public void setUp() {
        System.out.println("Test wird gestartet.");
    }

    @Test
    public void testGetAppWindowNull() {
        Assert.assertNull(Application.getAppWindow());
    }

    @After
    public void tearDown() {
        System.out.println("Test wird beendet.");
    }

}