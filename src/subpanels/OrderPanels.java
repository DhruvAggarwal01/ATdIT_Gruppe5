package subpanels;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import main.Styles;
import main.MainPanel;
import main.NavItemPanelChooser;

import db_interaction.DBOrdersExtractor;

import db_interaction.Order;
/**

 */
public class OrderPanels extends JPanel {

    private static final long serialVersionUID = -7427825579667861982L;

    /**
    
     */
    public OrderPanels(String Title, String ToolTip, Integer rgbRed, Integer rgbGreen, Integer rgbBlue) {
        this.setLayout(new GridLayout(8, 0, 10, 10));
        this.setBackground(new Color(rgbRed, rgbGreen, rgbBlue));

        JLabel onTimeLabel = new JLabel(Title);
        onTimeLabel.setFont(Styles.SUBPANEL_TITLE_FONT2);
        onTimeLabel.setForeground(Color.BLACK);
        onTimeLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        onTimeLabel.setToolTipText(ToolTip);
        onTimeLabel.setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 0));
        onTimeLabel.addMouseListener(new MouseAdapter() {
        });
        this.add(onTimeLabel);
        // anstatt 5 objekarray.length aus db
        for (int i = 0; i < 5; i++) {
            JPanel labelID = new JPanel();
            MouseClickListener mouseCL = new MouseClickListener();
            labelID.addMouseListener(mouseCL);
            labelID.setBackground(new Color(rgbRed - 75, rgbGreen - 75, rgbBlue - 75));
            labelID.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5),
                    BorderFactory.createRaisedBevelBorder()));
            JLabel labelID2 = new JLabel("label" + i);
            labelID.add(labelID2);
            this.add(labelID);

        }

        this.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5),
                BorderFactory.createRaisedBevelBorder()));

   }
    class MouseClickListener extends MouseAdapter {
            public void changeColor(Object a) {
                JPanel theLabel = (JPanel) a;
                Color color =  theLabel.getBackground();
                Integer  r1 = color.getRed()+30 ;
                Integer g1 =  color.getGreen() +30;
                Integer b1 =  color.getBlue()+30;
                theLabel.setBackground(new Color(r1, g1, b1));
                    };
                    public void changeColor2(Object a) {
                        JPanel theLabel = (JPanel) a;
                        Color color =  theLabel.getBackground();
                        Integer  r1 = color.getRed()-30;
                        Integer g1 =  color.getGreen()-30;
                        Integer b1 =  color.getBlue()-30;
                        theLabel.setBackground(new Color(r1, g1, b1));
                            };

        /**
         * Diese Methode tbd
         */
        @Override
        public void mouseClicked(MouseEvent e) {
            MainPanel.getNavPane().setComponentAt(6, new NavItemPanelChooser("Logistik", "EditOrder", null));
        }
        @Override
        public void mouseEntered(MouseEvent e) {
            this.changeColor(e.getSource());
        }
        @Override
        public void mouseExited(MouseEvent e) {
            this.changeColor2(e.getSource());
        }
 
 
  
    }

}