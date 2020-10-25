package mainclasses;

import org.junit.*;

import atdit1.group5.mainclasses.AppRunner;

public class AppRunnerTest {

    //Checks if the LoginFrame is visible
    @Test
    public void testAppFrameIsVisible() {
        AppRunner.main(null);
        Assert.assertTrue(AppRunner.getLoginFrame().isVisible());
    }
}
