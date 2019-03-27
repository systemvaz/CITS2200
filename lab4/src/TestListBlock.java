

import java.util.Scanner;

public class TestListBlock 
{
	public static void main(String[] args)
	{
	  int data = 0;
	  Scanner reader = new Scanner(System.in);
	  ListBlock myQueue = new ListBlock(10);
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
	    int option = reader.nextInt();
	
	    switch(option)
	    {
	      case 1:
	        System.out.println("Int to insert: ");
	        data = reader.nextInt();
	        myQueue.insertBefore(data, myQueue.w);
	        myQueue.printqueue();
	        break;
	      case 2:
		    System.out.println("Int to insert: ");
		    data = reader.nextInt();
		    myQueue.insertAfter(data, myQueue.w);
		    myQueue.printqueue();
		    break;
	      case 3:
	        System.out.println(myQueue.examine(myQueue.w));
	        myQueue.printqueue();
	        break;
	      case 4:
		    System.out.println("Int to insert: ");
		    data = reader.nextInt();
		    myQueue.replace(data, myQueue.w);
		    myQueue.printqueue();
	        break;
	      case 5:
	    	myQueue.delete(myQueue.w);
		    myQueue.printqueue();
	    	break;
	      case 6:
	    	myQueue.next(myQueue.w);
		    myQueue.printqueue();
	    	break;
	      case 7:
	      	myQueue.previous(myQueue.w);
	      	myQueue.printqueue();
	      	break;
	      case 8:
	    	reader.close();
		    quit = true;
	    	break;
	    }
	  }
	}
}
