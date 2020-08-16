package panels;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import main.MainPanel;
import main.NavItemPanelChooser;
import subpanels.DiashowPanel;
import subpanels.ReadRSSPanel;
import subpanels.WeatherPanel;

public class OverviewPanel extends JPanel {

    private static final long serialVersionUID = 1L;

    public OverviewPanel() {
        this.setLayout(new BorderLayout());

        JPanel smallPanels = new JPanel(new GridLayout(1, 2, 30, 30));

        // 1. Panel: News
        JPanel newsPanel = new ReadRSSPanel("Neueste Beiträge aus Albersweiler auf Wochenblatt Reporter",
                "https://www.wochenblatt-reporter.de/albersweiler/rss");
        // 2. Panel: Wetter
        JPanel weatherPanel = new WeatherPanel("Heutige Wetterdaten aus Albersweiler");
        // 3. Panel:
        JPanel diashow = new DiashowPanel("Impressionen vom Steinbruch");

        smallPanels.add(newsPanel);
        smallPanels.add(weatherPanel);

        this.add(smallPanels, BorderLayout.NORTH);
        this.add(diashow, BorderLayout.CENTER);

        // this.setLayout(new GridLayout(2, 2, 30, 30));
        // this.setBorder(
        // BorderFactory.createCompoundBorder(this.getBorder(),
        // BorderFactory.createEmptyBorder(10, 5, 5, 5)));

        // // 3. Panel:
        // JPanel jp3 = new JPanel();
        // JLabel jl3 = new JLabel("---zum Reporting < klick mich! >---",
        // JLabel.CENTER);
        // jp3.add(jl3, BorderLayout.CENTER);
        // MouseClickListener mCL = new MouseClickListener(this);
        // jp3.addMouseListener(mCL);
    }

    class MouseClickListener extends MouseAdapter {

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