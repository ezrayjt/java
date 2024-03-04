/**
 * A class to specify the attributes and behaviours of a player.
 */

class Player
{   
    private String name;    
    private int guess;   /*According to Gameplay description,I assume a number from 1 to 100 is an integer.*/
    private int score;   /*Based on the provided table,I assume sore is an integer.*/

    public Player()
    {
        name = "unknown";
        guess = 0;
        score = 0;
    }

    public Player(String name)
    {
        this.name = name;
    }
    /**
     *This method stores player name.
     *@param String
     */
    public void setPlayerName(String name)
    {
        this.name = name;
    }
    /**
     *This method stores player guess.
     *@param int
     */
    public void setPlayerGuess(int guess)
    {
        this.guess = guess;
    }
    /**
     *This method stores player score.
     *@param int
     */
    public void setPlayerScore(int score)
    {
        this.score = score;
    }
}
