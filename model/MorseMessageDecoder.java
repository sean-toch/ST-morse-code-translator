package model;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * This class splits the morse code message into individual letters to be converted 
 * into an English message then reconstructs the string with the proper English language format
 * @author stoch
 */
public class MorseMessageDecoder
{
	
	/**
	 * This morseDecoder object is responsible for converting individual morse code letters into their english equivalent
	 */
    MorseDecoder letterDecoder;
	
    /**
     * This constructor initializes the letterDecoder with the codes.txt file
     * @throws FileNotFoundException
     */
	public MorseMessageDecoder() throws FileNotFoundException
	{
		letterDecoder = new MorseDecoder("res/codes.txt");
		
	}
	
	
	/**
	 * This method splits the morse code message into words then individual letters. These letters are converted using 
	 * letterDecoder then reconstructed in the proper English format
	 * @param message holds the string to be converted 
	 * @return encoded holds the converted message
	 */
	public String decodeMessage(String message)
	{
		String words[] = message.split("       ");
		String decoded = "";
		
		for (int i = 0; i < words.length; i++)
		{
			String letters[] = words[i].split("   "); 
			
			for (int j = 0; j < letters.length; j++)
			{       
		    		//Decode each letter and add it to the string
		    		decoded = decoded + letterDecoder.decode(letters[j]);
			}
			
			//Add space after each
			decoded = decoded + " ";
		}
		
		return decoded;
	}
}