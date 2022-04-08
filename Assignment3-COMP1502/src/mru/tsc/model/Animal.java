package mru.tsc.model;
/**
 * Animal class extended from toy
 * @author ardausuk and Rajan Bhullar
 *
 */
public class Animal extends Toy {
	//variables
	String Material;
	char size;
	

	/**
	 * Animal method
	 * @param SN serial number
	 * @param name of animal
	 * @param brand of the animal
	 * @param price of the animal
	 * @param availableCount number of animals
	 * @param ageAppropriate age of use
	 * @param mat materials used
	 * @param Size of animal
	 */
	public Animal(String SN, String name, String brand, double price, int availableCount, int ageAppropriate, String mat, String Size) {
		super(SN, name, brand, price, availableCount, ageAppropriate);
		 Material = mat;
		 size = Size.charAt(0);
		
	}
	
//getters and setters below
	public String getMaterial() {
		return Material;
	}

	public void setMaterial(String material) {
		Material = material;
	}

	public char getSize() {
		return size;
	}

	public void setSize(char size) {
		this.size = size;
	}
	
	
	@Override
	public String toString() {
		return "Animal [SN=" + SN + ", name=" + name + ", brand=" + brand + ", price=" + price + ", availableCount="
				+ availableCount + ", ageAppropraite=" + ageAppropraite + ", Material=" + Material + ", size=" + size
				+ "]";
	}

	public String format() {
		
		return SN + ";" + name + ";" + brand + ";" + price + ";" + availableCount + ";" + ageAppropraite + ";" + Material + ";" + size;
	
	}
	

}
