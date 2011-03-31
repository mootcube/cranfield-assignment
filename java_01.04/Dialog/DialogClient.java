

import java.awt.Dialog;

/**
 * Interface that should be implemented by classes that needes to be notified
 * whether dialog has been dismissed.
 * @author 
 * @version 1.0
 */
public interface DialogClient {
    
    /**
     * Executes an action when a dialog is dismissed.
     * @param d the dialog being dimissed.
     * @param arg useful information during dimissing process.
     */
    abstract public void dialogDimissed(Dialog d, Object arg);
}
