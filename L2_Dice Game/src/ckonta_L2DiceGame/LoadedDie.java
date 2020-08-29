package ckonta_L2DiceGame;
import java.util.Random;

/**
 * The loaded Die class contained the constructors and couples
 * others methode to facilitate and organize the program
 *
 * @author cheick
 * @version 1.0
 */

public class LoadedDie {

    public final int SIZE = 6;    //number of sides
    public int value;  //die value
    int favorNum;      //favorite number
    int hundredTime;   // hundredtime variable storage
    int percentage = 100;  //store percentage

    /**
     * the constructors is used to initialize variable that are constantly
     * use
     *
     * @param loadedNum is pass in as parameter
     * @param timesPerHundred is pass in as parameter
     */
    public LoadedDie(int loadedNum, int timesPerHundred) {

        hundredTime = timesPerHundred; //assigning variable
        favorNum = loadedNum;         // assigning variable
        roll();                      // calling roll function
    }

    /**
     * The roll method simulates the rolling of the die.
     * It will typically set this die's value to a random value
     * with uniform distribution between 1 and 6. Occasionally,
     * it will a priori return the favored value (with frequency
     * determined by the moreTimesPerHundred argument that was passed
     * to the constructor).
     */
    public void roll() {

        //create a random object
        Random rand = new Random();
        //temporary store for random num generate
        int temp = rand.nextInt(percentage);
        // checking if temp value is less than 100
        if (temp < hundredTime) {
            //setting value to favorite number
            value = favorNum;
            // else function to generate random num
        } else {
            //store random num to between 1 and 6
            value = rand.nextInt(SIZE) + 1;
        }
    }

    /**
     * get value function will get the value generated randomly
     *
     * @return the value of the random number
     */

    public int getValue() {
        //return random number value
        return value;
    }
}
