package listener;

import java.awt.event.*;

import main.LoginButtonPanel;

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
     * 
     */
    @Override
    public void keyTyped(KeyEvent e) {

    }

    /**
     * 
     */
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            loginButtonPanelView.getLoginButton().doClick();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}
