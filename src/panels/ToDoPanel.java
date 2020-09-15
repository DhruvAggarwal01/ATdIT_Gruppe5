package panels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.ListIterator;

import subpanels.NeueAufgabe;
import subpanels.Tasks;

/**
 * Diese Klasse bildet die To-Do-Verwaltung der Steinbruch Software ab
 * 
 * @author Sophie Orth, Monica Alessi, Dhruv Aggarwal, Maik Fichtenkamm, Lucas
 *         Lahr
 * 
 */

public class ToDoPanel extends JPanel {

    private static final long serialVersionUID = -1436022192721531424L;

    private JPanel aufgabenListe;
    private JPanel buttonPanel;
    private JButton neueAufgabe;
    private JButton aufgabeBearbeiten;
    private ArrayList<Tasks> task_list = new ArrayList<Tasks>();

    /**
     * Konstruktor bietet ein <code>JPanel</code>, welches alle aktiven
     * To-Do-ELemente in Form von <code>JCheckBox</code>en fassen soll und die
     * Buttons <code>Neue Aufgabe</code> und <code>Aufgabe bearbeiten</code>, welche
     * ein neues To-Do-Element erstellen oder ein bestehendes bearbeiten
     */

    public ToDoPanel() {
        this.setLayout(new BorderLayout());
        aufgabenListe = new JPanel(new GridLayout(1, 0, 5, 5));
        buttonPanel = new JPanel();
        
        neueAufgabe = new JButton("Neue Aufgabe");
        aufgabeBearbeiten = new JButton("Aufgabe bearbeiten");
        buttonPanel.add(neueAufgabe);
        buttonPanel.add(aufgabeBearbeiten);
        this.add(aufgabenListe, BorderLayout.CENTER);
        this.add(buttonPanel, BorderLayout.SOUTH);

        ButtonListener listenerNeueAufgabe = new ButtonListener(this);
        neueAufgabe.addActionListener(listenerNeueAufgabe);
        ListenerAufgabeBearbeiten listenerBearbeiten = new ListenerAufgabeBearbeiten();
        aufgabeBearbeiten.addActionListener(listenerBearbeiten);
        addTasks();
        this.add(aufgabenListe, BorderLayout.WEST);
        this.add(buttonPanel, BorderLayout.SOUTH);
    }

    public void addTasks() {
        ListIterator<Tasks> li = task_list.listIterator();

        while (li.hasNext()) {
            JButton task = new JButton(li.next().getName());
            aufgabenListe.add(task);
        }
    }

    public ArrayList<Tasks> getTask_list() {
        return this.task_list;
    }

    public void setTask_list(ArrayList<Tasks> task_list) {
        this.task_list = task_list;
    }

    class ButtonListener implements ActionListener {
        private ToDoPanel panel;

        public ButtonListener(ToDoPanel panel) {
            this.panel = panel;
        }

        public void actionPerformed(ActionEvent e) {
            new NeueAufgabe(panel);
        }
    }

    public JPanel getAufgabenListe() {
        return aufgabenListe;
    }

    class ListenerAufgabeBearbeiten implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // Selbes Fenster wie bei "Neue Aufgabe" geht auf, aber bisherigen Werte sind
            // schon darin enthalten

        }
    }

}