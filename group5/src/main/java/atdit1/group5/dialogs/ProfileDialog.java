package atdit1.group5.dialogs;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;
import javax.swing.*;

import atdit1.group5.Styles;
import atdit1.group5.db_interaction.LogInCredentialsChecker;
import atdit1.group5.listener.ResetSaveCloseListener;

/**
 * baut ein Dialogfenster auf, das dem Benutzer die Interaktionsfläche bietet,
 * um relevante Nutzerdaten anzupassen oder auch nur anzusehen.
 * 
 * @author Sophie Orth, Monica Alessi, Dhruv Aggarwal, Maik Fichtenkamm, Lucas
 *         Lahr
 */
public class ProfileDialog extends AbstractUsermenuDialog {

    private static final long serialVersionUID = -8158863932892908105L;
    private ResourceBundle text;

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

    private JLabel possibleErrorMessageLabel;
    private String errorMessage;

    private JPanel rsscPanel;
    private JButton resetEntriesButton;
    private JButton saveButton;
    private JButton saveAndCloseButton;

    /**
     * {@inheritDoc}
     * 
     * @param owner
     * @param title
     * @param modal
     */
    public ProfileDialog(JFrame owner, String title, boolean modal) {
        super(owner, title, modal);
        profileDialogTitle = title;

        contentSettingsSet();
        setInitDBUsersData();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void contentSettingsSet() {
        this.text = ResourceBundle.getBundle(("i18n/profileDialogStrings"));

        contentPanel = new JPanel(new GridLayout(7, 1));
        contentPanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createRaisedSoftBevelBorder(),
                BorderFactory.createTitledBorder(profileDialogTitle)));
        contentPanel.setBackground(new Color(220, 220, 220));

        personalInfoPanel = new JPanel(new GridLayout(6, 2));
        changePswdPanel = new JPanel(new GridLayout(3, 2));

        // Main title: Profile Information
        profileInfoTitleLabel = new JLabel(text.getString("profilInformationString"));
        profileInfoTitleLabel.setFont(Styles.PROFILE_LVL1_FONT);

        // Sub title: Personal Information
        titlePersonalInfoLabel = new JLabel(text.getString("personalDataString"));
        titlePersonalInfoLabel.setFont(Styles.PROFILE_LVL2_FONT);

        forenameLabel = new JLabel(text.getString("firstNameString"));
        forenameLabel.setFont(Styles.PROFILE_LVL3_FONT);
        forenameTextField = new JTextField();
        forenameTextField.setFont(Styles.PROFILE_LVL3_FONT);
        surnameLabel = new JLabel(text.getString("lastNameString"));
        surnameLabel.setFont(Styles.PROFILE_LVL3_FONT);
        surnameTextField = new JTextField();
        surnameTextField.setFont(Styles.PROFILE_LVL3_FONT);
        streetAndIdLabel = new JLabel(text.getString("streetString"));
        streetAndIdLabel.setFont(Styles.PROFILE_LVL3_FONT);
        streetAndIdTextField = new JTextField();
        streetAndIdTextField.setFont(Styles.PROFILE_LVL3_FONT);
        zipLabel = new JLabel(text.getString("zipString"));
        zipLabel.setFont(Styles.PROFILE_LVL3_FONT);
        zipTextField = new JTextField();
        zipTextField.setFont(Styles.PROFILE_LVL3_FONT);
        cityLabel = new JLabel(text.getString("CityString"));
        cityLabel.setFont(Styles.PROFILE_LVL3_FONT);
        cityTextField = new JTextField();
        cityTextField.setFont(Styles.PROFILE_LVL3_FONT);
        emailLabel = new JLabel(text.getString("eMailString"));
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
        titleChangePswdLabel = new JLabel(text.getString("changePasswortText"));
        titleChangePswdLabel.setFont(Styles.PROFILE_LVL2_FONT);

