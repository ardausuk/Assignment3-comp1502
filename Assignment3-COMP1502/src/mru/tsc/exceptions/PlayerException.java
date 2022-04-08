package mru.tsc.exceptions;
/**
 * Checks if user put the number of players correctly
 * @author ardausuk and Rajan Bhullar
 *
 */
public class PlayerException extends Exception {
	
	public PlayerException()
	{
		super("The minimum number of players has to be lower than the maximum number of players");
	}
}
