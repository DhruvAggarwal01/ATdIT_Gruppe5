package subpanels;

import java.awt.*;
import javax.swing.*;

import listener.NewTaskListener;
import listener.ToDoPanelButtonListener;
import panels.ToDoPanel;


/**
 * Diese Klasse legt fest wie neue Aufgaben angelegt werden.
 */

public class NewTask extends JDialog{
    // zu JDialog wechseln
    private static final long serialVersionUID = 1L;

    JPanel panel;
    JLabel name, description, date, time, priority;
    JTextField nameText, dateSet, timeSet;
    JTextArea descriptionText;
    JComboBox<String> prioritySet;
    JButton addTask;
    ToDoPanel toDoPanel;

    String[] prioritäten = new String[] { "none", "low", "moderate", "high", "very high" };

    public NewTask(ToDoPanel toDoPanel, ToDoPanelButtonListener li) {
        this.toDoPanel = toDoPanel;
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

        addTask = new JButton("Aufgabe hinzufuegen");

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
        panel.add(addTask);

        NewTaskListener listenerAddTask = new NewTaskListener(this, nameText.getText(), descriptionText.getText(), dateSet.getText(), timeSet.getText(),  prioritySet.getSelectedItem().toString(), li, toDoPanel);
        addTask.addActionListener(listenerAddTask);

        add(panel);
        setSize(500, 700);
        setVisible(true);
        setTitle("Neue Aufgabe anlegen");
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    }

    /**
     * Get-Methode liefert den eingetragenen Namen des To-Do-Elements zurück, damit
     * dieser in der <code>ActionPerformed</code> verwendet werden kann
     * 
     * @param String der im <code>JTextField</code> des Namen eingetragen wurde
     */

    public String getName() {
        return nameText.getText();
    }

}