import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;

/**
 * Diese Klasse bietet einen zentralen Zugriffspunkt für diverse, einsetzbaren Style-Komponenten (z.B. Fonts, Farben, ...).
 * 
 * @author Sophie Orth, Monica Alessi, Dhruv Aggarwal, Maik Fichtenkamm, Lucas
 *         Lahr
 */
public class Styles {

    /**
     * Einsatzmöglichkeit: Font für Anwendungstitel
     * 
     * @return <code>appheading</code> oder <code>null</code>
     */
    public final static Font APPHEADING() {
        try {
            Font appheading = Font.createFont(Font.TRUETYPE_FONT, new File("Library/Calligraphy-D4pm.ttf"));
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(appheading);
            return appheading;
        } catch (IOException ioe) {
            ioe.getStackTrace();
        } catch (FontFormatException ffe) {
            ffe.getStackTrace();
        }
        return null;
    }

    /**
     * Einsatzmöglichkeit: Font für Navigationsleisten-Elemente
     */
    public final static Font NAVPANE_FONT = new Font("Serif", Font.BOLD, 24);
}