        currentPswdLabel = new JLabel(text.getString("currentPasswortText"));
        currentPswdLabel.setFont(Styles.PROFILE_LVL3_FONT);
        currentPswdField = new JPasswordField();
        newPswdLabel = new JLabel(text.getString("newPasswortText"));
        newPswdLabel.setFont(Styles.PROFILE_LVL3_FONT);
        newPswdField = new JPasswordField();
        confirmPswdLabel = new JLabel(text.getString("newPasswortAgainText"));
        confirmPswdLabel.setFont(Styles.PROFILE_LVL3_FONT);
        confirmPswdField = new JPasswordField();

        changePswdPanel.add(currentPswdLabel);
        changePswdPanel.add(currentPswdField);
        changePswdPanel.add(newPswdLabel);
        changePswdPanel.add(newPswdField);
        changePswdPanel.add(confirmPswdLabel);
        changePswdPanel.add(confirmPswdField);

        possibleErrorMessageLabel = new JLabel(errorMessage, SwingConstants.CENTER);
        possibleErrorMessageLabel.setFont(Styles.ERROR_MSG_FONT);
        possibleErrorMessageLabel.setForeground(Color.RED);

        rsscPanel = new JPanel(new GridLayout(1, 3, 140, 140));
        // Action buttons
        ImageIcon resetEntriesIcon = new ImageIcon(
                new ImageIcon("group5/src/main/resources/images/resetEntriesIcon.png").getImage().getScaledInstance(20,
                        20, Image.SCALE_SMOOTH));
        ImageIcon saveIcon = new ImageIcon(new ImageIcon("group5/src/main/resources/images/saveIcon.png").getImage()
                .getScaledInstance(20, 20, Image.SCALE_SMOOTH));
        ImageIcon saveAndCloseIcon = new ImageIcon(
                new ImageIcon("group5/src/main/resources/images/saveAndCloseIcon.png").getImage().getScaledInstance(20,
                        20, Image.SCALE_SMOOTH));

        ActionListener rsscListener = new ResetSaveCloseListener(this);
        resetEntriesButton = new JButton((text.getString("resetEntriesText")), resetEntriesIcon);
        resetEntriesButton.setFont(Styles.RSSC_BUTTON_FONT);
        resetEntriesButton.addActionListener(rsscListener);
        saveButton = new JButton((text.getString("saveString")), saveIcon);
        saveButton.setFont(Styles.RSSC_BUTTON_FONT);
        saveButton.addActionListener(rsscListener);
        saveAndCloseButton = new JButton((text.getString("saveAndCloseString")), saveAndCloseIcon);
        saveAndCloseButton.setFont(Styles.RSSC_BUTTON_FONT);
        saveAndCloseButton.addActionListener(rsscListener);

        rsscPanel.add(resetEntriesButton);
        rsscPanel.add(saveButton);
        rsscPanel.add(saveAndCloseButton);

        contentPanel.add(profileInfoTitleLabel);
        contentPanel.add(titlePersonalInfoLabel);
        contentPanel.add(personalInfoPanel);
        contentPanel.add(titleChangePswdLabel);
        contentPanel.add(changePswdPanel);
        contentPanel.add(possibleErrorMessageLabel);
        contentPanel.add(rsscPanel);

