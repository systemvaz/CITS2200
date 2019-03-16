import java.util.Scanner;

public class LockTest
{

  static LockInt myLockInt = new LockInt();
  static LockString myLockString = new LockString();
  static Scanner reader = new Scanner(System.in);

  public static void open()
  {
    System.out.println("Enter code: ");
    int code = reader.nextInt();

    if (myLockInt.openLock(code))
    {
      System.out.println("Int: Lock Opened :)");
    }
    else
    {
      System.out.println("Int: WRONG CODE!");
    }

    if (myLockString.openLock(code))
    {
      System.out.println("String: Lock Opened :)");
    }
    else
    {
      System.out.println("String: WRONG CODE!");
    }
  }

  public static void change()
  {
    System.out.println("Enter code: ");
    int code = reader.nextInt();
    System.out.println("Enter new code: ");
    int newcode = reader.nextInt();

    if (myLockInt.changeLock(code, newcode))
    {
      System.out.println("Code change successful!");
    }
    else
    {
      System.out.println("Code change FAILED!");
    }

    if (myLockString.changeLock(code, newcode))
    {
      System.out.println("Code change successful!");
    }
    else
    {
      System.out.println("Code change FAILED!");
    }
  }

  public static void lock()
  {
    if (myLockInt.closed_state == false)
    {
      myLockInt.closeLock();
      myLockString.closeLock();
    }
    else
    {
      System.out.println("Lock already closed.");
    }
  }

  public static void main(String[] args)
  {
    System.out.println("Input: o = Open Lock | c = Change Combo | l = Close Lock");
    String option = reader.next();

    switch(option)
    {
      case "o":
        open();
        break;
      case "c":
        change();
        break;
      case "l":
        lock();
        break;
    }

  }

}
