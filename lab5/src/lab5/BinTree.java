/**
 * @author Alexander Varano della Vergiliana
 */


import CITS2200.*;
import java.util.Stack;
import java.util.ArrayList;

public class BinTree<E> extends BinaryTree<E>
{
	/**
	 * BinTree constructors
	 */
	public BinTree()
	{
		super();
	}
	
	public BinTree(E item, BinaryTree<E> b1, BinaryTree<E> b2)
	{
		super(item, b1, b2);
	}

	/**
	 * Casts users supplied object as new BinaryTree.
	 * Creates an iterator for each of the binary trees. Checks to see if both binary trees
	 * contain the same number of elements and if they do, enter a loop to check each tree
	 * item against each other.
	 * 
	 * @param o Take an object which is to be casted to a BinaryTree and compared for equality with BinTree.
	 * @return boolean True is both binary trees are equal, otherwise false.
	 */
	@Override
	public boolean equals(Object o) 
	{	
		if(o instanceof BinaryTree)
		{
			@SuppressWarnings("unchecked")
			BinaryTree<E> myTree = (BinaryTree<E>) o;
			Iterator<E> myIterator = myTree.iterator();
			Iterator<E> binIterator = this.iterator();
			
			int mySize = 0;
			while(myIterator.hasNext())
			{
				mySize++;
			}
			myIterator = myTree.iterator();
			
			int binSize = 0;
			while(binIterator.hasNext())
			{
				binSize++;
			}
			binIterator = this.iterator();
			
			if(mySize == binSize)
			{
				for(int i = 0; i < mySize; i++)
				{
					if(myIterator.next() != binIterator.next())
					{
						return false;
					}
				}
				return true;
			}
			else 
			{
				return false;
			}	
		}	
		return false;
	}	

	/**
	 * Provides a new iterator from inner class treeIterator
	 * @return Iterator<E>
	 */
	@Override
	public Iterator<E> iterator() 
	{
		return new treeIterator();
	}	

	
	/**
	 * Inner class to iterate over binary tree. 
	 */
	private class treeIterator implements CITS2200.Iterator<E>
	{		
		ArrayList<E> myArray = new ArrayList<E>();
		int i = 0;
		
		/**
		 * Using depth first search, place each tree elements into an ArrayList myArray.
		 * The depth first search utilises a Stack to perform this operation.
		 */
		public treeIterator()
		{
			Stack<E> myStack = new Stack<E>();
			E root = getItem();
			myStack.push(root);
				
			while(!myStack.empty())
			{
				E temp = myStack.pop();
				myArray.add(temp);
					
				if(getLeft().getItem() != null)
				{
					myStack.push(getLeft().getItem());
				}
				if(getRight().getItem() != null)
				{
					myStack.push(getRight().getItem());
				}
			}

		}
		
		/**
		 * Checks if ArrayList contains another item.
		 */
		public boolean hasNext() 
		{	
			if(i < myArray.size())
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		
		/**
		 * Get the next item provided the ArrayList.
		 * @return E Return the next item in the Array List
		 * @throws OutOfBounds if no item is present, by perform a hasNext opertion.
		 */
		public E next() throws OutOfBounds 
		{
			if(hasNext())
			{
				E temp = myArray.get(i);
				i++;
				return temp;
			}
			else
			{
				throw new OutOfBounds("No more elements");
			}
		}	
	}
	
}
