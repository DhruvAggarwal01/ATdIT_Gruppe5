package atdit1.group5.verifiers;

import java.awt.*;
import javax.swing.*;
import java.util.ResourceBundle;

import atdit1.group5.panels.EditOrder;

public class OrderAmountInputVerifier extends InputVerifier {

    private ResourceBundle text;

    final int MIN = 0;
    final int MAX = 1000;

    @Override
    public boolean verify(final JComponent input) {
        final JTextField intInput = (JTextField) input;
        final String inputtext = intInput.getText();
        int num;
        this.text = ResourceBundle.getBundle(("i18n/logistikStrings"));
        try {
            num = Integer.parseInt(inputtext);
        } catch (final NumberFormatException e) {
            intInput.setBackground(Color.RED);
            intInput.setText(text.getString("onlyNumbersErrorMessage"));
            EditOrder.setValidAmount(false);
            EditOrder.checkOrderValidity();
            return false;
        }
        if (num <= MAX && num >= MIN) {
            intInput.setBackground(Color.WHITE);
            EditOrder.setValidAmount(true);
            EditOrder.checkOrderValidity();
            return true;
        }
        intInput.setBackground(Color.RED);
        intInput.setText(text.getString("wrongAmountErrorMessage"));
        EditOrder.setValidAmount(false);
        EditOrder.checkOrderValidity();
        return false;
    }
}