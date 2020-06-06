import java.util.*;

/**
 * This is an entity class used to store the information in the ticket
 * @author Yulin Zhao
 */
public class Ticket
{
    // These variables represent corresponding material of the options
    // 1 for Tonkotsu/2 for Shoyu/3 for Shio
    private int soupChoice;
    // 1 for Soft/ 2 for Medium/3 for Firm
    private int noodlesChoice;
    // 1 for No please/2 for Just a little/3 for A lot!
    private int springOnionChoice;
    // 0 for No/ 1 for Yes
    private int noriChoice;
    // 0 for No/ 1 for Yes
    private int chashuChoice;
    // 0 for No/ 1 for Yes
    private int boiledEggChoice;
    // 0/1/2/3/4/5
    private int spicinessChoice;
    // 0 for No/ 1 for Yes
    private int extraNoriChoice;
    // 0 for No/ 1 for Yes
    private int extraBoiledEggChoice;
    // 0 for No/ 1 for Yes
    private int bambooShootsChoice;
    // 0 for No/ 1 for Yes
    private int extraChashuChoice;
    private double totalPrice;
    private Date createTime;
    //0 for not pay by stamp/1 for pay by stamp
    private int payByStamp;
    //1 for take it/0 for stay here to eat
    private int takeOrStay;
    
    public Ticket(int soupChoice, int noodlesChoice, int springOnionChoice, 
                    int noriChoice, int chashuChoice, int boiledEggChoice, int spicinessChoice,
                    int extraNoriChoice, int extraBoiledEggChoice, int bambooShootsChoice, int extraChashuChoice
                    ,int payByStamp,int takeOrStay)
    {
        this.soupChoice = soupChoice;
        this.noodlesChoice = noodlesChoice;
        this.springOnionChoice = springOnionChoice;
        this.noriChoice = noriChoice;
        this.chashuChoice = chashuChoice;
        this.boiledEggChoice = boiledEggChoice;
        this.spicinessChoice = spicinessChoice;
        this.extraNoriChoice = extraNoriChoice;
        this.extraBoiledEggChoice = extraBoiledEggChoice;
        this.bambooShootsChoice = bambooShootsChoice;
        this.extraChashuChoice = extraChashuChoice;
        this.createTime = new Date();
        this.payByStamp = payByStamp;
        this.takeOrStay = takeOrStay;
    }

    public Ticket() 
    {
        this.createTime = new Date();
    }

    public void setSoupChoice(int soupChoice) {
    	this.soupChoice = soupChoice;
    }
    
    public void setNoodlesChoice(int noodlesChoice) {
    	this.noodlesChoice = noodlesChoice;
    }
    
    public void setSpringOnionChoice(int springOnionChoice) {
    	this.springOnionChoice = springOnionChoice;
    }
    
    public void setNoriChoice(int noriChoice) {
    	this.noriChoice = noriChoice;
    }
    
    public void setChashuChoice(int chashuChoice) {
    	this.chashuChoice = chashuChoice;
    }
    
    public void setBoiledEggChoice(int boiledEggChoice) {
    	this.boiledEggChoice = boiledEggChoice;
    }
    
    public void setSpicinessChoice(int spicinessChoice) {
    	this.spicinessChoice = spicinessChoice;
    }
    
    public void setExtraNoriChoice(int extraNoriChoice) {
    	this.extraNoriChoice = extraNoriChoice;
    }
    
    public void setExtraBoiledEggChoice(int extraBoiledEggChoice) {
    	this.extraBoiledEggChoice = extraBoiledEggChoice;
    }
    
    public void setBambooShootsChoice(int bambooShootsChoice) {
    	this.bambooShootsChoice = bambooShootsChoice;
    }
    
    public void setExtraChashuChoice(int extraChashuChoice) {
    	this.extraChashuChoice = extraChashuChoice;
    }

    public void setTotalPrice(double totalPrice)
    {
        this.totalPrice = totalPrice;
    }
    
    public void setPayByStamp(int payByStamp)
    {
    	this.payByStamp = payByStamp;
    }
    
    public void setTakeOrStay(int takeOrStay)
    {
    	this.takeOrStay = takeOrStay;
    }
    
    public int getSoupChoice() {
    	return this.soupChoice;
    }
    
    public int getNoodlesChoice() {
    	return this.noodlesChoice;
    }
    
    public int getSpringOnionChoice() {
    	return this.springOnionChoice;
    }
    
    public int getNoriChoice() {
    	return this.noriChoice;
    }
    
    public int getChashuChoice() {
    	return this.chashuChoice;
    }
    
    public int getBoiledEggChoice() {
    	return this.boiledEggChoice;
    }
    
    public int getSpicinessChoice() {
    	return this.spicinessChoice;
    }
    
    public int getExtraNoriChoice() {
    	return this.extraNoriChoice;
    }
    
    public int getExtraBoiledEggChoice() {
    	return this.extraBoiledEggChoice;
    }
    
    public int getBambooShootsChoice() {
    	return this.bambooShootsChoice;
    }
    
    public int getExtraChashuChoice() {
    	return this.extraChashuChoice;
    }

    public double getTotalPrice()
    {
        return this.totalPrice;
    }

    public Date getCreateTime() {
    	return this.createTime;
    }
    
    public int getPayByStamp()
    {
    	return this.payByStamp;
    }
    
    public int getTakeOrStay()
    {
    	return this.takeOrStay;
    }
    
}