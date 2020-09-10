package db_interaction;

public class User {

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
    public static boolean isLoggedIn = false; // immer syncen mit Excel-DB (im Hinblick auf ausloggen)

}