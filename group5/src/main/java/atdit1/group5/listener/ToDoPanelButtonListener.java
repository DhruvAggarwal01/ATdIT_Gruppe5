package atdit1.group5.listener;

import java.awt.event.*;

import atdit1.group5.panels.ToDoPanel;
import atdit1.group5.subpanels.NewTask;
import atdit1.group5.subpanels.TaskButton;

/**
 * tbd
 * 
 * @author Sophie Orth, Monica Alessi, Dhruv Aggarwal, Maik Fichtenkamm, Lucas
 *         Lahr
 */
public class ToDoPanelButtonListener implements ActionListener {

    private ToDoPanel panel;

    /**
     * tbd
     * 
     * @param panel
     */
    public ToDoPanelButtonListener(ToDoPanel panel) {
        this.panel = panel;
    }

    /**
     * {@inheritDoc}
     */
    public void actionPerformed(ActionEvent e) {

        if (e.getSource().getClass().getName().equals("javax.swing.JButton")) {
            new NewTask(panel, this);

        } else {
            TaskButton b = (TaskButton) e.getSource();
            new NewTask(panel, this, b);
        }

    }
}
