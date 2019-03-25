import java.util.Scanner;

public class TestDeque 
{
	public static void main(String[] args)
	{
	  int data = 0;
	  Scanner reader = new Scanner(System.in);
	  DequeCyclic myQueue = new DequeCyclic(6);
	  boolean quit = false;
	  while(quit == false)
	  {
	    System.out.println("1: Push Left");
	    System.out.println("2: Push Right");
	    System.out.println("3: Pop Left");
	    System.out.println("4: Pop Right");
	    System.out.println("5: Peek Left");
	    System.out.println("6: Peek Right");
	    System.out.println("7: QUIT");
	    int option = reader.nextInt();
	
	    switch(option)
	    {
	      case 1:
	        System.out.println("Int to push: ");
	        data = reader.nextInt();
	        myQueue.pushLeft(data);
	        myQueue.printqueue();
	        break;
	      case 2:
		    System.out.println("Int to push: ");
		    data = reader.nextInt();
		    myQueue.pushRight(data);
		    myQueue.printqueue();
		    break;
	      case 3:
	        System.out.println(myQueue.popLeft());
	        myQueue.printqueue();
	        break;
	      case 4:
	    	System.out.println(myQueue.popRight());
		    myQueue.printqueue();  
	        break;
	      case 5:
	    	System.out.println(myQueue.peekLeft());
		    myQueue.printqueue();
	    	break;
	      case 6:
	    	System.out.println(myQueue.peekRight());
		    myQueue.printqueue();
	    	break;
	      case 7:
	    	reader.close();
		    quit = true;
	    	break;
	    }
	  }
	}
}


//  ADD THIS TO DequeCyclic.java
//
//public void printqueue()
//{
//	System.out.println(" ");
//	for (int i = 0; i < myDeque.length; i++)
//	{
//		System.out.print(myDeque[i] + " | ");
//	}
//	System.out.println("");
//	System.out.println("");
//}
