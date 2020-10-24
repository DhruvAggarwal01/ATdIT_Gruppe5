package listener;

import panels.ToDoPanel;

import java.awt.event.*;
import dialogs.NewTask;
import subpanels.TaskButton;

/**
 * Klasse, die den Listener darstellt für die Klasse NewTask, um auf den Button
 * des JDialog zu hören
 */
public class NewTaskListener implements ActionListener {
    private NewTask dialog;
    private ToDoPanel toDoPanel;
    private ToDoPanelButtonListener toDoPanelListener;
    // private static int id = 0;
    private TaskButton b;

    /**
     * Konstruktor, der diese Klasse erzeugt und deren Attribute initialiiert
     * 
     * @param dialog            Referenz auf die Klasse NewTask
     * @param toDoPanelListener der Listener vom ToDoPanel
     * @param toDoPanel         das ToDoPanek
     * @param b                 der bereits existierende TaskButton oder noch nicht
     *                          existierende TaskButton; kann null oder bereits
     *                          initialisiert sein
     */
    public NewTaskListener(NewTask dialog, ToDoPanelButtonListener toDoPanelListener, ToDoPanel toDoPanel,
            TaskButton b) {
        this.dialog = dialog;
        this.toDoPanelListener = toDoPanelListener;
        this.toDoPanel = toDoPanel;
        this.b = b;

    }

    /**
     * Invoked when an action occurs. Wird durchlaufen wenn der Button der Klasse
     * NewTask aktiviert wird: Wenn der TaskButton vorher noch nicht exisiterte,
     * wird einer neuer erzeugt und die eingetragenen Werte im JDialog werden
     * übergeben und der TaskButton wird dem toDoPanel und dessen Listener
     * dazugefügt. Wenn der TaskButton vorher existierte, werden dessen Werte
     * lediglich aktualisiert.
     * 
     */
    public void actionPerformed(ActionEvent e) {
        if (b == null) {
            TaskButton b = new TaskButton(dialog.getNameText().getText(), dialog.getDescriptionText().getText(),
                    dialog.getDateSet().getText(), dialog.getTimeSet().getText(),
                    dialog.getPrioritySet().getSelectedItem().toString());
            b.addActionListener(toDoPanelListener);
            toDoPanel.getAufgabenListe().add(b);
            toDoPanel.getAufgabenListe().revalidate();
        } else {
            b.setDescription(dialog.getDescriptionText().getText());
            b.setDate(dialog.getDateSet().getText());
            b.setTime(dialog.getTimeSet().getText());
            b.setPriority(dialog.getPrioritySet().getSelectedItem().toString());
            b.setName(dialog.getNameText().getText());
        }
        dialog.dispose();
    }
}
