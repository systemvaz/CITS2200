public class LockString implements Lock
{
  private String combo = "321";
  public boolean closed_state = false;

  public boolean openLock (int code)
  {
    String numtostring = "" + code;
    if (numtostring.equals(combo))
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
      String numtostring = "" + newcode;
      combo = numtostring;
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
