/**
 * This is a suerclass of two kind of report used in management and customer parts
 * @author Yulin Zhao
 */
public class Report 
{
    /* we use some array to indicates one report
    These 7 arrays represent the volume 7 required options choosen(onle for last week in management part) used both by two parts of reports*/
    // Yes/No
    protected int[] nori;
    // Yes/No
    protected int[] chashu;
    // Yes/No
    protected int[] boiledEgg;
    // Yes/No
    protected int[] extraNori;
    // Yes/No
    protected int[] extraBoiledEgg;
    // Yes/No
    protected int[] bambooShoots;
    // Yes/No
    protected int[] extraChashu;

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

    public int[] getExtraNori()
    {
        return extraNori;
    }

    public int[] getExtraBoiledEgg()
    {
        return extraBoiledEgg;
    }

    public int[] getBambooShoots()
    {
        return bambooShoots;
    }

    public int[] getExtraChashu()
    {
        return extraChashu;
    }

    public void addNori(int[] add)
    {
        this.nori[0] += add[0];
        this.nori[1] += add[1];
    }

    public void addChashu(int[] add)
    {
        this.chashu[0] += add[0];
        this.chashu[1] += add[1];
    }

    public void addBoiledEgg(int[] add)
    {
        this.boiledEgg[0] += add[0];
        this.boiledEgg[1] += add[1];
    }

    public void addExtraNori(int[] add)
    {
        this.extraNori[0] += add[0];
        this.extraNori[1] += add[1];
    }

    public void addExtraBoiledEgg(int[] add)
    {
        this.extraBoiledEgg[0] += add[0];
        this.extraBoiledEgg[1] += add[1];
    }

    public void addBambooShoots(int[] add)
    {
        this.bambooShoots[0] += add[0];
        this.bambooShoots[1] += add[1];
    }

    public void addExtraChashu(int[] add)
    {
        this.extraChashu[0] += add[0];
        this.extraChashu[1] += add[1];
    }
}