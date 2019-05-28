import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;
import CITS2200.BinaryTree;
import CITS2200.Iterator;

public class BinTree extends BinaryTree<Object>{
	public BinTree() { super(); }
	
	public BinTree(Object item, BinaryTree<Object> b1,
			BinaryTree<Object> b2) { super(item,b1,b2); }
	
	public boolean equals(Object o) {
		if ((this==null ^ o==null) || !(o instanceof BinaryTree)) {
			return false;
			
		
		}

		BinaryTree<Object> t = (BinaryTree<Object>) o;
		if (this.isEmpty() ^ t.isEmpty()) {
			return false;
	
		}
		if (this.isEmpty() && t.isEmpty()) {
			return true;

		}
		
		return ((this.getItem().equals(t.getItem())) &&
				(this.getLeft().equals(t.getLeft())) &&
				(this.getRight().equals(t.getRight())));


    }
	
	public Iterator<Object> iterator() {
		return new BinaryTreeIterator(this);
	}
	
	class BinaryTreeIterator implements Iterator<Object> {
		private Queue<BinaryTree<Object>> q = 
				new LinkedList<BinaryTree<Object>>();
		
		public BinaryTreeIterator(BinTree b) {
			if(b == null) {
				return;
			}
			else { q.add(b); }
		}
		
		public boolean hasNext() {
			return !q.isEmpty();
		}
		
		public Object next() {
			if(hasNext()) {
				BinTree b = (BinTree) q.remove();
		
				if(!b.getLeft().isEmpty()) {
					q.add(b.getLeft());
				}
	
				if(!b.getRight().isEmpty()) {
					q.add(b.getRight());
				}

				Object o = new Object();
				if(!b.isEmpty()) {
					o = b.getItem();
				}
				return o;

 			}
			else throw new 
			NoSuchElementException("No more elements in the binary tree");
		}
	}
}
