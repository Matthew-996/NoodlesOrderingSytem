import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * This is a class used to control the generation of a ticket and stored it in different forms of documents
 * @author Yulin Zhao
 */
public class CustomerControl 
{
    public CustomerControl(){
    }

    /**
     * The method to generate a new ticket
     * @return the new ticket
     */
    public Ticket createTicket()
    {
        return new Ticket();
    }

    /**
     * The method to get customer's soup choice stored in the target ticket
     * @param ticket the target ticket
     * @return the target ticket
     */
    public int getSoupChoice(Ticket ticket) 
    {
    	return ticket.getSoupChoice();
    }
    
    /**
     * The method to get customer's noodle choice stored in the target ticket
     * @param ticket the target ticket
     * @return the target ticket
     */
    public int getNoodlesChoice(Ticket ticket) 
    {
    	return ticket.getNoodlesChoice();
    }
    
    /**
     * The method to get customer's spring onion choice stored in the target ticket
     * @param ticket the target ticket
     * @return the target ticket
     */
    public int getSpringOnionChoice(Ticket ticket) 
    {
    	return ticket.getSpringOnionChoice();
    }
    
    /**
     * The method to get customer's nori choice stored in the target ticket
     * @param ticket the target ticket
     * @return the target ticket
     */
    public int getNoriChoice(Ticket ticket) 
    {
    	return  ticket.getNoriChoice();
    }
    
    /**
     * The method to get customer's chashu choice stored in the target ticket
     * @param ticket the target ticket
     * @return the target ticket
     */
    public int getChashuChoice(Ticket ticket) 
    {
    	return   ticket.getChashuChoice();
    }
    
    /**
     * The method to get customer's  boiled egg choice stored in the target ticket
     * @param ticket the target ticket
     * @return the target ticket
     */
    public int getBoiledEggChoice(Ticket ticket) 
    {
    	return  ticket.getBoiledEggChoice();
    }
    
    /**
     * The method to get customer's spiciness choice stored in the target ticket
     * @param ticket the target ticket
     * @return the target ticket
     */
    public int getSpicinessChoice(Ticket ticket) 
    {
    	return  ticket.getSpicinessChoice();  
    }
    
    /**
     * The method to get customer's extra nori choice stored in the target ticket
     * @param ticket the target ticket
     * @return the target ticket
     */
    public int getExtraNoriChoice(Ticket ticket) 
    {
    	return ticket.getExtraNoriChoice();
    }
    
    /**
     * The method to get customer's extra boiled egg choice stored in the target ticket
     * @param ticket the target ticket
     * @return the target ticket
     */
    public int getExtraBoiledEggChoice(Ticket ticket) 
    {
    	return ticket.getExtraBoiledEggChoice();
    }
    
    /**
     * The method to get customer's bambooshoots choice stored in the target ticket
     * @param ticket the target ticket
     * @return the target ticket
     */
    public int getBambooShootsChoice(Ticket ticket) 
    {
    	return ticket.getBambooShootsChoice();
    }
    
    /**
     * The method to get customer's extra chashu choice stored in the target ticket
     * @param ticket the target ticket
     * @return the target ticket
     */
    public int getExtraChashuChoice(Ticket ticket) 
    {
    	return ticket.getExtraChashuChoice();
    }
    
    /**
     * The method to get the total price of the order stored in the target ticket
     * @param ticket the target ticket
     * @return the target ticket
     */
    public double getTotalPrice(Ticket ticket) 
    {
    	return ticket.getTotalPrice();
    }

    /**
     * The method to get customer's TakeOrStay choice stored in the target ticket
     * @param ticket the target ticket
     * @return the target ticket
     */
    public int getTakeOrStay(Ticket ticket)
    {
        return ticket.getTakeOrStay();
    }

    /**
     * The method to get customer's choice of payment stored in the target ticket
     * @param ticket the target ticket
     * @return the target ticket
     */
    public int getPayByStamp(Ticket ticket) 
    {
        return ticket.getPayByStamp();
    }
    
    /**
     * The method to set customer's soup choice stored to the target ticket
     * @param ticket the target ticket
     * @param soupChoice the soup chioce
     * @return the target ticket
     */
    public Ticket setSoupChoice(Ticket ticket, int soupChoice) 
    {
        ticket.setSoupChoice(soupChoice);
        return ticket;
    }

    /**
     * The method to set customer's noodle choice stored to the target ticket
     * @param ticket the target ticket
     * @param noodlesChoice the noodle chioce
     * @return the target ticket
     */
    public Ticket setNoodlesChoice(Ticket ticket, int noodlesChoice) 
    {
        ticket.setNoodlesChoice(noodlesChoice);
        return ticket;
    }
    
