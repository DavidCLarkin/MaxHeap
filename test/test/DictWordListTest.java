package test;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import main.DictWordList;

/**
 * Test Class for WordList
 * @author David Larkin
 *
 */
public class DictWordListTest 
{

	private DictWordList wordList = new DictWordList();
	
	@Before
	public void testRead() throws IOException
	{
		wordList.readFile("C:/Users/David/Downloads/MaxHeap/MaxHeap/SpanishWords.txt");
	}
	@Test
	public void testSize() 
	{
		assertTrue(wordList.getDictWordList().getSize() > 0);
		assertTrue(wordList.getDictWordList().getSize() == 94); //size of the file
	}

}
