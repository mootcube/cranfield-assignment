


import java.awt.Button;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This test class ilustrates the use of DialogClient to solve the next problem:
 * the class that create a Dialog is not able to know when this Dialog 
 * is dismisses. 
 * <code>DialogTest</code> implements <code>DialogClient</code> so that code 
 * in method <code>dialogDimissed</code> will be executed when the dialog is 
 * closed.
 * <i>In this case, the dialog created is <code>ConnectDialog</code>.</i>
 * @author
 * @version 1.0
 */
public class DialogTest extends Frame implements DialogClient, ActionListener {
    
    private DialogInfo info;
    private Button connectButton;
    private Button closeButton;

    public DialogTest() {
        
        setTitle("Dialog data exchange test");
        
        Panel p = new Panel();
        p.setLayout(new FlowLayout(FlowLayout.CENTER));
        p.add(connectButton = new Button("Connect"));
        p.add(closeButton = new Button("Close"));
        add("Center", p);
        connectButton.addActionListener(this);
        closeButton.addActionListener(this);
       
    }
    
    

    public void dialogDimissed(Dialog d, Object arg) {
        info = (DialogInfo)arg;
        System.out.println(info);
    }

    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == connectButton) {
            info = new DialogInfo("yourname", "password");
            ConnectDialog cd = new ConnectDialog(this, this, 
                    "Dialog Test", info);
            cd.show();
        } else if (event.getSource() == closeButton){
            System.exit(0);
        }      
    }
    
    public static void main(String args[]) {
        Frame f = new DialogTest();
        f.resize(300, 200);
        f.show();
    }
}

