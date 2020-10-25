package subpanels;

import java.awt.*;
import javax.swing.*;

import listener.NewTaskListener;
import listener.ToDoPanelButtonListener;
import panels.ToDoPanel;

/**
 * legt fest wie neue Aufgaben angelegt werden.
 * 
 * @author Sophie Orth, Monica Alessi, Dhruv Aggarwal, Maik Fichtenkamm, Lucas
 *         Lahr
 */
public class NewTask extends JDialog {

    private static final long serialVersionUID = -8885029101653367966L;

    // zu JDialog wechseln
    private TaskButton taskButton;
    private JPanel panel;
    private JLabel name, description, date, time, priority;
    private JTextField nameText, dateSet, timeSet;
    private JTextArea descriptionText;
    private JComboBox<String> prioritySet;
    private JButton addTaskButton;
    private ToDoPanel toDoPanel;

    String[] prioritäten = new String[] { "none", "low", "moderate", "high", "very high" };

    /**
     * tbd
     * 
     * @param toDoPanel
     * @param li
     */
    public NewTask(ToDoPanel toDoPanel, ToDoPanelButtonListener li) {
        this.toDoPanel = toDoPanel;
        this.taskButton = null;
        initializePanel();
        addTaskButton = new JButton("Aufgabe hinzufuegen");
        addComponentsToPanel(li);
    }

    /**
     * tbd
     * 
     * @param toDoPanel
     * @param li
     * @param taskButton
     */
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

    /**
     * tbd
     */
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

    /**
     * tbd
     * 
     * @param li
     */
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

    /**
     * Getter-Methode für den Namen-Textfeld
     * 
     * @return Namen-Textfeld
     */
    public JTextField getNameText() {
        return this.nameText;
    }

    /**
     * Setter-Methode für den Namen-Textfeld
     * 
     * @param nameText Namen-Textfeld
     */
    public void setNameText(JTextField nameText) {
        this.nameText = nameText;
    }

    /**
     * Getter-Methode für den Datum-Textfeld
     * 
     * @return Datum-Textfeld
     */
    public JTextField getDateSet() {
        return this.dateSet;
    }

    /**
     * Setter-Methode für den Datum-Textfeld
     * 
     * @param dateSet Datum-Textfeld
     */
    public void setDateSet(JTextField dateSet) {
        this.dateSet = dateSet;
    }

    /**
     * Getter-Methode für den Zeit-Textfeld
     * 
     * @return Zeit-Textfeld
     */
    public JTextField getTimeSet() {
        return this.timeSet;
    }

    /**
     * Setter-Methode für den Zeit-Textfeld
     * 
     * @param timeSet Zeit-Textfeld
     */
    public void setTimeSet(JTextField timeSet) {
        this.timeSet = timeSet;
    }

    /**
     * Getter-Methode für den Beschreibung-Textfeld
     * 
     * @return Beschreibung-Textfeld
     */
    public JTextArea getDescriptionText() {
        return this.descriptionText;
    }

    /**
     * Setter-Methode für den Beschreibung-Textfeld
     * 
     * @param descriptionText Beschreibung-Textfeld
     */
    public void setDescriptionText(JTextArea descriptionText) {
        this.descriptionText = descriptionText;
    }

    /**
     * Getter-Methode für die Priorität-ComboBox
     * 
     * @return Priorität-ComboBox
     */
    public JComboBox<String> getPrioritySet() {
        return this.prioritySet;
    }

    /**
     * Setter-Methode für die Priorität-ComboBox
     * 
     * @param prioritySet Priorität-ComboBox
     */
    public void setPrioritySet(JComboBox<String> prioritySet) {
        this.prioritySet = prioritySet;
    }

}