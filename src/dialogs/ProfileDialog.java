package dialogs;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 
 */
public class ProfileDialog extends JDialog implements ActionListener {

    private static final long serialVersionUID = 1L;

    // private Container c;
    private JFrame appWindow;
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

    JPanel rsscPanel;
    private JButton resetEntriesButton;
    private JButton saveButton;
    private JButton saveAndCloseButton;

    /**
     * 
     */
    public ProfileDialog(JFrame owner, String title, boolean modal) {
        super(owner, title, modal);
        appWindow = owner;
        profileDialogTitle = title;

        dialogSettingsSet();
        contentSettingsSet();

    }

    /**
     * 
     */
    public void dialogSettingsSet() {
        this.setSize((int) (appWindow.getWidth() * 0.8), (int) (appWindow.getHeight() * 0.8));
        this.setResizable(false);
        this.setLocationRelativeTo(appWindow);
    }

    /**
     * 
     */
    public void contentSettingsSet() {
        contentPanel = new JPanel(new GridLayout(6, 1));
        contentPanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createRaisedSoftBevelBorder(),
                BorderFactory.createTitledBorder(profileDialogTitle)));
        contentPanel.setBackground(new Color(220, 220, 220));

        personalInfoPanel = new JPanel(new GridLayout(6, 2));
        changePswdPanel = new JPanel(new GridLayout(3, 2));

        profileInfoTitleLabel = new JLabel("PROFILE INFORMATION");

        titlePersonalInfoLabel = new JLabel("Personal Information");
        forenameLabel = new JLabel("First Name");
        forenameTextField = new JTextField();
        surnameLabel = new JLabel("Last Name");
        surnameTextField = new JTextField();
        streetAndIdLabel = new JLabel("Street, Id.");
        streetAndIdTextField = new JTextField();
        zipLabel = new JLabel("ZIP");
        zipTextField = new JTextField();
        cityLabel = new JLabel("City");
        cityTextField = new JTextField();
        emailLabel = new JLabel("E-mail");
        emailTextField = new JTextField();

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

        titleChangePswdLabel = new JLabel("Change Password");
        currentPswdLabel = new JLabel("Current Password");
        currentPswdField = new JPasswordField();
        newPswdLabel = new JLabel("New Password");
        newPswdField = new JPasswordField();
        confirmPswdLabel = new JLabel("Confirm Password");
        confirmPswdField = new JPasswordField();

        changePswdPanel.add(currentPswdLabel);
        changePswdPanel.add(currentPswdField);
        changePswdPanel.add(newPswdLabel);
        changePswdPanel.add(newPswdField);
        changePswdPanel.add(confirmPswdLabel);
        changePswdPanel.add(confirmPswdField);

        ImageIcon resetEntriesIcon = new ImageIcon(new ImageIcon("Library/images/resetEntriesIcon.png").getImage()
                .getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH));
        ImageIcon saveIcon = new ImageIcon(new ImageIcon("Library/images/saveIcon.png").getImage().getScaledInstance(20,
                20, java.awt.Image.SCALE_SMOOTH));
        ImageIcon saveAndCloseIcon = new ImageIcon(new ImageIcon("Library/images/saveAndCloseIcon.png").getImage()
                .getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH));

        rsscPanel = new JPanel(new GridLayout(1, 3, 10, 10));
        resetEntriesButton = new JButton("Reset Entries", resetEntriesIcon);
        saveButton = new JButton("Save", saveIcon);
        saveAndCloseButton = new JButton("Save & Close", saveAndCloseIcon);
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