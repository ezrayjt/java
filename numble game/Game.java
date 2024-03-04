import java.util.Scanner;
import java.util.ArrayList;
/**
 * A class caintain mainfunction which is gonna achieve the game play functionality by interacting with 
 * all other classes and mutiple methods.
 */
public class Game
{
    private Player player1;
    private Player player2;
    private NumberGenerator num;
    private int guess;
    private int max;
    private int min;
    private int turns;
    private int hiddenNumber;
    private String name;
    private int points;
    private int order;
    private ArrayList<Integer> guessList;
    private int compare;
    private int scores1;
    private int scores2;
    private int rounds;
    private boolean abandon;

    public Game()
    {   
        player1 = new Player();
        player2 = new Player("computer");
        num = new NumberGenerator();
        guess = 0;
        max = 101;
        min = 0;
        turns = 0;
        name = "unknown";
        points = 0;
        order = 0;
        guessList = new ArrayList<Integer>();
        scores1 = 0;
        scores2 = 0;
        hiddenNumber = 0;
        compare = 0 ; 
        rounds = 0;
        abandon = false;
    }
    /**
     *This method calls the function in number generator class.
     */
    public void setHiddenNumber()
    {
        hiddenNumber = num.randomNumberGenerator();
    }
    /**
     *This method ask user to input their user name.
     */
    public void setPlayer1Name()
    {
        System.out.println("What is your player name?");
        Scanner input = new Scanner(System.in);
        name = input.nextLine();
        while(name.length()>8 || name.length()<=0)
        {
            System.out.println("sorry,your name is invalid.It should be less than 8 characters.");
            name = input.nextLine();
        }
    }
    /**
     *This method generate a number to decide the order.
     */
    public void setOrder()
    {   
        order = num.orderGenerator();
        if ( order == 1 )
        {
            System.out.print("Player2(computer) will take the first turn.\n");
        }
        else if(order == 0)
        {
            System.out.print("Player1 will take the first turn.\n");
        }
    }
    /**
     *This method will check users input and make sure it is number.
     */
    public void setPlayer1guess()
    {   
        System.out.println("Take a guess of the hidden number! (Between "+ min +" and "+ max+" exclusive)");
        Scanner input = new Scanner(System.in);
        boolean flag = true;
        while(flag)
        {
            if(input.hasNextInt())
            {   
                guess = input.nextInt();
                while (guess<1 || guess>100)
                {
                    System.out.println("Typo?Your guess should be between 1 and 100 inclusive");
                    setPlayer1guess();
                }
                flag = false;
            }
            else
            {
                System.out.println("Typo?you should only type a number.");
                input.next();
            }
        }
    }
    /**
     *This method will check if player1 or player2 would abandon by cheking specific input.
     */
    public void setAbandon()
    {   
        if(order == 1)
        {   
            setTurns();
            System.out.println("------------Turn "+turns+"---------------");
            if(num.player2GiveUp() == 0)
            {   
                abandon = true;
                System.out.println("The player2 gives up this round!");
                setPoints();
                compare = 0;
                setAbandonScore();
                System.out.println("The player1 is awarded "+ points + " points!");
            }
            else
            {
                abandon = false;
            }
        }
        else if(order == 0)
        {   
            setTurns();
            System.out.println("------------Turn "+turns+"---------------");
            setPlayer1guess();
            if(guess == 999)
            {   
                abandon = true;
                System.out.println("The player1 gives up this round!");
                setPoints();
                compare = 1;
                setAbandonScore();
                System.out.println("The player2 is awarded "+ points + " points! ");
            }
            else
            {
                abandon = false;
            }
        }
    }
    /**
     *This method would re-initialize the guess.
     */
    public void setGuess()
    {   
        if (order == 0)
        {   
            guessList.add(guess);
            order = 1;
        }
        else if (order == 1)
        {   
            guess = num.player2Guess(max,min);
            System.out.println("The player2's guess is "+guess);
            guessList.add(guess);
            order = 0;    
        }
    }
    /**
     *This method will set the value of compare.
     */
    public void setCompare()
    {
        compare = order;
    }
    /**
     *This method will validate the value of guess and give different feedbacks.
     */
    public void guessValidation()
    {   
        if (guess > hiddenNumber && guess < max)
        {
            System.out.println("No,it's not the hiddenNumber.\n*hint*:The guess is greater than the hidden number");
            max = guess;
        }

        else if (guess < hiddenNumber && guess > min)
        {
            System.out.println("No,it's not the hiddenNumber.\n*hint*:The guess is less than the hidden number");
            min = guess;
        }

        else if ((guess != hiddenNumber && guess <= min && guess >=1)||(guess != hiddenNumber && guess>=max && guess<=100)) /*added != hiddenNumber in case hidden number is 100 or 1 .*/
        {
            System.out.println("oops,your guess is not within the range.Recall the hint.");
        }

        else if (guess == hiddenNumber)
        {
            System.out.println("Congrats! You get it! The hidden number is " + hiddenNumber);
            setPoints();
            System.out.println("You are awarded "+points+ " points!");
            setScores();
        }
    }
    /**
     *This method will increment the value of turns.
     */
    public void setTurns()
    {
        turns += 1;
    }
    /**
     *This method will increment the value of rounds.
     */
    public void setRounds()
    {
        rounds += 1;
    }
    /**
     *This method will caculate the points corresponding to the turns.
     */
    public void setPoints()
    {
        switch(turns)
        {   
            case 1 :
                points = 18;
                break;
            case 2 :
                points = 12;
                break;
            case 3 :
                points = 8;
                break;
            case 4 :
                points = 5;
                break;
            case 5 :
                points = 3;
                break;
            case 6 :
                points = 2;
                break;
        }
    }
    /**
     *This method will caculate  the score of players.
     */
    public void setScores()
    {   
        if (compare == 0)       /*player1 take the 1st turn*/
        {
            switch (turns)
            {
                case 1:
                    scores1 +=points;
                    break;
                case 2:
                    scores2 +=points;
                    break;
                case 3:
                    scores1 +=points;
                    break;
                case 4:
                    scores2 +=points;
                    break;
                case 5:
                    scores1 +=points;
                    break;
                case 6:
                    scores2 +=points;
                    break;
            }
        }

        else if(compare == 1)
        {
            switch (turns)
            {
                case 1:
                    scores2 +=points;
                    break;
                case 2:
                    scores1 +=points;
                    break;
                case 3:
                    scores2 +=points;
                    break;
                case 4:
                    scores1 +=points;
                    break;
                case 5:
                    scores2 +=points;
                    break;
                case 6:
                    scores1 +=points;
                    break;
            }
        }
    }
    /**
     *This method specifically caculate the score when player abandon the game.
     */
    public void setAbandonScore()
    {
        if(compare == 0)
        {
            scores1 += points;
        }
        else if(compare == 1)
        {
            scores2 += points;
        }
    }
    /**
     *This method will caculate and display the score when neither player guess the hidden number.
     */
    public void compareGuess()
    {   
        System.out.println("-----oops,no one get the right answer!-----\n-----Lets compare whose last guess is closer-----");
        if (compare == 0)        /*player1 take the 1st turn*/
        {   
            if(Math.abs(guessList.get(5)-hiddenNumber)>Math.abs(guessList.get(4)-hiddenNumber))
            {   
                System.out.println("player1 last guess is " + guessList.get(4) + "\nplayer 2 last guess is "+ guessList.get(5)+"\nThe hidden number is "+hiddenNumber+"\nSo,player1's guess is closer to the hidden number.\nPlayer1 is awarded 1 point.");
                scores1 += 1;
            }

            else
            {   
                System.out.println("player1 last guess is " + guessList.get(4) + "\nplayer 2 last guess is "+ guessList.get(5)+"\nThe hidden number is "+hiddenNumber+"\nSo,player2's guess is closer to the hidden number.\nPlayer2 is awarded 1 point.");
                scores2 += 1;
            }
        }

        else if (compare == 1)
        {
            if(Math.abs(guessList.get(5)-hiddenNumber)>Math.abs(guessList.get(4)-hiddenNumber))
            {   
                System.out.println("player1 last guess is " + guessList.get(5) + "\nplayer 2 last guess is "+ guessList.get(4)+"\nThe hidden number is "+hiddenNumber+"\nSo,player2's guess is closer to the hidden number.\nPlayer2 is awarded 1 point.");
                scores2 += 1;
            }

            else
            {   
                System.out.println("player1 last guess is " + guessList.get(5) + "\nplayer 2 last guess is "+ guessList.get(4)+"\nThe hidden number is "+hiddenNumber+"\nSo,player1's guess is closer to the hidden number.\nPlayer1 is awarded 1 point.");
                scores1 += 1;
            }
        }
    }
    /**
     *This method calls mutiple functions to achieve the first turn of the game.
     */
    public void firstTurnPlay()
    {   
        setRounds();
        System.out.println("---------------round "+rounds+" starts! ---------------------");
        System.out.println("Now judge will decide who is going to take the first turn!");
        setOrder();
        setCompare();
        setAbandon();
        if(abandon)
        {
            roundEnds();
        }
        else
        {   
            setGuess();
            guessValidation();
        }
    }
    /**
     *This method calls mutiple functions to achieve the last 5 turns of the game.
     */
    public void remainingTurnPlay()
    {
        boolean flag = true;
        int i = 0;
        while (flag && i < 5 )
        {   
            if(guess == hiddenNumber)
            {
                flag = false;
            }

            else
            {
                setAbandon();
                if(abandon)
                {
                    flag = false;
                }
                else
                {   
                    setGuess();
                    guessValidation();
                    i++;
                }
            }
        }
        if (guess != hiddenNumber && i == 5)
        {
            compareGuess();
            roundEnds();
        }
        else
        {
            roundEnds();
        }
    }
    /**
     *This method cope with the end part of the game.
     */
    public void roundEnds()
    {   
        if (rounds < 4)
        {
            System.out.println("-----------------the "+ rounds + " round ends!-----------------\nThe hidden number is "+ hiddenNumber +"\nplayer1 score is "+scores1 +"\nplayer2 score is "+ scores2);
            turns = 0;
            max = 101;
            min = 0;
            guessList.clear();
        }
        else if(rounds == 4)
        {
            System.out.println("-----------------the "+ rounds + " round ends!-----------------\nThe hidden number is "+ hiddenNumber +"\nplayer1 score is "+scores1 +"\nplayer2 score is "+ scores2);
            winner();
        }
    }
    /**
     *This method calls mutiple functions to achieve the round loop of the game.
     */
    public void roundPlay()
    {
        for(int i = 0 ; i<4 ; i++)
        {   
            firstTurnPlay();
            if(!abandon)
            {
                remainingTurnPlay();
            }
        }
    }
    /**
     *This method calculate the final outcome of the game.
     */
    public void winner()
    {   
        System.out.println("**----------------------Game over!----------------------------**");
        if(scores1 - scores2 > 0)
        {
            System.out.println("The winner is player1! Congrats!");
        }
        else if (scores1 - scores2 < 0)
        {
            System.out.println("The winner is player2! Congrats!");
        }
        else if (scores1 == scores2)
        {
            System.out.println("Congrats!Both player1 and player 2 are winners!");
        }
    }
    /**
     *This method calls mutiple functions to achieve all the main functions of the game.
     */
    public void gamePlay()
    {
        setHiddenNumber();
        System.out.println("**------------Welcome to the Numble Game!--------------**");
        setPlayer1Name();
        roundPlay();
        storePlayerName();
        storePlayerScore();
    }
    /**
     *This method stores the name of player1.
     */
    public void storePlayerName()
    {
        player1.setPlayerName(name);
    }
    /**
     *This method stores the score of players.
     */
    public void storePlayerScore()
    {
        player1.setPlayerScore(scores1);
        player2.setPlayerScore(scores2);
    }
    /**
     *This is main method.It runs the code.
     */
    public static void main(String[] args)
    {   
        Game judge = new Game();
        judge.gamePlay();
    }  
}
