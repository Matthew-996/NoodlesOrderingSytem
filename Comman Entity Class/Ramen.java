import java.io.Serializable;
/**
 * This class is an entity class to represent the state of the buttons(options) in menu that customer to choose
 * The variables in this class will be changed by using the method in ManagementControl class,which done by call the setMethod and getMethod in this Class. 
 * Finally the Ramen object will be store or changed in file "Ramen.dat"
 * Other class should use ManagementControl class to understand the state of buttons(options) in menu
 * @author Bailin Rong
 */
public class Ramen implements Serializable{
    /* we use array to indicates whether the material corresponding to this option is valid
    First 7 arrays represent the validation of 7 required options*/
    // Tonkotsu/Shoyu/Shio
    private int[] soup;
    // Soft/Medium/Firm
    private int[] noodles;
    // No please/Just a little/A lot!
    private int[] springOnion;
    // Yes/No
    private int[] nori;
    // Yes/No
    private int[] chashu;
    // Yes/No
    private int[] boiledEgg;
    // 0/1/2/3/4/5
    private int[] spiciness;
    //These 4 arrays stand for price/validation which is different from first 7
    private float[] extraNori;
    private float[] extraBoiledEgg;
    private float[] bambooShoots;
    private float[] extraChashu;

    public Ramen(int[] soup,int[] noodles,int[] springOnion,int[] nori,int[] chashu,int[] boiledEgg,int[] spiciness,
                 float[] extraNori,float[] extraBoiledEgg,float[] bambooShoots,float[] extraChashu)

    {
        this.soup = soup;
        this.noodles = noodles;
        this.springOnion = springOnion;
        this.nori = nori;
        this.chashu = chashu;
        this.boiledEgg = boiledEgg;
        this.spiciness = spiciness;
        this.extraNori = extraNori;
        this.extraBoiledEgg = extraBoiledEgg;
        this.bambooShoots = bambooShoots;
        this.extraChashu = extraChashu;
    }

    public Ramen()
    {
        this.soup = new int[]{1,1,1};
        this.noodles = new int[]{1,1,1};
        this.springOnion = new int[]{1,1,1};
        this.nori = new int[]{1,1};
        this.chashu = new int[]{1,1};
        this.boiledEgg = new int[]{1,1};
        this.spiciness = new int[]{1,1,1,1,1,1};

        this.extraNori = new float[]{2,1};
        this.extraBoiledEgg = new float[]{1,1};
        this.bambooShoots = new float[]{1,1};
        this.extraChashu = new float[]{1,1};
    }

    public int[] getSoup()
    {
        return soup;
    }

    public int[] getNoodles()
    {
        return noodles;
    }

    public int[] getSpringOnion()
    {
        return springOnion;
    }

    public int[] getNori()
    {
        return nori;
    }

    public int[] getChashu()
    {
        return chashu;
    }

    public int[] getBoiledEgg()
    {
        return boiledEgg;
    }

    public int[] getSpiciness()
    {
        return spiciness;
    }

    public float getExtraNoriPrice()
    {
        return extraNori[0];
    }

    public float getExtraNori()
    {
        return extraNori[1];
    }

    public float getExtraBoiledEggPrice()
    {
        return extraBoiledEgg[0];
    }

    public float getExtraBoiledEgg()
    {
        return extraBoiledEgg[1];
    }

    public float getBambooShootsPrice()
    {
        return bambooShoots[0];
    }

    public float getBambooShoots()
    {
        return bambooShoots[1];
    }

    public float getExtraChashuPrice()
    {
        return extraChashu[0];
    }

    public float getExtraChashu()
    {
        return extraChashu[1];
    }

    public void setSoup(int[] soup)
    {
        this.soup = soup;
    }

    public void setNoodles(int[] noodles)
    {
        this.noodles = noodles;
    }

    public void setSpringOnion(int[] springOnion)
    {
        this.springOnion = springOnion;
    }

    public void setNori(int[] nori)
    {
        this.nori = nori;
    }

    public void setChashu(int[] chashu)
    {
        this.chashu = chashu;
    }

    public void setBoiledEgg(int[] boiledEgg)
    {
        this.boiledEgg = boiledEgg;
    }

    public void setSpiciness(int[] spiciness)
    {
        this.spiciness = spiciness;
    }

    public void setExtraNoriPrice(float extraNoriPrice)
    {
        this.extraNori[0] = extraNoriPrice;
    }

    public void setExtraNori(float extraNori)
    {
        this.extraNori[1] = extraNori;
    }

    public void setExtraBoiledEggPrice(float extraBoiledEggPrice)
    {
        this.extraBoiledEgg[0] = extraBoiledEggPrice;
    }

    public void setExtraBoiledEgg(float extraBoiledEgg)
    {
        this.extraBoiledEgg[1] = extraBoiledEgg;
    }

    public void setBambooShootsPrice(float bambooShootsPrice)
    {
        this.bambooShoots[0] = bambooShootsPrice;
    }

    public void setBambooShoots(float bambooShoots)
    {
        this.bambooShoots[1] = bambooShoots;
    }

    public void setExtraChashuPrice(float extraChashuPrice)
    {
        this.extraChashu[0] = extraChashuPrice;
    }

    public void setExtraChashu(float extraChashu)
    {
        this.extraChashu[1] = extraChashu;
    }

}

