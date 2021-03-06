package atdit1.group5.dialogs;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;
import javax.swing.*;
import javax.swing.event.ChangeListener;

import atdit1.group5.mainclasses.ActualApp;
import atdit1.group5.Styles;
import atdit1.group5.listener.ThemeChangeListener;
import atdit1.group5.listener.TimeoutAndCloseListener;

/**
 * baut ein Dialog-Fenster auf, das dem Benutzer die Möglichkeit bietet,
 * verschiedene App-Einstellungen vorzunehmen.
 * 
 * @author Sophie Orth, Monica Alessi, Dhruv Aggarwal, Maik Fichtenkamm, Lucas
 *         Lahr
 */
public class SettingsDialog extends AbstractUsermenuDialog {

    private static final long serialVersionUID = 5756321453884339110L;
    private ResourceBundle text;

    private String settingsDialogTitle;

    private JPanel contentPanel;
    private JPanel styleSettingsPanel;
    private JPanel functionalitySettingsPanel;

    private JLabel settingsTitleLabel;

    private JLabel titleStyleSettingsLabel;

    private JLabel themeToggleSettingLabel;
    public final ImageIcon nightModeOFFIcon = new ImageIcon(
            new ImageIcon("group5/src/main/resources/images/nightModeOff.png").getImage().getScaledInstance(20, 20,
                    Image.SCALE_SMOOTH));
    public final ImageIcon nightModeONIcon = new ImageIcon(
            new ImageIcon("group5/src/main/resources/images/nightModeOn.png").getImage().getScaledInstance(20, 20,
                    Image.SCALE_SMOOTH));
    private static JToggleButton themeToggleButton;

    private JLabel titleFunctionalitySettingsLabel;

    private JLabel timeoutTimeLabel;
    private SpinnerNumberModel timeoutSpinnerModel;
    private JSpinner timeoutTimeSpinner;

    private JPanel cPanel;
    private JButton closeButton;
    private JButton applyAndCloseButton;

    public SettingsDialog(JFrame owner, String title, boolean modal) {
        super(owner, title, modal);
        settingsDialogTitle = title;
        contentSettingsSet();
    }

    /**
     * setzt aus verschiedenen Swing/AWT-Komponenten ein passendes UI zusammen.
     */
    @Override
    public void contentSettingsSet() {
        this.text = ResourceBundle.getBundle(("i18n/settingsDialogStrings"));
        contentPanel = new JPanel(new GridLayout(6, 1));
        contentPanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createRaisedSoftBevelBorder(),
                BorderFactory.createTitledBorder(settingsDialogTitle)));
        contentPanel.setBackground(new Color(220, 220, 220));

        styleSettingsPanel = new JPanel(new GridLayout(1, 2));
        functionalitySettingsPanel = new JPanel(new GridLayout(1, 2));

        // Main title: Einstellungen
        settingsTitleLabel = new JLabel(text.getString("settingsString"));
        settingsTitleLabel.setFont(Styles.PROFILE_LVL1_FONT);

        // Sub title: Style-Einstellungen
        titleStyleSettingsLabel = new JLabel(text.getString("styleSettings"));
        titleStyleSettingsLabel.setFont(Styles.PROFILE_LVL2_FONT);

        themeToggleSettingLabel = new JLabel(text.getString("nightmodeString"));
        themeToggleSettingLabel.setFont(Styles.PROFILE_LVL3_FONT);

        ChangeListener tcListener = new ThemeChangeListener(this);
        themeToggleButton = new JToggleButton((text.getString("OffString")), nightModeOFFIcon, false);
        themeToggleButton.setFont(Styles.PROFILE_LVL3_FONT);
        themeToggleButton.addChangeListener(tcListener);

        styleSettingsPanel.add(themeToggleSettingLabel);
        styleSettingsPanel.add(themeToggleButton);

        // Sub title: Funktionalität-Einstellungen
        titleFunctionalitySettingsLabel = new JLabel(text.getString("functionalSettingsString"));
        titleFunctionalitySettingsLabel.setFont(Styles.PROFILE_LVL2_FONT);

        timeoutTimeLabel = new JLabel(text.getString("timeUntilTimeoutText"));
        timeoutTimeLabel.setFont(Styles.PROFILE_LVL3_FONT);
        timeoutSpinnerModel = new SpinnerNumberModel(ActualApp.getTimeoutTimer().getInitialDelay() / 60000,
                60000 / 60000, 7200000 / 60000, 1);
        timeoutTimeSpinner = new JSpinner(timeoutSpinnerModel);

        functionalitySettingsPanel.add(timeoutTimeLabel);
        functionalitySettingsPanel.add(timeoutTimeSpinner);

        ImageIcon closeIcon = new ImageIcon(new ImageIcon("group5/src/main/resources/images/closeIcon.png").getImage()
                .getScaledInstance(20, 20, Image.SCALE_SMOOTH));
        ImageIcon applyAndCloseIcon = new ImageIcon(
                new ImageIcon("group5/src/main/resources/images/saveAndCloseIcon.png").getImage().getScaledInstance(20,
                        20, Image.SCALE_SMOOTH));

        cPanel = new JPanel(new GridLayout(1, 3, 140, 140));
        ActionListener tacListener = new TimeoutAndCloseListener(this);
        closeButton = new JButton((text.getString("closeString")), closeIcon);
        closeButton.setFont(Styles.RSSC_BUTTON_FONT);
        closeButton.addActionListener(tacListener);
        applyAndCloseButton = new JButton((text.getString("saveTimeouText")), applyAndCloseIcon);
        applyAndCloseButton.setFont(Styles.RSSC_BUTTON_FONT);
        applyAndCloseButton.addActionListener(tacListener);

        cPanel.add(closeButton);
        cPanel.add(applyAndCloseButton);

        contentPanel.add(settingsTitleLabel);
        contentPanel.add(titleStyleSettingsLabel);
        contentPanel.add(styleSettingsPanel);
        contentPanel.add(titleFunctionalitySettingsLabel);
        contentPanel.add(functionalitySettingsPanel);
        contentPanel.add(cPanel);

        this.add(contentPanel);
    }

    public JToggleButton getThemeToggleButton() {
        return themeToggleButton;
    }

    public JButton getCloseButton() {
        return closeButton;
    }

    public JPanel getStyleSettingsPanel() {
        return styleSettingsPanel;
    }

    public JPanel getFunctionalitySettingsPanel() {
        return functionalitySettingsPanel;
    }

    public JButton getApplyAndCloseButton() {
        return applyAndCloseButton;
    }

    public JSpinner getTimeoutTimeSpinner() {
        return timeoutTimeSpinner;
    }
}