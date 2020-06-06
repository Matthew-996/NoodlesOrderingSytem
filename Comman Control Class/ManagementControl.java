import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * This class is a contol class to be used to modify Ramen object and file named "Ramen.dat"  
 * @author Bailin Rong
 */

public class ManagementControl
{
	/**
	 * get corresponding state of soup in Ramen
	 * @param ramen To represent the object in Ramen.dat and be used in other part
	 * @return state of soup
	 */
    public int[] getSoup(Ramen ramen)
    {
        return ramen.getSoup();
    }
    
    /**
	 * get corresponding state of Noodles in Ramen
	 * @param ramen To represent the object in Ramen.dat and be used in other part
	 * @return state of Noodles
	 */
    public int[] getNoodles(Ramen ramen)
    {
        return ramen.getNoodles();
    }
    
    /**
   	 * get corresponding state of SpringOnion in Ramen
   	 * @param ramen To represent the object in Ramen.dat and be used in other part
   	 * @return state of SpringOnion
   	 */
    public int[] getSpringOnion(Ramen ramen)
    {
        return ramen.getSpringOnion();
    }
    
    /**
   	 * get corresponding state of Nori in Ramen
   	 * @param ramen To represent the object in Ramen.dat and be used in other part
   	 * @return state of Nori
   	 */
    public int[] getNori(Ramen ramen)
    {
        return ramen.getNori();
    }
    
    /**
   	 * get corresponding state of Chashu in Ramen
   	 * @param ramen To represent the object in Ramen.dat and be used in other part
   	 * @return state of Chashu
   	 */
    public int[] getChashu(Ramen ramen)
    {
        return ramen.getChashu();
    }
    
    /**
   	 * get corresponding state of BoiledEgg in Ramen
   	 * @param ramen To represent the object in Ramen.dat and be used in other part
   	 * @return state of BoiledEgg
   	 */
    public int[] getBoiledEgg(Ramen ramen)
    {
        return ramen.getBoiledEgg();
    }
    
    /**
   	 * get corresponding state of Spiciness in Ramen
   	 * @param ramen To represent the object in Ramen.dat and be used in other part
   	 * @return state of Spiciness
   	 */
    public int[] getSpiciness(Ramen ramen)
    {
        return ramen.getSpiciness();
    }
    
    /**
   	 * get corresponding Price of extra nori in Ramen
   	 * @param ramen To represent the object in Ramen.dat and be used in other part
   	 * @return price of extra nori
   	 */
    public float getExtraNoriPrice(Ramen ramen)
    {
        return ramen.getExtraNoriPrice();
    }
    
    /**
   	 * get corresponding state of extra nori in Ramen
   	 * @param ramen To represent the object in Ramen.dat and be used in other part
   	 * @return state of extra nori
   	 */
    public float getExtraNori(Ramen ramen)
    {
        return ramen.getExtraNori();
    }

    /**
   	 * get corresponding Price of extra boiled egg in Ramen
   	 * @param ramen To represent the object in Ramen.dat and be used in other part
   	 * @return price of extra boiled egg
   	 */
    public float getExtraBoiledEggPrice(Ramen ramen)
    {
        return ramen.getExtraBoiledEggPrice();
    }
    
    /**
   	 * get corresponding state of extra boiled egg in Ramen
   	 * @param ramen To represent the object in Ramen.dat and be used in other part
   	 * @return state of extra boiled egg
   	 */
    public float getExtraBoiledEgg(Ramen ramen)
    {
        return ramen.getExtraBoiledEgg();
    }
    
    
    /**
   	 * get corresponding Price of bambooshoots in Ramen
   	 * @param ramen To represent the object in Ramen.dat and be used in other part
   	 * @return price of bambooshoots
   	 */
    public float getBambooShootsPrice(Ramen ramen)
    {
        return ramen.getBambooShootsPrice();
    }
    
