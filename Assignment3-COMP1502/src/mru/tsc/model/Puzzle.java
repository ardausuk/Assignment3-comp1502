package mru.tsc.model;

public class Puzzle extends Toy {

	
	String puzzleType;

	
	public Puzzle(String SN, String name, String brand, double price, int availableCount, int ageAppropriate,
			String type) {
		super(SN, name, brand, price, availableCount, ageAppropriate);
		puzzleType = type;
	}

	
	@Override
	public String toString() {
		return "Puzzle [SN=" + SN + ", name=" + name + ", brand=" + brand + ", price=" + price + ", availableCount="
				+ availableCount + ", ageAppropraite=" + ageAppropraite + ", puzzleType=" + puzzleType + "]";
	}

	public String getPuzzleType() {
		return puzzleType;
	}

	public void setPuzzleType(String puzzleType) {
		this.puzzleType = puzzleType;
	}
	
	
	public String format() {
		
		return SN + ";" + name + ";" + brand + ";" + price + ";" + availableCount + ";" + ageAppropraite + ";" + puzzleType;
	
	}

}
