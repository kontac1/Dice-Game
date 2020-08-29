package ckonta_L2DiceGame;
import java.util.Scanner;

/**
 * the Dicegame class program the game and print the scores
 *
 * @author cheick
 * @version 1.0
 */

public class DiceGame {
    /**
     * the main function is use to call other function and print
     * values
     *
     * @param args contain the command line argument
     */

    public static void main(String[] args) {
        //store repeat variable
        String line;
        //store user input to repeat the game
        char choice;

        //create scanner object
        Scanner input = new Scanner(System.in);

        //new line
        System.out.println();

        //calling welcomeText function
        welcomeText();

        //new line
        System.out.println();
        //do function to create a repeat
        do {
            //call gameSetup
            gameSetUp();

            //print new line
            System.out.println();
            //print prompt for user if they will like to play again
            System.out.print("Will you like to play again (Y/N): ");
            // store user input
            line = input.next();
            //store the characters
            choice = line.charAt(0);
         // assigning choice variable
        }while (choice =='y' || choice == 'Y');
        //new line
        System.out.println();

        //call thanYouText to close the program
        thankYouText();

        //new line
        System.out.println();
    }

    /**
     * the gameSetup function contain the program to run the game
     * and print insight
     */

    public static void gameSetUp() {
        int currentRoll;        //storing currentRoll variable
        final int MAXRoll = 10;   //storing maximum time of roll
        final int USERLOAD= 1;    //loaded user dice
        final int USERPERCENT = 30; //percentage of num show
        final int COMPULOAD = 6;  //loaded computer die
        final int COMPPERCNT = 30; //percentage of numshow
        int timeUserWon = 0;  //storing the number of time user win
        int timeCompWon = 0;  //storing the number of time computer win

        //create a scanner object
        Scanner input = new Scanner(System.in);
        //createing dice object for user
        LoadedDie userDie = new LoadedDie(USERLOAD,USERPERCENT);
        //creating dice object for computer
        LoadedDie compDice = new LoadedDie(COMPULOAD,COMPPERCNT);

        //for loop to loop through the game
        for (currentRoll = 1; currentRoll <= MAXRoll; currentRoll++) {
            userDie.roll();  //storing the user die roll value
            compDice.roll(); // storing computer die roll value
            // compare the user die value to the computer die value
            if(userDie.getValue() > compDice.getValue()){
                //counting the number of time user win
                timeUserWon += 1;
            }
            else if (compDice.getValue() > userDie.getValue()) {
                //counting the number of value computer win
                timeCompWon += 1;
            }

            //new line
            System.out.println();
            //print game stages
            System.out.println("Roll " + currentRoll + " of " + MAXRoll + ":");
            //print user die value
            System.out.println("I roll a " + compDice.getValue());
            //inform user to play
            System.out.print("Ready to roll? (Press enter when ready to roll): ");
            //new line
            input.nextLine();
            //print the dice value for computer
            System.out.println("You roll a " + userDie.getValue());
        }
        //print the number of time each player win
        System.out.println("I win " + timeCompWon + " times");
        System.out.println("You win " + timeUserWon + " time");
        //check if computer win is higher than user win
        if (timeCompWon > timeUserWon) {
            //print the grand winner message
            System.out.println("Grand winner is me!");
        }
        //else statement to check if user win is higher than computer win
        else if (timeUserWon > timeCompWon) {
            //print he grand winner test
            System.out.println("the grand winner is you!");
        }
        else {
            //else no one win
            System.out.println("No one win!");
        }

    }

    /**
     * the welcometext function print the welcome message when
     * game start
     */
    public static void welcomeText() {
        //print welcome text
        System.out.println("This is a game of you versus the computer. We will each\n" +
                "have one die. We roll our own die and the higher number\n" +
                "wins. We roll ten times and the one with the higher number\n" +
                "of wins is the grand winner.");
    }

    /**
     * thankYouText function will print the thank you message
     */
    public static void thankYouText() {
        System.out.println("Thank you for playing!");
    }

}
