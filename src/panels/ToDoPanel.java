package panels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

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
    private ArrayList<Tasks> task_list = new ArrayList<Tasks>();

    /**
     * Konstruktor bietet ein <code>JPanel</code>, welches alle aktiven
     * To-Do-ELemente in Form von <code>JCheckBox</code>en fassen soll und die
     * Buttons <code>Neue Aufgabe</code> und <code>Aufgabe bearbeiten</code>, welche
     * ein neues To-Do-Element erstellen oder ein bestehendes bearbeiten
     */

    public ToDoPanel() {
        this.setLayout(new BorderLayout());
        
        aufgabenListe = new JPanel(new GridLayout(0, 1, 10, 10));
        buttonPanel = new JPanel();
        
        neueAufgabe = new JButton("Neue Aufgabe");
        buttonPanel.add(neueAufgabe);

        ButtonListener listenerNeueAufgabe = new ButtonListener(this);
        neueAufgabe.addActionListener(listenerNeueAufgabe);

        this.add(aufgabenListe, BorderLayout.CENTER);
        this.add(buttonPanel, BorderLayout.SOUTH);
    }

    public ArrayList<Tasks> getTask_list() {
        return this.task_list;
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


}