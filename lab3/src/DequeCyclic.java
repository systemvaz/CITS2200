import CITS2200.*;


public class DequeCyclic implements Deque<Object>
{
	private Object[] myDeque;
	private int right, left;

	public DequeCyclic(int size)
	{
		myDeque = new Object[size];
		left = -1;
		right = -1;
	}
	
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
	
	public boolean isEmpty()
	{
		return(left == -1);
	}
	
	public boolean isFull()
	{
		return((left == 0 && right == myDeque.length - 1) || (left == right + 1));
	}	

}
