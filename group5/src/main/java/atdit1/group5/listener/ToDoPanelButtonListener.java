package atdit1.group5.listener;

import java.awt.event.*;

import atdit1.group5.panels.ToDoPanel;
import atdit1.group5.dialogs.NewTask;
import atdit1.group5.subpanels.TaskButton;

/**
 * implementiert das Interface ActionListener und stellt ein Listener für die
 * Buttons vom ToDoPanel dar.
 * 
 * @author Sophie Orth, Monica Alessi, Dhruv Aggarwal, Maik Fichtenkamm, Lucas
 *         Lahr
 */
public class ToDoPanelButtonListener implements ActionListener {

    private ToDoPanel panel;

    /**
     * erzeugt den Listener und initialisiert dessen Werte.
     * 
     * @param panel
     */
    public ToDoPanelButtonListener(ToDoPanel panel) {
        this.panel = panel;
    }

    /**
     * Invoked when an action occurs. Wenn der Button "neue Aufgabe" gedrückt wird,
     * wird eine noch nicht existierende Aufgabe erzeugt durch NewTask(panel, this).
     * Wenn auf eine bereits existierende Aufgabe gedrückt wird, wird auch der
     * bereits existierende TaskButton mitgegeben.
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
