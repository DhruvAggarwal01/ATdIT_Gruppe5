package listener;

import java.awt.event.*;

import panels.ToDoPanel;
import subpanels.NewTask;
import subpanels.TaskButton;

public class ToDoPanelButtonListener implements ActionListener {

    private ToDoPanel panel;

    public ToDoPanelButtonListener(ToDoPanel panel) {
        this.panel = panel;
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource().getClass().getName().equals("javax.swing.JButton")) {
            new NewTask(panel, this);

        } else {
            TaskButton b = (TaskButton) e.getSource();
            new NewTask(panel, this, b);
        }

    }
}
