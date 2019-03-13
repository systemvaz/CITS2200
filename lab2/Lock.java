public interface Lock
{

  public boolean openLock (int code);

  public boolean closeLock (boolean state);

  public boolean changeLock (int code, int newcode);

}
