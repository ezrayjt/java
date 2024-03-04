/**
 * A class will generate a random number to support different functionalities.
 */

import java.util.Random;

public class NumberGenerator
{   
    public int randomNumberGenerator()
    {
        Random randomNumber = new Random();
        int rand = randomNumber.nextInt(100)+1;
        return rand;
    }
    /**
     *This method stores player name.
     *@return the random number generated
     */
    public int orderGenerator()
    {
        Random randomNumber = new Random();
        int num = randomNumber.nextInt(2);
        return num;
    }
    /**
     *This method stores player name.
     *@return the random number generated
     */
    public int player2Guess(int max, int min)
    {
        Random randomNumber = new Random();
        int guess = randomNumber.nextInt(max-min-1)+min+1;
        return guess;
    }
    /**
     *This method stores player name.
     *@return the random number generated
     */
    public int player2GiveUp()
    {
        Random randomNumber = new Random();
        int giveUp = randomNumber.nextInt(20);
        return giveUp;
    }
}
