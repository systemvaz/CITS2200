/**
 * @author Alexander Varano della Vergiliana
 * @version 1.0
 */

import CITS2200.*;

public class ListLinked implements List
{
	private Link before;
	private Link after;
	public CITS2200.WindowLinked window;
	
	/**
	 * Constructor initialising the Linked List ADT, setting up the before first and after last elements.
	 * Setting up a new window object and assigning it to the before first position.
	 */
	public ListLinked()
	{
		after = new Link(null, null);
		before = new Link(null, after);
		window = new CITS2200.WindowLinked();
		beforeFirst(window);
	}

	/**
	 * Sets the window to the after last position.
	 * @param window Takes the window object as input
	 */
	public void afterLast(CITS2200.WindowLinked window) 
	{
		window.link = after;
	}

	/**
	 * Sets the window to the before first position
	 * @param window Takes the window object as input
	 */
	public void beforeFirst(CITS2200.WindowLinked window) 
	{
		window.link = before;
	}

	/**
	 * Deletes the list item underneath the window
	 * @param window Takes the window object as input
	 * @throws OutOfBounds If the window is currently over the before first or after last position
	 */
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

	/**
	 * Returns the current item underneath the window
	 * @param window Takes the window object as input
	 * @throws OutOfBounds If the window is currently over the before first or after last position
	 */
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

	/**
	 * Creates a new link after current window position and inserts user supplied object
	 * @param window Take the window object as input
	 * @param e User supplied Object to be inserted into new list element
	 * @throws OutOfBounds If window is over the after last position
	 */
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

	/**
	 * Creates a new link before current window position and inserts user supplied object
	 * @param window Take the window object as input
	 * @param e User supplied Object to be inserted into new list element
	 * @throws OutOfBounds If window is over the before first position
	 */
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

	/**
	 * Specifies whether the window is over the after last position
	 * @param window Take the window object as input
	 * @return boolean True is over the after last position, otherwise false.
	 */
	public boolean isAfterLast(CITS2200.WindowLinked window)
	{
		return(window.link == after);
	}

	/**
	 * Specifies whether the window is over the before first position
	 * @param window Take the window object as input
	 * @return boolean True is over the before first position, otherwise false.
	 */
	public boolean isBeforeFirst(CITS2200.WindowLinked window)
	{
		return(window.link == before);
	}

	/**
	 * Specifies whether the list is empty.
	 * @return boolean True if empty, otherwise false.
	 */
	public boolean isEmpty() 
	{
		return(before.successor == after);
	}

	/**
	 * Moves the window to the next item in the list
	 * @param window Takes the window object as input
	 * @throws OutOfBounds If the window is over the after last position.
	 */
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

	/**
	 * Moves the window to the previous item in the list
	 * @param window Takes the window object as input
	 * @throws OutOfBounds If the window is over the before first position.
	 */
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

	/**
	 * Replaces the item underneath the window with the user supplied input
	 * @param e User supplied Object to replace with
	 * @param window Take the window object as input
	 * @return The item that has been replaced by the new object.
	 * @throws OutOfBounds If the window is in the before first or after last position.
	 */
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
