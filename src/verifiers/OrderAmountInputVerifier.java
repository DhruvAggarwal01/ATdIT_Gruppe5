package verifiers;


import javax.swing.*;

import panels.EditOrder;
import usedstrings.LogistikStrings;

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
            intInput.setBackground(java.awt.Color.RED);
            intInput.setText(LogistikStrings.getOnlyNumbersErrorMessage());
            EditOrder.setValidAmount(false);
            EditOrder.checkOrderValidity();
            return false;
        }
        if (num <= MAX && num >= MIN) {
            intInput.setBackground(java.awt.Color.WHITE);
            EditOrder.setValidAmount(true);
            EditOrder.checkOrderValidity();
            return true;
        }
        intInput.setBackground(java.awt.Color.RED);
        intInput.setText(LogistikStrings.getWrongAmountErrorMessage());
        EditOrder.setValidAmount(false);
        EditOrder.checkOrderValidity();
        return false;
    }
}