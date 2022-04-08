package mru.tsc.model;
/**
 * Board game class extending toy
 * @author ardausuk and Rajan Bhullar
 *
 */
public class BoardGame extends Toy{


	 //variables
	String players;
	String designers;
/**
 * Board game method
 * @param SN serial number
 * @param name of board game
 * @param brand of board game
 * @param price of board game
 * @param availableCount number of board games
 * @param ageAppropriate age of use
 * @param player number of players
 * @param designer of board game
 */
	public BoardGame(String SN, String name, String brand, double price, int availableCount, int ageAppropriate, String player, String designer) {
		super(SN, name, brand, price, availableCount, ageAppropriate);
		players = player;
		designers = designer;
		
	}
	//setters and getters below
	public String getDesigners() {
		return designers;
	}

	public void setDesigners(String designers) {
		this.designers = designers;
	}

	@Override
	public String toString() {
		return "BoardGame [SN=" + SN + ", name=" + name + ", brand=" + brand + ", price=" + price + ", availableCount="
				+ availableCount + ", ageAppropraite=" + ageAppropraite + ", players=" + players + ", designers="
				+ designers + "]";
	
}
	public String format() {
		
		return SN + ";" + name + ";" + brand + ";" + price + ";" + availableCount + ";" + ageAppropraite + ";" + players + ";" + designers;
	
	}
}