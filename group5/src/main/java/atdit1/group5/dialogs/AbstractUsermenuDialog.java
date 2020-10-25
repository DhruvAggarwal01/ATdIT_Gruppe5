package atdit1.group5.dialogs;

import javax.swing.*;

/**
 * baut ein abstraktes Dialogfenster für das Userprofil in der
 * Steinbruch-Anwendung auf.
 * 
 * @author Sophie Orth, Monica Alessi, Dhruv Aggarwal, Maik Fichtenkamm, Lucas
 *         Lahr
 */
abstract class AbstractUsermenuDialog extends JDialog {

    private static final long serialVersionUID = 1L;

    private JFrame owner;

    /**
     * {@inheritDoc}
     * 
     * @param owner
     * @param title
     * @param modal
     */
    public AbstractUsermenuDialog(JFrame owner, String title, boolean modal) {
        super(owner, title, modal);
        this.owner = owner;

        dialogSettingsSet();
    }

    /**
     * stellt Dialogfenster ein.
     */
    public void dialogSettingsSet() {
        this.setSize((int) (owner.getWidth() * 0.8), (int) (owner.getHeight() * 0.8));
        this.setResizable(false);
        this.setLocationRelativeTo(owner);
    }

    /**
     * stellt Dialoginhalt ein.
     */
    abstract void contentSettingsSet();

}