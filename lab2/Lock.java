/**
* @author   Alexander Varano della Vergiliana (22268@student.uwa.edu.au)
* @version  1.0
*/

public interface Lock
{
  /**
  * Interface opens lock given correct code has been inputed
  *
  * @param  code Takes integer as code to try on lock
  * @return Returns false if code rejected, true if code is correct
  */
  public boolean openLock (int code);

  /**
  * Iterface sets the lock to the closed closed state
  *
  * @return Returns true on success
  */
  public boolean closeLock ();

  /**
  * Interface changes lock code given correct current code provided
  *
  * @param  code Take integer as code to try on lock
  * @param  newcode Takes integer as code to change to
  * @return Returns false if code does not match current code
  */
  public boolean changeLock (int code, int newcode);

}
