
package main;

import java.util.ArrayList;

/**
 * The Max Heap Class implementation
 * @author David Larkin
 *@version 1.0
 * @param <T>
 */
public class MaxHeap<T extends Comparable<T>> implements MaxHeapInterface 
{
	private ArrayList<T> items; 		//No restrictions, any size
	
	/**
	 * Constructor for MaxHeap
	 */
	public MaxHeap()
	{
		items = new ArrayList<T>();
	}
	
	/**
	 * Getter for Max Heap
	 * @return items in Heap
	 */
	public ArrayList<T> getMaxHeap()
	{
		return items;
	}
	
	/**
	 * Method to add an element T to the Heap
	 */
	@Override
	public void add(Comparable newEntry) 
	{
		items.add((T) newEntry);
		siftUp();
	}

	/**
	 * Method to remove the highest valued item T in the Heap
	 * This item will be the root node of the heap
	 */
	@Override
	public Comparable removeMax() 
	{
		if(items.size() == 0)
		{
			System.out.println("no elements");
		}
		if(items.size() == 1)
		{
			return items.remove(0);
		}
		
		T hold = items.get(0);
		items.set(0, items.remove(items.size()-1)); //set bottom to top
		siftDown(); //sift down to fix max heap
		
		return hold;
	}

	/**
	 * Method to return the highest valued item T in the Heap
	 */
	@Override
	public Comparable getMax() 
	{
		if(items.size() > 0)
		{
			return (Comparable) items.get(0);
		}
		
		return null;
	}

	/**
	 * Checks whether the heap is empty of not, 
	 * returns True or False
	 */
	@Override
	public boolean isEmpty() 
	{
		return items.isEmpty();
	}

	/**
	 * Method to get the size of the heap
	 */
	@Override
	public int getSize() 
	{
		return items.size();
	}

	/**
	 * Removes all elements from the heap
	 */
	@Override
	public void clear() 
	{
		items.clear();
	}
	
	/**
	 * To String for readability
	 */
	@Override
	public String toString()
	{
		return items.toString();
	}
	
	/**
	 * Used after adding an element, to reorder the Heap so that
	 * the nodes are placed properly and represents the binary tree
	 * representation
	 */
	private void siftUp()
	{
		int k = items.size() - 1;
		while(k > 0)
		{
			int p = (k-1)/2; //algorithm for child
			T item = items.get(k);
			T parent = items.get(p);
			if(item.compareTo(parent) > 0)
			{
				items.set(k, parent); //swap
				items.set(p, item);
				k = p;
			}
			else
			{
				break;
			}
		}
	}
	
	/**
	 * Method to move elements down once an element is removed
	 * This is also used to keep the order of the heap in tact
	 */
	private void siftDown()
	{
		int k = 0;
		int l = 2*k+1;
		while(l < items.size())
		{
			int max=l, r=l+1;
			if(r < items.size())
			{
				if(items.get(r).compareTo(items.get(l)) > 0)
				{
					max++;
				}
			}
			if(items.get(k).compareTo(items.get(max)) < 0)
			{
				//switch
				T temp = items.get(k);
				items.set(k, items.get(max));
				items.set(max, temp);
				k = max;
				l = 2*k+1;
			}
			else
			{
				break;
			}
		}
	}


}
