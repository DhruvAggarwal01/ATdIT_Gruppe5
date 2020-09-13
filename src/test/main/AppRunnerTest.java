package test.main;

import org.junit.*;

import main.AppRunner;

public class AppRunnerTest {

    @Test
    public void testAppFrameIsVisible() {
        AppRunner.main(null);
        Assert.assertTrue(AppRunner.getLoginFrame().isVisible());
    }
}
