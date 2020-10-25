package atdit1.group5.exceptions;

import java.awt.*;
import javax.swing.*;

import atdit1.group5.styles.Styles;

/**
 * baut eine abstrakte Custom-Exception für die Steinbruch-Anwendung auf.
 * 
 * @author Sophie Orth, Monica Alessi, Dhruv Aggarwal, Maik Fichtenkamm, Lucas
 *         Lahr
 */
public abstract class AbstractCustomException extends Exception {

    private static final long serialVersionUID = -6592272596211461816L;

    /**
     * gibt die Exception-Nachricht zurück.
     * 
     * @return Exception-Nachricht
     */
    public abstract String getExceptionMessage();

    /**
     * baut ein JPanel für die Exception auf und gibt diesen für die weitere
     * Verarbeitung zurück.
     * 
     * @return JPanel für die Exception
     */
    public JPanel getExceptionPanel() {
        JPanel exceptionPanel = new JPanel(new BorderLayout());

        ImageIcon errorMsgIcon = new ImageIcon(
                new ImageIcon("group5/src/main/resources/images/errorIcon.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
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