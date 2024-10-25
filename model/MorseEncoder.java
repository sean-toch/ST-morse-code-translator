package model;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * This class reads the codes from the codes.txt file and uses it to convert individual 
 * letters from the English alphabet to morse code
 * @author stoch
 */
public class MorseEncoder
{
	/**
	 * This string array holds the morse code equivalents of the letters 
	 */
	String[] letterCodes;
	
		/**
		 * This constructor initializes the letterCodes array and runs the readCodes method to fill the array
		 * @param fileName is the name of the file that hold the letter codes
		 * @throws FileNotFoundException
		 */
		public MorseEncoder(String fileName) throws FileNotFoundException
	    {
	        letterCodes = new String[26];
	        readCodes(fileName);
	    }

		/**
		 * This method reads the letter codes in the file and adds them to the array 
		 * @param fileName is the name of the file that hold the letter codes
		 * @throws FileNotFoundException
		 */
	    private void readCodes(String fileName) throws FileNotFoundException
	    {
	    	Scanner input = new Scanner(new File(fileName));
			String letter;
			String code;
			int count = 0;

			while (input.hasNextLine()) 
			{
				letter = input.next();
				code = input.next();
				letterCodes[count] = code;
				count++;
			}
			input.close();
	    }

	    public void print() 
	    {   
	        for (int i = 0; i < 26; i++)
	        System.out.println(letterCodes[i]);
	    }
	    
	 
	    /**
	     * This method  converts individual letter into morse code using switch case and the letterCodes array
	     * @param letter char for conversion
	     * @return code char value of the letter in morse code
	     */
	    public String encode(char letter) 
	    {   
	    	letter = Character.toLowerCase(letter);
	        String code="";
	        
	        switch(letter) 
	        {
	        case 'e':
	        	code=letterCodes [0]; break;
	        case 't':
	        	code=letterCodes [1];break;
	        case 'i':
	        	code=letterCodes [2];break;
	        case 'n':
	        	code=letterCodes [3];break;
	        case 'm':
	        	code=letterCodes [4];break;
	        case 'a':
	        	code=letterCodes [5]; break;
	        case 'w':
	        	code=letterCodes [6];break;
	        case 'r':
	        	code=letterCodes [7];break;
	        case 's':
	        	code=letterCodes [8];break;
	        case 'u':
	        	code=letterCodes [9];break;
	        case 'k':
	        	code=letterCodes [10]; break;
	        case 'd':
	        	code=letterCodes [11];break;
	        case 'o':
	        	code=letterCodes [12];break;
	        case 'g':
	        	code=letterCodes [13];break;
	        case 'p':
	        	code=letterCodes [14];break;
	        case 'j':
	        	code=letterCodes [15]; break;
	        case 'b':
	        	code=letterCodes [16];break;
	        case 'x':
	        	code=letterCodes [17];break;
	        case 'h':
	        	code=letterCodes [18];break;
	        case 'v':
	        	code=letterCodes [19];break;
	        case 'f':
	        	code=letterCodes [20];break;
	        case 'l':
	        	code=letterCodes [21]; break;
	        case 'c':
	        	code=letterCodes [22];break;
	        case 'y':
	        	code=letterCodes [23];break;
	        case 'z':
	        	code=letterCodes [24];break;
	        case 'q':
	        	code=letterCodes [25];break;
	        }
	    	return code;
	    }
}
