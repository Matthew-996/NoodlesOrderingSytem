/**
 * This is an entity class for customer part(last week) report used for recommend best selling Ramen combination
 * @author Yulin Zhao
 */
public class RecommendReport extends Report
{
    //Array to store 3*3*3*6 kinds of ramen combination
    private int[][][][] total;

    public RecommendReport()
    {
        this.total = new int[3][3][3][6];
        this.nori = new int[]{0,0};
        this.chashu = new int[]{0,0};
        this.boiledEgg = new int[]{0,0};

        this.extraNori = new int[]{0,0};
        this.extraBoiledEgg = new int[]{0,0};
        this.bambooShoots = new int[]{0,0};
        this.extraChashu = new int[]{0,0};
    }

    public int[] getPopularCollocation()
    {
        int[] collo = new int[4];
        int i, j, k, m;
        int max = total[0][0][0][0];
        for(i = 0; i < 3; i++)
            for(j = 0; j < 3; j++)
                for(k = 0; k < 3; k++)
                    for(m = 0; m < 6; m++)
                        if(total[i][j][k][m] > max)
                        {
                            collo[0] = i;
                            collo[1] = j;
                            collo[2] = k;
                            collo[3] = m;
                            max = total[i][j][k][m];
                        }
        return collo;
    }

    public void addPopular(int i, int j, int k, int m)
    {
        total[i][j][k][m]++;
    }
    //Compare the number of people who choose yes with that of people who choose no
    public int getPopularNori()
    {
        if(this.nori[0] >= this.nori[1])
            return 0;
        else
            return 1;
    }
    //Compare the number of people who choose yes with that of people who choose no
    public int getPopularChashu()
    {
        if(this.chashu[0] >= this.chashu[1])
            return 0;
        else
            return 1;
    }
    //Compare the number of people who choose yes with that of people who choose no
    public int getPopularBoiledEgg()
    {
        if(this.boiledEgg[0] >= this.boiledEgg[1])
            return 0;
        else
            return 1;
    }
    //Compare the number of people who choose yes with that of people who choose no
    public int getPopularExtraNori()
    {
        if(this.extraNori[0] >= this.extraNori[1])
            return 0;
        else
            return 1;
    }
    //Compare the number of people who choose yes with that of people who choose no
    public int getPopularExtraBoiledEgg()
    {
        if(this.extraBoiledEgg[0] >= this.extraBoiledEgg[1])
            return 0;
        else
            return 1;
    }
    //Compare the number of people who choose yes with that of people who choose no
    public int getPopularBambooShoots()
    {
        if(this.bambooShoots[0] >= this.bambooShoots[1])
            return 0;
        else
            return 1;
    }
    //Compare the number of people who choose yes with that of people who choose no
    public int getPopularExtraChashu()
    {
        if(this.extraChashu[0] >= this.extraChashu[1])
            return 0;
        else
            return 1;
    }
}