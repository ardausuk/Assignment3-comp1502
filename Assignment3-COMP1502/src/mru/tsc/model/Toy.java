package mru.tsc.model;

public abstract class Toy {
	
	String SN;
	String name;
	String brand;
	String type;
	double price;
	int availableCount;
	int ageAppropraite;

	
	public Toy(String SN, String name, String brand, double price, int availableCount, int ageAppropriate) {
		this.SN = SN;
		this.name = name;
		this.brand = brand;
		this.price = price;
		this.availableCount = availableCount;
		this.ageAppropraite = ageAppropriate;
	}

	public String getSN() {
		return SN;
	}

	public void setSN(String sN) {
		SN = sN;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getAvailableCount() {
		return availableCount;
	}

	public void setAvailableCount(int availableCount) {
		this.availableCount = availableCount;
	}

	public int getAgeAppropraite() {
		return ageAppropraite;
	}

	public void setAgeAppropraite(int ageAppropraite) {
		this.ageAppropraite = ageAppropraite;
	}
}
