package Owner;

import Players.Player;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author 
 */
public class Time {
    LocalDateTime start;
    LocalDateTime end;
    long cancelDate;// in hours
    int price; // price for this period
    String status;
    public Playground ground;
    public Player player;
    /**
     *empty constructor
     */
    public Time(){
        
    }
    /**
     * add slot time
     * @param start start date
     * @param end end date it will be auto increase start date by one hour 
     * @param hours cancellation period by hours 
     * @param price slot price 
     */
    public void addTime(LocalDateTime start,LocalDateTime end,
                          long hours,int price){
        this.start=start;
        this.end=end;
        this.cancelDate=hours;
        this.price=price;
        this.status="available"; 
    }
    /**
     *function to update slot status booked or available  
     * @param status slot status
     */
    public void updateStatus(String status){
        this.status=status;
    }
    /**
     *function to cancel booked slot
     * @param date the current date
     * @return return true if the deference between start date and current date greater than cancellation period 
     */
    public boolean cancelBook(LocalDateTime date){
        long diffInHours = java.time.Duration.between(date, this.start).toHours();
        return diffInHours>=this.cancelDate;
    }
    /**
     * return start date in formate (dd-MM-yyyy HH:mm:ss)
     * @return start date in formate (dd-MM-yyyy HH:mm:ss)
     */
    public String startTime(){
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");  
        String formatDateTime = this.start.format(format);
        return formatDateTime;
    }
    /**
     * return end date in formate (dd-MM-yyyy HH:mm:ss)
     * @return end date in formate (dd-MM-yyyy HH:mm:ss)
     */
    public String endTime(){
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");  
        String formatDateTime = this.end.format(format);
        return formatDateTime;
    }
    /**
     * return start date without format to compare between tow dates 
     * @return start date
     */
    public LocalDateTime getStart(){
        return this.start;
    }
    /**
     * return end date without format to compare between tow dates 
     * @return end date
     */
    public LocalDateTime getEnd(){
        return this.end;
    }
    /**
     * return slot price 
     * @return slot price
     */
    public int price(){ return this.price;}
    /**
     *return current slot status
     * @return current slot status
     */
    public String status(){ return this.status;}

}
