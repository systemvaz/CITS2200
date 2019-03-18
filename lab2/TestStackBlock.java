import java.util.Scanner;

public class TestStackBlock
{
  static StackBlock myStackBlock = new StackBlock();
  static Scanner reader = new Scanner(System.in);
  //static Int data = new String("");

  public static boolean menu()
  {
    System.out.println("1: Create stack");
    System.out.println("2: Push");
    System.out.println("3: Pop");
    System.out.println("4: Examine");
    System.out.println("5: QUIT");
    int option = reader.nextInt();

    switch(option)
    {
      case 1:
        System.out.println("Enter size: ");
        int size = reader.nextInt();
        myStackBlock.StackBlocks(size);
        break;
      case 2:
        System.out.println("Int to push: ");
        int data = reader.nextInt();
        myStackBlock.push(data);
        break;
      case 3:
        System.out.println(myStackBlock.pop());
        break;
      case 4:
        System.out.println(myStackBlock.examine());
        break;
      case 5:
        return true;
    }

    return false;
  }

  public static void main(String[] args)
  {
    boolean quit = false;
    while(quit == false)
    {
      menu();
    }
  }


}
