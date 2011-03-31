


import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Dialog requesting the user for a username 
 * and a pasword and which will ilustrate the data flow in 
 * and out of the dialog.
 * @author
 * @version 1.0
 */
public class ConnectDialog extends NDialog implements ActionListener {
    
    private TextField username;
    private TextField password;
    
    private Button okButton;
    private Button cancelButton;
    
    private boolean wasCancelled;
    private DialogInfo info;
    
    public ConnectDialog(Frame frame, DialogClient client, String title,
            DialogInfo info){
        super(frame, title, client, true);
        this.info = info;
        
        Panel p1 = new Panel();
        p1.setLayout(new GridLayout(2,2));
        p1.add(new Label("Username: "));
        p1.add(username = new TextField(info.getUsername(), 8));
         p1.add(new Label("Password: "));
        p1.add(password = new TextField(info.getPassword(), 8));
        add("Center", p1);
        
        Panel p2 = new Panel();
        p2.add(okButton = new Button("OK"));
        p2.add(cancelButton = new Button("Cancel"));
        add("South", p2);
        pack();
        
        // adding listeners
        okButton.addActionListener(this);
        cancelButton.addActionListener(this);
    }

    /**
     * Carry out a call to client's <code>dialogDimissed</code> method. 
     * @param event
     */
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == cancelButton) {
            wasCancelled = true;            
        } else {
            wasCancelled = false;
            info.setUsername(username.getText());
            info.setPassword(password.getText());
        }
        
        hide();
        dispose();
        
        // notify the client that dialog has been closed
        client.dialogDimissed(this, info);
    }
    
    public boolean wasCancelled() {
        return wasCancelled;
    }
}

