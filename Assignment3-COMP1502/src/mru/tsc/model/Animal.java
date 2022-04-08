package mru.tsc.model;

public class Animal extends Toy {
	
	String Material;
	char size;
	

	
	public Animal(String SN, String name, String brand, double price, int availableCount, int ageAppropriate, String mat, String Size) {
		super(SN, name, brand, price, availableCount, ageAppropriate);
		 Material = mat;
		 size = Size.charAt(0);
		
	}
	

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
