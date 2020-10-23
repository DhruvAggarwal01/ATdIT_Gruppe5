package subpanels;


import javax.swing.JButton;


public class TaskButton extends JButton {
    //private int id;
    private String name;
    private String date;
    private String description;
    private String time;
    private String priority;
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public TaskButton( String name,String description, String date, String time, String priority) {
        this.setText(name);
        //this.setBackground(createColour());
        //this.id = id;
        this.name = name;
        this.date = date;
        this.description = description;
        this.time = time;
        this.priority = priority;
    }

    /* public int getId() {
        return this.id;
    } */

   /*  public Color createColour(){
        float red = Math.random();
        float green = Math.random();
        float blue = Math.random();
        return (new Color(red, green, blue));
    } */

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.setText(name);
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
