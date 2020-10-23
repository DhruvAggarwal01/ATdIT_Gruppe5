package main;

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
  public final static java.awt.Color SURROUNDING_PANEL_COLOR = new java.awt.Color(110, 187, 255);

  /**
   * Einsatzmöglichkeit: Font für Anwendungstitel
   */
  public final static java.awt.Font APPHEADING = new java.awt.Font("Rockwell Extra Bold", java.awt.Font.BOLD, 26);

  /**
   * Einsatzmöglichkeit: Font für Navigationsleisten-Elemente
   */
  public final static java.awt.Font NAVPANE_FONT = new java.awt.Font("Rockwell", java.awt.Font.BOLD, 20);

  /**
   * Einsatzmöglichkeit: Font für TitledBorder-Titel
   */
  public final static java.awt.Font TAB_BORDERTITLE_FONT = new java.awt.Font("Rockwell", java.awt.Font.BOLD, 18);

  /* --------------------- Styles für zentrale Panels ------------------------- */
  /**
   * Einsatzmöglichkeit: Font für Subpanel-Titel
   */
  public final static java.awt.Font SUBPANEL_TITLE_FONT = new java.awt.Font("Calibri Light", java.awt.Font.BOLD, 14);

  /**
   * Einsatzmöglichkeit2: Font für Subpanel-Titel
   */
  public final static java.awt.Font SUBPANEL_TITLE_FONT2 = new java.awt.Font("Calibri Light", java.awt.Font.BOLD, 22);

  /**
   * Einsatzmöglichkeit: Font für Subpanel-Textinhalt
   */
  public final static java.awt.Font SUBPANEL_TEXTCOMPONENT_FONT = new java.awt.Font("Calibri", java.awt.Font.PLAIN, 12);

  /* --------------------- Styles für Usermenu-Dialogs ------------------------ */
  /**
   * Einsatzmöglichkeit: Font für Profildialog-Haupttitel (Lvl. 1)
   */
  public final static java.awt.Font PROFILE_LVL1_FONT = new java.awt.Font("Calibri Light", java.awt.Font.BOLD, 18);

  /**
   * Einsatzmöglichkeit: Font für Profildialog-Subtitel (Lvl. 2)
   */
  public final static java.awt.Font PROFILE_LVL2_FONT = new java.awt.Font("Calibri Light", java.awt.Font.BOLD, 16);

  /**
   * Einsatzmöglichkeit: Font für Profildialog-Labeltext (Lvl. 3)
   */
  public final static java.awt.Font PROFILE_LVL3_FONT = new java.awt.Font("Calibri", java.awt.Font.PLAIN, 12);

  /**
   * Einsatzmöglichkeit: Font für Bestätigungsbuttons
   */
  public final static java.awt.Font RSSC_BUTTON_FONT = new java.awt.Font("Calibri", java.awt.Font.BOLD, 14);

  /**
   * Einsatzmöglichkeit: Font für Bestätigungsbuttons
   */
  public final static java.awt.Font ORDER_INFO = new java.awt.Font("Calibri", java.awt.Font.BOLD, 20);

  /**
   * Einsatzmöglichkeit: Font für Bestätigungsbuttons
   */
  public final static java.awt.Font ORDER_INFO_HEAD = new java.awt.Font("Calibri", java.awt.Font.BOLD, 24);

  /**
   * Einsatzmöglichkeit: Font für Fehlermeldungen
   */
  public final static java.awt.Font ERROR_MSG_FONT = new java.awt.Font("Calibri", java.awt.Font.BOLD, 12);

  /**
   * Einsatzmöglichkeit: Font für Fehlermeldungen
   */
  public final static java.awt.Font ERROR_STACKTRACE_FONT = new java.awt.Font("Calibri", java.awt.Font.PLAIN, 12);
}
