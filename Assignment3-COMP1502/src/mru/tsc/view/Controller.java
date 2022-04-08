package mru.tsc.view;

import javafx.fxml.FXML;

import javafx.scene.control.Button;

import javafx.scene.control.ToggleGroup;

import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;

import javafx.scene.control.TextArea;

import javafx.scene.layout.AnchorPane;
import mru.tsc.controller.StoreController;
import mru.tsc.exceptions.NegativeUserInput;
import mru.tsc.exceptions.PlayerException;
import javafx.scene.control.RadioButton;
import mru.tsc.model.Toy;
import javafx.collections.ObservableList;
import javafx.scene.control.ChoiceBox;



public class Controller {
	
	ObservableList<String> CategoryList = FXCollections.observableArrayList("Animal", "Board Game", "Figure", "Puzzle");
	
	@FXML
	private RadioButton radioSN;
	@FXML
	private ToggleGroup RadioButtonSelection;
	@FXML
	private RadioButton rdName;
	@FXML
	private RadioButton rdType;
	@FXML
	private TextField SNField;
	@FXML
	private TextField NameField;
	@FXML
	private TextField TypeField;
	@FXML
	private TextArea Output;
	@FXML
	private Button Search;
	@FXML
	private Button Reset;
	@FXML
	private ChoiceBox <String> Category;
	@FXML
	private TextField AddSNField;
	@FXML
	private TextField AddNameField;
	@FXML
	private TextField AddBrandField;
	@FXML
	private TextField AddPriceField;
	@FXML
	private TextField AddAvaiableField;
	@FXML
	private TextField AddAgeField;
	@FXML
	private Button Save;
	@FXML
	private TextField AddClassificationField;
	@FXML
	private TextField AddPuzzleField;
	@FXML
	private TextField AddMaterialField;
	@FXML
	private TextField AddSizeField;
	@FXML
	private TextField AddDesignersField;
	@FXML
	private TextField MinPlayersField;
	@FXML
	private TextField MaxPlayersField;
	@FXML
	private TextField SerialInput;
	@FXML
	private TextArea OutputSerialNumber;
	@FXML
	private Button RemoveToy;
	
	@FXML
	private TextArea ErrorOutput;
	
	public String SearchType= null;
	
	
	StoreController CONT;

	ArrayList<Toy> toys = new ArrayList<>();

	@FXML
private void initialize() {
		Category.setValue("Figure");
		Category.setItems(CategoryList);
		SNField.setEditable(false);
		NameField.setEditable(false);
		TypeField.setEditable(false);
		Search.setDisable(true);
	}

	public Controller() throws Exception {
		CONT = new StoreController();
	}

	
	public void ChangeSearchType(ActionEvent e) {

		if (radioSN.isSelected()) {
			SearchType = "SN";
			SNField.setEditable(true);
			NameField.setEditable(false);
			TypeField.setEditable(false);
		}

		else if (rdName.isSelected()) {
			SearchType = "Name";
			SNField.setEditable(false);
			NameField.setEditable(true);
			TypeField.setEditable(false);

		} else if (rdType.isSelected()) {
			SearchType = "Type";
			SNField.setEditable(false);
			NameField.setEditable(false);
			TypeField.setEditable(true);

		}

		SNField.setText("");
		NameField.setText("");
		TypeField.setText("");
		Search.setDisable(false);
	}

	
	public void SearchToy(ActionEvent e) throws Exception {

		if (SearchType.equalsIgnoreCase("SN")) {

			if (CONT.repeatSN(SNField.getText()) == true) {
				Toy t = CONT.SNSearch(SNField.getText());
				Output.setText(t.toString());
			} else {
				Output.setText("A toy with that SN could not be located");
			}
		} else if (SearchType.equalsIgnoreCase("Name")) {
			String ToyNames = CONT.toySearch(NameField.getText());
			if (ToyNames.equalsIgnoreCase("Matches Found:")) {
				ToyNames = "A toy of that name could not be located";
			}
			Output.setText(ToyNames);
		} else if (SearchType.equalsIgnoreCase("Type")) {
			if (TypeField.getText().isEmpty()) {
				Output.setText("Please enter either (A)nimal (B)oardGame (F)igure or (P)uzzle");
			} else {
				Output.setText(CONT.typeSearching(TypeField.getText()));
			}
		}
	}

	
	public void Resetfields(ActionEvent e) {
		SNField.setText("");
		NameField.setText("");
		TypeField.setText("");
		Output.setText("");
		RadioButtonSelection.selectToggle(null);
	}


	public void RemoveToy(ActionEvent e) throws Exception {
		if (CONT.repeatSN(SerialInput.getText()) == true) {
			Toy t = CONT.SNSearch(SerialInput.getText());
			OutputSerialNumber.setText(t.toString() + "\n" + "Toy has been successfully removed!");
			CONT.RemoveToy(SerialInput.getText());
			CONT.Save();
		} else {
			OutputSerialNumber.setText("A toy with this Serial Number could not be found");
		}
	}


