package main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**
 * Class to read the file and make objects, add to a heap
 * @author David Larkin
 * @version 1.0
 *
 */
public class DictWordList 
{
	private static MaxHeap<DictionaryWord> wordList = new MaxHeap<DictionaryWord>(); //Used to hold objects
	public static XStream xstream = new XStream(new DomDriver());
	public static FileOutputStream fos;
	public static FileInputStream fis;
	
	
	public DictWordList()
	{
		xstream.alias("DictionaryWord", DictionaryWord.class);
	}
	
	/**
	 * Makes a new Array of strings based on the lines from the file.
	 * Sets the first index to the Spanish word and the second to the English word.
	 * Creates an object of DictionaryWord afterwards based on the Array of Strings.
	 * @param directory
	 * @throws IOException
	 */
	public void readFile(String directory) throws IOException
	{
		Scanner scan = new Scanner(new File(directory));
		String delim = "\\t"; //separate by tab
		String temp;
		while(scan.hasNextLine())
		{
			temp = scan.nextLine();
			String[] lineSplits = temp.split(delim);
			if(lineSplits.length == 2)
			{
				DictionaryWord word = new DictionaryWord(null, null);
				word.setSpanish(lineSplits[0]);
				word.setEnglish(lineSplits[1]);
				wordList.add(word);
			}
		}
		scan.close();
	}
	
	/**
	 * Save objects from heap to XML
	 */
	public void saveToXML()
	{
		try
		{
			fos = new FileOutputStream("D:/Dictionary.txt");
			xstream.toXML(wordList,fos);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void readFromXML()
	{
		try
		{
			fis = new FileInputStream("D:/Dictionary.txt");
			xstream.fromXML("D:/Dictionary.txt");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	/**
	 * Returns the heap
	 * @return
	 */
	public MaxHeap<DictionaryWord> getDictWordList()
	{
		return wordList;
	}
	
	/**
	 * Search for a Word by English, to return the Spanish word
	 * that equals that Spanish meaning
	 * @param english
	 * @return
	 */
	public String searchWord(String english)
	{
		//System.out.println(wordList.getSize());
		for(int i = 0; i < wordList.getSize(); i++)
		{
			if(((DictionaryWord) wordList.getMaxHeap().get(i)).getEnglish().toUpperCase().contains(english.toUpperCase())) //cast to use the heap
			{
				System.out.println("It is the "+ i + " item");
				return ((DictionaryWord) wordList.getMaxHeap().get(i)).getSpanish() + ", ( " + wordList.getMaxHeap().get(i).getEnglish()+")"; //cast object
			}
		}
		return "Doesn't exist in Heap";
	}
	
	
}