    /**
   	 * get corresponding state of bambooshoots in Ramen
   	 * @param ramen To represent the object in Ramen.dat and be used in other part
   	 * @return state of bambooshoots
   	 */
    public float getBambooShoots(Ramen ramen)
    {
        return ramen.getBambooShoots();
    }
    
    /**
   	 * get corresponding Price of extra Chashu in Ramen
   	 * @param ramen To represent the object in Ramen.dat and be used in other part
   	 * @return price of extra Chashu
   	 */
    public float getExtraChashuPrice(Ramen ramen)
    {
        return ramen.getExtraChashuPrice();
    }
    
    
    /**
   	 * get corresponding state of extra Chashu in Ramen
   	 * @param ramen To represent the object in Ramen.dat and be used in other part
   	 * @return state of extra Chashu
   	 */
    public float getExtraChashu(Ramen ramen)
    {
        return ramen.getExtraChashu();
    }

    /**
	 * set corresponding state of soup in Ramen
	 * @param ramen To represent the object in Ramen.dat and be used in other part
	 * @param soup the array to represent the state of soup and will be used to modify Ramen object.
	 */
    public void setSoup(Ramen ramen,int soup[])
    {
        ramen.setSoup(soup);
    }
    
    /**
	 * set corresponding state of noodles in Ramen
	 * @param ramen To represent the object in Ramen.dat and be used in other part
	 * @param noodles the array to represent the state of noodles and will be used to modify Ramen object.
	 */
    public void setNoodles(Ramen ramen,int noodles[])
    {
        ramen.setNoodles(noodles);
    }
    
    /**
	 * set corresponding state of spingOnion in Ramen
	 * @param ramen To represent the object in Ramen.dat and be used in other part
	 * @param springOnion the array to represent the state of springOnion and will be used to modify Ramen object.
	 */
    public void setSpringOnion(Ramen ramen, int springOnion[])
    {
        ramen.setSpringOnion(springOnion);
    }
    
    /**
	 * set corresponding state of nori in Ramen
	 * @param ramen To represent the object in Ramen.dat and be used in other part
	 * @param nori  the array to represent the state of nori and will be used to modify Ramen object.
	 */
    public void setNori(Ramen ramen, int nori[])
    {
        ramen.setNori(nori);
    }
    
    /**
	 * set corresponding state of chashu in Ramen
	 * @param ramen To represent the object in Ramen.dat and be used in other part
	 * @param chashu the array to represent the state of chashu and will be used to modify Ramen object
	 */
    public void setChashu(Ramen ramen,int chashu[])
    {
        ramen.setChashu(chashu);
    }
    
    /**
	 * set corresponding state of boiledEgg in Ramen
	 * @param ramen To represent the object in Ramen.dat and be used in other part
	 * @param boiledEgg the array to represent the state of boiledEgg and will be used to modify Ramen object
	 */
    public void setBoiledEgg(Ramen ramen, int boiledEgg[])
    {
        ramen.setBoiledEgg(boiledEgg);
    }
    
    /**
	 * set corresponding state of spiciness in Ramen
	 * @param ramen To represent the object in Ramen.dat and be used in other part
	 * @param spiciness the array to represent the state of spiciness and will be used to modify Ramen object
	 */
    public void setSpiciness(Ramen ramen, int spiciness[])
    {
        ramen.setSpiciness(spiciness);
    }
    
    /**
   	 * set corresponding Price of extra nori in Ramen
   	 * @param ramen To represent the object in Ramen.dat and be used in other part
   	 * @param extraNoriPrice To represent the price of extraNori and will be used to modify Ramen object
   	 */
    public void setExtraNoriPrice(Ramen ramen, float extraNoriPrice)
    {
        ramen.setExtraNoriPrice(extraNoriPrice);
    }
    
    /**
   	 * set corresponding state of extra nori in Ramen
   	 * @param ramen To represent the object in Ramen.dat and be used in other part
   	 * @param extraNori To represent the state of extraNori and will be used to modify Ramen object
   	 */
    public void setExtraNori(Ramen ramen, float extraNori)
    {
        ramen.setExtraNori(extraNori);
    }
    
