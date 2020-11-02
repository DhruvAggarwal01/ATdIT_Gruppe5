package atdit1.group5.panels;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.ResourceBundle;

import atdit1.group5.listener.LogoIconMouseAdapter;

/**
 * dient der Demo eines Panels 2. Ebene (s. <code>NavItemPanelChooser</code>)
 * anhand des Reporting-Panels.
 * 
 * @author Sophie Orth, Monica Alessi, Dhruv Aggarwal, Maik Fichtenkamm, Lucas
 *         Lahr
 */
public class ReportingPanel extends JPanel {

    private static final long serialVersionUID = -8379965032225222069L;
    private ResourceBundle text;

    private JPanel reportingHeaderRowPanel;
    private JButton backButton;
    private JLabel mockLabel;

    /**
     * platziert ein einfaches Label zentral im Panel und stellt ein Button, welches
     * eine Zurück-Taste dar.
     */
    public ReportingPanel() {        
        this.text = ResourceBundle.getBundle(("i18n/mainAppStrings"));
        this.setLayout(new BorderLayout());

        reportingHeaderRowPanel = new JPanel(new GridLayout(1, 7, 30, 30));
        backButton = new JButton(text.getString("backString"));
        ActionListener limaListener = new LogoIconMouseAdapter();
        backButton.addActionListener(limaListener);

        mockLabel = new JLabel(text.getString("reportingText"), SwingUtilities.CENTER);

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

    /**
     * Getter-Methode für das Panel für die Reporting-Header-Zeile
     * 
     * @return Panel für die Reporting-Header-Zeile
     */
    public JPanel getReportingHeaderRowPanel() {
        return reportingHeaderRowPanel;
    }

    /**
     * Getter-Methode für den Zurück-Button
     * 
     * @return Zurück-Button
     */
    public JButton getBackButton() {
        return backButton;
    }

    /**
     * Getter-Methode für das Pseudolabel
     * 
     * @return Pseudolabel
     */
    public JLabel getMockLabel() {
        return mockLabel;
    }

}