    /**
     * The method to set customer's spring onion choice stored to the target ticket
     * @param ticket the target ticket
     * @param springOnionChoice the spring onion chioce
     * @return the target ticket
     */
    public Ticket setSpringOnionChoice(Ticket ticket, int springOnionChoice) 
    {
        ticket.setSpringOnionChoice(springOnionChoice);
        return ticket;
    }
    
    /**
     * The method to set customer's nori choice stored to the target ticket
     * @param ticket the target ticket
     * @param noriChoice the nori chioce
     * @return the target ticket
     */
    public Ticket setNoriChoice(Ticket ticket, int noriChoice) 
    {
        ticket.setNoriChoice(noriChoice);
        return ticket;
    }
    
    /**
     * The method to set customer's chashu choice stored to the target ticket
     * @param ticket the target ticket
     * @param chashuChoice the chashu chioce
     * @return the target ticket
     */
    public Ticket setChashuChoice(Ticket ticket, int chashuChoice) 
    {
        ticket.setChashuChoice(chashuChoice);
        return ticket;
    }
    
    /**
     * The method to set customer's boiled egg choice stored to the target ticket
     * @param ticket the target ticket
     * @param boiledEggChoice the boiled egg chioce
     * @return the target ticket
     */
    public Ticket setBoiledEggChoice(Ticket ticket, int boiledEggChoice) 
    {
        ticket.setBoiledEggChoice(boiledEggChoice);
        return ticket;
    }
    
    /**
     * The method to set customer's spiciness choice stored to the target ticket
     * @param ticket the target ticket
     * @param spicinessChoice the spiciness chioce
     * @return the target ticket
     */
    public Ticket setSpicinessChoice(Ticket ticket, int spicinessChoice) 
    {
        ticket.setSpicinessChoice(spicinessChoice);
        return ticket;
    }
    
    /**
     * The method to set customer's extra nori choice stored to the target ticket
     * @param ticket the target ticket
     * @param extraNoriChoice the extra nori chioce
     * @return the target ticket
     */
    public Ticket setExtraNoriChoice(Ticket ticket, int extraNoriChoice) 
    {
        ticket.setExtraNoriChoice(extraNoriChoice);
        return ticket;
    }
    
    /**
     * The method to set customer's extra boiled egg choice stored to the target ticket
     * @param ticket the target ticket
     * @param extraBoiledEggChoice the extra boiled egg chioce
     * @return the target ticket
     */
    public Ticket setExtraBoiledEggChoice(Ticket ticket, int extraBoiledEggChoice) 
    {
        ticket.setExtraBoiledEggChoice(extraBoiledEggChoice);
        return ticket;
    }

    /**
     * The method to set customer's bambooshoots choice stored to the target ticket
     * @param ticket the target ticket
     * @param bambooShootsChoice the bamboo shoots chioce
     * @return the target ticket
     */
    public Ticket setBambooShootsChoice(Ticket ticket, int bambooShootsChoice) 
    {
        ticket.setBambooShootsChoice(bambooShootsChoice);
        return ticket;
    }
    
    /**
     * The method to set customer's extra chashu choice stored to the target ticket
     * @param ticket the target ticket
     * @param extraChashuChoice the extra chashu chioce
     * @return the target ticket
     */
    public Ticket setExtraChashuChoice(Ticket ticket, int extraChashuChoice) 
    {
        ticket.setExtraChashuChoice(extraChashuChoice);
        return ticket;
    }

    /**
     * The method to set customer's TakeOrStay choice stored to the target ticket
     * @param ticket the target ticket
     * @param takeOrStay the takeOrStay chioce
     * @return the target ticket
     */
    public Ticket setTakeOrStay(Ticket ticket, int takeOrStay)
    {
        ticket.setTakeOrStay(takeOrStay);
        return ticket;
    }

    /**
     * The method to set customer's payment way choice stored to the target ticket
     * @param ticket the target ticket
     * @param payByStamp the payment way chioce
     * @return the target ticket
     */
    public Ticket setPayByStamp(Ticket ticket, int payByStamp) 
    {
        ticket.setPayByStamp(payByStamp);
        return ticket;
    }
    
    /**
     * This is a method to calculate the total price according to the choices of customer
     * @param ticket the target ticket
     * @param extraNoriPrice the price of extra nori now
     * @param extraBoiledEggPrice the price of extra boiledegg now
     * @param bambooShootsiPrice the price of bambooshoots now
     * @param extraChashuPrice the price of extra chashu now
     * @return the total price using calculation
     */
    public double getTotalPrice(Ticket ticket, float extraNoriPrice, float extraBoiledEggPrice, float bambooShootsiPrice, float extraChashuPrice)
    {
        ticket.setTotalPrice(9.99 + ticket.getExtraNoriChoice() * extraNoriPrice + ticket.getExtraBoiledEggChoice() * extraBoiledEggPrice + 
        ticket.getBambooShootsChoice() * bambooShootsiPrice + ticket.getExtraChashuChoice() * extraChashuPrice);
        return ticket.getTotalPrice();
    }

