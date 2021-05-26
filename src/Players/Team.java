
package Players;

import java.util.ArrayList;
import javafx.util.Pair;

/**
 *
 * @author 
 */
public class Team {
    ArrayList<Pair<String,String>>team;
    /**
     * empty constructor
     */
    public Team(){
     this.team=new ArrayList<>();
    }
    /**
     *function used to add member to the team
     * @param member team member player will add him
     */
    public void addMember(Pair<String,String>member){
        team.add(member);
    }
    /**
     * to print all team members
     */
    public void getTeam(){
        for (Pair<String,String> team1 : team) {
            System.out.println("Name:.."+team1.getKey()+"\nEmail:.."+team1.getValue());
        }
    }
}
