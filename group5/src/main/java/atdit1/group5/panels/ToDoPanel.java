package atdit1.group5.panels;

import java.awt.*;
import javax.swing.*;
import java.util.ResourceBundle;

import atdit1.group5.listener.ToDoPanelButtonListener;

/**
 * bildet die To-Do-Verwaltung der Steinbruch Software ab.
 * 
 * @author Sophie Orth, Monica Alessi, Dhruv Aggarwal, Maik Fichtenkamm, Lucas
 *         Lahr
 */
public class ToDoPanel extends JPanel {

    private static final long serialVersionUID = -1436022192721531424L;
    private ResourceBundle text;
    private JPanel taskList;
    private JPanel buttonPanel;
    private JButton newTaskButton;

    /**
     * bietet ein <code>JPanel</code>, welches alle aktiven To-Do-ELemente in Form
     * von <code>JCheckBox</code>en fassen soll und die Buttons
     * <code>Neue Aufgabe</code> und <code>Aufgabe bearbeiten</code>, welche ein
     * neues To-Do-Element erstellen oder ein bestehendes bearbeiten.
     */
    public ToDoPanel() {
        this.setLayout(new BorderLayout());
        this.text = ResourceBundle.getBundle(("i18n/todoStrings"));

        taskList = new JPanel(new GridLayout(0, 1, 10, 10));
        buttonPanel = new JPanel();

        newTaskButton = new JButton(text.getString("newTaskString"));
        newTaskButton.setPreferredSize(new Dimension(300, 100));
        buttonPanel.add(newTaskButton);

        ToDoPanelButtonListener listenerNewTask = new ToDoPanelButtonListener(this);
        newTaskButton.addActionListener(listenerNewTask);

        this.add(taskList, BorderLayout.CENTER);
        this.add(buttonPanel, BorderLayout.SOUTH);
    }

    /**
     * Getter-Methode für das Panel für die Aufgabenliste
     * 
     * @return Panel für die Aufgabenliste
     */
    public JPanel getTaskList() {
        return taskList;
    }

}