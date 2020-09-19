package verifiers;
import usedstrings.LogistikStrings;
import javax.swing.*;
import java.awt.*;

public class OrderAmountInputVerifier extends InputVerifier {
    
    final int MIN = 0;
    final int MAX = 1000;

    @Override
    public boolean verify(final JComponent input) {
        final JTextField intInput = (JTextField) input;
        final String text = intInput.getText();
        int num;
        try {
            num = Integer.parseInt(text);
        } catch (final NumberFormatException e) {
            intInput.setBackground(Color.RED);
            intInput.setText(LogistikStrings.getonlyNumbersErrorMessage());
            return false;
        }
        if (num <= MAX && num >= MIN){
            intInput.setBackground(Color.WHITE);
            return true;}  
        intInput.setBackground(Color.RED);
        intInput.setText(LogistikStrings.getwrongAmountErrorMessage());
        return false;
    }
}