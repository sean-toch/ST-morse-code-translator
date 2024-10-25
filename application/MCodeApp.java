package application;
import java.io.FileNotFoundException;
import java.util.Scanner;
import model.MorseMessageDecoder;
import model.MorseMessageEncoder;

/**
 * This class hold the main method of this application
 * @author stoch
 */
public class MCodeApp 
{
    /**
     * This main method continually prompts the user whether they want to encode or decode, gets the message then runs the appropriate code 
     * @throws FileNotFoundException 
     */
    public static void main(String args[]) throws FileNotFoundException
    {
        Scanner in = new Scanner(System.in);
        MorseMessageDecoder decoder = new  MorseMessageDecoder();
        MorseMessageEncoder encoder = new  MorseMessageEncoder();
        String message;
        char choice = ' ';
        
        do
        {
            System.out.print ("Enter E (encode), D (decode) or Q(quit): ");
            try { 
                choice = in.nextLine().toUpperCase().charAt(0);
                switch (choice)
                {
                    case 'D':
                            System.out.println ("Enter the message you'd like to decode from Morse Code");
                            System.out.println("*Add 3 spaces after the final letter*");
                            message = in.nextLine();
                            System.out.println (decoder.decodeMessage(message));
                            break;
                    case 'E':
                            System.out.println ("Enter the message you'd like to encode into Morse Code");
                            message = in.nextLine();
                            System.out.println (encoder.encodeMessage(message));
                    default:   
                }
            }
            catch (StringIndexOutOfBoundsException e )
            {   System.out.println ("Invalid entry - try again");
            }
        } while (choice != 'Q');
        
        
    }
}
