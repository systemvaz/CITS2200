import java.util.Scanner;

public class QueueTest
{
  public static void main(String[] args)
  {
    Scanner reader = new Scanner(System.in);
    QueueCyclic myQueue = new QueueCyclic(9);
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
          break;
        case 2:
          System.out.println(myQueue.dequeue());
          break;
        case 3:
          System.out.println(myQueue.examine());
          break;
        case 4:
          quit = true;
          break;
      }
    }
  }
}
