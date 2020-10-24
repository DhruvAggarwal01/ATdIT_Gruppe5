package subpanels;

import java.util.Random;
import java.awt.Color;
import javax.swing.JButton;

/**
 * Klasse, die die Buttons mit den Aufgaben für das ToDo-Panel darstellt.
 */
public class TaskButton extends JButton {

    private String name;
    private String date;
    private String description;
    private String time;
    private String priority;
    private static final long serialVersionUID = 1L;

    /**
     * Konstruktor, der einen TaskButton erzeugt und dessen Variabeln initialisiert
     * 
     * @param name        Name der Aufgabe
     * @param description Beschreibung der Aufgabe
     * @param date        Datum der Aufgabe
     * @param time        Zeit der Aufgabe
     * @param priority    Priorität der Aufgabe
     */
    public TaskButton(String name, String description, String date, String time, String priority) {
        this.setText(name + "   Priorität: " + priority);
        this.setBackground(createColour());
        this.name = name;
        this.date = date;
        this.description = description;
        this.time = time;
        this.priority = priority;
    }

    /**
     * Methode, der eine zufällige Color für den Hintergrund der TaskButtons
     * erzeugt. Diese Color soll jedoch hell sein, wodurch man die Schrift auf dem
     * Button noch lesen kann.
     * 
     * @return Color: die zufällige Farbe für den Hintergrund des TaskButton
     */
    public Color createColour() {
        Random r = new Random();
        int rgb = Color.HSBtoRGB(r.nextFloat(), r.nextFloat(), 0.5f + r.nextFloat() / 2f);
        return (new Color(rgb));
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.setText(name + "   Priorität: " + priority);
        this.name = name;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTime() {
        return this.time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPriority() {
        return this.priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }
}
