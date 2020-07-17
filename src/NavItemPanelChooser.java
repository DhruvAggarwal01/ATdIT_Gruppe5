import javax.swing.*;
import java.awt.*;

public class NavItemPanelChooser extends JPanel {

    private static final long serialVersionUID = 2503046166751075554L;

    NavItemPanelChooser(String navItemName) {
        this.setLayout(new FlowLayout());
        this.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black),
                navItemName + " > Xxx1 > Xxx2")); // der Pfad muss eine Referenz zur aufgerufen Panel haben! --> nicht
                                            // hartkodiert!
        switch (navItemName) {
            case "Overview":
                // this.add(new XxxJPanel()); //tbd
                break;
            case "ToDo's":
                break;
            case "Produktion":
                break;
            default:
                break;
        }
    }
}