package subpanels;

import java.awt.*;
import javax.swing.*;

import panels.ToDoPanel;

import java.awt.event.*;

/**
 * Diese Klasse legt fest wie neue Aufgaben angelegt werden.
 */

public class NeueAufgabe extends JDialog {
    // zu JDialog wechseln
    private static final long serialVersionUID = 1L;

    Container c;
    JLabel name, beschreibung, datum, uhrzeit, priorität;
    JTextField nameText, datumAngabe, uhrzeitAngabe;
    JTextArea beschreibungText;
    JComboBox<String> prioritätAuswahl;
    JButton aufgabeHinzufuegen;
    ToDoPanel panel;

    String[] prioritäten = new String[] { "keine", "gering", "mittel", "hoch", "sehr hoch" };

    public NeueAufgabe(ToDoPanel panel) {
        this.panel = panel;
        this.setSize(500, 700);
        this.setVisible(true);
        this.setTitle("Neue Aufgabe anlegen");
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        c = getContentPane();
        c.setLayout(new GridLayout(0, 2, 50, 15));

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

        c.add(name);
        c.add(nameText);
        c.add(beschreibung);
        c.add(beschreibungText);
        c.add(datum);
        c.add(datumAngabe);
        c.add(uhrzeit);
        c.add(uhrzeitAngabe);
        c.add(priorität);
        c.add(prioritätAuswahl);
        c.add(aufgabeHinzufuegen);

        ButtonListener listenerAufgabeHinzufuegen = new ButtonListener(this);
        aufgabeHinzufuegen.addActionListener(listenerAufgabeHinzufuegen);

        this.add(c);

    }

    /**
     * Der Listener sorgt dafür, dass ein neu angelegtes To-Do im To-Do-Panel
     * angezeigt wird
     */

    class ButtonListener implements ActionListener {
        private NeueAufgabe f;

        public ButtonListener(NeueAufgabe m){
            f = m;
        }
        public void actionPerformed(ActionEvent e) {
            Tasks t = new Tasks(nameText.getText(), datumAngabe.getText(), beschreibungText.getText(), uhrzeitAngabe.getText(),  prioritätAuswahl.getSelectedItem().toString());
            panel.getTask_list().add(t);
            panel.getAufgabenListe().add(new JButton(t.getName()));
            panel.getAufgabenListe().revalidate();
            f.dispose();
        }
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