package Players;

import Abstract.User;
import Owner.Time;
import java.util.ArrayList;

/**
 *
 * @author 
 * 
 */
public class Player extends User{
    public ArrayList<Time>booked;
    public Team team;
    /**
     *empty constructor 
     */
    public Player(){
        super();
        team=new Team();
        booked=new ArrayList<>();
    }
    
}
