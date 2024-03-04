import java.util.Scanner;
import java.util.ArrayList;
/**
 * A class caintains main function to achieve all functionalities
 * to conbine with all other classes.
 */
public class WhaleWatching
{   
    static Location[] locationList = new Location[4];
    private static boolean flag = true;
    private static String scientist1;
    private static String scientist2;
    private static String scientist3;
    private static String scientist4;

    public static void simulation()
    {   
        Scanner input = new Scanner(System.in);
        System.out.println("------------Welcome to Whale Watching simulation----------");
        System.out.println("please input scientists's name for each location.");
        System.out.println("Eden: ");
        scientist1 = input.nextLine();
        System.out.println("Jervis Bay: ");
        scientist2 = input.nextLine();
        System.out.println("Byron Bay: ");
        scientist3 = input.nextLine();
        System.out.println("Hervey Bay: ");
        scientist4 = input.nextLine();
        setUp();
        display();
        FileEditor.update();
    }

    public static void setLocation()
    {   
        ArrayList<Whale> EdenWhales = new ArrayList<Whale>();
        ArrayList<Whale> JervisBayWhales = new ArrayList<Whale>();
        ArrayList<Whale> ByronBayWhales = new ArrayList<Whale>();
        ArrayList<Whale> HerveyBayWhales = new ArrayList<Whale>();

        Location Eden = new Location("Eden", 0, EdenWhales, 0, 0);
        Location JervisBay = new Location("Jervis Bay", 0, JervisBayWhales, 0, 0);
        Location ByronBay = new Location("Byron Bay", 0, ByronBayWhales, 0, 0);
        Location HerveyBay = new Location("Hervey Bay", 0, HerveyBayWhales, 0, 0);

        Eden.setAdultWhaleNum();
        JervisBay.setAdultWhaleNum();
        ByronBay.setAdultWhaleNum();
        HerveyBay.setAdultWhaleNum();

        Eden.setScientist(scientist1);
        JervisBay.setScientist(scientist2);
        ByronBay.setScientist(scientist3);
        HerveyBay.setScientist(scientist4);

        locationList[0] = Eden;
        locationList[1] = JervisBay;
        locationList[2] = ByronBay;
        locationList[3] = HerveyBay;
    }

    public static void setWhale(Whale whale, int i)
    {   
        int percent_whale = RandomNumber.randomNum(1,100);
        if(percent_whale>=1 && percent_whale <= 50)
        {   
            if(RandomNumber.randomNum(1,100)==1 && flag)
            {
                whale.setSpecies("Migaloo");
                flag = false;
            }
            else
            {
                whale.setSpecies("Humpback");
            }
        }
        else if (percent_whale>=51 && percent_whale <= 75)
        {   
            whale.setSpecies("Minke");
        }
        else if (percent_whale >=76 && percent_whale <= 95)
        {
            whale.setSpecies("Southern Right");
        }
        else if (percent_whale >=96 && percent_whale <= 98)
        {
            whale.setSpecies("Blue");
        }
        else if (percent_whale >=99 && percent_whale <= 100)
        {
            whale.setSpecies("Orcas");
        }

        SeasonObservation.setSpeciesNum(whale.getSpecies());

        int percent_direction = RandomNumber.randomNum(0,1);
        if (percent_direction == 1)
        {
            whale.setDirection("north");
        }
        else
        {
            whale.setDirection("south");
            if (RandomNumber.randomNum(0,1) == 1)
            {
                whale.setCalf(1);
                locationList[i].setCalfNum();
                SeasonObservation.setCalvesNum(whale.getSpecies());
                if(RandomNumber.randomNum(1,10) == 1)
                {
                    SeasonObservation.setInjuredNum(whale.getSpecies());
                }
            }
        }

        if(RandomNumber.randomNum(1,10) == 1)
        {
            whale.setInjured("injured");
            SeasonObservation.setInjuredNum(whale.getSpecies());
        }
    }

    public static void setUp()
    {
        setLocation();
        for (int i = 0; i< 4 ; i++)
        {
            for(int j = 0; j < locationList[i].getAdultWhaleNum() ; j++)
            {
                locationList[i].setWhalesList();
                setWhale(locationList[i].getWhalesList().get(j),i);
            }
            locationList[i].setWWLD();
        }
    }

