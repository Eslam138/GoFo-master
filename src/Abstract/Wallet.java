
package Abstract;

/**
 *
 * @author 
 */
public class Wallet {
    private int balance;
    /**
     *Empty constructor
     */
    public Wallet(){
       this.balance=0;
    }
    /**
     *
     * @param value amount we wanna to add to balance
     */
    public void deposit(int value){
       if(value>0){
           this.balance+=value;
        }
      
    }
    /**
     *
     * @param value amount we wanna to decrease from balance
     */
    public void withdraw(int value){
       if(value>=this.balance){
           this.balance-=value;
       }
    }
    /**
     *
     */
    
    /**
     *
     * @return Wallet balance
     */
    public int getBalance(){
       return this.balance;
    }
}
