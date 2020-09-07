package subpanels;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import main.Styles;

import java.awt.*;
import java.awt.event.*;

/**
 * Diese Klasse baut ein Panel auf, das es ermöglicht eine Auswahl an Bildern
 * (Ausschnitten) als Sneak-Peek durchlaufen zu lassen.
 * 
 * @author Sophie Orth, Monica Alessi, Dhruv Aggarwal, Maik Fichtenkamm, Lucas
 *         Lahr
 */
public class DiashowPanel extends JPanel {

    private static final long serialVersionUID = 5722480908754773180L;

    private int counter = 1;
    private ImageIcon[] images = new ImageIcon[4];
    private JLabel diashowLabel;

    /**
     * Konstruktor, der tbd
     * 
     * @param diashowTitle Diashow-Titel
     */
    public DiashowPanel(String diashowTitle) {
        this.setLayout(new BorderLayout());

        JLabel diashowTitleLabel = new JLabel(diashowTitle);
        diashowTitleLabel.setFont(Styles.SUBPANEL_TITLE_FONT);
        diashowTitleLabel.setHorizontalAlignment(JLabel.CENTER);
        diashowTitleLabel.setForeground(Color.BLUE.darker());
        diashowTitleLabel.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));

        for (int i = 0; i < images.length; i++) {
            images[i] = new ImageIcon(new ImageIcon("Library/images/DiashowPic" + (i + 1) + ".jpg").getImage()
                    .getScaledInstance(500, 120, java.awt.Image.SCALE_SMOOTH));
        }

        diashowLabel = new JLabel(images[0]);
        diashowLabel.setHorizontalAlignment(JLabel.CENTER);

        Timer timer = new Timer(4000, new TimerListener());
        timer.start();

        this.add(diashowTitleLabel, BorderLayout.NORTH);
        this.add(diashowLabel, BorderLayout.CENTER);

        this.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(5, 20, 20, 20),
                BorderFactory.createRaisedBevelBorder()));
    }

    /**
     * Innere Klasse, die tbd
     */
    class TimerListener implements ActionListener {

        /**
         * Diese Methode tbd
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            counter %= images.length;
            diashowLabel.setIcon(images[counter++]);
        }
    }

}