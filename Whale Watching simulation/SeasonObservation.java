/**
 * A class caintain information of data over all four locations.
 * and have some functions to record the data.
 */

public class SeasonObservation
{
    static int InjuredNumHumpback = 0;
    static int injuredNumMinke = 0;
    static int injuredNumSouthernRight = 0;
    static int injuredNumBlue = 0;
    static int injuredNumOrcas = 0;
    static int injuredNumMigaloo = 0;
    static int total_Humpback = 0;
    static int total_Minke = 0;
    static int total_SouthernRight = 0;
    static int total_Blue = 0;
    static int total_Orcas = 0;
    static int total_Humpback_calves = 0;
    static int total_Minke_calves = 0;
    static int total_SouthernRight_calves = 0;
    static int total_Blue_calves = 0;
    static int total_Orcas_calves = 0;

    public static void setSpeciesNum(String species)
    {
        if (species == "Humpback")
        {
            total_Humpback++;
        }
        else if (species == "Minke")
        {
            total_Minke++;
        }
        else if (species == "Southern Right")
        {
            total_SouthernRight++;
        }
        else if (species == "Orcas")
        {
            total_Orcas++;
        }
        else if (species == "Blue")
        {
            total_Blue++;
        }
    }

    public static void setCalvesNum(String species)
    {
        if (species == "Humpback")
        {
            total_Humpback_calves++;
        }
        else if (species == "Minke")
        {
            total_Minke_calves++;
        }
        else if (species == "Southern Right")
        {
            total_SouthernRight_calves++;
        }
        else if (species == "Orcas")
        {
            total_Orcas_calves++;
        }
        else if (species == "Blue")
        {
            total_Blue_calves++;
        }
    }

    public static void setInjuredNum(String species)
    {
        if(species == "Humpback")
        {
            InjuredNumHumpback++;
        }
        else if(species == "Minke")
        {
            injuredNumMinke++;
        }
        else if(species == "Southern Right")
        {
            injuredNumSouthernRight++;
        }
        else if(species == "Blue")
        {
            injuredNumBlue++;
        }
        else if(species == "Orcas")
        {
            injuredNumOrcas++;
        }
        else if(species == "Migaloo")
        {
            injuredNumMigaloo++;
        }
    }
}
