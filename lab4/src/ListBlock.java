

public class ListBlock 
{
	private Object[] block;
	public WindowBlock w;
	private int before;
	private int after;
	
	public ListBlock (int size)
	{
		block = new Object[size];
		before = -1;
		after = 0;
		w.index = before;
	}
	
	/** CHECKERS **/
	
	public boolean isEmpty()
	{
		return(after == 0);
	}
	
	public boolean isFull()
	{
		return(after == block.length-1);;
	}
	
	public boolean isBeforeFirst(WindowBlock w)
	{
		return(w.index == before);
	}
	
	public boolean isAfterLast(WindowBlock w)
	{
		return(w.index == after);
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
			throw new Exception("Calling next after list end.");
		}
	}
	
	public void previous(WindowBlock w) throws Exception
	{
		if(!isBeforeFirst(w))
		{
			w.index--;
		}
		else
		{
			throw new Exception("Calling previous at start of list.");
		}
	}
	
	public void insertAfter(Object e, WindowBlock w) throws Exception
	{
		if(!isFull())
		{
			if(!isBeforeFirst(w))
			{
				for(int i = after-1; i > w.index; i--)
				{
					block[i+1] = block[i];
				}
				after++;
				block[w.index]= e;
				w.index++;
			}
			throw new Exception("Inserting before start");
		}
		throw new Exception("Inserting into full list");
	}
	
	public void insertBefore(Object e, WindowBlock w) throws Exception, Exception
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
		if(w.index != before || w.index != after)
		{
			return e[w.index];
		}
		else throw new Excpetion("some text here");
	}
	
	public Object replace(Object e, WindowBlock w) throws Exception
	{
		if(!isBeforeFirst(w) || !isAfterLast(w))
		{
			Object temp = block[w.index];
			block[w.index]= e;
			return temp;
		}
		else
		{
			throw new Exception("some text here");
		}
	}
	
	public Object delete(WindowBlock w) throws Exception
	{
		if(w.index != before || w.index != after)
		{
			Object temp = block[w.index];
			for(int i = w.index; i <= after; i++)
			{
				block[i] = block[i+1];
			}
			after--;
			w.index++;
			return temp;
		}
		else
		{
			throw new Exception("some text here");
		}
	}
	


public void printqueue()
{
	System.out.println(" ");
	for (int i = 0; i < block.length; i++)
	{
		System.out.print(block[i] + " | ");
	}
	System.out.println("");
	System.out.println("w = " + w.index);
	System.out.println("");
}
}
