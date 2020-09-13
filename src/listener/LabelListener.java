package listener;

import java.awt.*;
import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import subpanels.*;
import subpanels.Rectangle;

/**
 * Klasse, die von KeyAdapter erbt und ein Listener darstellt. Wenn die Taste N
 * gedrückt wird in QuarryMap, soll man beliebig viele Notizen anlegen können
 * 
 * @author Sophie Orth, Monica Alessi, Dhruv Aggarwal, Maik Fichtenkamm, Lucas
 *         Lahr
 */
public class LabelListener extends KeyAdapter {

    private static int count = 0;
    private QuarryMap view;
    private JPanel panel;

    /**
     * Konstruktor, der den Listener erzeugt und die Variablen initialisiert
     * 
     * @param quarryMapLabels das Panel mit den JTextAreas
     * @param view            das Panel mit der QuarryMap vom Steinbruch
     */
    public LabelListener(QuarryMapLabels quarryMapLabels, QuarryMap view) {
        this.view = view;
        panel = quarryMapLabels.getPanel();

    }

    /**
     * Diese Methode ist zuständig dafür, wenn die Taste N gedrückt wird, dass dann:
     * 1: die Koordinaten von der Mouse gespeichert werden und mit diesen
     * Koordinaten ein Rechteck erzeugt werden. Diese Rechtecke sollen in einer
     * Liste gespeichert werden, welche die Klasse <code>QuarryMap</code> enthält.
     * 2: eine JTextArea erzeugt wird und diese dem richtigen Panel hinzugefügt
     * werden.
     */
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_N) {
            PointerInfo pi = MouseInfo.getPointerInfo();
            Point p = pi.getLocation();
            Rectangle r = new Rectangle(p);

            view.getList().add(r);
            createLabels();

        }

    }

    /**
     * Erstellt die JTextArea mit den richtigen Eigenschaften und fügt sie dem
     * JPanel panelLabels von QuarryMapLabels dazu
     */
    public void createLabels() {
        JTextArea textarea = new JTextArea("Standort " + (++count) + ":");
        textarea.setBorder(BorderFactory.createEtchedBorder());
        textarea.setLineWrap(true);
        textarea.setWrapStyleWord(true);
        panel.add(textarea);
        panel.revalidate();

    }
}
