package test.panels;

import org.junit.*;

import java.text.SimpleDateFormat;
import java.util.*;

import panels.ToDoElement;

public class ToDoElementTest {

    Date datumprobe = new Date();
    Date zeitprobe = new Date();
    ToDoElement probe;

    @Before
    public void init() {
        probe = new ToDoElement("Name", "Beschreibung", datumprobe, zeitprobe, 1);
    }

    @Test
    public void testGetName() {
        Assert.assertEquals("Should provide the Name of the to do element","Name", probe.getName());
    }

    @Test
    public void testGetBeschreibung() {
        Assert.assertEquals("provides the explaination of the element","Beschreibung", probe.getBeschreibung());
    }

    @Test //tbd
    public void testGetDatum() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM dd HH:mm:ss");
        Calendar calendar = new GregorianCalendar(2013, 0, 31);
        System.out.println(sdf.format(calendar.getTime()));
        /*
         * probe.setDate(2020, 8, 28);
         * Assert.assertEquals("Tue Jan 28 00:08:00 CET 2020",probe.getDatum());
         */
    }

    @Test
    public void testGetPriorität() {
        Assert.assertEquals("gives the given priority",1, probe.getPriorität());
    }
}