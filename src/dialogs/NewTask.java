package dialogs;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.GridLayout;

import listener.NewTaskListener;
import listener.ToDoPanelButtonListener;
import panels.ToDoPanel;
import subpanels.TaskButton;

/**
 * Diese Klasse legt fest wie neue Aufgaben angelegt werden.
 */
public class NewTask extends JDialog {

    private static final long serialVersionUID = 1L;
    private TaskButton taskButton;
    private JPanel panel;
    private JLabel name, description, date, time, priority;
    private JTextField nameText, timeSet, dateSet;
    private JTextArea descriptionText;
    private JComboBox<String> prioritySet;
    private JButton addAndUpdateButton;
    private ToDoPanel toDoPanel;
    private String[] prioritäten = new String[] { "none", "low", "moderate", "high", "very high" };

    /**
     * Konstruktor, der aufgerufen wird wenn man eine neue Aufgabe anlegen möchte.
     * Dabei existiert diese Aufgabe vorher noch nicht. Dieser Konstruktor erzeugt
     * dann den nötigen JDialog, um eine Aufgabe anzulegen.
     * 
     * @param toDoPanel         Referenz zum ToDoPanel
     * @param toDoPanellistener
     */
    public NewTask(ToDoPanel toDoPanel, ToDoPanelButtonListener toDoPanellistener) {
        this.toDoPanel = toDoPanel;
        this.taskButton = null;
        initializePanel();
        addAndUpdateButton = new JButton("Aufgabe hinzufügen");
        setTitle("Neue Aufgabe anlegen");
        addComponentsToPanel(toDoPanellistener);
    }

    /**
     * Konsturktor, der aufgerufen wird, wenn eine Task schon existiert und somit in
     * den JDialog Werte übergeben werden von der bereits existierenden Task
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
        addAndUpdateButton = new JButton("Aufgabe aktualisieren");

        nameText.setText(taskButton.getName());
        descriptionText.setText(taskButton.getDescription());
        dateSet.setText(taskButton.getDate());
        timeSet.setText(taskButton.getTime());
        prioritySet.setSelectedItem(taskButton.getPriority());

        setTitle("Aufgabe aktualisieren");
        addComponentsToPanel(toDoPanellistener);
    }

    /**
     * Diese Methode initialisiert die nötigen Swing/AWT-Komponenten vom JDialog
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
        panel.add(dateSet);
        panel.add(time);
        panel.add(timeSet);
        panel.add(priority);
        panel.add(prioritySet);
        panel.add(addAndUpdateButton);

        NewTaskListener listenerAddTask = new NewTaskListener(this, toDoPanellistener, toDoPanel, taskButton);
        addAndUpdateButton.addActionListener(listenerAddTask);

        add(panel);
        setSize(500, 700);
        setVisible(true);
        setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
    }

    public JTextField getNameText() {
        return this.nameText;
    }

    public JTextField getDateSet() {
        return this.dateSet;
    }

    public JTextField getTimeSet() {
        return this.timeSet;
    }

    public JTextArea getDescriptionText() {
        return this.descriptionText;
    }

    public JComboBox<String> getPrioritySet() {
        return this.prioritySet;
    }

}