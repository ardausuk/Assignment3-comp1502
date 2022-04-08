package mru.tsc.model;
/**
 * Puzzle class extending toy
 * @author ardausuk and Rajan Bhullar
 *
 */
public class Puzzle extends Toy {

	//variable
	String puzzleType;

	/**
	 * Puzzle method
	 * @param SN serial number
	 * @param name of puzzle
	 * @param brand of puzzle
	 * @param price of the puzzle
	 * @param availableCount number of puzzles
	 * @param ageAppropriate age of use
	 * @param type of puzzle
	 */
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
//setters and getters
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
