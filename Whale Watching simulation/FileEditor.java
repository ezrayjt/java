import java.util.Scanner;
import java.io.FileReader;
import java.io.FileWriter;
/**
 * A class caintain function to read and update the file.and create a new file.
 */
public class FileEditor
{   
    private static String fileContent = "";
    /**
    * This method create a reader object and store the content of the file.then return
    * it to be used for different purpose.
    */
    public static void read()
    {
        try
        {
            FileReader reader = new FileReader("seasonObservations.txt");
            Scanner scan = new Scanner(reader);
            while(scan.hasNextLine())
            {
                fileContent = fileContent.concat(scan.nextLine() + "\n");
            }
            try
            {
                reader.close();
            }
            catch(Exception e)
            {
                System.out.println("something went wrong while reading");
            }
        }
        catch(Exception e)
        {
            System.out.println("something went wrong");
        }
    }

    public static String[][] sortInfo()
    {
        String[] file_location = fileContent.split("\n");
        String[][] file_locationInfo = {file_location[0].split(","),file_location[1].split(","),file_location[2].split(","),file_location[3].split(",")};
        for(int i = 0 ; i <4 ; i++)
        {   
            for(int j = 0; j < WhaleWatching.locationList[i].getAdultWhaleNum() ; j++)
            {
                if(WhaleWatching.locationList[i].getWhalesList().get(j).getSpecies()== "Humpback")
                {
                    file_locationInfo[i][0] = String.valueOf(Integer.valueOf(file_locationInfo[i][0]) + 1); 
                }
                else if(WhaleWatching.locationList[i].getWhalesList().get(j).getSpecies()== "Minke")
                {
                    file_locationInfo[i][2] = String.valueOf(Integer.valueOf(file_locationInfo[i][2]) + 1); 
                }
                else if(WhaleWatching.locationList[i].getWhalesList().get(j).getSpecies()== "Southern Right")
                {
                    file_locationInfo[i][4] = String.valueOf(Integer.valueOf(file_locationInfo[i][4]) + 1); 
                }
                else if(WhaleWatching.locationList[i].getWhalesList().get(j).getSpecies()== "Blue")
                {
                    file_locationInfo[i][6] = String.valueOf(Integer.valueOf(file_locationInfo[i][6]) + 1); 
                }
                else if(WhaleWatching.locationList[i].getWhalesList().get(j).getSpecies()== "Oracs")
                {
                    file_locationInfo[i][8] = String.valueOf(Integer.valueOf(file_locationInfo[i][8]) + 1); 
                }
                else if(WhaleWatching.locationList[i].getWhalesList().get(j).getSpecies()== "Migaloo")
                {
                    file_locationInfo[i][10] = String.valueOf(Integer.valueOf(file_locationInfo[i][10]) + 1); 
                }

                if(WhaleWatching.locationList[i].getWhalesList().get(j).getSpecies()== "Humpback" && WhaleWatching.locationList[i].getWhalesList().get(j).getCalf()== 1)
                {
                    file_locationInfo[i][1] = String.valueOf(Integer.valueOf(file_locationInfo[i][1]) + 1);
                }
                else if(WhaleWatching.locationList[i].getWhalesList().get(j).getSpecies()== "Minke" && WhaleWatching.locationList[i].getWhalesList().get(j).getCalf()== 1)
                {
                    file_locationInfo[i][3] = String.valueOf(Integer.valueOf(file_locationInfo[i][3]) + 1);
                }
                else if(WhaleWatching.locationList[i].getWhalesList().get(j).getSpecies()== "Southern Right" && WhaleWatching.locationList[i].getWhalesList().get(j).getCalf()== 1)
                {
                    file_locationInfo[i][5] = String.valueOf(Integer.valueOf(file_locationInfo[i][5]) + 1);
                }
                else if(WhaleWatching.locationList[i].getWhalesList().get(j).getSpecies()== "Blue" && WhaleWatching.locationList[i].getWhalesList().get(j).getCalf()== 1)
                {
                    file_locationInfo[i][7] = String.valueOf(Integer.valueOf(file_locationInfo[i][7]) + 1);
                }
                else if(WhaleWatching.locationList[i].getWhalesList().get(j).getSpecies()== "Oracs" && WhaleWatching.locationList[i].getWhalesList().get(j).getCalf()== 1)
                {
                    file_locationInfo[i][9] = String.valueOf(Integer.valueOf(file_locationInfo[i][9]) + 1);
                }
            }
        }
        return file_locationInfo;
    }

    public static void write(String[][] file_locationInfo)
    {
        try
        {
            FileWriter writer = new FileWriter("seasonObservationsUpdated.txt");
            try
            {
                for(int i=0 ; i <4 ; i++)
                {   
                    for(int j = 0; j < 10; j++)
                    {
                        writer.append(file_locationInfo[i][j] + ",");
                    }
                    writer.append(file_locationInfo[i][10] + "\n");
                }
            }
            finally
            {
                try
                {
                    writer.close();
                }
                catch(Exception e)
                {
                    System.out.println("something went wrong when writing.");
                }
            }
        }
        catch(Exception e)
        {
            System.out.println("something went wrong when writing.");
        }
    }

    public static void update()
    {
        read();
        write(sortInfo());
    }
}
