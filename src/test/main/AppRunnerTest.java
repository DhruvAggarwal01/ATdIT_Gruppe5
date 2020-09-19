package test.main;

import org.junit.*;

import main.AppRunner;

public class AppRunnerTest {

    //Checks if the LoginFrame is visible
    @Test
    public void testAppFrameIsVisible() {
        AppRunner.main(null);
        Assert.assertTrue(AppRunner.getLoginFrame().isVisible());
    }
}