    public static void display()
    {   
        for(int i = 0; i < 4;i++)
        {   
            System.out.println("==================="+locationList[i].getLocation()+"========================");
            System.out.println("reported by Scientst : " + locationList[i].getScientist() + "\n");
            System.out.println("Total number of whales: " + (locationList[i].getAdultWhaleNum() + locationList[i].getCalfNum()));
            for(Whale whale : locationList[i].getWhalesList())
            {   
                if(whale.getSpecies() == "Migaloo")
                {
                    System.out.println("Migaloo is sighted!");
                    System.out.println("Direction: " + whale.getDirection());
                    System.out.println("Health condition: " + whale.getInjured());
                }
                else
                {
                    System.out.println("species of whale: " + whale.getSpecies());
                    System.out.println("Direction: " + whale.getDirection());
                    System.out.println("accompanying calf: " + whale.getCalf());
                    System.out.println("Health condition: " + whale.getInjured());
                }
            }
            System.out.println();
        }
        System.out.println("*********************************************************");
        System.out.println();
        System.out.println("All four locations'information have been shown above.\nNow let's see the information for each species:\n");
        System.out.println("Total number with calves observed over the four locations:");
        System.out.println("---------------------------------------");
        System.out.println("1. Humpback: " + SeasonObservation.total_Humpback + " adults with " + SeasonObservation.total_Humpback_calves + " calves");
        System.out.println("Total number of injured Humpback is " + SeasonObservation.InjuredNumHumpback);
        System.out.println("2. Minke: " + SeasonObservation.total_Minke + " adults with " + SeasonObservation.total_Minke_calves + " calves");
        System.out.println("Total number of injured Minke is " + SeasonObservation.injuredNumMinke);
        System.out.println("3. Southern Right: " + SeasonObservation.total_SouthernRight + " adults with " + SeasonObservation.total_SouthernRight_calves + " calves");
        System.out.println("Total number of injured Southern Right is " + SeasonObservation.injuredNumSouthernRight);
        System.out.println("4. Blue: " + SeasonObservation.total_Blue + " adults with " + SeasonObservation.total_Blue_calves + " calves");
        System.out.println("Total number of injured Blue is " + SeasonObservation.injuredNumBlue);
        System.out.println("5. Orcas: " + SeasonObservation.total_Orcas + " adults with " + SeasonObservation.total_Orcas_calves + " calves");
        System.out.println("Total number of injured Orcas is " + SeasonObservation.injuredNumOrcas);
        System.out.println("---------------------------------------");
        System.out.println();

        if(!flag)
        {
            System.out.println("Migaloo is sighted today!");
        }
        else
        {
            System.out.println("Migaloo didn't come today. Try next time!");
        }

        System.out.println();
        System.out.println("****************WWLD**************");
        System.out.println();

        if(locationList[0].getWWLD() > locationList[1].getWWLD() && locationList[0].getWWLD() > locationList[2].getWWLD() && locationList[0].getWWLD() > locationList[3].getWWLD())
        {
            System.out.println("The most desirable location to view whales is " + locationList[0].getLocation() + "!\n\n");
        }
        else if(locationList[1].getWWLD() > locationList[0].getWWLD() && locationList[1].getWWLD() > locationList[2].getWWLD() && locationList[1].getWWLD() > locationList[3].getWWLD())
        {
            System.out.println("The most desirable location to view whales is " + locationList[1].getLocation() + "!\n\n");
        }
        else if(locationList[2].getWWLD() > locationList[1].getWWLD() && locationList[2].getWWLD() > locationList[0].getWWLD() && locationList[2].getWWLD() > locationList[3].getWWLD())
        {
            System.out.println("The most desirable location to view whales is " + locationList[2].getLocation() + "!\n\n");
        }
        else if(locationList[3].getWWLD() > locationList[1].getWWLD() && locationList[3].getWWLD() > locationList[2].getWWLD() && locationList[3].getWWLD() > locationList[0].getWWLD())
        {
            System.out.println("The most desirable location to view whales is " + locationList[3].getLocation() + "!\n\n");
        }
    }

    public static void main(String[] args)
    {
        simulation();
    }
}
