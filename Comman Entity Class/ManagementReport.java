/**
 * This is an entity class for management part(last week) report
 * @author Yulin Zhao
 */
public class ManagementReport extends Report
{
    // Tonkotsu/Shoyu/Shio
    private int[] soup;
    // Soft/Medium/Firm
    private int[] noodles;
    // No please/Just a little/A lot!
    private int[] springOnion;
    // 0/1/2/3/4/5
    private int[] spiciness;

    public ManagementReport()
    {
        this.soup = new int[]{0,0,0};
        this.noodles = new int[]{0,0,0};
        this.springOnion = new int[]{0,0,0};
        this.nori = new int[]{0,0};
        this.chashu = new int[]{0,0};
        this.boiledEgg = new int[]{0,0};

        this.spiciness = new int[]{0,0,0,0,0,0};

        this.extraNori = new int[]{0,0};
        this.extraBoiledEgg = new int[]{0,0};
        this.bambooShoots = new int[]{0,0};
        this.extraChashu = new int[]{0,0};
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

    public int[] getSpiciness()
    {
        return spiciness;
    }

    public void addSoup(int[] add)
    {
        this.soup[0] += add[0];
        this.soup[1] += add[1];
        this.soup[2] += add[2];
    }

    public void addNoodles(int[] add)
    {
        this.noodles[0] += add[0];
        this.noodles[1] += add[1];
        this.noodles[2] += add[2];
    }

    public void addSpringOnion(int[] add)
    {
        this.springOnion[0] += add[0];
        this.springOnion[1] += add[1];
        this.springOnion[2] += add[2];
    }

    public void addSpiciness(int[] add)
    {
        this.spiciness[0] += add[0];
        this.spiciness[1] += add[1];
        this.spiciness[2] += add[2];
        this.spiciness[3] += add[3];
        this.spiciness[4] += add[4];
        this.spiciness[5] += add[5];
    }
}