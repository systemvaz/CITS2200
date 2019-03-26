
/**
* @author   Alexander Varano della Vergiliana
* @version  1.0
*/

import CITS2200.*;


public class DequeCyclic implements Deque<Object>
{
	private Object[] myDeque;
	private int right, left;

	/**
	 * Constructor class initialising the Deque ADT and indices of the left and right element.
	 * @param size Takes integer as size of the new Deque ADT to be created.
	 */
	public DequeCyclic(int size)
	{
		myDeque = new Object[size];
		left = -1;
		right = -1;
	}
	
	/**
	 * Pushes a new element into the left hand side of the Deque ADT.
	 * @param o Takes an Object as the element to be inserted into the left hand side of the ADT.
	 * @throws Overflow If the stack is already full.
	 */
	public void pushLeft(Object o) throws Overflow
	{
		if(!isFull())
		{
			if(left == -1)
			{
				left = 0;
				right = 0;
			}
			else if(left == 0)
			{
				left = myDeque.length - 1;
			}
			else
			{
				left--;
			}
			myDeque[left] = o;
		}
		else
		{
			throw new Overflow("Cannot pushLeft: Deque is full!");
		}
	}
	
	/**
	 * Pushes a new element into the right hand side of the Deque ADT.
	 * @param o Takes an Object as the element to be inserted into the right hand side of the ADT.
	 * @throws Overflow If the stack is already full.
	 */
	public void pushRight(Object o) throws Overflow
	{
		if(!isFull())
		{
			if(left == - 1)
			{
				left = 0;
				right = 0;
			}
			else if(right == myDeque.length - 1)
			{
				right = 0;
			}
			else
			{
				right++;
			}
			myDeque[right] = o;
		}
		else
		{
			throw new Overflow("Cannot pushRight: Deque is full!");
		}
	}
	
	/**
	 * Pops the element in the outer most left hand side of the ADT.
	 * Shifts the left value according to its relative position in the ADT.
	 * @return Object Contains the outer left most element from the ADT.
	 * @throws Underflow If the ADT is empty and therefore is no element to pop. 
	 */
	public Object popLeft() throws Underflow
	{
		if(!isEmpty())
		{
			Object pop = myDeque[left];
			if(left == right)
			{
				left = -1;
				right = -1;
			}
			else if(left == myDeque.length - 1)
			{
				left = 0;
			}
			else
			{
				left++;
			}
			return pop;
		}
		else
		{
			throw new Underflow("Cannot popLeft: Deque is empty");
		}
	}

	/**
	 * Pops the element in the outer most right hand side of the ADT.
	 * Shifts the right value according to its relative position in the ADT.
	 * @return Object Contains the outer right most element from the ADT.
	 * @throws Underflow If the ADT is empty and therefore is no element to pop. 
	 */
	public Object popRight() throws Underflow
	{
		if(!isEmpty())
		{
			Object pop = myDeque[right];
			if(left == right)
			{
				left = -1;
				right = -1;
			}
			else if(right == 0)
			{
				right = myDeque.length - 1;
			}
			else
			{
				right--;
			}
			return pop;
		}
		else
		{
			throw new Underflow("Cannot popRight: Deque is empty");
		}
	}
	
	/**
	 * Returns the left most element in the ADT without changing the left positional values.
	 * @return Object The outer left element in the ADT.
	 * @throws Underflow If the ADT is empty and there is not element to Peek.
	 */
	public Object peekLeft() throws Underflow
	{
		if(!isEmpty())
		{
			return myDeque[left];
		}
		else
		{
			throw new Underflow("Cannot peekLeft: Deque is empty");
		}
	}
	
	/**
	 * Returns the right most element in the ADT without changing the right positional values.
	 * @return Object The outer right element in the ADT.
	 * @throws Underflow If the ADT is empty and there is not element to Peek.
	 */
	public Object peekRight() throws Underflow
	{
		if(!isEmpty())
		{
			return myDeque[right];
		}
		else
		{
			throw new Underflow("Cannot peekRight: Deque is empty");
		}
	}
	
	/**
	 * Simply checks whether the ADT is empty.
	 * @return boolean True if empty, False if not empty.
	 */
	public boolean isEmpty()
	{
		return(left == -1);
	}
	
	/**
	 * Simply checks whether the ADT is full.
	 * @return boolean True is full, False if not full.
	 */
	public boolean isFull()
	{
		return((left == 0 && right == myDeque.length - 1) || (left == right + 1));
	}	

}
