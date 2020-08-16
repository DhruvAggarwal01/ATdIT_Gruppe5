package main;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import panels.OverviewPanel;

import java.awt.*;
import java.util.Objects;

/**
 * Je nach ausgewaehltem Tab wird ein anderer Panel (hier: JPanel) als Tab
 * gesetzt.
 * 
 * @author Sophie Orth, Monica Alessi, Dhruv Aggarwal, Maik Fichtenkamm, Lucas
 *         Lahr
 */
public class NavItemPanelChooser extends JPanel {

    private static final long serialVersionUID = 2503046166751075554L;

    private String navItemName01, navItemName02, navItemName03;

    /**
     * Konstruktor, der zum zugehörigen NavigationItem einen passenden JPanel
     * einsetzt
     * 
     * @param navItemName Name des ausgewaehlten Tabs (NavigationItem)
     */
    public NavItemPanelChooser(String navItemName01, String navItemName02, String navItemName03) {

        this.navItemName01 = navItemName01;
        this.navItemName02 = navItemName02;
        this.navItemName03 = navItemName03;

        String isNext1 = " > ";
        String isNext2 = " > ";
        if (navItemName03 == null) {
            navItemName03 = "";
            isNext2 = "";
            if (navItemName02 == null) {
                navItemName02 = "";
                isNext1 = "";
                if (navItemName01 == null) {
                    navItemName01 = "";
                }
            }
        }

        this.setBorder(new TitledBorder(BorderFactory.createLineBorder(Color.black),
                navItemName01 + isNext1 + navItemName02 + isNext2 + navItemName03, TitledBorder.DEFAULT_JUSTIFICATION,
                TitledBorder.DEFAULT_POSITION, Styles.TAB_BORDERTITLE_FONT)); // der Pfad muss eine Referenz zur
                                                                              // aufgerufen Panel haben! --> nicht
        // hartkodiert!
        switch (navItemName01) {
            case "Overview":
                switch (navItemName02) {
                    case "":
                        this.setLayout(new BorderLayout());
                        this.add(new OverviewPanel(), BorderLayout.CENTER);
                        break;
                    case "Reporting":
                        this.setLayout(new BorderLayout());
                        this.add(new JLabel("REPORTING tbd"), BorderLayout.CENTER); // tbd
                    default:
                        break;
                }
            case "ToDo's":
                break;
            case "Produktion":
                break;
            default:
                break;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        NavItemPanelChooser navIPC = (NavItemPanelChooser) obj;
        return Objects.equals(navItemName01, navIPC.navItemName01) && Objects.equals(navItemName02, navIPC.navItemName02)
                && Objects.equals(navItemName03, navIPC.navItemName03);
    }
}