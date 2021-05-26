package gofo;

import Owner.Owner;
import Owner.Playground;
import Owner.Time;
import Players.Player;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;
import javafx.util.Pair;

/**
*It contains all the countries that users interact with
*@author 
*
*/
public class GoFo {

    private ArrayList<Owner>owners;
    private ArrayList<Player>players;
    private Admin admin;
    /**
     *Empty constructor   
     *initialize all private arrays and Admin  
     *
     */
    public GoFo(){
    owners=new ArrayList<>();
    players=new ArrayList<>();
    admin=new Admin();
    }
    /**
     *Function to check if an email is real or not 
     * it will accept any email style one char at least before @ 
     * tow chars at least after @ and before (.) after (.) must be one char at least no spaces allowed
     * @param email the email we will check
     * @return return true if an valid email else return false
     */
    public static boolean isValid(String email) 
    { 
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ 
                            "[a-zA-Z0-9_+&*-]+)*@" + 
                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
                            "A-Z]{2,7}$"; 
                              
        Pattern pat = Pattern.compile(emailRegex); 
        if (email == null) 
            return false;
        return pat.matcher(email).matches(); 
    }

    /**
     *method to add new users to GoFo System 
     * you should know no invalid email will be accepted
     * no limits in user name or password but spaces are not allowed
     * this method should sent verification code vie Mail 
     * it will print verification code (afghjk) you should enter it to sign up in system 
     * you should enter your password twice.
     */
    public void signup(){
    boolean loop=true;
    while(loop){
            System.out.println("Hello in GoFo\n"
                + "wich user you are?\n"
                + "[1] Player\n"
                + "[2] Playground Owner");
            String userType;
            Scanner scanner = new Scanner(System.in);
            userType=scanner.next();
            boolean check=true;
            if("2".equals(userType)||"1".equals(userType)){
                
                
                    String name,email,pass,conPass,userName;
                    System.out.println("Enter your Name");
                    scanner.nextLine();
                    name=scanner.nextLine();
                    System.out.println("Enter User Name");
                    userName=scanner.next();
                    System.out.println("Enter your email");
                    email=scanner.next();
                    System.out.println("Enter your Password");
                    pass=scanner.next();
                    System.out.println("Enter your Password again");
                    conPass=scanner.next();
                    if("1".equals(userType))
                    {
                        for (Player player : players) {
                            if(userName.equals( player.getID())){
                                System.out.println("this user name is exist");
                                check=false;
                                break;
                            }
                            if(check==true&&email.equals( player.getEmail())){
                                System.out.println("this Email is exist");
                                check=false;
                                break;
                            }
                        }
                        if(check==true){
                            if(!isValid(email)){
                                check=false;
                                System.out.println(email+" isn't an email address");
                            }
                        }
                        if(check==true){
                            if(!pass.equals(conPass)){
                                System.out.println("Error in password");
                                check=false;
                            }
                        }
                        if(check==true){
                            System.out.println("Enter verification code (afghjk)");
                            String  verification;
                            verification=scanner.next();
                            if(!verification.equals("afghjk")){
                                System.out.println("you Enterd wrong verification code");
                                check=false;
                            }
                        }
                        if(check==true){
                            Player newPlayer=new Player();
                            newPlayer.setID(userName);
                            newPlayer.setEmail(email);
                            newPlayer.setName(name);
                            newPlayer.setPass(pass);
                            players.add(newPlayer);
                            System.out.println("Now you are Player in GoFo Thanks:)");
                            loop=false;
                        }
                        else{
                            System.out.println("Do you want to Try Again "
                                    + "\n[1]Yes enter y"
                                    + "[2]No Enter n");
                            String help;
                            help=scanner.next();
                            if(help.equalsIgnoreCase("n"))
                                loop=false;
                    }
            
            }
                if("2".equals(userType))
                    {
                        for (Owner owner :owners ) {
                            if(userName.equals( owner.getID())){
                                System.out.println("this user name is exist");
                                check=false;
                                break;
                            }
                            if(check==true&&email.equals( owner.getEmail())){
                                System.out.println("this Email is exist");
                                check=false;
                                break;
                            }
                        }
                        if(check==true){
                            if(!isValid(email)){
                                check=false;
                                System.out.println(email+" isn't an email address");
                            }
                        }
                        if(check==true){
                            if(!pass.equals(conPass)){
                                System.out.println("Error in password");
                                check=false;
                            }
                        }
                        if(check==true){
                            System.out.println("Enter verification code (afghjk)");
                            String  verification;
                            verification=scanner.next();
                            if(!verification.equals("afghjk")){
                            System.out.println("you Enterd wrong verification code");
                            check=false;
                        }
                        if(check==true){
                            Owner newOwner=new Owner();
                            newOwner.setID(userName);
                            newOwner.setEmail(email);
                            newOwner.setName(name);
                            newOwner.setPass(pass);
                            owners.add(newOwner);
                            System.out.println("Now you are Owner in GoFo Thanks:)");
                            loop=false;
                        }
                        else{
                            System.out.println("Do you want to Try Again "
                                    + "\n[1]Yes enter y"
                                    + "[2]No Enter n");
                            String help;
                            help=scanner.next();
                            if(help.equalsIgnoreCase("y"))
                                loop=false;
                        }
                    }
                }
        }
        else {
            System.out.println("Invalid User type!!!!");
            System.out.println("Do you want to Try Again "
                                + "\n[1]Yes enter y\n"
                                + "[2]No Enter n\n");
                        String help;
                        help=scanner.next();
                        if(help.equalsIgnoreCase("n"))
                            loop=false;
                            
            
        }
    }
        
 }
    /**
     *this function will do all player operations like book playgrounds and create a team and send 
     * invitation via mail to each member in the team
     * @param playerNum the number of player in Players array in system
     */
    public void playerLogin(int playerNum){
        players.get(playerNum).wallet.deposit(1000);
        Scanner scanner=new Scanner(System.in);
        boolean loop=true;
            while(loop){
                System.out.print("hello "
                +players.get(playerNum).getName()
                +"\n");
                System.out.print("[1]book Playground\n"
                        + "[2]Booked playgrounds\n"
                        + "[3]Exit\n");
                String option;
                option=scanner.next();
                switch(option){
                   case"1":
                       String Governorate,city,street;
                       System.out.print("Enter Governorate:...");
                       Governorate=scanner.next();
                       System.out.print("Enter city:...");
                       city=scanner.next();
                       System.out.print("Enter street:...");
                       street=scanner.next();
                       int year,month,day,hour;
                       System.out.print("Enter year:...");
                       year=scanner.nextInt();
                       System.out.print("Enter Month:..");
                       month=scanner.nextInt();
                       System.out.print("Enter day:...");
                       day=scanner.nextInt();
                       System.out.print("Enter Hour in 24 System");
                       hour=scanner.nextInt();
                       boolean findGround=false;
                       LocalDateTime time=LocalDateTime.of(year, month, day, hour,0);
                       if(java.time.Duration.between(LocalDateTime.now(),time).toHours()>=0){
                           for(Owner owner:owners){
                               if(owner.ground.getGovernorate().equalsIgnoreCase(Governorate)
                                       &&owner.ground.getCity().equalsIgnoreCase(city)
                                       &&owner.ground.getStreet().equalsIgnoreCase(street)
                                       &&owner.ground.getStatus().equals("aa"))//aa=>active
                               {
                                   int slotNum=1;
                                   for(Time slot:owner.ground.times)
                                   {
                                       if(java.time.Duration.between(time,slot.getStart()).toHours()>=0)
                                       {
                                           System.out.println("plygroundName:.."+owner.ground.getName()+
                                                   " Owner Name: "+owner.getName());
                                           System.out.println("playGround address:"
                                                   +Governorate+" "+city+" "+street);
                                           System.out.println("Slot Number: "+ slotNum +" will start at: "+slot.startTime());
                                           System.out.println("will end at: "+slot.endTime());
                                           System.out.println("will cost: "+slot.price());
                                           slotNum++;
                                           findGround=true;
                                       }
                                       else
                                           slotNum++;
                                   }
          
                               }
                           }
                           for(Owner owner:owners){
                               if(owner.ground.getGovernorate().equalsIgnoreCase(Governorate)
                                       &&owner.ground.getCity().equalsIgnoreCase(city)
                                       &&!owner.ground.getStreet().equalsIgnoreCase(street)
                                       &&owner.ground.getStatus().equals("aa"))//aa=>active
                               {
                                   int slotNum=1;
                                   for(Time slot:owner.ground.times)
                                   {
                                       if(java.time.Duration.between(time,slot.getStart()).toHours()>0)
                                       {
                                           System.out.println("plygroundName:.."+owner.ground.getName()+
                                                   " Owner Name: "+owner.getName());
                                           System.out.println("playGround address:"
                                                   +Governorate+" "+city+" "+street);
                                           System.out.println("Slot Number: "+ slotNum +" will start at: "+slot.startTime());
                                           System.out.println("will end at: "+slot.endTime());
                                           System.out.println("will cost: "+slot.price());
                                           slotNum++;
                                           findGround=true;
                                       }
                                       else
                                           slotNum++;
                                   }
                               }
                           }
                       }
                       else
                           System.out.println("Error try again");
                       if(!findGround){
                           System.out.println("No playgrounds in this address or this date");
                       }
                       while(findGround==true){
                          String ask,name;
                          System.out.println("Do you want to book any playground\n"
                                  + "yes\n No");
                          ask=scanner.next();
                          if(ask.equalsIgnoreCase("yes")){
                              System.out.println("Enter Owner Name");
                              ask=scanner.next();
                              System.out.println("Enter playground Name");
                              name=scanner.next();
                              int slotNum;
                              System.out.println("Enter playground slot Number");
                              slotNum=scanner.nextInt();
                              for(Owner owner:owners){
                                  if(owner.getName().equalsIgnoreCase(ask)
                                          &&owner.ground.getName().equalsIgnoreCase(name)
                                          &&owner.ground.times.size()>=slotNum)
                                    {
                                        System.out.println("Enter your password to book this playground");
                                        ask=scanner.next();
                                        if(ask.equalsIgnoreCase(players.get(playerNum).getPass()))
                                        {
                                            if(!owner.ground.times.get(slotNum-1).status().
                                                    equalsIgnoreCase("booked")){
                                                 int  price=owner.ground.times.get(slotNum-1).price();
                                                 System.out.println("--------\n"+price+"------");
                                                if(players.get(playerNum).wallet.getBalance()>=price){
                                                    players.get(playerNum).wallet.withdraw(price);
                                                    owner.wallet.deposit(price);
                                                    System.out.println("you booked the playground");
                                                    owner.ground.times.get(slotNum-1).updateStatus("booked");
                                                    findGround=false;
                                                    owner.ground.times.get(slotNum-1).player=players.get(playerNum);
                                                    players.get(playerNum).booked.add(owner.ground.times.get(slotNum-1));
                                                    System.out.println("Do you want to add team?\nyes\nno");
                                                    String team;
                                                    team=scanner.next();
                                                    if(team.equalsIgnoreCase("yes"))
                                                    {
                                                        System.out.println("how many plyers you wanna to add?");
                                                        int teamCount;
                                                        teamCount=scanner.nextInt();
                                                        for(int i=0;i<teamCount;i++){
                                                            System.out.println("Enter player data");
                                                            String playerName,playerEmail;
                                                            System.out.println("Enter player name");
                                                            playerName=scanner.next();
                                                            System.out.println("Enter player email");
                                                            playerEmail=scanner.next();
                                                            if(isValid(playerEmail)){
                                                                System.out.println("Sending Email to invite him");
                                                                Pair<String,String>player=new Pair(playerName,playerEmail);
                                                                players.get(playerNum).team.addMember(player);
                                     
                                                            }
                                                            else{
                                                                System.out.println("invalid Email try again");
                                                                i--;
                                                            }
                                                        }
                                                    }
                                                }
                                                else{
                                                    System.out.println("you don't have money to book this playground");
                                                    findGround=false;
                                                }
                                            }
                                            else
                                                System.out.println("We are sorry this slot is booked for anothe player");
                                        }
                                        else
                                            System.out.println("wrong password!!!");
                                    }
                                  else
                                      System.out.println("you had enterd wrong data");
                              }
                          }
                          else
                              break;
                          
                       }
                   break;
                   case"2":
                       if(!players.isEmpty()){
                           for(Time slot:players.get(playerNum).booked){
                               System.out.println("playground name: "+
                                       slot.ground.getName());
                               System.out.println("it will start at:"+
                                       slot.startTime());
                               System.out.println("--------------------------------------");
                           }
                       }
                        else
                            System.out.println("You didn't book any play ground");
                       break;
                    case"3":
                        loop=false;
                        break;
                }
            }
    }
    /**
     *this function will allow admin to accept the new playgrounds
     * user Name admin1
     * password admin1
     */
    public void adminLogin(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Hello Admin");
       int playgroundCount=0;
       for(Owner owner:owners){
           if(owner.ground!=null)
           {
               if(owner.ground.getStatus().equals("ww")){//ww =>wait
               playgroundCount++;
               System.out.println("playground number "+
                       playgroundCount+"\n playground name "+owner.ground.getName());
               
           }
           else
               playgroundCount++;
           }
       }
       if(playgroundCount==0){
           System.out.println(" no playgrounds wanna to be active");
       }
       while(playgroundCount>0)
       {
           System.out.println("Do you want to active any play ground\n"
                   + "yes\n"
                   + "No");
           String ask;
           ask=scanner.next();
           if(ask.equalsIgnoreCase("yes"))
           {
               System.out.println("Enter playground Number");
               int num;
               num=scanner.nextInt();
               if(num<=owners.size()){
                   if(owners.get(num-1).ground.getStatus().equals("ww")){
                       owners.get(num-1).ground.setStatus("aa");//aa=>active
                       System.out.println("active....");
                       playgroundCount--;
                   }
                   else
                       System.out.println("Wrong number");
                   
               }
               else
                   System.out.println("Wrong number");
           }
           else
               break;
       }
    }
    /**
     *this function will do all owner operations like crate his playground
     * add slots for his playground and price for each slot 
     * in real life play at day Cheaper than play at night
     * @param ownerNum the number of owner in owner array in system
     */
    public void ownerLogin(int ownerNum){
        System.out.println("Hello "+owners.get(ownerNum).getName());
        boolean loop=true;
        Scanner scanner=new Scanner(System.in);
        while(loop){
            System.out.print("[1]create my playground\n"
                    + "[2]add slots to my playground\n"
                    + "[3]Exit\n");
            String toDo;
            toDo=scanner.next();
            switch(toDo){
                case"1":
                    if(owners.get(ownerNum).ground==null){
                    String name;
                    String Governorate;
                    String city;
                    String street;
                    String description;
                    String status;
                    System.out.print("Enter playground Name:...");
                       scanner.nextLine(); 
                       name=scanner.nextLine();
                    System.out.print("Enter Governorate:...");
                       Governorate=scanner.next();
                       System.out.print("Enter city:...");
                       city=scanner.next();
                       System.out.print("Enter street:...");
                       street=scanner.next();
                       System.out.print("Enter playground description:...");
                       scanner.nextLine();
                       description=scanner.nextLine();
                       status="ww";
                       owners.get(ownerNum).ground=new Playground();
                       owners.get(ownerNum).ground.setCity(city);
                       owners.get(ownerNum).ground.setDescription(description);
                       owners.get(ownerNum).ground.setName(name);
                       owners.get(ownerNum).ground.setGovernorate(Governorate);
                       owners.get(ownerNum).ground.setStreet(street);
                       owners.get(ownerNum).ground.setStatus(status);
                       System.out.println("you are created playground");
                    }
                    else
                        System.out.println("you are created playground");
                    break;
                    case"2":
                        System.out.println("How many slots you wanna to add");
                        int slotCount;
                        slotCount=scanner.nextInt();
                        for(int i=0;i<slotCount;i++){
                            System.out.println("Enter slot number "+(i+1)+"data");
                            int year,month,day,hour;
                            System.out.print("Enter year:...");
                            year=scanner.nextInt();
                            System.out.print("Enter Month:..");
                            month=scanner.nextInt();
                            System.out.print("Enter day:...");
                            day=scanner.nextInt();
                            System.out.println("Enter Hour in 24 System");
                            hour=scanner.nextInt();
                            
                            LocalDateTime time=LocalDateTime.of(year, month, day, hour, 0);
                            if(hour==23)
                                hour=-1;
                            LocalDateTime time2=LocalDateTime.of(year, month, day, hour+1, 0);
                            LocalDateTime time3=LocalDateTime.now();
                            if(owners.get(ownerNum).ground.times.isEmpty()){
                                if(java.time.Duration.between(time3, time).toHours()>0){
                                System.out.println("Enter slot price");
                                int price=scanner.nextInt();
                                System.out.println("Enter book Canceletion period in hours");
                                int cancel=scanner.nextInt();
                                Time slotDate=new Time();
                                slotDate.addTime(time, time2, cancel, price);
                                owners.get(ownerNum).ground.times.add(slotDate);
                                System.out.println("slot will be added");
                                }
                                else{                              
                                    System.out.println("invalid date try agian you should enter date greater than date now by one hour at least");
                                    i--;
                                }
                            }
                            else{
                                int endslot=owners.get(ownerNum).ground.times.size();
                                LocalDateTime endDate=owners.get(ownerNum).ground.times.get(endslot-1).getEnd();
                                if(java.time.Duration.between(endDate,time).toHours()>=0){// to make sure no slot Enter twice
                                System.out.println("Enter slot price");
                                int price=scanner.nextInt();
                                System.out.println("Enter book Canceletion period in hours");
                                int cancel=scanner.nextInt();
                                Time slotDate=new Time();
                                slotDate.addTime(time, time2, cancel, price);
                                owners.get(ownerNum).ground.times.add(slotDate);
                                System.out.println("slot will be added");
                                }
                                else{                              
                                    System.out.println("invalid date try agian you should enter date greater than date now by one hour at least");
                                    i--;
                                }
                            }
                            
                        }
                        break;
                case"3":
                    loop=false;
                    break;
            }
            
        }
        
    }  
    /**
     *home page for the system contain all GoFo operations
     */
    public void System(){
        boolean loop=true;
        Scanner scanner=new Scanner(System.in);
        while(loop){
            System.out.println("Hello in GoFo\n"
                    + "[1]signUp\n"
                    + "[2]Player Login\n"
                    + "[3]Owner Login\n"
                    + "[4]Admin Login\n"
                    + "[5]Exit");
            String userName,pass;
            String option=scanner.next();
            boolean findUser=false;
            int user=0;
            switch(option){
                case"1":
                    signup();
                    break;
                case"2":
                    System.out.println("Enter User Name");
                    userName=scanner.next();
                    System.out.println("Enter User password");
                    pass=scanner.next();
                    findUser=false;
                    for(Player player:players){
                        if(player.getID().equals(userName)&&player.getPass().equals(pass)){
                            playerLogin(user);
                            findUser=true;
                            
                        }
                        else
                            user++;
                    }
                    if(!findUser){
                        System.out.println("wrong password or User name");
                    }
                    break;
                case"3":
                    System.out.println("Enter User Name");
                    userName=scanner.next();
                    System.out.println("Enter User password");
                    pass=scanner.next();
                    findUser=false;
                    for(Owner owner:owners){
                        if(owner.getID().equals(userName)&&owner.getPass().equals(pass)){
                            ownerLogin(user);
                            findUser=true;
                        }
                        else
                            user++;
                    }
                    if(!findUser){
                        System.out.println("wrong password or User name");
                    }
                    break;
                case"4":
                    System.out.println("Enter User Name");
                    userName=scanner.next();
                    System.out.println("Enter User password");
                    pass=scanner.next();
                    findUser=false;
                        if(admin.getUserName().equals(userName)&&admin.getPass().equals(pass)){
                            adminLogin();
                        }
                        else
                            System.out.println("Wrong password or user Name");
                    break;
                case"5":
                    loop=false;
                    break;
            }
        }
    } 
}
