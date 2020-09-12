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

  @Test
  public void testGetPanelTitle() {
    Assert.assertEquals("Give the title of the diashow panel", "Title", diashowPanelTest.getDiashowTitle());
  }

  @Test
  public void testContainsPanels() {
    Assert.assertEquals("Looks how many components where added", 2, diashowPanelTest.getComponentCount());
  }

  @Test
  public void testTimerIsRunning() {
    Assert.assertTrue(diashowPanelTest.getTimer().isRunning());
  }

  @Test
  public void testDurationTimeDiashow() { // tbd
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