package verifiers;


import javax.swing.*;

import panels.EditOrder;
import usedstrings.LogistikStrings;

public class OrderStringVerifier extends InputVerifier {

    @Override
    public boolean verify(final JComponent input) {
        final JTextField firmInput = (JTextField) input;
        final String firmName = firmInput.getText();
        final char[] chars = firmName.toCharArray();

        for (final char c : chars) {
            if (!Character.isLetter(c)) {
                firmInput.setBackground(java.awt.Color.RED);
                firmInput.setText(LogistikStrings.getInvalidNameErrorMessae());
                EditOrder.setValidFirmName(false);
                EditOrder.checkOrderValidity();
                return false;
            }
        }
        firmInput.setBackground(java.awt.Color.WHITE);
        EditOrder.setValidFirmName(true);
        EditOrder.checkOrderValidity();
        return true;
    }

}
