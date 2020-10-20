package subpanels;

import javax.swing.JButton;

public class TaskButton extends JButton {
    private int id;
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    
    public TaskButton(int id, String name){
        super(name);
        this.id = id;
    }

    public int getId(){
        return id;
    }
}
