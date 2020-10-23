package subpanels;

import java.awt.*;
import javax.swing.*;

import listener.NewTaskListener;
import listener.ToDoPanelButtonListener;
import panels.ToDoPanel;

/**
 * Diese Klasse legt fest wie neue Aufgaben angelegt werden.
 */

public class NewTask extends JDialog {
    // zu JDialog wechseln
    private static final long serialVersionUID = 1L;
    private TaskButton taskButton;
    private JPanel panel;
    private JLabel name, description, date, time, priority;
    private JTextField nameText, dateSet, timeSet;
    private JTextArea descriptionText;
    private JComboBox<String> prioritySet;
    private JButton addTaskButton;
    private ToDoPanel toDoPanel;

    String[] prioritäten = new String[] { "none", "low", "moderate", "high", "very high" };

    public NewTask(ToDoPanel toDoPanel, ToDoPanelButtonListener li) {
        this.toDoPanel = toDoPanel;
        this.taskButton = null;
        initializePanel();
        addTaskButton = new JButton("Aufgabe hinzufuegen");
        addComponentsToPanel(li);
    }

    public NewTask(ToDoPanel toDoPanel, ToDoPanelButtonListener li, TaskButton taskButton) {
        this.toDoPanel = toDoPanel;
        this.taskButton = taskButton;
        initializePanel();
        addTaskButton = new JButton("Aufgabe aktualisieren");

        nameText.setText(taskButton.getName());
        descriptionText.setText(taskButton.getDescription());
        dateSet.setText(taskButton.getDate());
        timeSet.setText(taskButton.getTime());
        prioritySet.setSelectedItem(taskButton.getPriority());

        addComponentsToPanel(li);
    }

    public void initializePanel() {
        panel = new JPanel();
        panel.setLayout(new GridLayout(0, 2, 50, 15));

        name = new JLabel("Name:");
        description = new JLabel("Beschreibung:");
        date = new JLabel("Datum:");
        time = new JLabel("Uhrzeit:");
        priority = new JLabel("Priorität:");

        nameText = new JTextField();
        descriptionText = new JTextArea();
        dateSet = new JTextField();
        timeSet = new JTextField();

        prioritySet = new JComboBox<String>(prioritäten);

    }

    public void addComponentsToPanel(ToDoPanelButtonListener li) {
        panel.add(name);
        panel.add(nameText);
        panel.add(description);
        panel.add(descriptionText);
        panel.add(date);
        panel.add(dateSet);
        panel.add(time);
        panel.add(timeSet);
        panel.add(priority);
        panel.add(prioritySet);
        panel.add(addTaskButton);

        // nameText.getText(), descriptionText.getText(),
        // dateSet.getText(), timeSet.getText(),
        // prioritySet.getSelectedItem().toString()
        NewTaskListener listenerAddTask = new NewTaskListener(this, li, toDoPanel, taskButton);
        addTaskButton.addActionListener(listenerAddTask);

        add(panel);
        setSize(500, 700);
        setVisible(true);
        setTitle("Neue Aufgabe anlegen");
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    }

    public JTextField getNameText() {
        return this.nameText;
    }

    public void setNameText(JTextField nameText) {
        this.nameText = nameText;
    }

    public JTextField getDateSet() {
        return this.dateSet;
    }

    public void setDateSet(JTextField dateSet) {
        this.dateSet = dateSet;
    }

    public JTextField getTimeSet() {
        return this.timeSet;
    }

    public void setTimeSet(JTextField timeSet) {
        this.timeSet = timeSet;
    }

    public JTextArea getDescriptionText() {
        return this.descriptionText;
    }

    public void setDescriptionText(JTextArea descriptionText) {
        this.descriptionText = descriptionText;
    }

    public JComboBox<String> getPrioritySet() {
        return this.prioritySet;
    }

    public void setPrioritySet(JComboBox<String> prioritySet) {
        this.prioritySet = prioritySet;
    }

}