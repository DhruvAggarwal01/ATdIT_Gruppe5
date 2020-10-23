package listener;

import panels.ToDoPanel;

import java.awt.event.*;
import subpanels.NewTask;
import subpanels.TaskButton;

public class NewTaskListener implements ActionListener {
    private NewTask dialog;
    private ToDoPanel toDoPanel;
    private ToDoPanelButtonListener li;
    // private static int id = 0;
    private TaskButton b;

    public NewTaskListener(NewTask dialog, ToDoPanelButtonListener li, ToDoPanel toDoPanel, TaskButton b) {
        this.dialog = dialog;
        this.li = li;
        this.toDoPanel = toDoPanel;
        this.b = b;

    }

    public void actionPerformed(ActionEvent e) {
        if (b == null) {
            TaskButton b = new TaskButton(dialog.getNameText().getText(), dialog.getDescriptionText().getText(),
                    dialog.getDateSet().getText(), dialog.getTimeSet().getText(),
                    dialog.getPrioritySet().getSelectedItem().toString());
            b.addActionListener(li);

            // b.setText(t.getName());
            toDoPanel.getAufgabenListe().add(b);
            toDoPanel.getAufgabenListe().revalidate();
        } else {
            b.setName(dialog.getNameText().getText());
            b.setDescription(dialog.getDescriptionText().getText());
            b.setDate(dialog.getDateSet().getText());
            b.setTime(dialog.getTimeSet().getText());
            b.setPriority(dialog.getPrioritySet().getSelectedItem().toString());
        }
        dialog.dispose();
    }
}
