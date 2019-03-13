public class LockInt implements Lock
{
  private int combo = 321;

  public boolean openLock (int code)
  {
    if (code == combo)
    {
      closeLock(false);
      return true;
    }
    else
    {
      return false;
    }
  }

  public boolean changeLock (int code, int newcode)
  {
    if(openLock(code) == true)
    {
      combo = newcode;
      closeLock(false);
      return true;
    }
    else
    {
      return false;
    }
  }

  public boolean closeLock (boolean state)
  {
    return true;
  }

}
