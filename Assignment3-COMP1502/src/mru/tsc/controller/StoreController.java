package mru.tsc.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import mru.tsc.model.Animal;
import mru.tsc.model.BoardGame;
import mru.tsc.model.Figure;
import mru.tsc.model.Puzzle;
import mru.tsc.model.Toy;
import mru.tsc.view.Controller;
/**
 * StoreController class
 * @author ardausuk and Rajan Bhullar
 *
 */

public class StoreController {
	StoreController CONT;
	

/**
 * Store controller controls the GUI store
 * @throws Exception is thrown
 */
	public StoreController() throws Exception {
		loadData();
	}
	private final String FILE_PATH = "res/toys.txt"; 
	Scanner input = new Scanner(System.in); 
	ArrayList<Toy> toys = new ArrayList<>(); 

	/**
	 * loads data from file
	 * @throws Exception throws exception
	 */
	public void loadData() throws Exception {
		File db = new File(FILE_PATH);
		String currentLine;
		String[] splittedLine;

		// This reads the files
		if (db.exists()) {
			Scanner fileReader = new Scanner(db);

			while (fileReader.hasNextLine()) {

				currentLine = fileReader.nextLine();
				splittedLine = currentLine.split(";");
				char SN = splittedLine[0].charAt(0);

				
				if (checkType(SN) == "F") {
					Toy F = new Figure(splittedLine[0], splittedLine[1], splittedLine[2],
							Double.parseDouble(splittedLine[3]), Integer.parseInt(splittedLine[4]),
							Integer.parseInt(splittedLine[5]), splittedLine[6]);
					toys.add(F);

				}
				if (checkType(SN) == "A") {
					Toy A = new Animal(splittedLine[0], splittedLine[1], splittedLine[2],
							Double.parseDouble(splittedLine[3]), Integer.parseInt(splittedLine[4]),
							Integer.parseInt(splittedLine[5]), splittedLine[6], splittedLine[7]);
					toys.add(A);
				}
				if (checkType(SN) == "P") {
					Toy P = new Puzzle(splittedLine[0], splittedLine[1], splittedLine[2],
							Double.parseDouble(splittedLine[3]), Integer.parseInt(splittedLine[4]),
							Integer.parseInt(splittedLine[5]), splittedLine[6]);
					toys.add(P);
				}
				if (checkType(SN) == "B") {
					Toy B = new BoardGame(splittedLine[0], splittedLine[1], splittedLine[2],
							Double.parseDouble(splittedLine[3]), Integer.parseInt(splittedLine[4]),
							Integer.parseInt(splittedLine[5]), splittedLine[6], splittedLine[7]);
					toys.add(B);

				}
			}

			fileReader.close();
		}
	}

	/**
	 * Checks type with serial number
	 * @param SN serial number
	 * @return returns the type looking for
	 */
	public String checkType(char SN) {
		String Type = null;
		switch (SN) {
		case '1':
		case '0':
			Type = "F";
			break;
		case '2':
		case '3':
			Type = "A";
			break;
		case '4':
		case '5':
		case '6':
			Type = "P";
			break;
		case '7':
		case '8':
		case '9':
			Type = "B";
			break;
		}
		return Type;
	}

/**
 * Checks repeating serial number
 * @param SN serial number
 * @return the repeating serial number
 * @throws Exception throws the exception
 */
	public boolean repeatSN(String SN) throws Exception {
		boolean repeatSN = false;
		String StoredSN = "0";
		int i = 0;
		while (i < toys.size()) {
			StoredSN = toys.get(i).getSN();
			if (StoredSN.equals(SN)) {
				repeatSN = true;
			}
			i++;
		}
		return repeatSN;

	}

/**
 * Serial number search for toy
 * @param SN serial number
 * @return toy searched 
 */
	public Toy SNSearch(String SN) {
		Toy toy = null;
		for (Toy t : toys) {
			if (t.getSN().equals(SN)) {
				toy = t;
				break;
			}
		}
		return toy;
	}

/**
 * Removes toy
 * @param SN serial number
 */
	public void RemoveToy(String SN) {
		int i = 0;
		while (i < toys.size()) {
			String StoredSN = toys.get(i).getSN();
			if (StoredSN.equals(SN)) {
				toys.remove(i);
			}
			i++;
		}
	}

