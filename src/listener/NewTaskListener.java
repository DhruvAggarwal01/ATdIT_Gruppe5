package listener;

import javax.swing.*;

import panels.ToDoPanel;

import java.awt.*;
import java.awt.event.*;
import subpanels.NewTask;
import subpanels.TaskButton;
import subpanels.Tasks;

public class NewTaskListener implements ActionListener {
    private NewTask dialog;
    private ToDoPanel toDoPanel;
    private String name;
    private String description;
    private String date;
    private String time;
    private String priority;
    private ToDoPanelButtonListener li;
    private static int id = 0;


    public NewTaskListener(NewTask dialog, String name, String description, String date, String time, String priority, ToDoPanelButtonListener li, ToDoPanel toDoPanel){
        this.dialog = dialog;
        this.name = name;
        this.description = description;
        this.date = date;
        this.time = time;
        this.priority = priority;
        this.li = li;
        this.toDoPanel = toDoPanel;

    }
    public void actionPerformed(ActionEvent e) {
        
        Tasks t = new Tasks(++id, name, description, date, time, priority);
        toDoPanel.getTask_list().add(t);
        TaskButton task = new TaskButton(id, t.getName());
        task.addActionListener(li);
        toDoPanel.getAufgabenListe().add(task);
        toDoPanel.getAufgabenListe().revalidate();
        dialog.dispose();
    }
}