        this.add(contentPanel);
    }

    /**
     * besetzt die Defaullt-Eingabetexte auf die, aktuell in der Datenbank
     * verzeichneten, Daten ein.
     */
    public void setInitDBUsersData() {
        forenameTextField.setText(LogInCredentialsChecker.sessionUser.getForename());
        surnameTextField.setText(LogInCredentialsChecker.sessionUser.getSurname());
        streetAndIdTextField.setText(LogInCredentialsChecker.sessionUser.getStreet_nr());
        zipTextField.setText(String.valueOf(LogInCredentialsChecker.sessionUser.getZip()));
        cityTextField.setText(LogInCredentialsChecker.sessionUser.getCity());
        emailTextField.setText(LogInCredentialsChecker.sessionUser.getEmail());
    }

    /**
     * speichert die Eingaben, wenn Änderungsvalidität gegeben ist. Sonst wird eine
     * Fehlermeldung angezeigt.
     */
    public void saveEntriesOfTextFields() {
        if (isPswdChangeValid()) {
            LogInCredentialsChecker.sessionUser.setForename(forenameTextField.getText());
            LogInCredentialsChecker.sessionUser.setSurname(surnameTextField.getText());
            LogInCredentialsChecker.sessionUser.setStreet_nr(streetAndIdTextField.getText());
            LogInCredentialsChecker.sessionUser.setZip(Integer.parseInt(zipTextField.getText()));
            LogInCredentialsChecker.sessionUser.setCity(cityTextField.getText());
            LogInCredentialsChecker.sessionUser.setEmail(emailTextField.getText());
            if (!new String(newPswdField.getPassword()).equals("")) {
                LogInCredentialsChecker.sessionUser.setPassword(new String(newPswdField.getPassword()));
            }
            errorMessage = "";
            possibleErrorMessageLabel.setIcon(null);
            possibleErrorMessageLabel.setText(errorMessage);
        } else {
            errorMessage = text.getString("wrongCredentialsMessage");
            ImageIcon errorMsgIcon = new ImageIcon(new ImageIcon("group5/src/main/resources/images/errorIcon.png")
                    .getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
            possibleErrorMessageLabel.setIcon(errorMsgIcon);
            possibleErrorMessageLabel.setText(errorMessage);
        }
    }

    /**
     * prüft, ob eine angeforderte Passwortänderung valide ist.
     */
    public boolean isPswdChangeValid() {
        String currentPswd = new String(currentPswdField.getPassword());
        String newPswd = new String(newPswdField.getPassword());
        String confirmPswd = new String(confirmPswdField.getPassword());
        if (currentPswd.equals("") || newPswd.equals("") || confirmPswd.equals("")) {
            return true;
        }
        return currentPswd.equals(LogInCredentialsChecker.sessionUser.getPassword()) && newPswd.equals(confirmPswd);
    }

    /**
     * Getter-Methode für den Button zum Einträge-Reset
     * 
     * @return Button zum Einträge-Reset
     */
    public JButton getResetEntriesButton() {
        return resetEntriesButton;
    }

    /**
     * Getter-Methode für den Button zum Einträge-Speichern
     * 
     * @return Button zum Einträge-Speichern
     */
    public JButton getSaveButton() {
        return saveButton;
    }

    /**
     * Getter-Methode für den Button zum Einträge-Speichern und Schließen
     * 
     * @return Button zum Einträge-Speichern und Schließen
     */
    public JButton getSaveAndCloseButton() {
        return saveAndCloseButton;
    }

    /**
     * Getter-Methode für das Label zur möglichen Anzeige eines Fehlers
     * 
     * @return Label zur möglichen Anzeige eines Fehlers
     */
    public JLabel getPossibleErrorMessageLabel() {
        return possibleErrorMessageLabel;
    }

    /**
     * Getter-Methode für das Panel für die persönlichen Informationen
     * 
     * @return Panel für die persönlichen Informationen
     */
    public JPanel getPersonalInfoPanel() {
        return personalInfoPanel;
    }

    /**
     * Getter-Methode für das Panel für den inhaltlichen Teil
     * 
     * @return Panel für den inhaltlichen Teil
     */
    public JPanel getContentPanel() {
        return contentPanel;
    }

    /**
     * Getter-Methode für das Panel für die drei Beendigungsbuttons
     * 
     * @return Panel für die drei Beendigungsbuttons
     */
    public JPanel getRsscPanel() {
        return rsscPanel;
    }

    /**
     * Getter-Methode für das Panel für den "Passwort ändern"-Teil
     * 
     * @return Panel für den "Passwort ändern"-Teil
     */
    public JPanel getChangePswdPanel() {
        return rsscPanel;
    }

}