package exceptions;

import java.awt.*;
import javax.swing.*;

public abstract class AbstractCustomException extends Exception {

    private static final long serialVersionUID = -6592272596211461816L;

    public abstract String getExceptionMessage();

    public JPanel getExceptionPanel() {
        JPanel exceptionPanel = new JPanel(new BorderLayout());
        ImageIcon errorMsgIcon = new ImageIcon(new ImageIcon("Library/images/errorIcon.png").getImage()
                .getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH));
        exceptionPanel.add(new JLabel(getExceptionMessage(), errorMsgIcon, SwingUtilities.CENTER));
        return exceptionPanel;
    }

}