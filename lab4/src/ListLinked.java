import CITS2200.*;

public class ListLinked implements List
{
	private Link before;
	private Link after;
	public WindowLinked window;
	
	public ListLinked()
	{
		after = new Link(null, null);
		before = new Link(null, after);
		window = new WindowLinked();
		beforeFirst(window);
	}


	public void afterLast(WindowLinked window) 
	{
		window.link = after;
	}


	public void beforeFirst(WindowLinked window) 
	{
		window.link = before;
	}


	public Object delete(WindowLinked window) throws OutOfBounds 
	{
		Object temp = window.link.item;
		if(!isBeforeFirst(window))
		{
			if(window.link.successor != after)
			{
				window.link.item = window.link.successor.item;
				window.link.successor = window.link.successor.successor;
			}
			else
			{				
				previous(window);
				window.link.successor = after;
			}
			return temp;
		}
		else
		{
			throw new OutOfBounds("cannot delete from empty list");
		}
	}


	public Object examine(WindowLinked window) throws OutOfBounds 
	{
		if(!isBeforeFirst(window))
		{
			return(window.link.item);
		}
		else
		{
			throw new OutOfBounds("cannot examine from before first position");
		}
	}

	public void insertAfter(Object e, WindowLinked window) throws OutOfBounds 
	{
		window.link.successor = new Link(e, window.link.successor);
		if(isAfterLast(window))
		{
			after = window.link.successor;
		}
		window.link = window.link.successor;
	}


	public void insertBefore(Object e, WindowLinked window) throws OutOfBounds
	{
		if(!isBeforeFirst(window))
		{
			window.link.successor = new Link(window.link.item, window.link.successor);
			if(isAfterLast(window))
			{
				after = window.link.successor;
			}
			window.link.item = e;
			window.link = window.link.successor;
		}
		else
		{
			throw new OutOfBounds("inserting before start of list");
		}	
	}


	public boolean isAfterLast(WindowLinked window)
	{
		return(window.link == after);
	}


	public boolean isBeforeFirst(WindowLinked window)
	{
		return(window.link == before);
	}


	public boolean isEmpty() 
	{
		return(before.successor == after);
	}


	public void next(WindowLinked window) throws OutOfBounds
	{
		if(!isAfterLast(window))
		{
			window.link = window.link.successor;
		}
		else
		{
			throw new OutOfBounds("you are at the end of the list");
		}
		
	}


	public void previous(WindowLinked window) throws OutOfBounds
	{
		if(!isBeforeFirst(window))
		{
			Link current = before.successor;
			Link previous = before;
			
			while(current != window.link)
			{
				previous = current;
				current = current.successor;
			}
			window.link = previous;
		}
		else
		{
			throw new OutOfBounds("calling previous before start of list");
		}
	}


	public Object replace(Object e, WindowLinked window) throws OutOfBounds
	{
		if(!isBeforeFirst(window))
		{
			Object temp = window.link.item;
			window.link.item = e;
			return temp;
		}
		else
		{
			throw new OutOfBounds("calling replace before start of list");
		}
	}
	
	public void printqueue()
	{
		Link current = before;
		while(current != after.successor)
		{
			System.out.print(current.item + " | ");
			current = current.successor;
		}
		System.out.println(" ");
		System.out.println(" ");
	}
	
	
}
