package dialogs;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProfileDialog extends JDialog implements ActionListener {

    private static final long serialVersionUID = 1L;

    // private Container c;
    private JFrame appWindow;
    private String profileDialogTitle;

    private JLabel title;
    private JLabel name;
    private JTextField tname;
    private JLabel mno;
    private JTextField tmno;
    private JLabel gender;
    private JRadioButton male;
    private JRadioButton female;
    private ButtonGroup gengp;
    private JLabel dob;
    private JLabel add;
    private JTextArea tadd;
    private JCheckBox term;
    private JButton sub;
    private JButton saveAndCloseButton;
    private JTextArea tout;
    private JLabel res;
    private JTextArea resadd;

    public ProfileDialog(JFrame owner, String title, boolean modal) {
        super(owner, title, modal);
        appWindow = owner;
        profileDialogTitle = title;

        dialogSettingsSet();
        contentSettingsSet();

    }

    public void dialogSettingsSet() {
        this.setSize((int) (appWindow.getWidth() * 0.8), (int) (appWindow.getHeight() * 0.8));
        this.setResizable(false);
        this.setLocationRelativeTo(appWindow);
    }

    public void contentSettingsSet() {
        // c = getContentPane();

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createRaisedSoftBevelBorder(),
                BorderFactory.createTitledBorder(profileDialogTitle)));
        panel.setBackground(new Color(220, 220, 220));

        title = new JLabel("Registration Form");
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        title.setSize(300, 30);
        title.setLocation(300, 30);
        panel.add(title);

        name = new JLabel("Name");
        name.setFont(new Font("Arial", Font.PLAIN, 20));
        name.setSize(100, 20);
        name.setLocation(100, 100);
        panel.add(name);

        tname = new JTextField();
        tname.setFont(new Font("Arial", Font.PLAIN, 15));
        tname.setSize(190, 20);
        tname.setLocation(200, 100);
        panel.add(tname);

        mno = new JLabel("Mobile");
        mno.setFont(new Font("Arial", Font.PLAIN, 20));
        mno.setSize(100, 20);
        mno.setLocation(100, 150);
        panel.add(mno);

        tmno = new JTextField();
        tmno.setFont(new Font("Arial", Font.PLAIN, 15));
        tmno.setSize(150, 20);
        tmno.setLocation(200, 150);
        panel.add(tmno);

        gender = new JLabel("Gender");
        gender.setFont(new Font("Arial", Font.PLAIN, 20));
        gender.setSize(100, 20);
        gender.setLocation(100, 200);
        panel.add(gender);

        male = new JRadioButton("Male");
        male.setFont(new Font("Arial", Font.PLAIN, 15));
        male.setSelected(true);
        male.setSize(75, 20);
        male.setLocation(200, 200);
        panel.add(male);

        female = new JRadioButton("Female");
        female.setFont(new Font("Arial", Font.PLAIN, 15));
        female.setSelected(false);
        female.setSize(80, 20);
        female.setLocation(275, 200);
        panel.add(female);

        gengp = new ButtonGroup();
        gengp.add(male);
        gengp.add(female);

        dob = new JLabel("DOB");
        dob.setFont(new Font("Arial", Font.PLAIN, 20));
        dob.setSize(100, 20);
        dob.setLocation(100, 250);
        panel.add(dob);

        add = new JLabel("Address");
        add.setFont(new Font("Arial", Font.PLAIN, 20));
        add.setSize(100, 20);
        add.setLocation(100, 300);
        panel.add(add);

        tadd = new JTextArea();
        tadd.setFont(new Font("Arial", Font.PLAIN, 15));
        tadd.setSize(200, 75);
        tadd.setLocation(200, 300);
        tadd.setLineWrap(true);
        panel.add(tadd);

        term = new JCheckBox("Accept Terms And Conditions.");
        term.setFont(new Font("Arial", Font.PLAIN, 15));
        term.setSize(250, 20);
        term.setLocation(150, 400);
        panel.add(term);

        sub = new JButton("Save");
        sub.setFont(new Font("Arial", Font.PLAIN, 15));
        sub.setSize(100, 20);
        sub.setLocation(150, 450);
        // sub.addActionListener(this);
        panel.add(sub);

        saveAndCloseButton = new JButton("Save & Close");
        saveAndCloseButton.setFont(new Font("Arial", Font.PLAIN, 15));
        saveAndCloseButton.setSize(100, 20);
        saveAndCloseButton.setLocation(270, 450);
        saveAndCloseButton.addActionListener(this);
        panel.add(saveAndCloseButton);

        tout = new JTextArea();
        tout.setFont(new Font("Arial", Font.PLAIN, 15));
        tout.setSize(300, 400);
        tout.setLocation(500, 100);
        tout.setLineWrap(true);
        tout.setEditable(false);
        panel.add(tout);

        res = new JLabel("");
        res.setFont(new Font("Arial", Font.PLAIN, 20));
        res.setSize(500, 25);
        res.setLocation(100, 500);
        panel.add(res);

        resadd = new JTextArea();
        resadd.setFont(new Font("Arial", Font.PLAIN, 15));
        resadd.setSize(200, 75);
        resadd.setLocation(580, 175);
        resadd.setLineWrap(true);
        panel.add(resadd);

        this.add(panel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == saveAndCloseButton) {
            this.dispose();
        }
    }
}