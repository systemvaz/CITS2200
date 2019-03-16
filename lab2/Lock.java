public interface Lock
{

  public boolean openLock (int code);

  public boolean closeLock ();

  public boolean changeLock (int code, int newcode);

}
