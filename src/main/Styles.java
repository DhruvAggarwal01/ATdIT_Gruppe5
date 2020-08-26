package main;

import java.awt.Font;

/**
 * Diese Klasse bietet einen zentralen Zugriffspunkt für diverse, einsetzbaren
 * Style-Komponenten (z.B. Fonts, Farben, ...).
 * 
 * @author Sophie Orth, Monica Alessi, Dhruv Aggarwal, Maik Fichtenkamm, Lucas
 *         Lahr
 */
public class Styles {

    /**
     * Einsatzmöglichkeit: Font für Anwendungstitel
     * 
     */
    public final static Font APPHEADING = new Font("Arial", Font.BOLD, 36);

    /**
     * Einsatzmöglichkeit: Font für Navigationsleisten-Elemente
     */
    public final static Font NAVPANE_FONT = new Font("Arial", Font.BOLD, 24);

    /**
     * Einsatzmöglichkeit: Font für 
     */
    public final static Font TAB_BORDERTITLE_FONT = new Font("Arial", Font.BOLD, 18);

    /**
     * Einsatzmöglichkeit: Font für 
     */
    public final static Font SUBPANEL_TEXTCOMPONENT_FONT = new Font("Arial", Font.PLAIN, 12);
}