package mru.tsc.exceptions;
/**
 * Checks user inputs if negative number is input
 * @author ardausuk and Rajan Bhullar
 *
 */
public class NegativeUserInput extends Exception {
	
	public NegativeUserInput()
	{
		super("Please enter a positive double number, the price cannot be negative");
	}
}
