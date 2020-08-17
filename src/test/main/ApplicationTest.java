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

    @AfterClass
    public static void tearDown() {
        System.out.println("Test wird beendet.");
    }

}