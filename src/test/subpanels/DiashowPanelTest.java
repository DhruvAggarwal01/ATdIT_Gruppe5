package test.subpanels;

import java.time.Duration;
import java.time.Instant;

import org.junit.*;

import subpanels.DiashowPanel;

public class DiashowPanelTest {

  DiashowPanel diashowPanelTest;

  @Before
  public void init() {
    diashowPanelTest = new DiashowPanel("Title");
  }

  //Checks with a getter if the title of the diashowPanel is initialized correctly
  @Test
  public void testGetDiashowPanelTitle() {
    Assert.assertEquals("Give the title of the diashow panel", "Title", diashowPanelTest.getDiashowTitle());
  }

  //Checks with a getter if all 2 components of diashowPanel were added correctly
  @Test
  public void testDiashowPanelContainsPanels() {
    Assert.assertEquals("Looks how many components where added", 2, diashowPanelTest.getComponentCount());
  }

  //Checks if it is true that the timer of the diahowPanel is running with a boolean condition
  @Test
  public void testTimerIsRunning() {
    Assert.assertTrue(diashowPanelTest.getTimer().isRunning());
  }

  @Test
  public void testDurationTimeDiashow() {
    diashowPanelTest.getTimer().setInitialDelay(3);
    Instant start = Instant.now();
    System.out.println(start);
    Instant end = null;
    if (diashowPanelTest.getDiashowLabel().getIcon().equals(diashowPanelTest.getImages()[0])) {
      end = Instant.now();
    }
    System.out.println(end);
    int duration = (int) Duration.between(start, end).getSeconds();
    System.out.println(duration);
  }
}