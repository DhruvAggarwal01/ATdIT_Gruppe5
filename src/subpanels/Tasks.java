package subpanels;

public class Tasks {
    private String name;
    private String date;
    private String description;
    private String time;
    private String priority;

   

    public Tasks(String name, String date, String description, String time, String priority){
        this.name = name;
        this.date = date;
        this.description = description;
        this.time = time;
        this.priority = priority;
    }

    /* ----------------------- Getter/Setter-Methoden --------------------------- */
    
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
