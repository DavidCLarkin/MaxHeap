package test;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;

import main.DictionaryWord;
import main.MaxHeap;

/**
 * Test Class for Max Heap
 * @author David Larkin
 *
 */
public class MaxHeapTest 
{

	MaxHeap<Integer> items = new MaxHeap<Integer>();
	DictionaryWord test;
	
	@Before
	public void setUp()
	{
		test = new DictionaryWord("gracias","thanks");
	}
	@Test
	public void testAdd() 
	{
		// Add random numbers
		Random rand = new Random();
		for(int i = 0; i < 500; i++)
		{
			items.add(rand.nextInt(100));
		}
		
		// Test that the size is 100
		assertEquals(items.getSize(), 500);
		// Test the size is greater (Testing that adding works)
		assertTrue(items.getSize() > 0);
		
		System.out.println(items.getMax());
		
		assertEquals(items.getMax(), 99); // In 500 numbers, 99 should be one of them
		
		// Make sure isEmpty is working
		assertEquals(items.isEmpty(), false);
		
		// Clear heap and see if its empty
		items.clear();
		assertEquals(items.isEmpty(), true);
	}
	

}
