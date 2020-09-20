package verifiers;

import javax.swing.*;

import usedstrings.LogistikStrings;

import java.awt.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class OrderDateVerifier extends InputVerifier {
    
        public long calculateTimeDiffrence() {
            final Calendar cal_1 = new GregorianCalendar();
            final Calendar cal_2 = new GregorianCalendar();
            cal_1.set(1997, Calendar.MARCH, 1, 0, 0, 0); // erster Zeitpunkt
            cal_2.set(1998, Calendar.APRIL, 2, 0, 0, 0); // zweiter Zeitpunkt
            final long time = cal_2.getTime().getTime() - cal_1.getTime().getTime(); // Differenz in ms
            final long days = Math.round((double) time / (24. * 60. * 60. * 1000.)); // Differenz in Tagen
            System.out.println("Zeit-Differenz in Tagen: " + days);

            final long dayDiffrence = days;
            return dayDiffrence;
        }

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
            intInput.setText(LogistikStrings.getInvalidNameErrorMessae());
            return false;
        }
        if (num <= MAX && num >= MIN){
              intInput.setText("Amount cannot be more than 1000t");
            return true;}
        return false;
    }
}
