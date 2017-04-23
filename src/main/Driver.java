package main;

import java.io.IOException;
import java.util.Scanner;

import com.thoughtworks.xstream.XStream;

/**
 * Main Driver for the Heap project
 * @author David Larkin
 *
 */
public class Driver {
	
	public static DictWordList wordList = new DictWordList();
	public static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) throws IOException
	{
		wordList.readFile("SpanishWords.txt"); //Populate Heap
		System.out.println(wordList.getDictWordList());
		runMenu();
	}

	/**
	 * Method to take in a number for a menu system. Repeats while there is no good input e.g an integer
	 * @return The users choice
	 */
	private static int Menu()
	{
		boolean goodInput = false;
		int choice=0;
		do
		{
			try
			{
				System.out.println("0) Exit");
				System.out.println("1) Search for a Word");
				System.out.println("2) Add a Translation (English/Spanish)");
				System.out.println("3) Save Dictionary");
				System.out.println("Choose your option ==>");
				choice = input.nextInt();
				goodInput = true;
			}
			catch(Exception e)
			{
				System.out.println("Enter a valid number from the choices above");
				String throwOut = input.nextLine(); //useless line
			}
		} while(!goodInput);
		return choice;
	}
	
	/**
	 * Method to use the input from the Menu() method. Based on a switch statement
	 * Whatever the user types in from the Menu() method, this will execute the function based
	 * on that input
	 */
	public static void runMenu()
	{
		int choice = Menu();
		while(choice != 0)
		{
			switch (choice)
			{
		    	case 1:	
		    		searchForWord(); //Search the heap for a word
		    		break;
		    	case 2:
		    		addDictionaryWord(); //Add a word to the heap
		    		break;
		    	case 3:
		    		saveDictionary();
		    		break;
				default: 	System.err.println("You've entered an invalid number : " + choice +". Try again"); //Bad input
						break;
			}
			
	        System.out.println("\nPress any key to continue...");
	        input.nextLine();
	        input.nextLine(); //bug in scanner
	        choice = Menu();
		}
	       System.out.println("Exiting... bye");
	       System.exit(0);
	}
	
	
	/**
	 * Method to save to XML
	 */
	public static void saveDictionary()
	{
		System.out.println("Saving...");
		wordList.saveToXML();
	}
	
	/**
	 * Method to search for a word by Spanish
	 */
	public static void searchForWord()
	{
		String spanish;
		System.out.println("Please enter the Spanish word you want to search for (In English): ");
		input.nextLine();
		spanish = input.nextLine();
		
		System.out.println("Word is: " + wordList.searchWord(spanish));
	}
	
	/**
	 * Method to add a word to the heap
	 */
	public static void addDictionaryWord()
	{
		String english;
		String spanish;
		
		System.out.println("Enter the Spanish word of the word translation: ");
		input.nextLine();
		spanish = input.nextLine();
		System.out.println("Enter the English word for the word translation: ");
		english = input.nextLine();
		
		//Add to heap
		wordList.getDictWordList().add(new DictionaryWord(spanish.toLowerCase(), english.toLowerCase()));
		System.out.println(wordList.getDictWordList().getSize());
	}
	
}
