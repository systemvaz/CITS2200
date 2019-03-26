package lab4;

public class ListBlock 
{
	private Object[] block;
	private int before;
	private int after;
	
	public ListBlock (int size)
	{
		block = new Object[size];
		before = -1;
		after = 0;
	}
	
	/** CHECKERS **/
	
	public boolean isEmpty()
	{
		return true;
	}
	
	public boolean isFull()
	{
		return true;
	}
	
	public boolean isBeforeFirst(WindowBlock w)
	{
		return true;
	}
	
	public boolean isAfterLast(WindowBlock w)
	{
		return true;
	}
	
	/** MANIPULATORS **/
	
	public void beforeFirst(WindowBlock w)
	{
		w.index = before;
	}
	
	public void afterLast(WindowBlock w)
	{
		w.index = after;
	}
	
	public void next(WindowBlock w) throws Exception
	{
		if (!isAfterLast(w))
		{
			w.index++;
		}
		else
		{
			throw new Overflow("Calling next after list end.");
		}
	}
	
	public void previous(WindowBlock w)
	{
		
	}
	
	public void insertAfter(Object e, WindowBlock w) throws Exception
	{
		
	}
	
	public void insertBefore(Object e, WindowBlock w) throws Exception
	{
		if(!isFull())
		{
			if(!isBeforeFirst(w))
			{
				for(int i = after-1; i >= w.index; i--)
				{
					block[i+1] = block[i];
				}
				
				after++;
				block[w.index]= e;
				w.index++;
			}
			else
			{
				throw new Exception("Inserting before start");
			}
		}
		else
		{
			throw new Exception("Inserting in full list");
		}
	}
	
	public Object examine(WindowBlock w) throws Exception
	{
		return Object;
	}
	
	public Object replace(Object e, WindowBlock w) throws Exception
	{
		return Object;
	}
	
	public Object delete(WindowBlock w) throws Exception
	{
		return Object;
	}
}
