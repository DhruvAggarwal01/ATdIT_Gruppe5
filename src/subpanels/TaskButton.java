package subpanels;

import javax.swing.JButton;

/**
 * tbd
 * 
 * @author Sophie Orth, Monica Alessi, Dhruv Aggarwal, Maik Fichtenkamm, Lucas
 *         Lahr
 */
public class TaskButton extends JButton {

    private static final long serialVersionUID = -4637132117972382295L;

    // private int id;
    private String name;
    private String date;
    private String description;
    private String time;
    private String priority;

    /**
     * tbd
     * 
     * @param name
     * @param description
     * @param date
     * @param time
     * @param priority
     */
    public TaskButton(String name, String description, String date, String time, String priority) {
        this.setText(name);
        // this.setBackground(createColour());
        // this.id = id;
        this.name = name;
        this.date = date;
        this.description = description;
        this.time = time;
        this.priority = priority;
    }

    /*
     * public int getId() { return this.id; }
     */

    /*
     * public Color createColour(){ float red = Math.random(); float green =
     * Math.random(); float blue = Math.random(); return (new Color(red, green,
     * blue)); }
     */

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
    public String getDate() {
        return this.date;
    }

    /**
     * Setter-Methode für den Datum
     * 
     * @param date Datum
     */
    public void setDate(String date) {
        this.date = date;
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
    public String getTime() {
        return this.time;
    }

    /**
     * Setter-Methode für die Zeit
     * 
     * @param time Zeit
     */
    public void setTime(String time) {
        this.time = time;
    }

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
