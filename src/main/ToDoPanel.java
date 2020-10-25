package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * bildet die To-Do-Verwaltung der Steinbruch Software ab.
 * 
 * @author Sophie Orth, Monica Alessi, Dhruv Aggarwal, Maik Fichtenkamm, Lucas
 *         Lahr
 */

public class ToDoPanel extends JFrame {

    private static final long serialVersionUID = -2490912819402618727L;

    private Container c;
    public JPanel taskList;
    public JButton newTask;
    public JButton taskEdit;

    /**
     * bietet ein <code>JPanel</code>, welches alle aktiven To-Do-Elemente in Form
     * von <code>JCheckBox</code>en fassen soll und die Buttons
     * <code>Neue Aufgabe</code> und <code>Aufgabe bearbeiten</code>, welche ein
     * neues To-Do-Element erstellen oder ein bestehendes bearbeiten. Die drei
     * Aufgaben dienen Demonstrationszwecken.
     */
    public ToDoPanel() {
        c = getContentPane();
        newTask = new JButton("Neue Aufgabe");
        taskEdit = new JButton("Aufgabe bearbeiten");
        taskList = new JPanel();
        JCheckBox task1 = new JCheckBox("Aufgabe 1");
        JCheckBox task2 = new JCheckBox("Aufgabe 2");
        JCheckBox task3 = new JCheckBox("Aufgabe 3");
        taskList.add(task1);
        taskList.add(task2);
        taskList.add(task3);
        c.add(taskList);
        c.add(newTask);
        c.add(taskEdit);
        ButtonListener listenernewTask = new ButtonListener();
        newTask.addActionListener(listenernewTask);
        ListenertaskEdit listenerBearbeiten = new ListenertaskEdit();
        taskEdit.addActionListener(listenerBearbeiten);

    }

    /**
     * tbd
     */
    class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // ToDoElement newElement = new ToDoElement();
        }
    }

    /**
     * tbd
     */
    class ListenertaskEdit implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // Selbes Fenster wie bei "Neue Aufgabe" geht auf, aber bisherigen Werte sind
            // schon darin enthalten
        }
    }

}