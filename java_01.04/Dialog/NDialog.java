


import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Point;

/**
 * Extension of AWT's Dialog class including information about the client. 
 * @author
 * @version 1.0
 */
public class NDialog extends Dialog{
    /**
     * Instance of the class (client) that create this dialog. 
     */
    protected DialogClient client;
    
    /**
     * constructor, takes in reference to client
     * @param frame same as AWT's Dialog 
     * @param title same as AWT's Dialog 
     * @param client instance of the client.
     * @param modal same as AWT's Dialog 
     */
    public NDialog(Frame frame, String title, DialogClient client,
            boolean modal) {
        super(frame, title, modal);
        this.client = client;
    }

    /**
     * Method to change the client construction if required.
     * @param client new client to be assigned.
     */
    public void setClient(DialogClient client) {
        this.client = client;
    }
    
    @Override
    public void show() {
        
        Dimension frameSiz = getParent().size();
        Point frameLoc = getParent().location();
        Dimension mySize = size();
        int x, y;
        
        x = frameLoc.x + (frameSiz.width/2) - (mySize.width/2);
        y = frameLoc.y + (frameSiz.height/2) - (mySize.height/2);
        
        reshape(x, y, size().width, size().height);
        
        super.show();
        
    }
    
    
}
