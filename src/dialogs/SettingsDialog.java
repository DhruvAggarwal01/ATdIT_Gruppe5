package dialogs;

import main.Application;
import main.Styles;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JToggleButton;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

// import javax.swing.UIManager;
// import javax.swing.UnsupportedLookAndFeelException;

/**
 * 
 */
public class SettingsDialog extends AbstractUsermenuDialog implements ActionListener, ChangeListener {

    private static final long serialVersionUID = 5756321453884339110L;

    private String settingsDialogTitle;

    private JPanel contentPanel;
    private JPanel styleSettingsPanel;
    private JPanel functionalitySettingsPanel;

    private JLabel settingsTitleLabel;

    private JLabel titleStyleSettingsLabel;

    private JLabel themeToggleSettingLabel;
    private static ImageIcon nightModeOFFIcon = new ImageIcon(new ImageIcon("Library/images/nightModeOff.png")
            .getImage().getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH));
    private static ImageIcon nightModeONIcon = new ImageIcon(new ImageIcon("Library/images/nightModeOn.png").getImage()
            .getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH));
    private static JToggleButton themeToggleButton = new JToggleButton("Off", nightModeOFFIcon, false);

    private JLabel titleFunctionalitySettingsLabel;

    private JLabel timeoutTimeLabel;
    private SpinnerNumberModel timeoutSpinnerModel;
    private JSpinner timeoutTimeSpinner; // SpinnerModel sm = new SpinnerNumberModel(0, 0, 100, 1); //default
                                         // value,lower // bound,upper bound,increment by

    private JPanel cPanel;
    private JButton closeButton;

    public SettingsDialog(JFrame owner, String title, boolean modal) {
        super(owner, title, modal);
        settingsDialogTitle = title;
        // let user set the theme, user inactivity dispose after time
        contentSettingsSet();
    }

    /**
     * 
     */
    @Override
    void contentSettingsSet() {
        contentPanel = new JPanel(new GridLayout(6, 1));
        contentPanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createRaisedSoftBevelBorder(),
                BorderFactory.createTitledBorder(settingsDialogTitle)));
        contentPanel.setBackground(new Color(220, 220, 220));

        styleSettingsPanel = new JPanel(new GridLayout(1, 2));
        functionalitySettingsPanel = new JPanel(new GridLayout(1, 2));

        // Main title: Einstellungen
        settingsTitleLabel = new JLabel("EINSTELLUNGEN");
        settingsTitleLabel.setFont(Styles.PROFILE_LVL1_FONT);

        // Sub title: Style-Einstellungen
        titleStyleSettingsLabel = new JLabel("Style-Einstellungen");
        titleStyleSettingsLabel.setFont(Styles.PROFILE_LVL2_FONT);

        themeToggleSettingLabel = new JLabel("Nachtmodus");
        themeToggleSettingLabel.setFont(Styles.PROFILE_LVL3_FONT);

        themeToggleButton.setFont(Styles.PROFILE_LVL3_FONT);
        themeToggleButton.addChangeListener(this);

        styleSettingsPanel.add(themeToggleSettingLabel);
        styleSettingsPanel.add(themeToggleButton);

        // Sub title: Funktionalität-Einstellungen
        titleFunctionalitySettingsLabel = new JLabel("Funktionalität-Einstellungen");
        titleFunctionalitySettingsLabel.setFont(Styles.PROFILE_LVL2_FONT);

        timeoutTimeLabel = new JLabel("Zeit bis zum Timeout (in min):");
        timeoutTimeLabel.setFont(Styles.PROFILE_LVL3_FONT);
        timeoutSpinnerModel = new SpinnerNumberModel(Application.getTimeoutDelay() / 60000, 60000 / 60000,
                7200000 / 60000, 1);
        timeoutTimeSpinner = new JSpinner(timeoutSpinnerModel);

        //tbd: functionality --> timeout set reader textfield, setTimeout

        functionalitySettingsPanel.add(timeoutTimeLabel);
        functionalitySettingsPanel.add(timeoutTimeSpinner);

        ImageIcon closeIcon = new ImageIcon(new ImageIcon("Library/images/closeIcon.png").getImage()
                .getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH));

        cPanel = new JPanel(new GridLayout(1, 3, 140, 140));
        closeButton = new JButton("Apply & Close", closeIcon);
        closeButton.setFont(Styles.RSSC_BUTTON_FONT);
        closeButton.addActionListener(this);

        cPanel.add(closeButton);

        contentPanel.add(settingsTitleLabel);
        contentPanel.add(titleStyleSettingsLabel);
        contentPanel.add(styleSettingsPanel);
        contentPanel.add(titleFunctionalitySettingsLabel);
        contentPanel.add(functionalitySettingsPanel);
        contentPanel.add(cPanel);

        this.add(contentPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == closeButton) {
            this.dispose();
        }
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        if (e.getSource() == themeToggleButton) {
            if (themeToggleButton.isSelected()) {
                themeToggleButton.setText("On");
                themeToggleButton.setIcon(nightModeONIcon);

                try {
                    UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
                    SwingUtilities.updateComponentTreeUI(Application.getAppWindow());
                } catch (UnsupportedLookAndFeelException e1) {
                } catch (ClassNotFoundException e2) {
                } catch (InstantiationException e3) {
                } catch (IllegalAccessException e4) {
                }

            } else {
                themeToggleButton.setText("Off");
                themeToggleButton.setIcon(nightModeOFFIcon);

                try {
                    UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
                    SwingUtilities.updateComponentTreeUI(Application.getAppWindow());
                } catch (UnsupportedLookAndFeelException e1) {
                } catch (ClassNotFoundException e2) {
                } catch (InstantiationException e3) {
                } catch (IllegalAccessException e4) {
                }
            }
        }
    }

}