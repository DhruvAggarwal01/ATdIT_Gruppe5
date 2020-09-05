package main;

import java.awt.Color;
import java.awt.Font;

/**
 * Diese Klasse bietet einen zentralen Zugriffspunkt für diverse, einsetzbaren
 * Style-Komponenten (z.B. Fonts, Farben, ...).
 * 
 * @author Sophie Orth, Monica Alessi, Dhruv Aggarwal, Maik Fichtenkamm, Lucas
 *         Lahr
 */
public class Styles {

    /*
     * // ------ Styles for main surrounding panels ------\\
     */

    /**
     * 
     */
    public final static Color SURROUNDING_PANEL_COLOR = new Color(110, 187, 255);

    /**
     * Einsatzmöglichkeit: Font für Anwendungstitel
     * 
     */
    public final static Font APPHEADING = new Font("Rockwell Extra Bold", Font.BOLD, 26);

    /**
     * Einsatzmöglichkeit: Font für Navigationsleisten-Elemente
     */
    public final static Font NAVPANE_FONT = new Font("Rockwell", Font.BOLD, 20);

    /**
     * Einsatzmöglichkeit: Font für
     */
    public final static Font TAB_BORDERTITLE_FONT = new Font("Rockwell", Font.BOLD, 18);

    /*
     * ------ Styles for center panels ------\\
     */

    /**
     * Einsatzmöglichkeit: Font für
     */
    public final static Font SUBPANEL_TITLE_FONT = new Font("Calibri Light", Font.BOLD, 14);

    /**
     * Einsatzmöglichkeit: Font für
     */
    public final static Font SUBPANEL_TEXTCOMPONENT_FONT = new Font("Calibri", Font.PLAIN, 12);

    /*
     * // ------ Styles for user menu-dialogs ------\\
     */

    /**
     * Einsatzmöglichkeit: Font für
     */
    public final static Font PROFILE_LVL1_FONT = new Font("Calibri Light", Font.BOLD, 18);

    /**
     * Einsatzmöglichkeit: Font für
     */
    public final static Font PROFILE_LVL2_FONT = new Font("Calibri Light", Font.BOLD, 16);

    /**
     * Einsatzmöglichkeit: Font für
     */
    public final static Font PROFILE_LVL3_FONT = new Font("Calibri", Font.PLAIN, 12);

    /**
     * Einsatzmöglichkeit: Font für
     */
    public final static Font RSSC_BUTTON_FONT = new Font("Calibri", Font.BOLD, 14);

    /**
     * Einsatzmöglichkeit: Font für Fehlermdelungen
     */
    public final static Font ERROR_MSG_FONT = new Font("Calibri", Font.BOLD, 12);

}