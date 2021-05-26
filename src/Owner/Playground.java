package Owner;

import java.util.ArrayList;

/**
 *
 * @author 
 */
public class Playground {
    private String name;
    private String Governorate;
    private String city;
    private String street;
    private String description;
    private String status;
    public ArrayList<Time>times;
    /**
     *Empty constructor
     */
    public Playground(){
        this.times = new ArrayList<>();
        
    }
    /**
     *set playground name
     * 
     * @param s playground name
     */
    public void setName(String s){
     this.name=s;
    }
    /**
     *set playground Governorate address
     * 
     * @param s playground Governorate address
     */
    public void setGovernorate(String s){
     this.Governorate=s;
    }
    /**
     *set playground city address
     * 
     * @param s playground city address
     */
    public void setCity(String s){
     this.city=s;
    }
    /**
     *set playground street address
     * 
     * @param s playground street address
     */
    public void setStreet(String s){
     this.street=s;
    }
    /**
     *set playground Description
     * 
     * @param s playground Description
     */
    public void setDescription(String s){
     this.description=s;
    }
    /**
     *set playground Status (ww)= wait (aa)= active
     * 
     * @param s playground status
     */
    public void setStatus(String s){
     this.status=s;
    }
    /**
     *
     * @return playground name
     */
    public String getName(){
     return this.name;
    }
    /**
     *
     * @return playground city
     */
    public String getCity(){
     return this.city;
    }
    /**
     *
     * @return playground street
     */
    public String getStreet(){
     return this.street;
    }
    /**
     *
     * @return playground Description
     */
    public String getDescription(){
     return this.description;
    }
    /**
     *
     * @return playground Governorate
     */
    public String getGovernorate(){
     return this.Governorate;
    }
    /**
     *
     * @return playground Status
     */
    public String getStatus(){
     return this.status;
    }
}