    /**
     * This is a method to geneate ticket(entity) in the format of .txt file
     * include all the choices of a customer and create date generated automaticlly
     * @param ticket the target ticket
     */
    public void generateTicket(Ticket ticket)
    {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String[] soup = {"Tonkotsu", "Shoyu", "Shio"};
        String[] noodles = {"Soft", "Medium", "Firm"};
        String[] springOnion = {"No please", "Just a little", "A lot!"};
        String[] others = {"No" ,"Yes"};
        SimpleDateFormat newFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        try
        {
            String content = "Selection of basic ingredients:\n\tSoup: " + soup[(ticket.getSoupChoice()-1)]
                                +"\n\tNoodles: " + noodles[(ticket.getNoodlesChoice()-1)]
                                +"\n\tSpring Onion: " + springOnion[(ticket.getSpringOnionChoice()-1)]
                                +"\n\tNori: " + others[ticket.getNoriChoice()]
                                +"\n\tChashu: " + others[ticket.getChashuChoice()]
                                +"\n\tBoiled egg: " + others[ticket.getBoiledEggChoice()]
                                +"\n\tSpiciness level: " + ticket.getSpicinessChoice()
                            +"\nAdd-ons:" 
                                +"\n\tExtra Nori: " + others[ticket.getExtraNoriChoice()]
                                +"\n\tExtra boiled egg: " + others[ticket.getExtraBoiledEggChoice()]
                                +"\n\tBamboo shoots: " + others[ticket.getBambooShootsChoice()]
                                +"\n\tExtra Chashu: " + others[ticket.getExtraChashuChoice()]
                            +"\nTotal Price: " + ticket.getTotalPrice()
                            +"\nTaking away or not: " + others[ticket.getTakeOrStay()]
                            +"\nCreate Time: " + format.format(ticket.getCreateTime()) + ".";
//            File file =new File("ticketNo."+ newFormat.format(ticket.getCreateTime()) +".txt");
            File file = new File(FilePathGet.getpath("ticketNo."+ newFormat.format(ticket.getCreateTime()) +".txt"));
            if(!file.exists())
            {
                file.createNewFile();
            }
            //append file 
//            FileWriter fileWritter = new FileWriter(file.getName(),true);
            
            FileWriter fileWritter = new FileWriter(FilePathGet.getpath(file.getName()),true);

            fileWritter.write(content);
            fileWritter.close();
            System.out.println("finish");
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        this.generateRecord(ticket);
    }
    /**
     * This is a method to record ticket(entity) in the format of .csv file in the use of statistics later
     * @param ticket the target ticket
     */
    public void generateRecord(Ticket ticket)
    {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        int[] soup = {0,0,0};
        soup[ticket.getSoupChoice()-1] = 1;
        int[] noodles = {0,0,0};
        noodles[ticket.getNoodlesChoice()-1] = 1;
        int[] springOnion = {0,0,0};
        springOnion[ticket.getSpringOnionChoice()-1] = 1;
        int[] spicinessLevel = {0,0,0,0,0,0};
        spicinessLevel[ticket.getSpicinessChoice()] = 1;
        try 
        { 
//            File csv = new File("Record.csv"); 
            File csv = new File(FilePathGet.getpath("Record.csv"));

            BufferedWriter bw = new BufferedWriter(new FileWriter(csv, true)); 
            bw.write(format.format(ticket.getCreateTime()) + "," +  soup[0] + "," + soup[1] + "," + soup[2] + "," + 
                        noodles[0] + "," + noodles[1] + "," + noodles[2] + "," + 
                        springOnion[0] + "," + springOnion[1] + "," + springOnion[2] + "," + 
                        ticket.getNoriChoice() + "," + ticket.getChashuChoice() + "," + ticket.getBoiledEggChoice() + "," +
                        spicinessLevel[0] + "," + spicinessLevel[1] + "," + spicinessLevel[2] + "," + spicinessLevel[3] + "," + spicinessLevel[4] + "," + spicinessLevel[5] + "," +
                        ticket.getExtraNoriChoice() + "," + ticket.getExtraBoiledEggChoice() + "," + ticket.getBambooShootsChoice() + "," + ticket.getExtraChashuChoice() + "," + 
                        ticket.getTotalPrice() + "," + ticket.getTakeOrStay() + "," + ticket.getPayByStamp()) ; 
            bw.newLine(); 
            bw.close(); 
        }catch (IOException e) { 
            e.printStackTrace(); 
        } 
    }

    /**
     * This is a method to get past date according to the calender
     * @param past  specific backtracking days
     * @return real date
     */
    public String getPastDate(int past) {  
        Calendar calendar = Calendar.getInstance();  
        calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) - past);  
        Date today = calendar.getTime();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
        String result = format.format(today);   
        return result;  
    } 
}