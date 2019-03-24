public class LockInt implements Lock
{
  private int combo = 321;
  public boolean closed_state = false;

  public boolean openLock (int code)
  {
    if (code == combo)
    {
      closed_state = false;
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
      return true;
    }
    else
    {
      return false;
    }
  }

  public boolean closeLock ()
  {
    closed_state = true;
    return true;
  }

}
