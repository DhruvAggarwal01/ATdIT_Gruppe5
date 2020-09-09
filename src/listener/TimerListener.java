package listener;

import java.awt.event.*;

/**
 * Diese Klasse tbd
 * 
 * @author Sophie Orth, Monica Alessi, Dhruv Aggarwal, Maik Fichtenkamm, Lucas
 *         Lahr
 */
public class TimerListener implements ActionListener {

    /**
     * Diese Methode tbd
     * 
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        counter %= images.length;
        diashowLabel.setIcon(images[counter++]);
    }
}
