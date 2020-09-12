package panels;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

import listener.LogoIconMouseAdapter;

/**
 * Diese Klasse dient der Demo eines Panels 2. Ebene (s.
 * <code>NavItemPanelChooser</code>) anhand des Reporting-Panels.
 * 
 * @author Sophie Orth, Monica Alessi, Dhruv Aggarwal, Maik Fichtenkamm, Lucas
 *         Lahr
 */
public class ReportingPanel extends JPanel {

    private static final long serialVersionUID = -8379965032225222069L;
    private JPanel reportingHeaderRowPanel;
    private JButton backButton;
    private JLabel mockLabel;

    /**
     * Konstruktor, der ein einfaches Label zentral im Panel platziert und ein
     * Button, welches eine Zurück-Taste darstellt.
     */
    public ReportingPanel() {
        this.setLayout(new BorderLayout());

        reportingHeaderRowPanel = new JPanel(new GridLayout(1, 7, 30, 30));
        backButton = new JButton("Zurück");
        ActionListener limaListener = new LogoIconMouseAdapter();
        backButton.addActionListener(limaListener);

        mockLabel = new JLabel("REPORTING-Panel (siehe Prototyp)", SwingUtilities.CENTER);

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

    public JPanel getReportingHeaderRowPanel(){
        return reportingHeaderRowPanel;
    }
    public JButton getBackButton(){
        return backButton;
    }
    public JLabel getMockLabel(){
        return mockLabel;
    }
}
