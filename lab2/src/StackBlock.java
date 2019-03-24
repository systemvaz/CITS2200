/**
* @author   Alexander Varano della Vergiliana
* @version  1.0
*/

import CITS2200.*;

public class StackBlock implements Stack
{
  private int first, last;
  private Object[] myStack;

  /**
  * Constructor class initialising the stack array and positions of the
  * first and last elements.
  *
  * @param  s Takes integer as size of the new stack array to be created.
  */
  public StackBlock(int s)
  {
    first = 0;
    last = -1;
    myStack = new Object[s];
  }

  /**
  * Checks whether the stack array has been filled to the its max size.
  *
  * @return type: Boolean. False if not full. True if full.
  */
  public boolean isFull()
  {
    return(last == myStack.length - 1);
  }

  /**
  * Checks whether the stack array is empty.
  *
  * @return type: Boolean. False if not empty. True if empty.
  */
  public boolean isEmpty()
  {
    return(last < first);
  }

  /**
  * Pushes new object into the stack array. Checks whether the stack if is full
  * before pushing a new object.
  *
  * @param o Take object as new item to be push to the stack.
  * @throws Overflow If stack is already full.
  */
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

  /**
  * Returns the top element of the stack array if the stack is not empty.
  *
  * @return type: Object. Top element of the stack array.
  * @throws Underflow If stack is empty.
  */
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

  /**
  * Returns and removes the top element of the stack array if the stack
  * is not empty.
  *
  * @return type: Object. Top elemnts of the stack array.
  * @throws Underflow If stack is empty.
  */
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
