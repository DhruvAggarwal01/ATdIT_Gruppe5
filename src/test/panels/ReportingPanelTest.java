package test.panels;

import org.junit.Assert;
import org.junit.Test;

import panels.ReportingPanel;

public class ReportingPanelTest {
    
    ReportingPanel reportingPanelTest = new ReportingPanel();

    @Test
    public void testReportingHeaderRowPanelComponentCount(){
        Assert.assertEquals(7, reportingPanelTest.getReportingHeaderRowPanel().getComponentCount());
    }
    @Test
    public void testReportingPanelComponentCount(){
        Assert.assertEquals(2, reportingPanelTest.getComponentCount());
    }
    @Test
    public void testGetTextMockLabel(){
        Assert.assertEquals("REPORTING-Panel (siehe Prototyp)", reportingPanelTest.getMockLabel().getText());
    }
    @Test
    public void testGetTextBackButton(){
        Assert.assertEquals("Zurück", reportingPanelTest.getBackButton().getText());
    }
}
