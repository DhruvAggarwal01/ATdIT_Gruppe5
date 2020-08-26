package dialogs;

import javax.swing.JSpinner;
import javax.swing.JToggleButton;

// import javax.swing.UIManager;
// import javax.swing.UnsupportedLookAndFeelException;

/**
 * 
 */
public class SettingsDialog {

    JToggleButton themeToggle;
    JSpinner timeoutDelay;      //SpinnerModel sm = new SpinnerNumberModel(0, 0, 100, 1); //default value,lower bound,upper bound,increment by
    
    public SettingsDialog(){
        //let user set the theme, user inactivity dispose after time
        
        // try {
        //     // tbd: theme setting in JDialog, possible to set by user
        //     // UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel"); 
        //     // UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
        //     // UIManager.setLookAndFeel("com.sun.java.swing.plaf.mac.MacLookAndFeel");
        //     // UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        // } catch (UnsupportedLookAndFeelException e) {
        //     // handle exception
        // } catch (ClassNotFoundException e) {
        //     // handle exception
        // } catch (InstantiationException e) {
        //     // handle exception
        // } catch (IllegalAccessException e) {
        //     // handle exception
        // }
    }
}