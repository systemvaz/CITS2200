import CITS2200.*;

public class QueueLinked implements Queue
{
	private Link first;
	private Link last;
	
	public QueueLinked()
	{
		first = null;
		last = null;
	}

	public Object dequeue() throws Underflow
	{
		if(!isEmpty())
		{
			Object o = first.item;
			first = first.successor;
			if (isEmpty())
			{
				last = null;
			}
			return o;
		}
		else
		{
			throw new Underflow("dequeuing from empty queue");
		}
	}

	public void enqueue(Object a)
	{
		if(isEmpty())
		{
			first = new Link(a, null);
			last = first;
		}
		else
		{
			last.successor = new Link(a, null);
			last = last.successor;
		}
		
	}

	public Object examine() throws Underflow
	{
		if(!isEmpty())
		{
			return first.item;
		}
		else
		{
			throw new Underflow("list is empty");
		}
	}

	public boolean isEmpty()
	{
		return first == null;
	}

}
