package dialogs;

import main.Styles;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * 
 */
public class ProfileDialog extends AbstractUsermenuDialog implements ActionListener {

    private static final long serialVersionUID = 1L;

    private String profileDialogTitle;

    private JPanel contentPanel;
    private JPanel personalInfoPanel;
    private JPanel changePswdPanel;

    private JLabel profileInfoTitleLabel;

    private JLabel titlePersonalInfoLabel;
    private JLabel forenameLabel;
    private JTextField forenameTextField;
    private JLabel surnameLabel;
    private JTextField surnameTextField;
    private JLabel streetAndIdLabel;
    private JTextField streetAndIdTextField;
    private JLabel zipLabel;
    private JTextField zipTextField;
    private JLabel cityLabel;
    private JTextField cityTextField;
    private JLabel emailLabel;
    private JTextField emailTextField;

    private JLabel titleChangePswdLabel;
    private JLabel currentPswdLabel;
    private JPasswordField currentPswdField;
    private JLabel newPswdLabel;
    private JPasswordField newPswdField;
    private JLabel confirmPswdLabel;
    private JPasswordField confirmPswdField;

    private JPanel rsscPanel;
    private JButton resetEntriesButton;
    private JButton saveButton;
    private JButton saveAndCloseButton;

    /**
     * 
     */
    public ProfileDialog(JFrame owner, String title, boolean modal) {
        super(owner, title, modal);
        profileDialogTitle = title;

        contentSettingsSet();
    }

    /**
     * 
     */
    @Override
    public void contentSettingsSet() {
        contentPanel = new JPanel(new GridLayout(6, 1));
        contentPanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createRaisedSoftBevelBorder(),
                BorderFactory.createTitledBorder(profileDialogTitle)));
        contentPanel.setBackground(new Color(220, 220, 220));

        personalInfoPanel = new JPanel(new GridLayout(6, 2));
        changePswdPanel = new JPanel(new GridLayout(3, 2));

        // Main title: Profile Information
        profileInfoTitleLabel = new JLabel("PROFIL INFORMATIONEN");
        profileInfoTitleLabel.setFont(Styles.PROFILE_LVL1_FONT);

        // Sub title: Personal Information
        titlePersonalInfoLabel = new JLabel("Persönliche Daten");
        titlePersonalInfoLabel.setFont(Styles.PROFILE_LVL2_FONT);

        forenameLabel = new JLabel("Vorname");
        forenameLabel.setFont(Styles.PROFILE_LVL3_FONT);
        forenameTextField = new JTextField();
        forenameTextField.setFont(Styles.PROFILE_LVL3_FONT);
        surnameLabel = new JLabel("Nachname");
        surnameLabel.setFont(Styles.PROFILE_LVL3_FONT);
        surnameTextField = new JTextField();
        surnameTextField.setFont(Styles.PROFILE_LVL3_FONT);
        streetAndIdLabel = new JLabel("Straße Nr.");
        streetAndIdLabel.setFont(Styles.PROFILE_LVL3_FONT);
        streetAndIdTextField = new JTextField();
        streetAndIdTextField.setFont(Styles.PROFILE_LVL3_FONT);
        zipLabel = new JLabel("PLZ");
        zipLabel.setFont(Styles.PROFILE_LVL3_FONT);
        zipTextField = new JTextField();
        zipTextField.setFont(Styles.PROFILE_LVL3_FONT);
        cityLabel = new JLabel("Stadt");
        cityLabel.setFont(Styles.PROFILE_LVL3_FONT);
        cityTextField = new JTextField();
        cityTextField.setFont(Styles.PROFILE_LVL3_FONT);
        emailLabel = new JLabel("E-Mail");
        emailLabel.setFont(Styles.PROFILE_LVL3_FONT);
        emailTextField = new JTextField();
        emailTextField.setFont(Styles.PROFILE_LVL3_FONT);

        personalInfoPanel.add(forenameLabel);
        personalInfoPanel.add(forenameTextField);
        personalInfoPanel.add(surnameLabel);
        personalInfoPanel.add(surnameTextField);
        personalInfoPanel.add(streetAndIdLabel);
        personalInfoPanel.add(streetAndIdTextField);
        personalInfoPanel.add(zipLabel);
        personalInfoPanel.add(zipTextField);
        personalInfoPanel.add(cityLabel);
        personalInfoPanel.add(cityTextField);
        personalInfoPanel.add(emailLabel);
        personalInfoPanel.add(emailTextField);

        // Sub title: Change Password
        titleChangePswdLabel = new JLabel("Passwort ändern");
        titleChangePswdLabel.setFont(Styles.PROFILE_LVL2_FONT);

        currentPswdLabel = new JLabel("Aktuelles Passwort");
        currentPswdLabel.setFont(Styles.PROFILE_LVL3_FONT);
        currentPswdField = new JPasswordField();
        newPswdLabel = new JLabel("Neues Passwort");
        newPswdLabel.setFont(Styles.PROFILE_LVL3_FONT);
        newPswdField = new JPasswordField();
        confirmPswdLabel = new JLabel("Neues Passwort wiederholen");
        confirmPswdLabel.setFont(Styles.PROFILE_LVL3_FONT);
        confirmPswdField = new JPasswordField();

        changePswdPanel.add(currentPswdLabel);
        changePswdPanel.add(currentPswdField);
        changePswdPanel.add(newPswdLabel);
        changePswdPanel.add(newPswdField);
        changePswdPanel.add(confirmPswdLabel);
        changePswdPanel.add(confirmPswdField);

        // Action buttons
        ImageIcon resetEntriesIcon = new ImageIcon(new ImageIcon("Library/images/resetEntriesIcon.png").getImage()
                .getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH));
        ImageIcon saveIcon = new ImageIcon(new ImageIcon("Library/images/saveIcon.png").getImage().getScaledInstance(20,
                20, java.awt.Image.SCALE_SMOOTH));
        ImageIcon saveAndCloseIcon = new ImageIcon(new ImageIcon("Library/images/saveAndCloseIcon.png").getImage()
                .getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH));

        rsscPanel = new JPanel(new GridLayout(1, 3, 140, 140));
        resetEntriesButton = new JButton("Reset Entries", resetEntriesIcon);
        resetEntriesButton.setFont(Styles.RSSC_BUTTON_FONT);
        saveButton = new JButton("Save", saveIcon);
        saveButton.setFont(Styles.RSSC_BUTTON_FONT);
        saveAndCloseButton = new JButton("Save & Close", saveAndCloseIcon);
        saveAndCloseButton.setFont(Styles.RSSC_BUTTON_FONT);
        saveAndCloseButton.addActionListener(this);

        rsscPanel.add(resetEntriesButton);
        rsscPanel.add(saveButton);
        rsscPanel.add(saveAndCloseButton);

        contentPanel.add(profileInfoTitleLabel);
        contentPanel.add(titlePersonalInfoLabel);
        contentPanel.add(personalInfoPanel);
        contentPanel.add(titleChangePswdLabel);
        contentPanel.add(changePswdPanel);
        contentPanel.add(rsscPanel);

        this.add(contentPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == saveAndCloseButton) {
            this.dispose();
        }
    }
}