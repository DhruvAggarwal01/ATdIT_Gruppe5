package test.main;

import main.ActualApp;

import org.junit.*;

public class ApplicationTest {
    
    @Before
    public void init() {
        System.out.println("Test wird gestartet.");
    }

    @Test
    public void testGetAppWindowNull() {
        Assert.assertNull("AppWindow should not be initialized yet", ActualApp.getAppWindow());
    }

    @AfterClass
    public static void tearDown() {
        System.out.println("Test wird beendet.");
    }

}