import CITS2200.Deque;
import CITS2200.Overflow;
import CITS2200.Underflow;

public class DequeCyclic implements Deque{
	private int left, right, size, capacity; 
	private Object[] queue; 
	
	
	/*
	 * Constructing an empty Queue
	 * @param s is the final size of the array
	 */
	public DequeCyclic(final int s) {
		left= right = size = 0; 
		queue = new Object[s];
		capacity = s; 
		
	}

	public boolean isEmpty() {
		return (size == 0);
	}
	
	
	public boolean isFull() {
		return (size == capacity);
	}
	
	
	public void pushLeft(Object c) throws Overflow{
		if (isFull()) {
			throw new Overflow ("the queue is full");
		}
		else if (left == 0 && right == 0 && size ==0) {
			queue[0] = c;
		}
		
		else {
			left = (left+1) % queue.length;
			queue[left] = c;
		}
		size++;
		}

	public void pushRight(Object c) throws Overflow{
		if (isFull()) {
			throw new Overflow ("the queue is full");
		}
		else if (left == 0 && right == 0 && size == 0) {
			queue[0] = c;
		}
		else if (right == 0){
			right = queue.length-1;
			queue[right] = c;
			}
		else {
			right--;
			queue[right] = c;
		}
		size++;
		}
	
	public Object peekLeft() throws Underflow{
		if (isEmpty()) {
			throw new Underflow("the queue is empty");
		}
		return queue[left];
	}
	
	public Object peekRight() throws Underflow{
		if (isEmpty()) {
			throw new Underflow("the queue is empty");
		}
		return queue[right];
	}
	
	public Object popLeft() throws Underflow{
		Object temp;
		temp = queue[left];
		if (isEmpty()) {
			throw new Underflow("the queue is empty");
		}
		else if (left == 0) {
			left = capacity-1;
		}
		else {
			queue[left] = null;
			left--;
		}
		size--;
		return temp;
	}
	
	public Object popRight() throws Underflow{
		Object temp;
		temp = queue[right];
		if (isEmpty()) {
			throw new Underflow("the queue is empty");
		}
		else {
			queue[right] = null;
				if(right == capacity-1) {
					right=0;
				}
				else {
					right++;
				}
		}
		size--;
		return temp;
	}

}
