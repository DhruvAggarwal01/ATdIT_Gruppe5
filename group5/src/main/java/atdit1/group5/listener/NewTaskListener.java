package atdit1.group5.listener;

import java.awt.event.*;

import atdit1.group5.panels.ToDoPanel;
import atdit1.group5.dialogs.NewTask;
import atdit1.group5.subpanels.TaskButton;

/**
 * stellt die Funktionalität in Form eines Listeners zur Verfügung, um auf den
 * Button des JDialogs zu hören
 * 
 * @author Sophie Orth, Monica Alessi, Dhruv Aggarwal, Maik Fichtenkamm, Lucas
 *         Lahr
 */
public class NewTaskListener implements ActionListener {

    private NewTask dialog;
    private ToDoPanel toDoPanel;
    private ToDoPanelButtonListener toDoPanelListener;
    // private static int id = 0;
    private TaskButton b;

    /**
     * erzeugt diese Klasse und initialisiert deren Attribute.
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
     */
    public void actionPerformed(ActionEvent e) {
        if (b == null) {
            TaskButton b = new TaskButton(dialog.getNameText().getText(), dialog.getDescriptionText().getText(),
                    dialog.getDateSet().getText(), dialog.getTimeSet().getText(),
                    dialog.getPrioritySet().getSelectedItem().toString());
            b.addActionListener(toDoPanelListener);
            toDoPanel.getTaskList().add(b);
            toDoPanel.getTaskList().revalidate();
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
