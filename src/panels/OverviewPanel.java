package panels;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import main.MainPanel;
import main.NavItemPanelChooser;
import subpanels.ReadRSSPanel;

public class OverviewPanel extends JPanel {

    private static final long serialVersionUID = 1L;

    public OverviewPanel() {
        this.setLayout(new GridLayout(2, 2, 30, 30));
        this.setBorder(BorderFactory.createCompoundBorder(this.getBorder(), BorderFactory.createEmptyBorder(10, 5, 5, 5)));

        JPanel newsPanel = new ReadRSSPanel("Neueste Beiträge aus Albersweiler auf Wochenblatt Reporter",
                "https://www.wochenblatt-reporter.de/albersweiler/rss");

        JLabel jp1 = new JLabel("WETTER API", JLabel.CENTER);
        MainPanel.getNavPane();
        JPanel jp2 = new JPanel();
        JLabel jl2 = new JLabel("---zum Reporting < klick mich! >---", JLabel.CENTER);
        jp2.add(jl2, BorderLayout.CENTER);
        MouseClickListener mCL = new MouseClickListener(this);
        jp2.addMouseListener(mCL);
        JLabel jp3 = new JLabel("TBD", JLabel.CENTER);

        this.add(newsPanel);
        this.add(jp1);
        this.add(jp2);
        this.add(jp3);
    }

    class MouseClickListener extends MouseAdapter{

        OverviewPanel oP;
    
        MouseClickListener(OverviewPanel oP) {
            this.oP = oP;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            MainPanel.getNavPane().setComponentAt(0, new NavItemPanelChooser("Overview", "Reporting", null));
        }
    
        @Override
        public void mouseEntered(MouseEvent e) {
            oP.setCursor(new Cursor(Cursor.HAND_CURSOR));
    
        }
    }

}