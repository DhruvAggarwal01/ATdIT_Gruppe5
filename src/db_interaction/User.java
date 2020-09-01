package db_interaction;

public class User {

    int personnel_id;
    String username;
    String forename;
    String surname;
    String street_nr;
    int zip;
    String city;
    String email;
    String password;
    int role_id;
    boolean isLoggedIn; // immer syncen mit Excel-DB (im Hinblick auf ausloggen)

    /**
     * Konstruktor, zum Erstellen einer User-Instanz
     *
     * @param personnel_id
     * @param username
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
    User(int personnel_id, String username, String forename, String surname, String street_nr, String zip, int city,
            String email, String password, int role_id, boolean isLoggedIn) {

    }

    // public int getPersonnel_id() {
    // return this.personnel_id;
    // }

    // public void setPersonnel_id(int personnel_id) {
    // this.personnel_id = personnel_id;
    // }

    // public String getUsername() {
    // return this.username;
    // }

    // public void setUsername(String username) {
    // this.username = username;
    // }

    // public String getForename() {
    // return this.forename;
    // }

    // public void setForename(String forename) {
    // this.forename = forename;
    // }

    // public String getSurname() {
    // return this.surname;
    // }

    // public void setSurname(String surname) {
    // this.surname = surname;
    // }

    // public String getStreet_nr() {
    // return this.street_nr;
    // }

    // public void setStreet_nr(String street_nr) {
    // this.street_nr = street_nr;
    // }

    // public String getZip() {
    // return this.zip;
    // }

    // public void setZip(int zip) {
    // this.zip = zip;
    // }

    // public int getCity() {
    // return this.city;
    // }

    // public void setCity(String city) {
    // this.city = city;
    // }

    // public String getEmail() {
    // return this.email;
    // }

    // public void setEmail(String email) {
    // this.email = email;
    // }

    // public String getPassword() {
    // return this.password;
    // }

    // public void setPassword(String password) {
    // this.password = password;
    // }

    // public int getRole_id() {
    // return this.role_id;
    // }

    // public void setRole_id(int role_id) {
    // this.role_id = role_id;
    // }

    // public boolean getIsLoggedIn() {
    // return this.isLoggedIn;
    // }

    // public void setIsLoggedIn(boolean isLoggedIn) {
    // this.isLoggedIn = isLoggedIn;
    // }

    @Override
    public String toString() {
        return "{" + "personnel_id: " + personnel_id + " ; username: " + username + " ; forename: " + forename
                + " ; surname: " + surname + " ; street_nr: " + street_nr + " ; zip: " + zip + " ; city: " + city
                + " ; email: " + email + " ; password: " + password + " ; role_id: " + role_id + " ; isLoggedIn: "
                + isLoggedIn + "}";
    }
}