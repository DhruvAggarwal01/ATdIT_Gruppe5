package db_interaction;

public class User {

    public static int personnel_id;
    public static String username;
    public static String forename;
    public static String surname;
    public static String street_nr;
    public static int zip;
    public static String city;
    public static String email;
    public static String password;
    public static int role_id;
    public static boolean isLoggedIn; // immer syncen mit Excel-DB (im Hinblick auf ausloggen)

    /**
     * Konstruktor, zum Erstellen einer User-Instanz
     *
     * 
     */
    User() {
        // personnel_id = p_personnel_id;
        // username = p_username;
        // forename = p_forename;
        // surname = p_surname;
        // street_nr = p_street_nr;
        // zip = p_zip;
        // city = p_city;
        // email = p_email;
        // password = p_password;
        // role_id = p_role_id;
        // isLoggedIn = p_isLoggedIn;
    }

    @Override
    public String toString() {
        return "{" + "personnel_id: " + personnel_id + " ; username: " + username + " ; forename: " + forename
                + " ; surname: " + surname + " ; street_nr: " + street_nr + " ; zip: " + zip + " ; city: " + city
                + " ; email: " + email + " ; password: " + password + " ; role_id: " + role_id + " ; isLoggedIn: "
                + isLoggedIn + "}";
    }
}