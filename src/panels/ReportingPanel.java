package panels;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import main.MainPanel;
import main.NavItemPanelChooser;

public class ReportingPanel extends JPanel {

    private static final long serialVersionUID = -8379965032225222069L;

    public ReportingPanel() {
        this.setLayout(new BorderLayout());

        JPanel reportingHeaderRowPanel = new JPanel(new GridLayout(1, 7, 30, 30));
        JButton backButton = new JButton("Zurück");
        backButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                MainPanel.getNavPane().setComponentAt(0, new NavItemPanelChooser("Overview", null, null));
                MainPanel.getNavPane().setSelectedIndex(0);
            }

        });

        JLabel mockLabel = new JLabel("REPORTING-Panel (siehe Prototyp)", SwingUtilities.CENTER);

        reportingHeaderRowPanel.add(new JLabel(""));
        reportingHeaderRowPanel.add(new JLabel(""));
        reportingHeaderRowPanel.add(new JLabel(""));
        reportingHeaderRowPanel.add(new JLabel(""));
        reportingHeaderRowPanel.add(new JLabel(""));
        reportingHeaderRowPanel.add(new JLabel(""));
        reportingHeaderRowPanel.add(backButton);

        this.add(reportingHeaderRowPanel, BorderLayout.NORTH);
        this.add(mockLabel, BorderLayout.CENTER);
    }
}
