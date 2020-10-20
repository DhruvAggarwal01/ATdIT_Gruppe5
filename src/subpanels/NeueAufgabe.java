package subpanels;

import java.awt.*;
import javax.swing.*;

import listener.NewTaskListener;
import listener.ToDoPanelButtonListener;
import panels.ToDoPanel;


/**
 * Diese Klasse legt fest wie neue Aufgaben angelegt werden.
 */

public class NeueAufgabe extends JDialog{
    // zu JDialog wechseln
    private static final long serialVersionUID = 1L;

    JPanel panel;
    JLabel name, beschreibung, datum, uhrzeit, priorität;
    JTextField nameText, datumAngabe, uhrzeitAngabe;
    JTextArea beschreibungText;
    JComboBox<String> prioritätAuswahl;
    JButton aufgabeHinzufuegen;
    ToDoPanel toDoPanel;

    String[] prioritäten = new String[] { "keine", "gering", "mittel", "hoch", "sehr hoch" };

    public NeueAufgabe(ToDoPanel toDoPanel, ToDoPanelButtonListener li) {
        this.toDoPanel = toDoPanel;
        panel = new JPanel();
        
        panel.setLayout(new GridLayout(0, 2, 50, 15));

        name = new JLabel("Name:");
        beschreibung = new JLabel("Beschreibung:");
        datum = new JLabel("Datum:");
        uhrzeit = new JLabel("Uhrzeit:");
        priorität = new JLabel("Priorität:");

        nameText = new JTextField();
        beschreibungText = new JTextArea();
        datumAngabe = new JTextField();
        uhrzeitAngabe = new JTextField();

        prioritätAuswahl = new JComboBox<String>(prioritäten);

        aufgabeHinzufuegen = new JButton("Aufgabe hinzufuegen");

        panel.add(name);
        panel.add(nameText);
        panel.add(beschreibung);
        panel.add(beschreibungText);
        panel.add(datum);
        panel.add(datumAngabe);
        panel.add(uhrzeit);
        panel.add(uhrzeitAngabe);
        panel.add(priorität);
        panel.add(prioritätAuswahl);
        panel.add(aufgabeHinzufuegen);

        NewTaskListener listenerAufgabeHinzufuegen = new NewTaskListener(this, nameText.getText(), beschreibungText.getText(), datumAngabe.getText(), uhrzeitAngabe.getText(),  prioritätAuswahl.getSelectedItem().toString(), li, toDoPanel);
        aufgabeHinzufuegen.addActionListener(listenerAufgabeHinzufuegen);

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