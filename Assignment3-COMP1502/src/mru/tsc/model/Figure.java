package mru.tsc.model;
/**
 * Figure class extending toy
 * @author ardausuk and Rajan Bhullar
 *
 */
public class Figure extends Toy{
		
	//variables
	char classification;
	/**
	 * Figure method
	 * @param SN serial number
	 * @param name of figure
	 * @param brand of figure
	 * @param price of the figure
	 * @param availableCount number of figures
	 * @param ageAppropriate age of use for figure
	 * @param Class of figure, doll, etc.
	 */
	public Figure(String SN, String name, String brand, double price, int availableCount, int ageAppropriate, String Class) {
		super(SN, name, brand, price, availableCount, ageAppropriate);
		classification = Class.charAt(0);
		
	}
	
	@Override
	public String toString() {
		return "Figure [SN=" + SN + ", name=" + name + ", brand=" + brand + ", price=" + price + ", availableCount="
				+ availableCount + ", ageAppropraite=" + ageAppropraite + ", classification=" + classification + "]";
	}
	//getters and setters
	public char getClassification() {
		return classification;
	}
	public void setClassification(char classification) {
		this.classification = classification;
	}
	
public String format() {
		
		return SN + ";" + name + ";" + brand + ";" + price + ";" + availableCount + ";" + ageAppropraite + ";" + classification;
	
	}

}
