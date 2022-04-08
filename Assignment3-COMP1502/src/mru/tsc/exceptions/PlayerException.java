package mru.tsc.exceptions;

public class PlayerException extends Exception {
	
	public PlayerException()
	{
		super("The minimum number of players has to be lower than the maximum number of players");
	}
}
