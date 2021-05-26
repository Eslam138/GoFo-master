package gofo;

/**
 *
 * @author 
 */
public class Admin {
    private String pass;
    private String UserName;
    /**
     *Empty constructor to add user name and password.
     * <h1>UserName :admin1</h1>
     * <h1>Password :admin1</h1>
     */
    public Admin(){
        this.pass="admin1";
        this.UserName="admin1";
    }
    /**
     *return admin password
     * @return password
     */
    public String getPass() {return this.pass;}
    /**
     *return admin user name
     * @return user name
     */
    public String getUserName(){return this.UserName;}
    
}