	public void chooseType(ActionEvent e) {
		if (Category.getValue().equalsIgnoreCase("Figure")) {
			AddMaterialField.setEditable(false);
			AddSizeField.setEditable(false);
			AddPuzzleField.setEditable(false);
			MinPlayersField.setEditable(false);
			MaxPlayersField.setEditable(false);
			AddDesignersField.setEditable(false);
			AddClassificationField.setEditable(true);
		}
		if (Category.getValue().equalsIgnoreCase("Animal")) {
			AddMaterialField.setEditable(true);
			AddSizeField.setEditable(true);
			AddPuzzleField.setEditable(false);
			MinPlayersField.setEditable(false);
			MaxPlayersField.setEditable(false);
			AddDesignersField.setEditable(false);
			AddClassificationField.setEditable(false);
		}
		if (Category.getValue().equalsIgnoreCase("Puzzle")) {
			AddMaterialField.setEditable(false);
			AddSizeField.setEditable(false);
			AddPuzzleField.setEditable(true);
			MinPlayersField.setEditable(false);
			MaxPlayersField.setEditable(false);
			AddDesignersField.setEditable(false);
			AddClassificationField.setEditable(false);
		}
		if (Category.getValue().equalsIgnoreCase("Board Game")) {
			AddMaterialField.setEditable(false);
			AddSizeField.setEditable(false);
			AddPuzzleField.setEditable(false);
			MinPlayersField.setEditable(true);
			MaxPlayersField.setEditable(true);
			AddDesignersField.setEditable(true);
			AddClassificationField.setEditable(false);
		}
		AddToyReset();
	}

	
	public void AddToyReset() {
		AddMaterialField.setText("");
		AddSizeField.setText("");
		AddPuzzleField.setText("");
		MinPlayersField.setText("");
		MaxPlayersField.setText("");
		AddDesignersField.setText("");
		AddClassificationField.setText("");
	}

