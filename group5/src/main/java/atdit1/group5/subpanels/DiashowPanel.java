package atdit1.group5.subpanels;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import atdit1.group5.listener.TimerListener;
import atdit1.group5.Styles;

/**
 * baut ein Panel auf, das es ermöglicht eine Auswahl an Bildern (Ausschnitten)
 * als "Sneak-Peeks" durchlaufen zu lassen.
 * 
 * @author Sophie Orth, Monica Alessi, Dhruv Aggarwal, Maik Fichtenkamm, Lucas
 *         Lahr
 */
public class DiashowPanel extends JPanel {

    private static final long serialVersionUID = 5722480908754773180L;

    private int counter = 0;
    private ImageIcon[] images = new ImageIcon[4];
    private JLabel diashowLabel;
    private String diashowTitle;
    private Timer timer;

    /**
     * baut die Einstellungen des UI und eigentlichen Diashow-Funktionalität auf.
     * 
     * @param diashowTitle Diashow-Titel
     */
    public DiashowPanel(String diashowTitle) {
        this.diashowTitle = diashowTitle;
        this.setLayout(new BorderLayout());
        this.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(5, 20, 20, 20),
                BorderFactory.createRaisedBevelBorder()));

        JLabel diashowTitleLabel = new JLabel(diashowTitle);
        diashowTitleLabel.setFont(Styles.SUBPANEL_TITLE_FONT);
        diashowTitleLabel.setHorizontalAlignment(JLabel.CENTER);
        diashowTitleLabel.setForeground(Color.BLUE.darker());
        diashowTitleLabel.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));

        for (int i = 0; i < images.length; i++) {
            images[i] = new ImageIcon(new ImageIcon("group5/src/main/resources/images/DiashowPic" + (i + 1) + ".jpg")
                    .getImage().getScaledInstance(500, 120, Image.SCALE_SMOOTH));
        }

        diashowLabel = new JLabel(images[0]);
        diashowLabel.setHorizontalAlignment(JLabel.CENTER);

        ActionListener tListener = new TimerListener(this);
        timer = new Timer(4000, tListener);
        timer.start();

        this.add(diashowTitleLabel, BorderLayout.NORTH);
        this.add(diashowLabel, BorderLayout.CENTER);
    }

    /**
     * Getter-Methode für den Diashowbilder-Zähler
     * 
     * @return Diashowbilder-Zähler
     */
    public int getCounter() {
        return this.counter;
    }

    /**
     * Setter-Methode für den Diashowbilder-Zähler
     * 
     * @param counter Diashowbilder-Zähler
     */
    public void setCounter(int counter) {
        this.counter = counter;
    }

    /**
     * Getter-Methode für das Diashowbilder-Array
     * 
     * @return Diashowbilder-Array
     */
    public ImageIcon[] getImages() {
        return this.images;
    }

    /**
     * Getter-Methode für den Diashowpanel-Title
     * 
     * @return Diashowpanel-Title
     */
    public String getDiashowTitle() {
        return diashowTitle;
    }

    /**
     * Getter-Methode für das Diashowlabel
     * 
     * @return Diashowlabel
     */
    public JLabel getDiashowLabel() {
        return this.diashowLabel;
    }

    /**
     * Getter-Methode für das Diashow-Timer
     * 
     * @return Diashow-Timer
     */
    public Timer getTimer() {
        return timer;
    }

}