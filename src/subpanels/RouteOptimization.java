package subpanels;

import java.awt.*;
import javax.swing.*;

/**
 * Klasse, die das Panel für die Wegoptimierung erzeugt. In dieser Klasse sollen
 * später die Funktionalitäten für die Wegoptimierung implementiert werdne.
 * Diese sind NOCH NICHT realisiert worden!
 * 
 * @author Sophie Orth, Monica Alessi, Dhruv Aggarwal, Maik Fichtenkamm, Lucas
 *         Lahr
 */
public class RouteOptimization extends JPanel {

    private static final long serialVersionUID = 9126041066134832083L;

    /**
     * Durch überschreiben der paintComponent Methode kann man das Hintergrundbild,
     * welches vorher von der Library geholt wird, anzeigen lassen.
     */
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image backgroundImage = Toolkit.getDefaultToolkit()
                .getImage("Library/images/Wegoptimierung.jpg");
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        g.drawImage(backgroundImage, 0, 0, size.width / 100 * 80, size.height / 100 * 80, this);
    }

    /**
     * In der Uni haben wir den Algorithmus Dijkstra gelernt. Diesen könnte man zum
     * Beispiel als erstes versuchen für die Wegoptimierung zu benutzen (uns ist
     * bewusst, dass dieser nicht sehr effizient und es deutlich bessere gibt. Für
     * eine erste Version der Funktionalität könnte man diesen jedoch trotzdem
     * implementieren).
     * 
     * den Algorithmus von Deijkstra könnte man zum Beispiel so wie in dieser Quelle
     * implementieren, nur an unsere Funktionalität und unser Netz angepasst:
     * https://gist.github.com/heckenmann/6a42de6413efa815dff0
     */

}
