package subpanels;

import javax.swing.*;

import listener.TimerListener;
import main.Styles;

import java.awt.*;
import java.awt.event.*;

/**
 * Diese Klasse baut ein Panel auf, das es ermöglicht eine Auswahl an Bildern
 * (Ausschnitten) als "Sneak-Peeks" durchlaufen zu lassen.
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

    /**
     * Konstruktor, der die Einstellungen des UI und eigentlichen
     * Diashow-Funktionalität aufbaut.
     * 
     * @param diashowTitle Diashow-Titel
     */
    public DiashowPanel(String diashowTitle) {
        this.diashowTitle = diashowTitle;
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

        ActionListener tListener = new TimerListener(this);
        Timer timer = new Timer(4000, tListener);
        timer.start();

        this.add(diashowTitleLabel, BorderLayout.NORTH);
        this.add(diashowLabel, BorderLayout.CENTER);

        this.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(5, 20, 20, 20),
                BorderFactory.createRaisedBevelBorder()));
    }

    /* ----------------------- Getter/Setter-Methoden --------------------------- */
    public int getCounter() {
        return this.counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public ImageIcon[] getImages() {
        return this.images;
    }

    public String getTitlePanel() {
        return diashowTitle;
    }

    public JLabel getDiashowLabel() {
        return this.diashowLabel;
    }
}