	/**
	 * Adding the figure
	 * @param sN serial number
	 * @param name of the figure
	 * @param brand of the figure
	 * @param price of the figure
	 * @param count number of figures
	 * @param age of use for figure
	 * @param type of figure
	 */
	public void addFigure(String sN, String name, String brand, double price, int count, int age, String type) {
		Toy F = new Figure(sN, name, brand, price, count, age, type);
		toys.add(F);
	}

/**
 * Adding the animal
 * @param sN serial number
 * @param name of the animal
 * @param brand brand of the animal
 * @param price of the animal
 * @param count number of animals
 * @param age of use for animals
 * @param material of the animals
 * @param Size of the animal
 */
	public void addAnimal(String sN, String name, String brand, double price, int count, int age, String material,
			String Size) {
		Toy A = new Animal(sN, name, brand, price, count, age, material, Size);
		toys.add(A);
	}

/**
 * Adding the puzzle
 * @param SN serial number
 * @param name of the puzzle
 * @param brand of the puzzle
 * @param price of the puzzle
 * @param count of number of the puzzle
 * @param age of use for puzzle
 * @param type of puzzle
 */
	public void addPuzzle(String SN, String name, String brand, double price, int count, int age, String type) {
		Toy P = new Puzzle(SN, name, brand, price, count, age, type);
		toys.add(P);
	}

	/**
	 * adding the board game
	 * @param sN serial number
	 * @param name of the board game
	 * @param brand of the board game
	 * @param price of the board game
	 * @param count number of board games
	 * @param age of use for board games
	 * @param players number of players for game
	 * @param designers who designed the board game
	 */
	public void addBoardGame(String sN, String name, String brand, double price, int count, int age, String players,
			String designers) {
		Toy B = new BoardGame(sN, name, brand, price, count, age, players, designers);
		toys.add(B);
	}

	/**
	 * Saves IO
	 * @throws IOException throws input output exception
	 */
	public void Save() throws IOException {
		File db = new File(FILE_PATH);
		PrintWriter pw = new PrintWriter(db);
		int i = 0;
		while (i < toys.size()) {
			if (toys.get(i) instanceof Animal) {
				Animal A = (Animal) toys.get(i);
				pw.println(A.format());
			}
			if (toys.get(i) instanceof BoardGame) {
				BoardGame B = (BoardGame) toys.get(i);
				pw.println(B.format());
			}
			if (toys.get(i) instanceof Figure) {
				Figure F = (Figure) toys.get(i);
				pw.println(F.format());
			}
			if (toys.get(i) instanceof Puzzle) {
				Puzzle P = (Puzzle) toys.get(i);
				pw.println(P.format());
			}
			i++;
		}

		pw.close();
	}
	/**
	 * Searching for type
	 * @param choice user choice
	 * @return output searched
	 */
	public String typeSearching(String choice) {
		String output = "Matches Found:";
		int i;
		char type = choice.toUpperCase().charAt(0);
		if (type == 'A') {
			i = 0;
			while (i < toys.size()) {
				if (toys.get(i) instanceof Animal) {
					Animal A = (Animal) toys.get(i);
					output = output + "\n" + A.toString();
				}
				i++;
			}
		}
		if (type == 'B') {
			i = 0;
			while (i < toys.size()) {
				if (toys.get(i) instanceof BoardGame) {
					BoardGame B = (BoardGame) toys.get(i);
					output = output + "\n" + B.toString();
				}
				i++;
			}
		}
		if (type == 'F') {
			i = 0;
			while (i < toys.size()) {

				if (toys.get(i) instanceof Figure) {
					Figure F = (Figure) toys.get(i);
					output = output + "\n" + F.toString();
				}
				i++;
			}
		}
		if (type == 'P') {
			i = 0;
			while (i < toys.size()) {

				if (toys.get(i) instanceof Puzzle) {
					Puzzle P = (Puzzle) toys.get(i);
					output = output + "\n" + P.toString();
				}
				i++;
			}
		}
		if (type != 'P' && type != 'F' && type != 'B' && type != 'A') {
			output = "Please Enter a Valid Toy Type, the valid types are\n(A)nimal\n(B)oard Game\n(F)igure\n(P)uzzle";
		}
		return output;
	}
/**
 * Test
 * @return hello test
 */
	public String test() {
		return "hello";
	}
	/**
	 * toy search
	 * @param name of toy
	 * @return output of the search
	 */
	public String toySearch(String name) {
		Toy toy = null;
		String output = "Matches Found";
		for (Toy t1 : toys) {
			if ((t1.getName().toUpperCase()).contains(name.toUpperCase())) {
				toy = t1;
				output = output + "\n" + toy.toString();
				
			}
		}
		return output;
	}

}
