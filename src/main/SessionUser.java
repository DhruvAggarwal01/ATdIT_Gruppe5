package main;

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

    boolean isLoggedIn;         //immer syncen mit Excel-DB (im Hinblick auf ausloggen)

    /**
     * Konstruktor,
     * 
     * @param benutzerName
     * @param passWord
     */
    SessionUser(String benutzerName, String passWord) {
        // FileInputStream file = new FileInputStream(new File("test.xlsx"));
        // Workbook workbook = new XSSFWorkbook(file);

        // Sheet sheet = workbook.getSheetAt(0);
    }

}