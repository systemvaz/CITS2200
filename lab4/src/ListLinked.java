import CITS2200.*;

public class ListLinked implements List
{
	private Link before;
	private Link after;
	public CITS2200.WindowLinked window;
	
	public ListLinked()
	{
		after = new Link(null, null);
		before = new Link(null, after);
		window = new CITS2200.WindowLinked();
		beforeFirst(window);
	}


	public void afterLast(CITS2200.WindowLinked window) 
	{
		window.link = after;
	}


	public void beforeFirst(CITS2200.WindowLinked window) 
	{
		window.link = before;
	}


	public Object delete(CITS2200.WindowLinked window) throws OutOfBounds 
	{
		if(!isBeforeFirst(window) && !isAfterLast(window))
		{
			Object temp = window.link.item;
			window.link.item = window.link.successor.item;
			window.link.successor = window.link.successor.successor;
			if(window.link.successor == null)
			{
				after = window.link;
			}
			return temp;
		}
		else
		{
			throw new OutOfBounds("cannot delete from out of bounds");
		}
	}


	public Object examine(CITS2200.WindowLinked window) throws OutOfBounds 
	{
		if(!isBeforeFirst(window) && !isAfterLast(window))
		{
			return(window.link.item);
		}
		else
		{
			throw new OutOfBounds("cannot examine from out of bounds");
		}
	}

	public void insertAfter(Object e, CITS2200.WindowLinked window) throws OutOfBounds 
	{
		if(!isAfterLast(window))
		{
			window.link.successor = new Link(e, window.link.successor);
			//window.link = window.link.successor;			
		}
		else
		{
			throw new OutOfBounds("cannot insert after the after last position");
		}
	}


	public void insertBefore(Object e, CITS2200.WindowLinked window) throws OutOfBounds
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


	public boolean isAfterLast(CITS2200.WindowLinked window)
	{
		return(window.link == after);
	}


	public boolean isBeforeFirst(CITS2200.WindowLinked window)
	{
		return(window.link == before);
	}


	public boolean isEmpty() 
	{
		return(before.successor == after);
	}


	public void next(CITS2200.WindowLinked window) throws OutOfBounds
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


	public void previous(CITS2200.WindowLinked window) throws OutOfBounds
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


	public Object replace(Object e, CITS2200.WindowLinked window) throws OutOfBounds
	{
		if(!isBeforeFirst(window) && !isAfterLast(window))
		{
			Object temp = window.link.item;
			window.link.item = e;
			return temp;
		}
		else
		{
			throw new OutOfBounds("calling replace outside of bounds");
		}
	}

}
