package model;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;

/**
 * This class uses a binary tree to convert morse code letters into their English language equivalent
 * @author stoch
 */
public class MorseDecoder
{
	/**
	 * This binary tree object is used to traverse the tree
	 */
	BinaryTree<Character> intCode;

	/**
	 * This constructor initializes the binary tree object and runs the createTree method
	 * @param fileName name of the file with the letter codes
	 * @throws FileNotFoundException
	 */
    public MorseDecoder(String fileName) throws FileNotFoundException
    {
        intCode = new  BinaryTree<Character>(null);
        createTree(fileName);
    }

    /**
     * This method reads the codes from codes.txt and uses them to create a binary tree for decoding
     * @param fileName
     * @throws FileNotFoundException
     */
    private void createTree(String fileName) throws FileNotFoundException
    {
        Scanner in = new Scanner(new File(fileName));
        String letter;
        String code;

        while (in.hasNextLine())
        {
            letter = in.next();
            code = in.next();
            placeCode (intCode, letter.charAt(0), code);
        }
        in.close();
    }
    
    /**
     * This method is used by the createTree method to place the characters in their proper places
     * @param m binary tree object to traverse the tree
     * @param charToPlace holds the char value that is to be added to the tree
     * @param code holds the morse code equivalent of the letter
     */
    private void placeCode(BinaryTree<Character> m, char charToPlace, String code)
    {
    	int count = 0;
        char codeChar = code.charAt(count);
        
        BinaryTree<Character> n = new  BinaryTree<Character>(charToPlace);
        
        for (int i = 0; i < code.length() - 1; i++)
		{
        	
        	if (codeChar == '.')  
        	{
        		m = m.getLeft();
        	}
        	else if (codeChar == '-')
        	{
        		m = m.getRight();
        	}
        	
        	count++;
        	
        	codeChar = code.charAt(count);
		}     
        
        if (codeChar == '.')   
    	{
    		m.setLeft(n);
    	}
    	else if (codeChar == '-')
    	{
    		m.setRight(n);
    	}
    }
    
    /**
     * This method traverses and prints the binary tree
     */
    public void print() 
    {   
        Iterator<Character> it = intCode.iterator();
 
        while (it.hasNext())
        {
        	System.out.print (it.next()+" ");
        }
        
    }  
    
    /**
     * This method calls the decoder method
     * @param code holds the codes other the letter that is to be converted to the English alphabet
     * @return the result of the decoder method
     */
    public char decode(String code) 
    {   
        return decoder(intCode, code);
    }
    
    /**
     * This method traverses the tree to find the equivalent letter for the code
     * @param m binary tree object to traverse the tree
     * @param code holds the morse code equivalent of the letter
     * @return returns the letter converted from the code
     */
    private char decoder( BinaryTree<Character> m, String code) 
    {   
    	int count = 0;
        char codeChar = code.charAt(count);
        char decoded = ' '; 
        
        for (int i = 0; i < code.length() - 1; i++)
		{
        	
        	if (codeChar == '.')  
        	{
        		m = m.getLeft();
        	}
        	else if (codeChar == '-')
        	{
        		m = m.getRight();
        	}
        	
        	count++;
        	
        	codeChar = code.charAt(count);
		}     
        
        if (codeChar == '.')   
    	{
    		decoded = m.getLeft().getRootElement();
    	}
    	else if (codeChar == '-')
    	{
    		decoded = m.getRight().getRootElement();
    	}
        
        return decoded;
    }
}