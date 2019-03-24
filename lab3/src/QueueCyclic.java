import CITS2200.*;

public class QueueCyclic implements Queue
{
  int first, last;
  Object[] myQueue;

  public QueueCyclic(int size)
  {
    first = 0;
    last = size;
    myQueue = new Object[size+1];
  }

  public boolean isEmpty()
  {
    return first == (last+1) % myQueue.length;
  }

  public boolean isFull()
  {
    return first == (last+2) % myQueue.length;
  }

  public void enqueue(Object a)
  {
    if(!isFull())
    {
      last = (last + 1) % myQueue.length;
      myQueue[last] = a;
    }
    else
    {
      throw new Overflow("Error: Queue is full.");
    }
  }

  public Object examine()
  {
    if(!isEmpty())
    {
      return myQueue[first];
    }
    else
    {
      throw new Underflow("Cannot examine an empty queue.");
    }
  }

  public Object dequeue()
  {
    if(!isEmpty())
    {
      Object getitem = myQueue[first];
      first = (first + 1) % myQueue.length;
      return getitem;
    }
    else
    {
      throw new Underflow("Cannot dequeue an empty queue.");
    }
  }
  
	public void printqueue()
	{
		System.out.println(" ");
		for (int i = 0; i < myQueue.length; i++)
		{
			System.out.print(myQueue[i] + " | ");
		}
		System.out.println("");
		System.out.println("");
	}

}
