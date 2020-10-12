package exceptions;

import java.awt.*;
import javax.swing.*;

import main.Styles;

/**
 * Diese Klasse tbd
 * 
 * @author Sophie Orth, Monica Alessi, Dhruv Aggarwal, Maik Fichtenkamm, Lucas
 *         Lahr
 */
public abstract class AbstractCustomException extends Exception {

    private static final long serialVersionUID = -6592272596211461816L;

    /**
     * 
     * @return
     */
    public abstract String getExceptionMessage();

    /**
     * 
     * @return
     */
    public JPanel getExceptionPanel() {
        JPanel exceptionPanel = new JPanel(new BorderLayout());

        ImageIcon errorMsgIcon = new ImageIcon(new ImageIcon("Library/images/errorIcon.png").getImage()
                .getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH));
        String errorStackTrace = "";
        StackTraceElement[] stack = this.getStackTrace();
        for (StackTraceElement line : stack) {
            errorStackTrace += line.toString();
            errorStackTrace += "\n";
        }
        JTextArea errorTraceTextArea = new JTextArea(errorStackTrace);
        errorTraceTextArea.setFont(Styles.ERROR_STACKTRACE_FONT);
        errorTraceTextArea.setRows(7);
        JScrollPane errorTraceScrollPane = new JScrollPane(errorTraceTextArea);

        exceptionPanel.add(new JLabel(getExceptionMessage(), errorMsgIcon, SwingUtilities.CENTER), BorderLayout.NORTH);
        exceptionPanel.add(errorTraceScrollPane);

        return exceptionPanel;
    }

}