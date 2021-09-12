import java.util.*;

/**
 * Write a description of class LuckyDipGenerator here.
 * 
 * This class does one function which is of returning a random number using "math.random".
 * "math.random generates number between 0.1 to 0.9"
 *
 * @author Kapish
 * @version (22nd April 2021)
 */


public class LuckyDipGenerator
{
    private int maximumNumber;

    public LuckyDipGenerator()
    {
        maximumNumber = 5;
    }
    
    public int generateRandomNumber()
    {
        return 1 + (int) (Math.random() * maximumNumber);
    }
}
