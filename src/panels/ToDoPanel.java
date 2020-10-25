package panels;

import java.awt.*;
import javax.swing.*;

import listener.ToDoPanelButtonListener;

/**
 * bildet die To-Do-Verwaltung der Steinbruch Software ab.
 * 
 * @author Sophie Orth, Monica Alessi, Dhruv Aggarwal, Maik Fichtenkamm, Lucas
 *         Lahr
 */
public class ToDoPanel extends JPanel {

    private static final long serialVersionUID = -1436022192721531424L;

    private JPanel taskList;
    private JPanel buttonPanel;
    private JButton newTask;

    /**
     * bietet ein <code>JPanel</code>, welches alle aktiven To-Do-ELemente in Form
     * von <code>JCheckBox</code>en fassen soll und die Buttons
     * <code>Neue Aufgabe</code> und <code>Aufgabe bearbeiten</code>, welche ein
     * neues To-Do-Element erstellen oder ein bestehendes bearbeiten.
     */
    public ToDoPanel() {
        this.setLayout(new BorderLayout());

        taskList = new JPanel(new GridLayout(0, 1, 10, 10));
        buttonPanel = new JPanel();

        newTask = new JButton("Neue Aufgabe");
        buttonPanel.add(newTask);

        ToDoPanelButtonListener listenerNewTask = new ToDoPanelButtonListener(this);
        newTask.addActionListener(listenerNewTask);

        this.add(taskList, BorderLayout.CENTER);
        this.add(buttonPanel, BorderLayout.SOUTH);
    }

    // tbd

    public JPanel getAufgabenListe() {
        return taskList;
    }

}