package db_interaction;

import java.util.Objects;

public class User {

    private int personnel_id = 0;
    private String username = "";
    private String forename = "";
    private String surname = "";
    private String street_nr = "";
    private int zip = 00000;
    private String city = "";
    private String email = "..._...@....";
    private String password = "**********";
    private int role_id = 1;
    private boolean isLoggedIn = false;

    @Override
    public String toString() {
        return "{" + "personnel_id: " + personnel_id + " ; username: " + username + " ; forename: " + forename
                + " ; surname: " + surname + " ; street_nr: " + street_nr + " ; zip: " + zip + " ; city: " + city
                + " ; email: " + email + " ; password: " + password + " ; role_id: " + role_id + " ; isLoggedIn: "
                + isLoggedIn + "}";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(final Object obj) {
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
        return Objects.equals(personnel_id, user.personnel_id) && Objects.equals(username, user.username)
                && Objects.equals(forename, user.forename) && Objects.equals(surname, user.surname)
                && Objects.equals(street_nr, user.street_nr) && Objects.equals(zip, user.zip)
                && Objects.equals(city, user.city) && Objects.equals(email, user.email)
                && Objects.equals(password, user.password) && Objects.equals(role_id, user.role_id)
                && Objects.equals(isLoggedIn, user.isLoggedIn);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() { // wird
        return Objects.hash(personnel_id, username, forename, surname, street_nr, zip, city, email, password, role_id,
                isLoggedIn);
    }

    public int getPersonnel_id() {
        return this.personnel_id;
    }

    public void setPersonnel_id(int personnel_id) {
        this.personnel_id = personnel_id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public int getZip() {
        return this.zip;
    }

    public void setZip(int zip) {
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

    public boolean isIsLoggedIn() {
        return this.isLoggedIn;
    }

    public void setIsLoggedIn(boolean isLoggedIn) {
        this.isLoggedIn = isLoggedIn;
    }

}