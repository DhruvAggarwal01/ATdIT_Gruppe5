package listener;

import java.awt.event.*;

import main.LoginButtonPanel;

/**
 * stellt die Funktionalität in Form eines Listeners zur Verfügung, um einen
 * Tastendruck im Login-Screen zu verarbeiten.
 * 
 * @author Sophie Orth, Monica Alessi, Dhruv Aggarwal, Maik Fichtenkamm, Lucas
 *         Lahr
 */
public class LoginKeyListener implements KeyListener {

    private final LoginButtonPanel loginButtonPanelView;

    /**
     * Konstruktor, der eine Referenz auf die Instanz des
     * <code>LoginButtonPanel</code> mithilfe des Parameters herstellt, um damit
     * weiterzuarbeiten.
     * 
     * @param loginButtonPanelView Instanz von <code>LoginButtonPanel</code>
     */
    public LoginKeyListener(LoginButtonPanel loginButtonPanelView) {
        this.loginButtonPanelView = loginButtonPanelView;
    }

    /**
     * wird hier nicht genutzt, muss jedoch verpflichtend implementiert werden.
     */
    @Override
    public void keyTyped(KeyEvent e) {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            loginButtonPanelView.getLoginButton().doClick();
        }
    }

    /**
     * wird hier nicht genutzt, muss jedoch verpflichtend implementiert werden.
     */
    @Override
    public void keyReleased(KeyEvent e) {
    }

}
