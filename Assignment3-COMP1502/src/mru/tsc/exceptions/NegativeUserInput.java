package mru.tsc.exceptions;

public class NegativeUserInput extends Exception {
	
	public NegativeUserInput()
	{
		super("Please enter a positive double number, the price cannot be negative");
	}
}
