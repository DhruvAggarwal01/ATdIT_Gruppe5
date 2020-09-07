package db_interaction;

/**
 * Diese Klasse überprüft die Eingabe im Welcome-Screen
 * {@link src.WelcomeScreen} und extrahiert bei erfolgreichen LogIn-Eingaben die
 * zugehörigen User-Daten aus der Excel-Datenbank. +Ausloggen
 * 
 * @author Sophie Orth, Monica Alessi, Dhruv Aggarwal, Maik Fichtenkamm, Lucas
 *         Lahr
 */
public class SessionUser extends User {

    /**
     * Konstruktor, zum Erstellen einer Instanz des eingeloggten Users
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
    SessionUser(int personnel_id, String username, String forename, String surname, String street_nr, String zip,
            String city, String email, String password, int role_id, boolean isLoggedIn) {
        super(personnel_id, username, forename, surname, street_nr, zip, city, email, password, role_id, isLoggedIn);
    }
}