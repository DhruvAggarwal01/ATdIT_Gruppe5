package listener;

import java.awt.event.*;

import javax.swing.JButton;

import panels.ToDoPanel;
import subpanels.NeueAufgabe;

public class ToDoPanelButtonListener implements ActionListener {

    private ToDoPanel panel;

    public ToDoPanelButtonListener(ToDoPanel panel) {
        this.panel = panel;
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource().getClass().getName().equals("javax.swing.JButton")){
            System.out.println("ja nur ein Button");
            new NeueAufgabe(panel, this);
        }
        else{
            //bestehende Aufgabe anzeigen und gewisse Werte ändern können!
            ;
        }
    }
}
