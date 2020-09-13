package dialogs;

import javax.swing.*;

/**
 * @author Sophie Orth, Monica Alessi, Dhruv Aggarwal, Maik Fichtenkamm, Lucas
 *         Lahr
 */
abstract class AbstractUsermenuDialog extends JDialog {

    private static final long serialVersionUID = 1L;

    private JFrame owner;

    public AbstractUsermenuDialog(JFrame owner, String title, boolean modal) {
        super(owner, title, modal);
        this.owner = owner;

        dialogSettingsSet();
    }

    public void dialogSettingsSet() {
        this.setSize((int) (owner.getWidth() * 0.8), (int) (owner.getHeight() * 0.8));
        this.setResizable(false);
        this.setLocationRelativeTo(owner);
    }

    abstract void contentSettingsSet();

}