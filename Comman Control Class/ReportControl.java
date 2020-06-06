import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;
/**
 * This is a control class for report
 * @author Yulin Zhao
 */
public class ReportControl
{
    public ReportControl()
    {

    }

    /**
     * Encapsulate the number of options by an array(Management Side)
     * @return the summary array
     */
    public int[] getVolumeReport()
    {
        // Each position corresponds to the sales volume of each material as below
        int[] volume = new int[29];
        ManagementReport report = this.generateReport();
        volume[0] = report.getSoup()[0];
        volume[1] = report.getSoup()[1];
        volume[2] = report.getSoup()[2];
        volume[3] = report.getNoodles()[0];
        volume[4] = report.getNoodles()[1];
        volume[5] = report.getNoodles()[2];
        volume[6] = report.getSpringOnion()[0];
        volume[7] = report.getSpringOnion()[1];
        volume[8] = report.getSpringOnion()[2];
        volume[9] = report.getNori()[0];
        volume[10] = report.getNori()[1];
        volume[11] = report.getChashu()[0];
        volume[12] = report.getChashu()[1];
        volume[13] = report.getBoiledEgg()[0];
        volume[14] = report.getBoiledEgg()[1];
        volume[15] = report.getSpiciness()[0];
        volume[16] = report.getSpiciness()[1];
        volume[17] = report.getSpiciness()[2];
        volume[18] = report.getSpiciness()[3];
        volume[19] = report.getSpiciness()[4];
        volume[20] = report.getSpiciness()[5];
        volume[21] = report.getExtraNori()[0];
        volume[22] = report.getExtraNori()[1];
        volume[23] = report.getExtraBoiledEgg()[0];
        volume[24] = report.getExtraBoiledEgg()[1];
        volume[25] = report.getBambooShoots()[0];
        volume[26] = report.getBambooShoots()[1];
        volume[27] = report.getExtraChashu()[0];
        volume[28] = report.getExtraChashu()[1];
        return volume;


    }
    /**
     * Encapsulate the number of options by an array(Customer side)
     * @return the summary array
     */
    public int[] getRecommendReport()
    {
        /*First 4 is the  most popular combination(Soup + Noodles + SpringOnion + Spiceness) 
        For example: 0000 means: Tonkotsu + Soft + No please + 0(Spiceness Level)
        The next 7 is other ingredients(Nori + Chashu + Boiledegg + ExNori + ExBoiledegg + Bambooshots + ExChashu)
        For example 0000000 means: 7 Yes*/
        int[] reco = new int[11];
        RecommendReport report = this.generateRecommendation();
        reco[0] = report.getPopularCollocation()[0];
        reco[1] = report.getPopularCollocation()[1];
        reco[2] = report.getPopularCollocation()[2];
        reco[3] = report.getPopularCollocation()[3];
        reco[4] = report.getPopularNori();
        reco[5] = report.getPopularChashu();
        reco[6] = report.getPopularBoiledEgg();
        reco[7] = report.getPopularExtraNori();
        reco[8] = report.getPopularExtraBoiledEgg();
        reco[9] = report.getPopularBambooShoots();
        reco[10] = report.getPopularExtraChashu();
        return reco;
    }

