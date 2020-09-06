package subpanels;

import java.net.*;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.io.*;

import main.MainPanel;
import main.NavItemPanelChooser;
import main.Styles;

/**

 */
public class AtRiskPanel extends JPanel {

    private static final long serialVersionUID = -7427825579667861982L;

    /**

     */
    public AtRiskPanel(String onTimeTitle) {
        this.setLayout(new BorderLayout());
        this.setBackground(Color.YELLOW);

        JLabel onTimeLabel = new JLabel(onTimeTitle);
        onTimeLabel.setFont(Styles.SUBPANEL_TITLE_FONT);
        onTimeLabel.setForeground(Color.BLUE.darker());
        onTimeLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        onTimeLabel.setToolTipText("These Ordes are at Risk of delivering on Time!");
        onTimeLabel.setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 0));
        onTimeLabel.addMouseListener(new MouseAdapter() {

        });
        this.add(onTimeLabel, BorderLayout.NORTH);

        this.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(5, 0, 0, 5),
                BorderFactory.createRaisedBevelBorder()));
    }

    /**
     
     */
    class MouseClickListener extends MouseAdapter {

        /**
       
         */
   

    }
}