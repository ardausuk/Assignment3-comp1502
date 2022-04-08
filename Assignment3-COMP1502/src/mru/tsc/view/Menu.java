package mru.tsc.view;

import java.util.ArrayList;
import java.util.Scanner;

import mru.tsc.controller.StoreController;
import mru.tsc.exceptions.PlayerException;
import mru.tsc.exceptions.NegativeUserInput;
import mru.tsc.model.Toy;


public class Menu extends StoreController {
	private final String FILE_PATH = "res/toys.txt";
	static Scanner in = new Scanner(System.in);
	ArrayList<Toy> toys = new ArrayList<>();

	
	public Menu() throws Exception {
		startMenu();
	}


	public void startMenu() throws Exception {
		System.out.println("***********************************");
		System.out.println("***Welcome to Toy Store Company!***");
		System.out.println("***********************************");
		System.out.println(" ");
		System.out.println("How May We Help You?");
		System.out.println(" ");
		System.out.println("\t (1) Search Inventory and Purchase Toy");
		System.out.println("\t (2) Add New Toy");
		System.out.println("\t (3) Remove Toy");
		System.out.println("\t (4) Save and Exit");
		System.out.println(" ");
		int selection = getInt(4);
		switch (selection) {
		case 1:
			searchMenu();
			break;
		case 2:
			addToy();
			break;
		case 3:
			removeToy();
			break;
		case 4:
			super.Save();
			break;
		}

	}


	public void removeToy() throws Exception {
		String SN = promptSN();
		Toy t1 = SNSearch(SN);
		ShowRemoveSN(t1);
		if (t1 != null) {
			System.out.println("Do you want to remove this toy? Y/N");
			char option = in.next().toUpperCase().charAt(0);
			if (option == 'Y') {
				super.RemoveToy(SN);
				System.out.println("Toy Removed");
			}
		}
		startMenu();
	}

	
	public int getInt(int lastOption) {
		boolean validint = false;
		int input = 0;
		while (validint == false) {
			System.out.print("Please enter an option > ");
			if (in.hasNextInt()) {
				input = in.nextInt();
				in.nextLine();
				if (input > lastOption || input <= 0) {
					System.out.println("Please enter a valid option\n");
				} else {
					validint = true;
				}
			} else {
				System.out.println("Please input a valid integer\n");
				in.nextLine();
			}
		}
		return input;
	}

	
	public void addToy() throws Exception {
		String SN = checkSN();
		boolean takenSN = super.repeatSN(SN);
		while (takenSN) {
			System.out.println("That SN already exists, please enter a new Serial Number");
			SN = checkSN();
			takenSN = super.repeatSN(SN);
		}
		String toyType = super.checkType(("" + SN).charAt(0));
		if (toyType == "F") {
			addFigure(SN);
		}
		if (toyType == "A") {
			addAnimal(SN);
		}
		if (toyType == "P") {
			addPuzzle(SN);
		}
		if (toyType == "B") {
			addBoardGame(SN);
		}
		startMenu();
	}

	
	public void searchMenu() throws Exception {
		System.out.println("Find Toys with:");
		System.out.println(" ");
		System.out.println("\t (1) Serial Number ( SN )");
		System.out.println("\t (2) Toy Name");
		System.out.println("\t (3) Type");
		System.out.println("\t (4) Back to Main Menu");
		System.out.println(" ");

		int option = getInt(4);
		switch (option) {
		case 1:
			String SN = promptSN();
			Toy t1 = SNSearch(SN);
			showSN(t1);
			searchMenu();
			break;
		case 2:
			String name = promptName();
			toySearch(name);
			searchMenu();
			break;
		case 3:
			
			String choice = promptType();
			super.typeSearching(choice);
			searchMenu();
			break;
		case 4:
			startMenu();
		}
	}

	

