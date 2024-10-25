package model;
import java.io.FileNotFoundException;

/**
 * This class splits the string message into individual letters to be converted 
 * into morse code then reconstructs the message with the proper morse code format
 * @author stoch
 */
public class MorseMessageEncoder
{
	/**
	 * This morse encoder object is responsible for converting individual letters into their morse code equivalent
	 */
    MorseEncoder letterEncoder;
	
    
    /**
     * This constructor initializes the letterEncoder with the codes.txt file
     * @throws FileNotFoundException
     */
	public MorseMessageEncoder() throws FileNotFoundException
	{
		letterEncoder = new MorseEncoder("res/codes.txt");
		
	}
	
	
	/**
	 * This method splits the message into individual letters. These letters are converted using 
	 * letterEncoder then reconstructed in the proper morse code format
	 * @param message holds the string to be converted 
	 * @return encoded holds the converted message
	 */
	public String encodeMessage(String message)
	{
		String encoded = "";
		
		for (int i = 0; i < message.length(); i++)
		{
		    char c = message.charAt(i);        
		    
		    if(c == ' ')
		    {
		    	//Add 4 extra spaces between words
		    	encoded = encoded + "    ";
		    }
		    else
		    {
		    	//Add 3 spaces after every letter
		    	encoded = encoded + letterEncoder.encode(c) + "   ";
		    }
		}
		
		return encoded;
	}
}