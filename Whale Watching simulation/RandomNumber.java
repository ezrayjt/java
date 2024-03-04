/**
 * A class will generate a random number to support different functionalities.
 */

import java.util.Random;

public class RandomNumber
{
    public static int randomNum(int min, int max)
    {
        Random randomNumber = new Random();
        int rand = randomNumber.nextInt(max-min+1)+min;  
        return rand;
    }
}

