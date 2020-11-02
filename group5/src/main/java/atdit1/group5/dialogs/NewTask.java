package atdit1.group5.dialogs;

import java.awt.*;
import java.time.LocalTime;

import javax.swing.*;
import java.util.ResourceBundle;

import com.github.lgooddatepicker.components.DatePickerSettings;
import com.github.lgooddatepicker.components.DateTimePicker;
import com.github.lgooddatepicker.components.TimePickerSettings;
import com.github.lgooddatepicker.components.TimePickerSettings.TimeArea;

import atdit1.group5.listener.NewTaskListener;
import atdit1.group5.listener.ToDoPanelButtonListener;
import atdit1.group5.panels.ToDoPanel;
import atdit1.group5.subpanels.TaskButton;

/**
 * legt fest wie neue Aufgaben angelegt werden.
 * 
 * @author Sophie Orth, Monica Alessi, Dhruv Aggarwal, Maik Fichtenkamm, Lucas
 *         Lahr
 */
public class NewTask extends JDialog {

    private static final long serialVersionUID = -8885029101653367966L;
    private ResourceBundle text;

    private TaskButton taskButton;
    private JPanel panel;
    private JLabel name, description, date, priority;
    private JTextField nameText;
    private JTextArea descriptionText;
    private JComboBox<String> prioritySet;
    private JButton addAndUpdateButton;
    private ToDoPanel toDoPanel;
    private DateTimePicker dateTimePicker;

    String[] prioritäten = new String[] { "none", "low", "moderate", "high", "very high" };

    /**
     * wird aufgerufen, wenn man eine neue Aufgabe anlegen möchte. Dabei existiert
     * diese Aufgabe vorher noch nicht. Dieser Konstruktor erzeugt dann den nötigen
     * JDialog, um eine Aufgabe anzulegen.
     * 
     * @param toDoPanel         Referenz zum ToDoPanel
     * @param toDoPanellistener
     */
    public NewTask(ToDoPanel toDoPanel, ToDoPanelButtonListener toDoPanellistener) {
        this.text = ResourceBundle.getBundle(("i18n/dialogStrings"));
        this.toDoPanel = toDoPanel;
        this.taskButton = null;
        initializePanel();
        addAndUpdateButton = new JButton(text.getString("addTaskString"));
        setTitle(text.getString("addTaskText"));
        addComponentsToPanel(toDoPanellistener);
    }

    /**
     * wird aufgerufen, wenn eine Task schon existiert und somit in den JDialog
     * Werte übergeben werden von der bereits existierenden Task
     * 
     * @param toDoPanel         Referenz zum toDoPanel
     * @param toDoPanellistener Listener von den Buttons vom toDoPanel
     * @param taskButton        übergebener TaskButton, der die bereits existierende
     *                          Aufgabe enthält
     */
    public NewTask(ToDoPanel toDoPanel, ToDoPanelButtonListener toDoPanellistener, TaskButton taskButton) {
        this.toDoPanel = toDoPanel;
        this.taskButton = taskButton;
        initializePanel();
        addAndUpdateButton = new JButton(text.getString("updateTaskString"));

        nameText.setText(taskButton.getName());
        descriptionText.setText(taskButton.getDescription());
        dateTimePicker = taskButton.getDateTimePicker();
        prioritySet.setSelectedItem(taskButton.getPriority());

        setTitle(text.getString("updateTaskString"));
        addComponentsToPanel(toDoPanellistener);
    }

    /**
     * initialisiert die nötigen Swing-/AWT-Komponenten vom JDialog
     */
    public void initializePanel() {
        panel = new JPanel();
        panel.setLayout(new GridLayout(0, 2, 50, 15));

        name = new JLabel(text.getString("nameString") + ":");
        description = new JLabel(text.getString("descriptionString") + ":");
        date = new JLabel(text.getString("dateTimeString") + ":");
        priority = new JLabel(text.getString("priorityString") + ":");

        nameText = new JTextField();
        descriptionText = new JTextArea();

        DatePickerSettings dateSettings = new DatePickerSettings();

        TimePickerSettings timeSettings = new TimePickerSettings();
        timeSettings.setColor(TimeArea.TimePickerTextValidTime, Color.blue);
        timeSettings.initialTime = LocalTime.now();
        dateTimePicker = new DateTimePicker(dateSettings, timeSettings);

        prioritySet = new JComboBox<String>(prioritäten);
    }

    /**
     * Diese Methode fügt die nötigen Swing/AWT-Komponenten dem Panel hinzu.
     * 
     * @param toDoPanellistener
     */
    public void addComponentsToPanel(ToDoPanelButtonListener toDoPanellistener) {
        panel.add(name);
        panel.add(nameText);
        panel.add(description);
        panel.add(descriptionText);
        panel.add(date);
        panel.add(dateTimePicker);
        panel.add(priority);
        panel.add(prioritySet);
        panel.add(addAndUpdateButton);

        NewTaskListener listenerAddTask = new NewTaskListener(this, toDoPanellistener, toDoPanel, taskButton);
        addAndUpdateButton.addActionListener(listenerAddTask);

        add(panel);
        setSize(700, 700);
        setVisible(true);
        setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
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
    public DateTimePicker getDateTimePicker() {
        return this.dateTimePicker;
    }

    /**
     * Setter-Methode für den Datum-Textfeld
     * 
     * @param dateSet Datum-Textfeld
     */
    public void setDateSet(DateTimePicker dateTimePicker) {
        this.dateTimePicker = dateTimePicker;
    }

    /**
     * Getter-Methode für den Zeit-Textfeld
     * 
     * @return Zeit-Textfeld
     */

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