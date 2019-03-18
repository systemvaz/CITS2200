import CITS2200.*;

public class StackBlock implements Stack
{
  private int first, last;
  private Object[] myStack;

  public void StackBlocks(int s)
  {
    first = 0;
    last = -1;
    myStack = new Object[s];
  }

  public boolean isFull()
  {
    return(last == myStack.length - 1);
  }

  public boolean isEmpty()
  {
    return(last < first);
  }

  public void push(Object o)
  {
    if (!isFull())
    {
      last = last + 1;
      myStack[last] = o;
    }
    else
    {
      throw new Overflow("Cannot push - stack full");
    }
  }

  public Object examine()
  {
    if(!isEmpty())
    {
      return(myStack[last]);
    }
    else
    {
      throw new Underflow("Cannot examine - stack empty");
    }
  }

  public Object pop()
  {
      if(!isEmpty())
      {
        last = last - 1;
        return(myStack[last + 1]);
      }
      else
      {
        throw new Underflow("Cannot pop - stack empty");
      }
  }

}
