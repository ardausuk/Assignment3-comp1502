package mru.tsc.model;

public class BoardGame extends Toy{


	 
	String players;
	String designers;

	public BoardGame(String SN, String name, String brand, double price, int availableCount, int ageAppropriate, String player, String designer) {
		super(SN, name, brand, price, availableCount, ageAppropriate);
		players = player;
		designers = designer;
		
	}
	
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