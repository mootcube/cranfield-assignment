


/**
 * Bean containing information related to the Dialog's fields.
 * @author
 * @version 1.0
 */
public class DialogInfo {
    private String username;
    private String password;

    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public DialogInfo(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    @Override
    public String toString() {
        StringBuffer s = new StringBuffer();
        s.append(username + "\n" + password + "\n");
        return s.toString();
    }
}
