package subpanels;

public class Tasks {
    private int id;
    private String name;
    private String date;
    private String description;
    private String time;
    private String priority;

   

    public Tasks(int id, String name, String date, String description, String time, String priority){
        this.id = id;
        this.name = name;
        this.date = date;
        this.description = description;
        this.time = time;
        this.priority = priority;
    }

    /* ----------------------- Getter/Setter-Methoden --------------------------- */
    
    public int getId() {
        return this.id;
    }
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
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
