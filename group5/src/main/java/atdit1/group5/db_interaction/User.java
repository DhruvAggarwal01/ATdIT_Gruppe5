package atdit1.group5.db_interaction;

import java.util.Objects;

/**
 * dient dem Aufbau eines Benutzernamens und im Besonderen seiner Attribute.
 * 
 * @author Sophie Orth, Monica Alessi, Dhruv Aggarwal, Maik Fichtenkamm, Lucas
 *         Lahr
 */
public class User {

    public int personnel_id = 0;
    public String username = "";
    public String forename = "";
    public String surname = "";
    public String street_nr = "";
    public int zip = 00000;
    public String city = "";
    public String email = "..._...@....";
    public String password = "**********";
    public int role_id = 1;
    public boolean isLoggedIn = false;

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "{" + "personnel_id: " + personnel_id + " ; username: " + username + " ; forename: " + forename
                + " ; surname: " + surname + " ; street_nr: " + street_nr + " ; zip: " + zip + " ; city: " + city
                + " ; email: " + email + " ; password: " + password + " ; role_id: " + role_id + " ; isLoggedIn: "
                + isLoggedIn + "}";
    }

    /* -------------- Overriding zum möglichen Vergleich zweier User ------------ */
    /**
     * {@inheritDoc}
     * 
     * @param obj
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User user = (User) obj;
        return Objects.equals(personnel_id, user.personnel_id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() { // wird
        return Objects.hash(personnel_id);
    }

    /**
     * Getter-Methode für die Personal-Id
     * 
     * @return Personal-Id
     */
    public int getPersonnel_id() {
        return this.personnel_id;
    }

    /**
     * Setter-Methode für die Personal-Id
     * 
     * @param personnel_id Personal-Id
     */
    public void setPersonnel_id(int personnel_id) {
        this.personnel_id = personnel_id;
    }

    /**
     * Getter-Methode für den Benutzernamen
     * 
     * @return Benutzername
     */
    public String getUsername() {
        return this.username;
    }

    /**
     * Setter-Methode für den Benutzernamen
     * 
     * @param username Benutzername
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Getter-Methode für den Vornamen
     * 
     * @return Vorname
     */
    public String getForename() {
        return this.forename;
    }

    /**
     * Setter-Methode für den Vornamen
     * 
     * @param forename Vorname
     */
    public void setForename(String forename) {
        this.forename = forename;
    }

    /**
     * Getter-Methode für den Nachnamen
     * 
     * @return Nachname
     */
    public String getSurname() {
        return this.surname;
    }

    /**
     * Setter-Methode für den Nachnamen
     * 
     * @param surname Nachname
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * Getter-Methode für Straße+Hausnummer
     * 
     * @return Straße+Hausnummer
     */
    public String getStreet_nr() {
        return this.street_nr;
    }

    /**
     * Setter-Methode für Straße+Hausnummer
     * 
     * @param street_nr Straße+Hausnummer
     */
    public void setStreet_nr(String street_nr) {
        this.street_nr = street_nr;
    }

    /**
     * Getter-Methode für die Postleitzahl
     * 
     * @return Postleitzahl
     */
    public int getZip() {
        return this.zip;
    }

    /**
     * Setter-Methode für die Postleitzahl
     * 
     * @param zip Postleitzahl
     */
    public void setZip(int zip) {
        this.zip = zip;
    }

    /**
     * Getter-Methode für die Stadt
     * 
     * @return Stadt
     */
    public String getCity() {
        return this.city;
    }

    /**
     * Setter-Methode für die Stadt
     * 
     * @param city Stadt
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Getter-Methode für die Email-Adresse
     * 
     * @return Email-Adresse
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * Setter-Methode für die Email-Adresse
     * 
     * @param email Email-Adresse
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Getter-Methode für das Passwort
     * 
     * @return Passwort
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * Setter-Methode für das Passwort
     * 
     * @param password Passwort
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Getter-Methode für die Rollen-Id
     * 
     * @return Rollen-Id
     */
    public int getRole_id() {
        return this.role_id;
    }

    /**
     * Setter-Methode für die Rollen-Id
     * 
     * @param role_id Rollen-Id
     */
    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    /**
     * Getter-Methode für den LoggedIn-Status
     * 
     * @return LoggedIn-Status
     */
    public boolean getIsLoggedIn() {
        return this.isLoggedIn;
    }

    /**
     * Setter-Methode für den LoggedIn-Status
     * 
     * @param isLoggedIn LoggedIn-Status
     */
    public void setIsLoggedIn(boolean isLoggedIn) {
        this.isLoggedIn = isLoggedIn;
    }

}