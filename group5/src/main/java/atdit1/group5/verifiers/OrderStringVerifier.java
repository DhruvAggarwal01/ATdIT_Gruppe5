package atdit1.group5.verifiers;

import java.awt.*;
import javax.swing.*;
import java.util.ResourceBundle;

import atdit1.group5.panels.EditOrder;

public class OrderStringVerifier extends InputVerifier {

    private ResourceBundle text;

    @Override
    public boolean verify(final JComponent input) {
        this.text = ResourceBundle.getBundle(("i18n/logistik_panels/LogistikStrings"));
        final JTextField firmInput = (JTextField) input;
        final String firmName = firmInput.getText();
        final char[] chars = firmName.toCharArray();

        for (final char c : chars) {
            if (!Character.isLetter(c)) {
                firmInput.setBackground(Color.RED);
                firmInput.setText(text.getString("invalidNameErrorMessae"));
                EditOrder.setValidFirmName(false);
                EditOrder.checkOrderValidity();
                return false;
            }
        }
        firmInput.setBackground(Color.WHITE);
        EditOrder.setValidFirmName(true);
        EditOrder.checkOrderValidity();
        return true;
    }

}
