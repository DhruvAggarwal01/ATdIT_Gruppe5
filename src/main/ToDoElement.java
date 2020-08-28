package main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Diese Klasse beschreibt ein einzelnes To-Do-Element näher
 * 
 * 
 */

public class ToDoElement {

    private String name;
    private String beschreibung;
    private Date datum;
    private Date uhrzeit;
    private int priorität;

    public ToDoElement(String name, String beschreibung, Date datum, Date uhrzeit, int priorität) {
        this.name = name;
        this.beschreibung = beschreibung;
        this.datum = datum;
        this.uhrzeit = uhrzeit;
        this.priorität = priorität;

    }

    public void setDate(int year, int month, int day) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
        String dateInString = year + "-" + month + "-" + day;
        try {
            datum = format.parse(dateInString);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM dd HH:mm:ss");
        Calendar calendar = new GregorianCalendar(2013, 0, 31);
        System.out.println(sdf.format(calendar.toString()));
    }

    public String getName() {
        return name;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public Date getDatum() {
        return datum;
    }

    public Date getUhrzeit() {
        return uhrzeit;
    }

    public int getPriorität() {
        return priorität;
    }

}