import CITS2200.*;

/**
 * 
 * @author Alexander Varano della Vergiliana
 * 
 * Class provides an implementation of a priority queue with enqueue, dequeue and iterator methods.
 *
 */
public class PriorityQueueLinked implements PriorityQueue <Object>
{
	Link<Object> front;
	
	public PriorityQueueLinked()
	{
		front = null;
	}
	
	private class Link<Object>
	{
		Object element;
		int priority;
		Link<Object> next;
		
		public Link(Object e, int p, Link<Object> n)
		{
			this.element = e;
			this.priority = p;
			this.next = n;
		}
	}
	
	/**
	 * Dequeues an item from the priority queue and moves the next element to the front position
	 * 
	 * @return Object Returns the element at the front of the queue.
	 * @throws Underflow If the queue is empty.
	 */
	@Override
	public Object dequeue() throws Underflow 
	{
		if(!isEmpty())
		{
			Object temp = front.element;
			front = front.next;
			return temp;
		}
		else
		{
			throw new Underflow("Empty Queue");
		}
	}

	/**
	 * Enqueues and item into the priority queue in the appropriate position depending on its given priority.
	 * 
	 * @param e Element to be enqueued
	 * @param p The priority of the element.
	 * @throws IllegalValue If the priority is not in a valid range.
	 */
	@Override
	public void enqueue(Object e, int p) throws IllegalValue 
	{
		if(isEmpty() || p > front.priority)
		{
			front = new Link<Object>(e, p, front);
		}
		else
		{
			Link<Object> l = front;
			while(l.next != null && l.next.priority >= p)
			{
				l = l.next;
			}
			l.next = new Link<Object>(e, p, l.next);
		}
		
	}

	/**
	 * Examine the element at the front of the queue if the queue is not empty.
	 * 
	 * @return Object Returns the element at the front of the queue.
	 */
	@Override
	public Object examine() throws Underflow 
	{
		if(!isEmpty())
		{
			return front.element;
		}
		else
		{
			throw new Underflow("Empty Queue");
		}
	}

	@Override
	public boolean isEmpty() 
	{
		return(front == null);
	}

	
	/**
	 * Provides an iterator for the priority queue.
	 * 
	 * @return Priority queue iterator.
	 */
	@Override
	public Iterator<Object> iterator() 
	{
		return new QueueIterator();
	}
	
	class QueueIterator implements Iterator<Object>
	{
		private Link<Object> window = new Link<Object>(null, 0, null);
		
		/**
		 * If priority queue is not empty set the window to be before the first item.
		 */
		public QueueIterator()
		{
			if(!isEmpty())
			{
				window.next = front;	
			}
		}
		
		/**
		 * Check if the is a next item in the queue.
		 * 
		 * @return True is item exists, false otherwise.
		 */
		public boolean hasNext() 
		{
			return(window.next != null);
		}

		/**
		 * Provides the next item in the priority queue.
		 * 
		 * @return Object Returns the next element in the queue.
		 * @throws OutOfBounds if there is no next item in the priority queue.
		 */
		public Object next() throws OutOfBounds 
		{
			if(hasNext())
			{
				Object temp = window.next.element;
				window = window.next;
				return temp;
			}
			else
			{
				throw new OutOfBounds("No more elements");
			}
		}
	}

}
