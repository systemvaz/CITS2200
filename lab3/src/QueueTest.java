import java.util.Scanner;

public class QueueTest
{  
	public static void main(String[] args)
	{
	  Scanner reader = new Scanner(System.in);
	  QueueCyclic myQueue = new QueueCyclic(6);
	  boolean quit = false;
	  while(quit == false)
	  {
	    System.out.println("1: Enqueue");
	    System.out.println("2: Dequeue");
	    System.out.println("3: Examine");
	    System.out.println("4: QUIT");
	    int option = reader.nextInt();
	
	    switch(option)
	    {
	      case 1:
	        System.out.println("Int to push: ");
	        int data = reader.nextInt();
	        myQueue.enqueue(data);
	        myQueue.printqueue();
	        break;
	      case 2:
	        System.out.println(myQueue.dequeue());
	        myQueue.printqueue();
	        break;
	      case 3:
	        System.out.println(myQueue.examine());
	        myQueue.printqueue();
	        break;
	      case 4:
	        reader.close();
	        quit = true;
	        break;
	    }
	  }
	}
}