    /**
   	 * set corresponding Price of extra BoiledEgg in Ramen
   	 * @param ramen To represent the object in Ramen.dat and be used in other part
   	 * @param extraBoiledEggPrice To represent the price of extraBoiledEgg and will be used to modify Ramen object
   	 */
    public void setExtraBoiledEggPrice(Ramen ramen, float extraBoiledEggPrice)
    {
        ramen.setExtraBoiledEggPrice(extraBoiledEggPrice);
    }
    
    /**
   	 * set corresponding state of extra BoiledEgg in Ramen
   	 * @param ramen To represent the object in Ramen.dat and be used in other part
   	 * @param extraBoiledEgg To represent the state of extraBoiledEgg and will be used to modify Ramen object
   	 */ 
    public void setExtraBoiledEgg(Ramen ramen, float extraBoiledEgg)
    {
        ramen.setExtraBoiledEgg(extraBoiledEgg);
    }
    
    /**
   	 * set corresponding Price of BambooShoots in Ramen
   	 * @param ramen To represent the object in Ramen.dat and be used in other part
   	 * @param bambooShootsPrice To represent the price of bambooShoots and will be used to modify Ramen object
   	 */
    public void setBambooShootsPrice(Ramen ramen, float bambooShootsPrice)
    {
        ramen.setBambooShootsPrice(bambooShootsPrice);
    }
    
    /**
   	 * set corresponding state of extra BambooShoots in Ramen
   	 * @param ramen To represent the object in Ramen.dat and be used in other part
   	 * @param bambooShoots To represent the state of bambooShoots and will be used to modify Ramen object
   	 */
    public void setBambooShoots(Ramen ramen, float bambooShoots)
    {
        ramen.setBambooShoots(bambooShoots);
    }
    
    /**
   	 * set corresponding Price of extra Chashu in Ramen
   	 * @param ramen To represent the object in Ramen.dat and be used in other part
   	 * @param extraChashuPrice To represent the price of extraChashu and will be used to modify Ramen object
   	 */
    public void setExtraChashuPrice(Ramen ramen, float extraChashuPrice)
    {
        ramen.setExtraChashuPrice(extraChashuPrice);
    }
    
    /**
   	 * set corresponding state of extra Chashu in Ramen
   	 * @param ramen To represent the object in Ramen.dat and be used in other part
   	 * @param extraChashu To represent the state of extraChashu and will be used to modify Ramen object
   	 */
    public void setExtraChashu(Ramen ramen, float extraChashu)
    {
        ramen.setExtraChashu(extraChashu);
    }

    /**
   	 * change the Ramen.dat by the newRamen
   	 * @param newRamen To represent the object that will be updated in Ramen.dat 
   	 */
    static public void RamenWrite(Ramen newRamen)
    {

        try {
            ObjectOutputStream os=new ObjectOutputStream(new FileOutputStream(new File(FilePathGet.getpath("Ramen.dat"))));
            os.writeObject(newRamen);
            os.close();
        }
        catch(IOException i)
        {
            i.printStackTrace();
            return;
        }
    }
    
    /**
   	 * get the data of Ramen.dat and convert into the Ramen object
   	 * @return the Ramen object from Ramen.dat
   	 */
    static public Ramen RamenRead()
    {
        Ramen backRamen = null;

        try {
            FileInputStream fileIn = new FileInputStream(FilePathGet.getpath("Ramen.dat"));
            ObjectInputStream in = new ObjectInputStream(fileIn);
            backRamen = (Ramen) in.readObject();
            in.close();
            fileIn.close();
            return backRamen;
        }catch(IOException i) {
            i.printStackTrace();
            return null;
        }catch(ClassNotFoundException c) {

            System.out.println("Ramen class not found");
            c.printStackTrace();
            return null;
        }
    }

}
