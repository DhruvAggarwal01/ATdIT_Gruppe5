package panels;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import listener.ToDoPanelButtonListener;

/**
 * Diese Klasse bildet die To-Do-Verwaltung der Steinbruch Software ab
 * 
 * @author Sophie Orth, Monica Alessi, Dhruv Aggarwal, Maik Fichtenkamm, Lucas
 *         Lahr
 * 
 */
public class ToDoPanel extends JPanel {

    private static final long serialVersionUID = -1436022192721531424L;
    private JPanel taskList;
    private JPanel buttonPanel;
    private JButton newTaskButton;

    /**
     * Diese Methode ist der Konstruktor und erzeugt das ToDOPanel und die dafür
     * nötigen Swing/AWT-Komponenten erzeugt. Die taskList nimmt dabei Komponenten
     * vom Typ TaskButton auf und zusätzlich wird noch ein JButton hinzugefügt.
     */
    public ToDoPanel() {
        this.setLayout(new BorderLayout());

        taskList = new JPanel(new GridLayout(0, 1, 10, 10));
        buttonPanel = new JPanel();

        newTaskButton = new JButton("Neue Aufgabe");
        newTaskButton.setPreferredSize(new Dimension(300, 100));
        buttonPanel.add(newTaskButton);

        ToDoPanelButtonListener listenerNewTask = new ToDoPanelButtonListener(this);
        newTaskButton.addActionListener(listenerNewTask);

        this.add(taskList, BorderLayout.CENTER);
        this.add(buttonPanel, BorderLayout.SOUTH);
    }

    public JPanel getAufgabenListe() {
        return taskList;
    }

}