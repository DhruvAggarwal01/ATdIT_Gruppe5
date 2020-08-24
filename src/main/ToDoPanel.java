package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/** Diese Klasse bildet die To-Do-Verwaltung der Steinbruch Software ab
 * @author  Sophie Orth, Monica Alessi, Dhruv Aggarwal, Maik Fichtenkamm, Lucas Lahr
 * 
 */

public class ToDoPanel extends JFrame {

    private Container c;
    public JPanel aufgabenListe;
    public JButton neueAufgabe;
    public JButton aufgabeBearbeiten; 

    /** Konstruktor bietet ein <code>JPanel</code>, welches alle aktiven To-Do-ELemente in Form von <code>JCheckBox</code>en fassen soll
     * und die Buttons <code>Neue Aufgabe</code> und <code>Aufgabe bearbeiten</code>, welche ein neues
     * To-Do-Element erstellen oder ein bestehendes bearbeiten
     * Die drei Aufgaben dienen Demonstrationszwecken
     */

    public ToDoPanel(){
        c = getContentPane();
        neueAufgabe = new JButton("Neue Aufgabe");
        aufgabeBearbeiten = new JButton("Aufgabe bearbeiten");
        aufgabenListe = new JPanel();
        JCheckBox aufgabe1 = new JCheckBox("Aufgabe 1");
        JCheckBox aufgabe2 = new JCheckBox("Aufgabe 2");
        JCheckBox aufgabe3 = new JCheckBox("Aufgabe 3");
        aufgabenListe.add(aufgabe1);
        aufgabenListe.add(aufgabe2);
        aufgabenListe.add(aufgabe3);
        c.add(aufgabenListe);
        c.add(neueAufgabe);
        c.add(aufgabeBearbeiten);
        ButtonListener listenerNeueAufgabe = new ButtonListener();
        neueAufgabe.addActionListener(listenerNeueAufgabe);
        ListenerAufgabeBearbeiten listenerBearbeiten = new ListenerAufgabeBearbeiten();
        aufgabeBearbeiten.addActionListener(listenerBearbeiten);

    }

    class ButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            //ToDoElement newElement = new ToDoElement();
        }
    }

    class ListenerAufgabeBearbeiten implements ActionListener{
        public void actionPerformed(ActionEvent e){
            //Selbes Fenster wie bei "Neue Aufgabe" geht auf, aber bisherigen Werte sind schon darin enthalten
            
        }
    }
    
}