package main;

import java.awt.*;

/**
 * Diese Klasse bietet einen zentralen Zugriffspunkt für diverse, einsetzbaren
 * Style-Komponenten (z.B. Fonts, Farben, ...).
 * 
 * @author Sophie Orth, Monica Alessi, Dhruv Aggarwal, Maik Fichtenkamm, Lucas
 *         Lahr
 */
public class Styles {

  /* ----------------------- Styles für Hauptpanel ---------------------------- */
  /**
   * Einsatzmöglichkeit: Color für umgebendes Panel
   */
  public final static Color SURROUNDING_PANEL_COLOR = new Color(110, 187, 255);

  /**
   * Einsatzmöglichkeit: Font für Anwendungstitel
   */
  public final static Font APPHEADING = new Font("Rockwell Extra Bold", Font.BOLD, 26);

  /**
   * Einsatzmöglichkeit: Font für Navigationsleisten-Elemente
   */
  public final static Font NAVPANE_FONT = new Font("Rockwell", Font.BOLD, 20);

  /**
   * Einsatzmöglichkeit: Font für TitledBorder-Titel
   */
  public final static Font TAB_BORDERTITLE_FONT = new Font("Rockwell", Font.BOLD, 18);

  /* --------------------- Styles für zentrale Panels ------------------------- */
  /**
   * Einsatzmöglichkeit: Font für Subpanel-Titel
   */
  public final static Font SUBPANEL_TITLE_FONT = new Font("Calibri Light", Font.BOLD, 14);

  /**
   * Einsatzmöglichkeit2: Font für Subpanel-Titel
   */
  public final static Font SUBPANEL_TITLE_FONT2 = new Font("Calibri Light", Font.BOLD, 22);

  /**
   * Einsatzmöglichkeit: Font für Subpanel-Textinhalt
   */
  public final static Font SUBPANEL_TEXTCOMPONENT_FONT = new Font("Calibri", Font.PLAIN, 12);

  /* --------------------- Styles für Usermenu-Dialogs ------------------------ */
  /**
   * Einsatzmöglichkeit: Font für Profildialog-Haupttitel (Lvl. 1)
   */
  public final static Font PROFILE_LVL1_FONT = new Font("Calibri Light", Font.BOLD, 18);

  /**
   * Einsatzmöglichkeit: Font für Profildialog-Subtitel (Lvl. 2)
   */
  public final static Font PROFILE_LVL2_FONT = new Font("Calibri Light", Font.BOLD, 16);

  /**
   * Einsatzmöglichkeit: Font für Profildialog-Labeltext (Lvl. 3)
   */
  public final static Font PROFILE_LVL3_FONT = new Font("Calibri", Font.PLAIN, 12);

  /**
   * Einsatzmöglichkeit: Font für Bestätigungsbuttons
   */
  public final static Font RSSC_BUTTON_FONT = new Font("Calibri", Font.BOLD, 14);

  /**
   * Einsatzmöglichkeit: Font für Bestätigungsbuttons
   */
  public final static Font ORDER_INFO = new Font("Calibri", Font.BOLD, 20);

  /**
   * Einsatzmöglichkeit: Font für Bestätigungsbuttons
   */
  public final static Font ORDER_INFO_HEAD = new Font("Calibri", Font.BOLD, 24);
  /**
   * Einsatzmöglichkeit: Font für Fehlermdelungen
   */
  public final static Font ERROR_MSG_FONT = new Font("Calibri", Font.BOLD, 12);

}
