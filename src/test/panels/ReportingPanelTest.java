package test.panels;

import org.junit.*;

import panels.ReportingPanel;

public class ReportingPanelTest {

    // Creation and initialization of a new reportingPanel object
    ReportingPanel reportingPanelTest = new ReportingPanel();

    // Checks with a getter if all 7 components in reportingHeaderRowPanel were
    // added correctly
    @Test
    public void testReportingHeaderRowPanelComponentCount() {
        Assert.assertEquals(7, reportingPanelTest.getReportingHeaderRowPanel().getComponentCount());
    }

    // Checks with a getter if all 2 components of reportingPanel were added
    // correctly
    @Test
    public void testReportingPanelComponentCount() {
        Assert.assertEquals(2, reportingPanelTest.getComponentCount());
    }

    // Checks with a getter if the text in mockLabel is initialized correctly
    @Test
    public void testGetTextMockLabel() {
        Assert.assertEquals("REPORTING-Panel (siehe Prototyp)", reportingPanelTest.getMockLabel().getText());
    }

    // Checks with a getter if the text in backButton is initialized correctly
    @Test
    public void testGetTextBackButton() {
        Assert.assertEquals("Zurück", reportingPanelTest.getBackButton().getText());
    }
}
