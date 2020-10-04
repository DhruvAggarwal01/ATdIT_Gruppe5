package main;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.util.Objects;

import exceptions.NavItemNotFoundException;
import panels.*;

/**
 * Diese Klasse nimmt je nach ausgewähltem Tab ein anderes Panel als Tab an.
 * 
 * @author Sophie Orth, Monica Alessi, Dhruv Aggarwal, Maik Fichtenkamm, Lucas
 *         Lahr
 */
public class NavItemPanelChooser extends JPanel {

    private static final long serialVersionUID = 2503046166751075554L;

    private String navItemName01, navItemName02, navItemName03, panelExplorerTitle;

    /**
     * Konstruktor, der zum zugehörigen NavigationItem einen passenden JPanel
     * einsetzt
     * 
     * @param navItemName01 Navigationsitem auf Ebene 1
     * @param navItemName02 Navigationsitem auf Ebene 2
     * @param navItemName03 Navigationsitem auf Ebene 3
     */
    public NavItemPanelChooser(final String navItemName01, final String navItemName02, final String navItemName03) {
        this.navItemName01 = navItemName01;
        this.navItemName02 = navItemName02;
        this.navItemName03 = navItemName03;

        panelExplorerTitle = setPanelExplorerText();
        this.setBorder(new TitledBorder(BorderFactory.createLineBorder(Color.black), panelExplorerTitle,
                TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, Styles.TAB_BORDERTITLE_FONT));
        try {
            chooserFunctionality();
        } catch (NavItemNotFoundException nitfe) {
            String exceptionMessage = nitfe.getExceptionMessage();
            JOptionPane.showMessageDialog(new JFrame(), exceptionMessage, "Error: " + nitfe.getClass(),
                    JOptionPane.ERROR_MESSAGE);
            this.add(nitfe.getExceptionPanel(), BorderLayout.CENTER);
            this.setEnabled(false);
        }
    }

    /**
     * Setter-Methode für den Text des linken oberen Panel-Explorers. Ist eine
     * null-Referenz an eines der Explorer-Teile zugewiesen, so wird diese mit einem
     * leeren String ausgetauscht.
     * 
     * @param navItemName01 Navigationsitem auf Ebene 1
     * @param navItemName02 Navigationsitem auf Ebene 2
     * @param navItemName03 Navigationsitem auf Ebene 3
     * 
     * @return Panel-Explorer-Text
     */
    public String setPanelExplorerText() {
        String isNext1 = " > ";
        String isNext2 = " > ";
        if (navItemName03 == null || navItemName03 == "") {
            navItemName03 = "";
            isNext2 = "";
            if (navItemName02 == null || navItemName02 == "") {
                navItemName02 = "";
                isNext1 = "";
                if (navItemName01 == null) {
                    navItemName01 = "";
                }
            }
        }

        return (navItemName01 + isNext1 + navItemName02 + isNext2 + navItemName03);
    }

    /**
     * Diese Methode ist dafür zuständig aus den verschiedenen Panels je nach
     * Nutzerwunsch den Richtigen auszuwählen und selbst anzunehmen.
     * 
     * @param navItemName01 Navigationsitem auf Ebene 1
     * @param navItemName02 Navigationsitem auf Ebene 2
     * @param navItemName03 Navigationsitem auf Ebene 3
     */
    public void chooserFunctionality() throws NavItemNotFoundException {
        switch (navItemName01) {
            case "Overview":
                switch (navItemName02) {
                    case "":
                        this.setLayout(new BorderLayout());
                        this.add(new OverviewPanel(), BorderLayout.CENTER);
                        break;
                    case "Reporting":
                        this.setLayout(new BorderLayout());
                        this.add(new ReportingPanel(), BorderLayout.CENTER);
                        break;
                    default:
                        break;
                }
                break;
            case "ToDo's":
                break;
            case "Produktion":
                this.setLayout(new BorderLayout());
                this.add(new ProduktionPanel(), BorderLayout.CENTER);
                break;
            case "Betriebsmittel":
                break;
            case "HR":
                break;
            case "Genehmigungen":
                break;
            case "Logistik":
                switch (navItemName02) {
                    case "":
                        this.setLayout(new BorderLayout());
                        this.add(new LogistikPanel(false), BorderLayout.CENTER);
                        break;
                    case "DisplayAll":
                        this.setLayout(new BorderLayout());
                        this.add(new LogistikPanel(true), BorderLayout.CENTER);
                        break;
                    case "EditOrder":
                        this.setLayout(new BorderLayout());
                        this.add(new EditOrder(false), BorderLayout.CENTER);
                        break;
                    case "ShowOrder":
                        this.setLayout(new BorderLayout());
                        this.add(new ShowOrder(), BorderLayout.CENTER);
                        break;
                    case "CreateOrder":
                        this.setLayout(new BorderLayout());
                        this.add(new EditOrder(true), BorderLayout.CENTER);
                        break;
                    default:
                        break;
                }
                break;
            default:
                throw new NavItemNotFoundException(navItemName01, navItemName02, navItemName03);
        }
    }

    /* ----- Overriding zum möglichen Vergleich zweier NavItemPanelChooser ------ */
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(final Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final NavItemPanelChooser navIPC = (NavItemPanelChooser) obj;
        return Objects.equals(navItemName01, navIPC.navItemName01)
                && Objects.equals(navItemName02, navIPC.navItemName02)
                && Objects.equals(navItemName03, navIPC.navItemName03);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() { // wird
        return Objects.hash(navItemName01, navItemName02, navItemName03);
    }

    
    /**
     * Getter-Methode für den Panel-Explorer-Titel
     * 
     * @return Panel-Explorer-Titel
     */
    public String getPanelExplorerTitle() {
        return panelExplorerTitle;
    }
}