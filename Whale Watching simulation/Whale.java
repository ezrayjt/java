/**
 * A class caintain information of Whale.
 */

public class Whale
{
    private String species;
    private int calf;
    private String direction;
    private String injured;
    static int total_adults = 0;
    static int total_calves = 0;
    static int total_rare_whales = 0;
    static int Migaloo = 0;

    public Whale()
    {
        species = "unknown";
        calf = 0;
        direction = "unknown";
        injured = "Healthy";
        total_adults ++;
    }

    public Whale(String species , int calf, String direction, String injured)
    {
        this.species = species;
        this.calf = calf;
        this.direction = direction;
        this.injured = injured;
    }

    public void display()
    {
        System.out.println(); 
    }

    public String getSpecies()
    {
        return species;
    }

    public int getCalf()
    {
        return calf;
    }

    public String getDirection()
    {
        return direction;
    }

    public String getInjured()
    {
        return injured;
    }

    public void setSpecies(String species)
    {
        this.species = species;
        if (species == "Blue" || species == "Orcas")
        {
            total_rare_whales++;
        }
        else if(species == "Migaloo")
        {
            Migaloo++;
        }
    }

    public void setCalf(int calf)
    {
        this.calf = calf;
        total_calves ++;
    }

    public void setDirection(String direction)
    {
        this.direction = direction;
    }

    public void setInjured(String injured)
    {
        this.injured = injured;
    }
}

