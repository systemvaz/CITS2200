import java.util.Scanner;

import CITS2200.Link;

public class TestListLinked 
{
	public static void main(String[] args)
	{
	  int data = 0;
	  Scanner reader = new Scanner(System.in);
	  ListLinked myQueue = new ListLinked();
	  boolean quit = false;
	  while(quit == false)
	  {
	    System.out.println("1: Insert Before");
	    System.out.println("2: Insert After");
	    System.out.println("3: Examine");
	    System.out.println("4: Replace");
	    System.out.println("5: Delete");
	    System.out.println("6: Next");
	    System.out.println("7: Previous");
	    System.out.println("8: QUIT");
	    System.out.println("9: IsBeforeFirst?");
	    System.out.println("10: IsAfterLast?");
	    System.out.println("11: isEmpty");
	    int option = reader.nextInt();
	
	    switch(option)
	    {
	      case 1:
	        System.out.println("Int to insert: ");
	        data = reader.nextInt();
	        myQueue.insertBefore(data, myQueue.window);
	        myQueue.printqueue();
	        break;
	      case 2:
		    System.out.println("Int to insert: ");
		    data = reader.nextInt();
		    myQueue.insertAfter(data, myQueue.window);
		    myQueue.printqueue();
		    break;
	      case 3:
	        System.out.println(myQueue.examine(myQueue.window));
	        myQueue.printqueue();
	        break;
	      case 4:
		    System.out.println("Int to insert: ");
		    data = reader.nextInt();
		    System.out.println(myQueue.replace(data, myQueue.window));
		    myQueue.printqueue();
	        break;
	      case 5:
	    	System.out.println(myQueue.delete(myQueue.window));
		    myQueue.printqueue();
	    	break;
	      case 6:
	    	myQueue.next(myQueue.window);
		    myQueue.printqueue();
	    	break;
	      case 7:
	      	myQueue.previous(myQueue.window);
	      	myQueue.printqueue();
	      	break;
	      case 8:
	    	reader.close();
		    quit = true;
	    	break;
	      case 9:
	    	  System.out.println(myQueue.isBeforeFirst(myQueue.window));
	    	  break;
	      case 10:
	    	  System.out.println(myQueue.isAfterLast(myQueue.window));
	    	  break;
	      case 11:
	    	  System.out.println(myQueue.isEmpty());
	    	  break;
	    }
	  }
	}
}



//public void printqueue()
//{
//	Link current = before;
//	while(current != after.successor)
//	{
//		System.out.print(current.item + " | ");
//		current = current.successor;
//	}
//	System.out.println(" ");
//	System.out.println(" ");
//}
//

