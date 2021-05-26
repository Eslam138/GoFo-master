
package Abstract;

/**
 *
 * @author
 */
public class User {
    protected String name;
    protected String ID;
    protected String pass;
    protected String email;
    public Wallet wallet;
    /**
     * Empty Constructor
     */
    public User(){
        this.name="name";
        this.ID="ID";
        this.pass="pass";
        this.email="email";
        wallet=new Wallet();
    }
    /**
     * @param name user name    
     */
    public void setName(String name){
        this.name=name;
    }
    /**
     * @param ID username is unique    
     */
    public void setID(String ID){
        this.ID=ID;
    }
   /**
     * @param pass account password    
     */ 
    public void setPass(String pass){
        this.pass=pass;
    }
    /**
     * @param email user email    
     */
    public void setEmail(String email){
        this.email=email;
    }
    /**
     * @return user name
     */
    public String getName(){
    return this.name;
    }
    /**
     * @return account username
     */
    public String getID(){
    return this.ID;
    }
    /**
     * @return account password
     */
    public String getPass(){
    return this.pass;
    }
    /**
     * @return user email
     */
    public String getEmail(){
    return this.email;
    }
}
