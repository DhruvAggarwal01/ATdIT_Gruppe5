package listener;

import javax.swing.*;

import panels.ToDoPanel;

import java.awt.*;
import java.awt.event.*;
import subpanels.NeueAufgabe;
import subpanels.TaskButton;
import subpanels.Tasks;

public class NewTaskListener implements ActionListener {
    private NeueAufgabe dialog;
    private ToDoPanel toDoPanel;
    private String name;
    private String beschreibung;
    private String datum;
    private String uhrzeit;
    private String priorität;
    private ToDoPanelButtonListener li;
    private static int id = 0;


    public NewTaskListener(NeueAufgabe dialog, String name, String beschreibung, String datum, String uhrzeit, String priorität, ToDoPanelButtonListener li, ToDoPanel toDoPanel){
        this.dialog = dialog;
        this.name = name;
        this.beschreibung = beschreibung;
        this.datum = datum;
        this.uhrzeit = uhrzeit;
        this.priorität = priorität;
        this.li = li;
        this.toDoPanel = toDoPanel;

    }
    public void actionPerformed(ActionEvent e) {
        
        Tasks t = new Tasks(++id, name, beschreibung, datum, uhrzeit, priorität);
        toDoPanel.getTask_list().add(t);
        TaskButton task = new TaskButton(id, t.getName());
        task.addActionListener(li);
        toDoPanel.getAufgabenListe().add(task);
        toDoPanel.getAufgabenListe().revalidate();
        dialog.dispose();
    }
}