	public void AddToyErrorCheck(ActionEvent e) throws Exception {
		boolean errorfree = true;
		String errors = "Toy cannot be added:";
		char firstdigit = 'f';
		if (AddNameField.getText().isEmpty()) {
			errors = errors + "\n" + "Please enter a Name";
			errorfree = false;
		}
		if (AddBrandField.getText().isEmpty()) {
			errors = errors + "\n" + "Please enter a Brand";
			errorfree = false;
		}
		if (AddSNField.getText().isEmpty()) {
			errors = errors + "\n" + "Please enter a SN";
			errorfree = false;
		}
		else {
			firstdigit = AddSNField.getText().charAt(0);
			if (CONT.repeatSN(AddSNField.getText()) == true) {
				errors = errors + "\n" + "A toy with that SN already exists";
				errorfree = false;
			}

			try {
				Long.parseLong(AddSNField.getText());
			} catch (NumberFormatException e1) {
				errors = errors + "\n" + "Your SN can only contain numbers";
				errorfree = false;
			}
			if (AddSNField.getText().length() != 10) {
				errors = errors + "\n" + "Your SN must be ten digits long";
				errorfree = false;
			}
		}
	
		if (AddPriceField.getText().isEmpty()) {
			errors = errors + "\n" + "Please enter a Price";
			errorfree = false;
		} else {
			try {
				Double.parseDouble(AddPriceField.getText());
				checkPrice(Double.parseDouble(AddPriceField.getText()));
			} catch (NumberFormatException | NegativeUserInput e1) {
				errors = errors + "\n" + "You must enter a valid price";
				errorfree = false;
			}
		}

		
		if (AddAvaiableField.getText().isEmpty()) {
			errors = errors + "\n" + "Please enter an available amount";
			errorfree = false;
		} else {
			try {
				Integer.parseInt(AddAvaiableField.getText());
				checkPrice(Double.parseDouble(AddAvaiableField.getText()));
			} catch (NumberFormatException | NegativeUserInput e1) {
				errors = errors + "\n" + "You must enter a valid available amount";
				errorfree = false;
			}
		}

		try {
			Integer.parseInt(AddAgeField.getText());
		} catch (NumberFormatException e1) {
			errors = errors + "\n" + "You must enter a valid appropriate age";
			errorfree = false;
		}

		if (Category.getValue().equalsIgnoreCase("Figure")) {
			if (checkFigure(firstdigit).equalsIgnoreCase("")) {

			} else {
				errorfree = false;
				errors = errors + checkFigure(firstdigit);
			}
		}
		
		if (Category.getValue().equalsIgnoreCase("Animal")) {
			if (checkAnimal(firstdigit).equalsIgnoreCase("")) {

			} else {
				errorfree = false;
				errors = errors + checkAnimal(firstdigit);
			}
		}
		
		if (Category.getValue().equalsIgnoreCase("Puzzle")) {
			if (checkPuzzle(firstdigit).equalsIgnoreCase("")) {

			} else {
				errorfree = false;
				errors = errors + checkPuzzle(firstdigit);
			}
		}
		
		if (Category.getValue().equalsIgnoreCase("Board Game")) {
			if (MaxPlayersField.getText().isEmpty() || MinPlayersField.getText().isEmpty()) {
				errors = errors + "\n" + "Please enter a minimum and maximum players";
				errorfree = false;
			} else {
				try {
					checkPlayers(Integer.parseInt(MinPlayersField.getText()),
							Integer.parseInt(MaxPlayersField.getText()));
				} catch (PlayerException | NumberFormatException e1) {
					errors = errors + "\n" + "Your minimum players cannot be more than your maximum players";
					errorfree = false;
				}

			}
			if (checkBoardGame(firstdigit).equalsIgnoreCase("")) {

			} else {
				errorfree = false;
				errors = errors + checkBoardGame(firstdigit);
			}
		}
		if (errorfree == false) {
			ErrorOutput.setText(errors);
		}
		if (errorfree == true) {
			ErrorOutput.setText("Toy Added");
			AddToy();
		}
	}

	
	public void AddToy() throws IOException {
		if (Category.getValue().equalsIgnoreCase("Figure")) {
			CONT.addFigure(AddSNField.getText(), AddNameField.getText(), AddBrandField.getText(),
					Double.parseDouble(AddPriceField.getText()), Integer.parseInt(AddAvaiableField.getText()),
					Integer.parseInt(AddAgeField.getText()), AddClassificationField.getText());
		}
		if (Category.getValue().equalsIgnoreCase("Animal")) {
			CONT.addAnimal(AddSNField.getText(), AddNameField.getText(), AddBrandField.getText(),
					Double.parseDouble(AddPriceField.getText()), Integer.parseInt(AddAvaiableField.getText()),
					Integer.parseInt(AddAgeField.getText()), AddMaterialField.getText(), AddSizeField.getText());
		}
		if (Category.getValue().equalsIgnoreCase("Puzzle")) {
			CONT.addPuzzle(AddSNField.getText(), AddNameField.getText(), AddBrandField.getText(),
					Double.parseDouble(AddPriceField.getText()), Integer.parseInt(AddAvaiableField.getText()),
					Integer.parseInt(AddAgeField.getText()), AddPuzzleField.getText());
		}
		if (Category.getValue().equalsIgnoreCase("Board Game")) {
			CONT.addBoardGame(AddSNField.getText(), AddNameField.getText(), AddBrandField.getText(),
					Double.parseDouble(AddPriceField.getText()), Integer.parseInt(AddAvaiableField.getText()),
					Integer.parseInt(AddAgeField.getText()),
					MinPlayersField.getText() + "-" + MaxPlayersField.getText(), AddDesignersField.getText());
		}
		CONT.Save();
	}

	
	public String checkFigure(char firstdigit) {
		String extraerror = "";
		if (firstdigit != '0' && firstdigit != '1') {
			extraerror = extraerror + "\n" + "The first digit of a Figures SN must be a 0 or a 1";
		}
		if (AddClassificationField.getText().isEmpty()) {
			extraerror = extraerror + "\n" + "Please enter a classification";
		} else {
			char classification = AddClassificationField.getText().toUpperCase().charAt(0);
			if (classification != 'A' && classification != 'D' && classification != 'H') {
				extraerror = extraerror + "\n"
						+ "The classification of a Figure must be either (A)ction (D)oll or (H)istoric";
			}
		}
		return extraerror;
	}

	
	public String checkAnimal(char firstdigit) {
		String extraerror = "";
		if (firstdigit != '2' && firstdigit != '3') {
			extraerror = extraerror + "\n" + "The first digit of a Animals SN must be a 2 or a 3";
		}
		if (AddSizeField.getText().isEmpty()) {
			extraerror = extraerror + "\n" + "Please enter a size";
		} else {
			char classification = AddSizeField.getText().toUpperCase().charAt(0);
			if (classification != 'S' && classification != 'M' && classification != 'L') {
				extraerror = extraerror + "\n" + "The size of a Animal must be either (S)mall (M)edium or (L)arge";
			}
		}
		if (AddMaterialField.getText().isEmpty()) {
			extraerror = extraerror + "\n" + "Please enter a material";
		}
		return extraerror;
	}

	
	public String checkPuzzle(char firstdigit) {
		String extraerror = "";
		if (firstdigit != '4' && firstdigit != '5' && firstdigit != '6') {
			extraerror = extraerror + "\n" + "The first digit of a Puzzles SN must be a 4, 5, or 6";

		}
		if (AddPuzzleField.getText().isEmpty()) {
			extraerror = extraerror + "\n" + "Please enter a Puzzle type";
		} else {
			char classification = AddPuzzleField.getText().toUpperCase().charAt(0);
			if (classification != 'C' && classification != 'M' && classification != 'L' && classification != 'T'
					&& classification != 'R') {
				extraerror = extraerror + "\n"
						+ "The puzzle type must be either (M)echanical (C)ryptic (L)ogic (T)rivia or (R)iddle";
			}
		}
		return extraerror;
	}

	
	public String checkBoardGame(char firstdigit) {
		String extraerror = "";
		if (firstdigit != '7' && firstdigit != '8' && firstdigit != '9') {
			extraerror = extraerror + "\n" + "The first digit of a Puzzles SN must be a 7, 8, or 9";

		}
		if (AddDesignersField.getText().isEmpty()) {
			extraerror = extraerror + "\n" + "Please enter the board games designers";
		}

		return extraerror;
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

}
	