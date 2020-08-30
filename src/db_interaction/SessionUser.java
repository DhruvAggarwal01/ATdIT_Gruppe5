package db_interaction;

// import org.apache.poi.*;
// import javax.swing.*;
// import java.awt.*;
// import java.io.*;

/**
 * Diese Klasse überprüft die Eingabe im Welcome-Screen
 * {@link src.WelcomeScreen} und extrahiert bei erfolgreichen LogIn-Eingaben die
 * zugehörigen User-Daten aus der Excel-Datenbank. +Ausloggen
 * 
 * @author Sophie Orth, Monica Alessi, Dhruv Aggarwal, Maik Fichtenkamm, Lucas
 *         Lahr
 */
public class SessionUser {

    private int personnel_id;
    private String forename;
    private String surname;
    private String street_nr;
    private String zip;
    private String city;
    private String email;
    private String password;
    private int role_id;
    private boolean isLoggedIn; // immer syncen mit Excel-DB (im Hinblick auf ausloggen)

    /**
     * Konstruktor, zum Erstellen einer Instanz des eingeloggten Users
     *
     * @param personnel_id
     * @param forename
     * @param surname
     * @param street_nr
     * @param zip
     * @param city
     * @param email
     * @param password
     * @param role_id
     * @param isLoggedIn
     */
    SessionUser(int personnel_id, String forename, String surname, String street_nr, String zip, String city,
            String email, String password, int role_id, boolean isLoggedIn) {

        
    }

    public int getPersonnel_id() {
        return this.personnel_id;
    }

    public void setPersonnel_id(int personnel_id) {
        this.personnel_id = personnel_id;
    }

    public String getForename() {
        return this.forename;
    }

    public void setForename(String forename) {
        this.forename = forename;
    }

    public String getSurname() {
        return this.surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getStreet_nr() {
        return this.street_nr;
    }

    public void setStreet_nr(String street_nr) {
        this.street_nr = street_nr;
    }

    public String getZip() {
        return this.zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole_id() {
        return this.role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public boolean getIsLoggedIn() {
        return this.isLoggedIn;
    }

    public void setIsLoggedIn(boolean isLoggedIn) {
        this.isLoggedIn = isLoggedIn;
    }

}