import java.awt.*;
import java.io.*;

public class Styles {
    public static Font APPHEADING() throws IOException, FontFormatException {
        Font appheading = Font.createFont(Font.TRUETYPE_FONT, new File("Library/Calligraphy-D4pm.ttf"));
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(appheading);
        return appheading;
    }
}