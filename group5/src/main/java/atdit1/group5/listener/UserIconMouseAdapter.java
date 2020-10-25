package atdit1.group5.listener;

import java.awt.event.*;
import javax.swing.*;

import atdit1.group5.db_interaction.LogInCredentialsChecker;
import atdit1.group5.mainclasses.HeaderPanel;

/**
 * dient dem Anzeigen eines Welcome-Elements als Menüpunkt, während der Benutzer
 * die Maus auf dem User-Icon platziert hat.
 * 
 * @author Sophie Orth, Monica Alessi, Dhruv Aggarwal, Maik Fichtenkamm, Lucas
 *         Lahr
 */
public class UserIconMouseAdapter extends MouseAdapter {

    private final HeaderPanel headerPanelView;

    /**
     * stellt eine Referenz auf die Instanz des <code>HeaderPanel</code> mithilfe
     * des Parameters her, um damit weiterzuarbeiten.
     * 
     * @param headerPanelView Instanz von <code>HeaderPanel</code>
     */
    public UserIconMouseAdapter(HeaderPanel headerPanelView) {
        this.headerPanelView = headerPanelView;
    }

    /**
     * setzt den ersten Menüpunkt mit einer Welcome-Nachricht, wenn der Benutzer mit
     * der Maus die Komponente "betritt".
     * 
     * @param e eingetretenes Event
     */
    @Override
    public void mouseEntered(MouseEvent e) {
        headerPanelView
                .setWelcomeItem(new JMenuItem("<HTML><U>Hallo " + LogInCredentialsChecker.sessionUser.getForename()
                        + " " + LogInCredentialsChecker.sessionUser.getSurname() + "!</U></HTML>"));
        headerPanelView.getWelcomeItem().setEnabled(false);
        headerPanelView.getUserIconButton().add(headerPanelView.getWelcomeItem(), 0);
    }

    /**
     * entfernt den ersten Menüpunkt, wenn der Benutzer mit der Maus die Komponente
     * "verlässt".
     * 
     * @param e eingetretenes Event
     */
    @Override
    public void mouseExited(MouseEvent e) {
        headerPanelView.getUserIconButton().remove(headerPanelView.getWelcomeItem());
    }

}
