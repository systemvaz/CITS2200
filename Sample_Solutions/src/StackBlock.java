import CITS2200.Overflow;
import CITS2200.Stack;
import CITS2200.Underflow;

public class StackBlock implements Stack{
	private int s; 
	private Object[] stack; 
	private int top; 

	
	public StackBlock(final int s) {
		if (s < 1) {
			throw new IllegalArgumentException("Max Elements cannot be less than 1, was: " + s);			
		}
		this.s = s;
		stack = new Object[s];
		top = 0;
	}


	public boolean isEmpty() {
		return (top == 0);
	}
	
	public boolean isFull() {
		return (top >= stack.length);
	}
	
	
	public void push(Object o) throws Overflow {
		if (isFull()) {
			throw new Overflow("the stack is full");
		}
		stack[top] = o;
		top++;

	}
	
	public Object examine() throws Underflow {
		if (isEmpty()) {
			throw new Underflow("the stack is empty");
		}
		else {
			return stack[top-1];
		}
		
	}
	
	
	public Object pop() throws Underflow {
		if (!isEmpty()) {
			top--;
			return (stack[top]);
		}
		else throw new Underflow("the stack is empty");		
	}
	
	
}
