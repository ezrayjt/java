import java.util.ArrayList;
/**
 * A class caintain location information.
 */
public class Location
{   
    private String location;
    private int adultWhaleNum;
    private ArrayList<Whale> whalesList;
    private int calfNum;
    private int WWLD;
    private String scientist;
    
    public Location()
    {
        location = "unknown";
        adultWhaleNum = 0;
        whalesList = new ArrayList<Whale>();
        calfNum = 0;
        WWLD = 0;
    }

    public Location(String location, int adultWahleNum , ArrayList<Whale> whalesList, int calfNum , int WWLD)
    {
        this.location = location;
        this.adultWhaleNum = adultWhaleNum;
        this.whalesList = whalesList;
        this.calfNum = calfNum;
        this.WWLD = WWLD;
    }

    public void setScientist(String scientist)
    {
        this.scientist = scientist;
    }

    public String getScientist()
    {
        return scientist;
    }

    public void setWWLD()
    {
        WWLD = Whale.total_adults + 2 * Whale.total_calves + 4 * Whale.total_rare_whales + 10 * Whale.Migaloo;
        Whale.total_adults = 0;
        Whale.total_calves = 0;
        Whale.total_rare_whales = 0;
        Whale.Migaloo = 0;
    }

    public int getWWLD()
    {
        return WWLD;
    }

    public void setCalfNum()
    {
        calfNum++;
    }

    public int getCalfNum()
    {
        return calfNum;
    }

    public void setWhalesList()
    {
        whalesList.add(new Whale());
    }

    public ArrayList<Whale> getWhalesList()
    {
        return whalesList;
    }

    public String getLocation()
    {
        return location;
    }

    public void setLocation(String location)
    {
        this.location = location;
    }

    public int getAdultWhaleNum()
    {
        return adultWhaleNum;
    }

    public void setAdultWhaleNum()
    {
        adultWhaleNum = RandomNumber.randomNum(0,9);
    }
}