    /**
     * This method obtain the sales statistics of the previous week by reading the record. csv file and comparing the date.
     * @return the corresponding management part report
     */
    public ManagementReport generateReport()
    {
        String item[];
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentDate = format.format(new Date());
        String sevenDaysBefore = this.getPastDate(7);
        ManagementReport report = new ManagementReport();
        try 
        { 
            BufferedReader reader = new BufferedReader(new FileReader(FilePathGet.getpath("Record.csv")));
            //reader.readLine(); If the first line is the title
            String line = null; 
            while((line=reader.readLine())!=null)
            { 
                item = line.split(",");
                // compare the date with the range of one week
                if(item[0].compareTo(currentDate) <= 0 && item[0].compareTo(sevenDaysBefore) >= 0)
                {
                    report.addSoup(new int[]{Integer.parseInt(item[1]),Integer.parseInt(item[2]),Integer.parseInt(item[3])});
                    report.addNoodles(new int[]{Integer.parseInt(item[4]),Integer.parseInt(item[5]),Integer.parseInt(item[6])});
                    report.addSpringOnion(new int[]{Integer.parseInt(item[7]),Integer.parseInt(item[8]),Integer.parseInt(item[9])});
                    if(Integer.parseInt(item[10]) == 1)
                        report.addNori(new int[]{1,0});
                    else
                        report.addNori(new int[]{0,1});
                    if(Integer.parseInt(item[11]) == 1)
                        report.addChashu(new int[]{1,0});
                    else
                        report.addChashu(new int[]{0,1});
                    if(Integer.parseInt(item[12]) == 1)
                        report.addBoiledEgg(new int[]{1,0});
                    else
                        report.addBoiledEgg(new int[]{0,1});
                    report.addSpiciness(new int[]{Integer.parseInt(item[13]),Integer.parseInt(item[14]),Integer.parseInt(item[15]),Integer.parseInt(item[16]),Integer.parseInt(item[17]),Integer.parseInt(item[18])});
                    if(Integer.parseInt(item[19]) == 1)
                        report.addExtraNori(new int[]{1,0});
                    else
                        report.addExtraNori(new int[]{0,1});
                    if(Integer.parseInt(item[20]) == 1)
                        report.addExtraBoiledEgg(new int[]{1,0});
                    else
                        report.addExtraBoiledEgg(new int[]{0,1});
                    if(Integer.parseInt(item[21]) == 1)
                        report.addBambooShoots(new int[]{1,0});
                    else
                        report.addBambooShoots(new int[]{0,1});
                    if(Integer.parseInt(item[22]) == 1)
                        report.addExtraChashu(new int[]{1,0});
                    else
                        report.addExtraChashu(new int[]{0,1});
                }
            } 
            reader.close();
        } 
        catch (Exception e) 
        { 
            e.printStackTrace(); 
        } 
        return report;
    }

    /**
     * This method obtain the sales statistics of the all the historical data by reading the record. csv file.
     * @return the corresponding recommended combination of Ramen
     */
    public RecommendReport generateRecommendation()
    {
        int i,j,k,m;
        String item[];
        RecommendReport report = new RecommendReport();
        try 
        { 
//            BufferedReader reader = new BufferedReader(new FileReader("Record.csv"));
          BufferedReader reader = new BufferedReader(new FileReader(FilePathGet.getpath("Record.csv")));

            //reader.readLine(); If the first line is the title
            String line = null; 
            while((line=reader.readLine())!=null)
            { 
                item = line.split(",");
                // compare the date with the range of hole record
                if(Integer.parseInt(item[1]) == 1)
                    i = 0;
                else if(Integer.parseInt(item[2]) == 1)
                    i = 1;
                else 
                    i = 2;
                if(Integer.parseInt(item[4]) == 1)
                    j = 0;
                else if(Integer.parseInt(item[5]) == 1)
                    j = 1;
                else 
                    j = 2;
                if(Integer.parseInt(item[7]) == 1)
                    k = 0;
                else if(Integer.parseInt(item[8]) == 1)
                    k = 1;
                else 
                    k = 2;
                if(Integer.parseInt(item[10]) == 1)
                    report.addNori(new int[]{1,0});
                else
                    report.addNori(new int[]{0,1});
                if(Integer.parseInt(item[11]) == 1)
                    report.addChashu(new int[]{1,0});
                else
                    report.addChashu(new int[]{0,1});
                if(Integer.parseInt(item[12]) == 1)
                    report.addBoiledEgg(new int[]{1,0});
                else
                    report.addBoiledEgg(new int[]{0,1});
                if(Integer.parseInt(item[13]) == 1)
                    m = 0;
                else if(Integer.parseInt(item[14]) == 1)
                    m = 1;
                else if(Integer.parseInt(item[15]) == 1)
                    m = 2;
                else if(Integer.parseInt(item[16]) == 1)
                    m = 3;
                else if(Integer.parseInt(item[17]) == 1)
                    m = 4;
                else
                    m = 5;
                report.addPopular(i, j, k, m);
                if(Integer.parseInt(item[19]) == 1)
                    report.addExtraNori(new int[]{1,0});
                else
                    report.addExtraNori(new int[]{0,1});
                if(Integer.parseInt(item[20]) == 1)
                    report.addExtraBoiledEgg(new int[]{1,0});
                else
                    report.addExtraBoiledEgg(new int[]{0,1});
                if(Integer.parseInt(item[21]) == 1)
                    report.addBambooShoots(new int[]{1,0});
                else
                    report.addBambooShoots(new int[]{0,1});
                if(Integer.parseInt(item[22]) == 1)
                    report.addExtraChashu(new int[]{1,0});
                else
                    report.addExtraChashu(new int[]{0,1});
            } 
            reader.close();
        } 
        catch (Exception e) 
        { 
            e.printStackTrace(); 
        } 
        return report;
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