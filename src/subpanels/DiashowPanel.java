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
 * 
 */
public class DiashowPanel extends JPanel {

    private static final long serialVersionUID = 5722480908754773180L;

    private int counter = 1;
    private ImageIcon[] image = new ImageIcon[4];
    private JLabel diashowLabel;

    /**
     * 
     */
    public DiashowPanel(String diashowTitle) {
        this.setLayout(new BorderLayout());

        JLabel diashowTitleLabel = new JLabel(diashowTitle);
        diashowTitleLabel.setFont(Styles.SUBPANEL_TITLE_FONT);
        diashowTitleLabel.setHorizontalAlignment(JLabel.CENTER);
        diashowTitleLabel.setForeground(Color.BLUE.darker());
        diashowTitleLabel.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));

        for (int i = 0; i < image.length; i++) {
            image[i] = new ImageIcon("Library/images/DiashowPic" + (i + 1) + ".jpg");
        }

        diashowLabel = new JLabel(image[0]);
        diashowLabel.setHorizontalAlignment(JLabel.CENTER);

        Timer timer = new Timer(4000, new TimerListener());
        timer.start();

        this.add(diashowTitleLabel, BorderLayout.NORTH);
        this.add(diashowLabel, BorderLayout.CENTER);

        this.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(5, 20, 20, 20),
                BorderFactory.createRaisedBevelBorder()));
    }

    /**
     * 
     */
    class TimerListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            counter %= image.length;
            diashowLabel.setIcon(image[counter++]);
        }
    }

}