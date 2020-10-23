package listener;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * @author Sophie Orth, Monica Alessi, Dhruv Aggarwal, Maik Fichtenkamm, Lucas
 *         Lahr
 */
public class ResetInputFieldListener extends MouseAdapter {
    @Override
    public void mouseClicked(final MouseEvent e) {
        e.getSource();
        final JTextField mysource = (JTextField) e.getSource();
        final String fieldInputText = mysource.getText();
        switch (fieldInputText) {
            case "Field must only contain numbers":
                mysource.setText("");
                mysource.setBackground(Color.WHITE);
                break;
            case "Amount cannot be more than 1000t":
                mysource.setBackground(Color.WHITE);
                mysource.setText("");
                break;
            case "Field must only contain characters from the Alphabet":
                mysource.setText("");
                mysource.setBackground(Color.WHITE);
                break;
            case "0":
                mysource.setBackground(Color.WHITE);
                mysource.setText("");
                break;
            default:
                break;
        }
    }
}
