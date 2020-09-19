package verifiers;
import usedstrings.LogistikStrings;
import javax.swing.*;
import java.awt.*;

public class OrderStringVerifier extends InputVerifier {

    @Override
    public boolean verify(JComponent input) {
        JTextField firmInput = (JTextField) input;
        String firmName = firmInput.getText();
        char[] chars = firmName.toCharArray();

        for (char c : chars) {
            if(!Character.isLetter(c)) {
                firmInput.setBackground(Color.RED);
                firmInput.setText(LogistikStrings.getonlyNumbersErrorMessage());
                return false;
            }
        }
        firmInput.setBackground(Color.WHITE);
        return true;
    }
       
}
