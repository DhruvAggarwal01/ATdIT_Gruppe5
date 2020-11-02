package atdit1.group5.subpanels;

import javax.swing.JButton;

import com.github.lgooddatepicker.components.DateTimePicker;

import java.util.Random;
import java.util.ResourceBundle;
import java.awt.Color;

/**
 * Klasse, die die Buttons mit den Aufgaben für das ToDo-Panel darstellt.
 * 
 * @author Sophie Orth, Monica Alessi, Dhruv Aggarwal, Maik Fichtenkamm, Lucas
 *         Lahr
 */
public class TaskButton extends JButton {

    private static final long serialVersionUID = -4637132117972382295L;
    private ResourceBundle text;

    private String name;
    private DateTimePicker dateTimePicker;
    private String description;
    private String priority;

    /**
     * erzeugt einen TaskButton und initialisiert dessen Variablen.
     * 
     * @param name        Name der Aufgabe
     * @param description Beschreibung der Aufgabe
     * @param date        Datum der Aufgabe
     * @param time        Zeit der Aufgabe
     * @param priority    Priorität der Aufgabe
     */
    public TaskButton(String name, String description, DateTimePicker dateTimePicker, String priority) {
        this.text = ResourceBundle.getBundle(("i18n/todoStrings"));

        this.setText(name + text.getString("priorityString") + priority);
        this.setBackground(createColour());
        this.name = name;
        this.dateTimePicker = dateTimePicker;
        this.description = description;
        this.priority = priority;
    }

    /**
     * erzeugt eine zufällige Color für den Hintergrund der TaskButtons. Diese Color
     * soll jedoch hell sein, wodurch man die Schrift auf dem Button noch lesen
     * kann.
     * 
     * @return Color: die zufällige Farbe für den Hintergrund des TaskButton
     */
    public Color createColour() {
        Random r = new Random();
        int rgb = Color.HSBtoRGB(r.nextFloat(), r.nextFloat(), 0.5f + r.nextFloat() / 2f);
        return (new Color(rgb));
    }

    /**
     * Getter-Methode für den ToDo-Namen
     * 
     * @return ToDo-Name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Setter-Methode für den ToDo-Namen
     * 
     * @param name ToDo-Name
     */
    public void setName(String name) {
        this.setText(name);
        this.name = name;
    }

    /**
     * Getter-Methode für den Zurück-Button
     * 
     * @return Da-Button
     */
    public DateTimePicker getDateTimePicker() {
        return this.dateTimePicker;
    }

    /**
     * Setter-Methode für den Datum
     * 
     * @param date Datum
     */
    public void setDateTimePicker(DateTimePicker dateTimePicker) {
        this.dateTimePicker = dateTimePicker;
    }

    /**
     * Getter-Methode für die Beschreibung
     * 
     * @return Beschreibung
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Setter-Methode für die Beschreibung
     * 
     * @param description Beschreibung
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Getter-Methode für die Zeit
     * 
     * @return Zeit
     */

    /**
     * Getter-Methode für die Priorität
     * 
     * @return Priorität
     */
    public String getPriority() {
        return this.priority;
    }

    /**
     * Setter-Methode für die Priorität
     * 
     * @param priority Priorität
     */
    public void setPriority(String priority) {
        this.priority = priority;
    }

}
