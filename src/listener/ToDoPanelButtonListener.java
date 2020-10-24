package listener;

import java.awt.event.*;

import panels.ToDoPanel;
import dialogs.NewTask;
import subpanels.TaskButton;

/**
 * Klasse, die das Interface ActionListener implementiert und ein Listener
 * darstellt für die Buttons vom ToDoPanel
 */
public class ToDoPanelButtonListener implements ActionListener {

    private ToDoPanel panel;

    /**
     * Konstruktor, der den Listener erzeugt und dessen Werte initialisiert
     */
    public ToDoPanelButtonListener(ToDoPanel panel) {
        this.panel = panel;
    }

    /**
     *  Invoked when an action occurs.
     *  Wenn der Button "neue Aufgabe" gedrückt wird, wird eine noch nicht existierende Aufgabe erzeugt durch NewTask(panel, this).
     *  Wenn auf eine bereits existierende Aufgabe gedrückt wird, wird auch der bereits existierende TaskButton mitgegeben. 
     */
    public void actionPerformed(ActionEvent e) {

        if (e.getSource().getClass().getName().equals("javax.swing.JButton")) {
            new NewTask(panel, this);

        } else {
            TaskButton b = (TaskButton) e.getSource();
            new NewTask(panel, this, b);
        }

    }
}
