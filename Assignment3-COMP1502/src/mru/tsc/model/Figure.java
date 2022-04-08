package mru.tsc.model;

public class Figure extends Toy{
		
	
	char classification;
	
	public Figure(String SN, String name, String brand, double price, int availableCount, int ageAppropriate, String Class) {
		super(SN, name, brand, price, availableCount, ageAppropriate);
		classification = Class.charAt(0);
		
	}
	
	@Override
	public String toString() {
		return "Figure [SN=" + SN + ", name=" + name + ", brand=" + brand + ", price=" + price + ", availableCount="
				+ availableCount + ", ageAppropraite=" + ageAppropraite + ", classification=" + classification + "]";
	}
	
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