	public String promptSN() {
		System.out.println(" ");
		System.out.print("Enter Serial Number here:");
		String SN = in.nextLine().trim();
		return SN;
	}

	
	public void showSN(Toy tys) throws Exception {
		if (tys != null)
			System.out.print(tys);
		else {
			System.out.println(" ");
			System.out.println("Serial Number not found");
		}
		System.out.println(" ");
		System.out.println("Press Enter to continue");
		in.nextLine();
		searchMenu();
	}

	

	public void ShowRemoveSN(Toy tys) throws Exception {
		if (tys != null)
			System.out.print(tys);
		else {
			System.out.println(" ");
			System.out.println("Serial Number not found");
		}
		System.out.println(" ");
		System.out.println("Press Enter to continue");
		in.nextLine();
	}

	
	private void typeSearch() {

	}

	
	public String checkSN() {
		boolean validlong = false;
		String input = "0";
		System.out.println("Enter Serial Number: ");
		while (validlong == false) {
			if (in.hasNextLong()) {
				input = in.next();
				in.nextLine();
				int length = String.valueOf(input).length();
				if (length != 10) {
					System.out.println("Please enter a 10 digit number\n");
				} else {
					validlong = true;
				}
			} else {
				System.out.println("Please input a number");
				in.nextLine();
			}
		}
		return input;
	}

	
	public void addFigure(String SN) throws NegativeUserInput {
		boolean valid = false;
		String name = addName();
		String brand = addBrand();
		double price = addPrice();
		int count = addCount();
		int age = addAge();
		String type = null;
		while (valid == false) {
			System.out.println("choose a classificaton for this figure\n(A)ction \n(D)oll \n(H)istoric");
			char classification = in.nextLine().toUpperCase().charAt(0);
			if (classification == 'A' || classification == 'D' || classification == 'H') {
				valid = true;
				type = "" + classification;
			} else {
				System.out.println("Please enter a valid classification");
				in.nextLine();
			}

		}
		super.addFigure(SN, name, brand, price, count, age, type);
		System.out.println("New toy added");
		System.out.println(" ");
		System.out.println("Press Enter to Continue");
		in.nextLine();
	}

	
	public void addAnimal(String SN) throws NegativeUserInput {
		boolean valid = false;
		String name = addName();
		String brand = addBrand();
		double price = addPrice();
		int count = addCount();
		int age = addAge();
		System.out.println("What Material is this toy made out of?");
		String material = in.next();
		in.nextLine();
		String type = null;
		while (valid == false) {
			System.out.println("choose a size for the animal \n(S)mall \n(M)edium \n(L)arge");
			char classification = in.nextLine().toUpperCase().charAt(0);
			if (classification == 'S' || classification == 'M' || classification == 'L') {
				valid = true;
				type = "" + classification;
			} else {
				System.out.println("Please enter a valid size");
				in.nextLine();
			}

		}
		super.addAnimal(SN, name, brand, price, count, age, material, type);
		System.out.println("New toy added");
		System.out.println(" ");
		System.out.println("Press Enter to Continue");
		in.nextLine();
	}

	
	public void addPuzzle(String SN) throws NegativeUserInput {
		boolean valid = false;
		String name = addName();
		String brand = addBrand();
		double price = addPrice();
		int count = addCount();
		int age = addAge();
		String type = null;
		while (valid == false) {
			System.out
					.println("What type of puzzle is this? \n(M)echanical \n(C)ryptic \n(L)ogic \n(T)rivia \n(R)iddle");
			char classification = in.nextLine().toUpperCase().charAt(0);
			if (classification == 'C' || classification == 'M' || classification == 'L' || classification == 'T'
					|| classification == 'R') {
				valid = true;
				type = "" + classification;
			} else {
				System.out.println("Please enter a valid puzzle type");
				in.nextLine();
			}
			super.addPuzzle(SN, name, brand, price, count, age, type);
			System.out.println("New toy added");
			System.out.println(" ");
			System.out.println("Press Enter to Continue");
			in.nextLine();
		}
	}

	
	public void addBoardGame(String SN) throws PlayerException, NegativeUserInput {
		String name = addName();
		String brand = addBrand();
		double price = addPrice();
		int count = addCount();
		int age = addAge();
		String players = addPlayers();
		System.out.println("Enter Designer Names(Use ',' to seperate the names if there is more than one name): ");
		String Designers = in.nextLine();
		super.addBoardGame(SN, name, brand, price, count, age, players, Designers);
		System.out.println("New toy added");
		System.out.println(" ");
		System.out.println("Press Enter to Continue");
		in.nextLine();

	}

	
	public String addName() {
		System.out.println("What is this toys name?");
		return in.next();
	}

	
	public String addBrand() {
		System.out.println("What is the brand of this toy?");
		return in.next();
	}

	
	public double addPrice() {
		boolean validinput = false;
		String n1;
		double price = 0;
		while (validinput == false) {
			do {
				in.nextLine();
				System.out.println("What is the price of this toy?");
				n1 = in.nextLine();
				price = Double.parseDouble(n1);
				validinput = true;

			} while (n1 == null);
			try {
				checkPrice(price);
			} catch (NegativeUserInput e) {
				System.out.println(e.getMessage());
				System.out.println(" ");
				System.out.println("Press Enter To Continue...");
				validinput = false;
			}
		}
		return price;
	}

	
	public String addPlayers() throws PlayerException {
		boolean validinput = false;
		String n1;
		String n2;
		int minPlayers = 0;
		int maxPlayers = 0;
		while (validinput == false) {
			do {
				System.out.println("What is the minumum players for this board game?");
				n1 = in.nextLine();
				minPlayers = Integer.parseInt(n1);
			} while (n1 == null);

			do {
				System.out.println("What is the maximum players for this board game?");
				n2 = in.nextLine();
				maxPlayers = Integer.parseInt(n2);
				validinput = true;
			} while (n2 == null);

			try {
				checkPlayers(minPlayers, maxPlayers);
			} catch (PlayerException e) {
				System.out.println(e.getMessage());
				System.out.println(" ");
				validinput = false;
			}
		}

		String playerRange = "" + minPlayers + "-" + maxPlayers;
		return playerRange;
	}

	
	public int addCount() {
		System.out.println("How many are available?");
		return intCheck();
	}

	
	public int addAge() {
		System.out.println("What is the appropriate age for this toy?");
		return intCheck();
	}

	
	public double checkPrice(double price) throws NegativeUserInput {
		if (price < 0) {
			throw new NegativeUserInput();
		}
		return price;
	}

	
	public void checkPlayers(int min, int max) throws PlayerException {
		if (max < min) {
			throw new PlayerException();
		}
	}

	
	public int intCheck() {
		boolean validInt = false;
		int input = 0;
		while (validInt == false) {
			if (in.hasNextInt()) {
				input = in.nextInt();
				in.nextLine();
				validInt = true;
			} else {
				System.out.println("Please input an integer");
				in.nextLine();
			}
		}
		return input;

	}

	
	public String promptName() {
		System.out.println(" ");
		System.out.print("Enter Toy Name here:");
		String SN = in.nextLine().trim();
		return SN;
	}

	
	public void showName(Toy nme) throws Exception {
		if (nme != null)
			System.out.print(nme);
		else {
			System.out.println(" ");
			System.out.println("Toy name not found");
		}
		System.out.println(" ");
		System.out.println("Press Enter to continue >");
		in.nextLine();
		searchMenu();
	}

	
	public String promptType() {
		boolean correctType = false;
		String name = null;
		char choice = 0;
		while (correctType == false) {
			System.out.println(" ");
			System.out.println("What type of toy are you looking for?");
			System.out.println("(A)nimal");
			System.out.println("(B)oard Game");
			System.out.println("(F)igure");
			System.out.println("(P)uzzle");
			System.out.println(" ");
			System.out.println("Enter Toy Type Here:");
			name = in.nextLine().trim();
			choice = name.toUpperCase().charAt(0);
			if (choice == 'A' || choice == 'B' || choice == 'F' || choice == 'P') {
				correctType = true;
			} else {
				System.out.println("Please input a valid type:");
			}
		}
		return name;
	}
}