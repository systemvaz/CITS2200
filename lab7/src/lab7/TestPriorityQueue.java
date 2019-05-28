package lab7;
import java.util.Scanner;

public class TestPriorityQueue 
{
	public static void main(String[] args)
	{
	  int data = 0;
	  int priority = 0;
	  Scanner reader = new Scanner(System.in);
	  PriorityQueueLinked myQueue = new PriorityQueueLinked();
	  boolean quit = false;
	  while(quit == false)
	  {
	    System.out.println("1: Enqueue");
	    System.out.println("2: Dequeue");
	    System.out.println("3: Examine");
	    System.out.println("4: Iterator");
	    System.out.println("5: Iterator Has Next");
	    System.out.println("6: Iterator Next");
	    System.out.println("7: QUIT");
	    int option = reader.nextInt();
	
	    switch(option)
	    {
	      case 1:
	        System.out.println("Element to insert: ");
	        data = reader.nextInt();
	        System.out.println("Priority Number: ");
	        priority = reader.nextInt();
	        myQueue.enqueue(data, priority);
	        break;
	      case 2:
		    myQueue.dequeue();
		    break;
	      case 3:
	        System.out.println(myQueue.examine());
	        break;
	      case 4:
	    	myQueue.iterator();
	        break;
	      case 5:
	    	System.out.println(myQueue.iterator().hasNext());
	    	break;
	      case 6:
	    	System.out.println(myQueue.iterator().next());
	    	break;
	      case 7:
		    reader.close();
			quit = true;
	      	break;
	    }
	  }
	}
}
