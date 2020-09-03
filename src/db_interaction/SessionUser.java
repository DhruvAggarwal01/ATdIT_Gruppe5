package db_interaction;

/**
 * Diese Klasse überprüft die Eingabe im Welcome-Screen
 * {@link src.WelcomeScreen} und extrahiert bei erfolgreichen LogIn-Eingaben die
 * zugehörigen User-Daten aus der Excel-Datenbank. +Ausloggen
 * 
 * @author Sophie Orth, Monica Alessi, Dhruv Aggarwal, Maik Fichtenkamm, Lucas
 *         Lahr
 */
public class SessionUser extends User {     //OBSOLETE KLASSE WIRD GELÖSCHT

    public static int personnel_id = 0;
    public static String username = "";
    public static String forename = "";
    public static String surname = "";
    public static String street_nr = "";
    public static int zip = 00000;
    public static String city = "";
    public static String email = "..._...@....";
    public static String password = "**********";
    public static int role_id = 1;
    public static boolean isLoggedIn = false;

    /**
     * Konstruktor, zum Erstellen einer Instanz des eingeloggten Users
     *
     */
    // SessionUser() {
    // }
    // SessionUser(int p_personnel_id, String p_username, String p_forename, String
    // p_surname, String p_street_nr,
    // int p_zip, String p_city, String p_email, String p_password, int p_role_id,
    // boolean p_isLoggedIn) {
    // super(p_personnel_id, p_username, p_forename, p_surname, p_street_nr, p_zip,
    // p_city, p_email, p_password,
    // p_role_id, p_isLoggedIn);

}