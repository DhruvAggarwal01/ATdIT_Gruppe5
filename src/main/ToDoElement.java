package main;

import java.util.Date;

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

    public ToDoElement(String name, String beschreibung, Date datum, Date uhrzeit, int priorität){
        this.name = name;
        this.beschreibung = beschreibung;
        this.datum = datum;
        this.uhrzeit = uhrzeit;
        this.priorität = priorität;
        
    }

    
}