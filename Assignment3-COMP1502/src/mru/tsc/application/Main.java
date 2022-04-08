package mru.tsc.application;

import javafx.application.Application;
import javafx.stage.Stage;
import mru.tsc.controller.StoreController;
import mru.tsc.view.myScene;

/**
 * This is the main class where it runs the gui and controller of toy.
 * @author Rajan and Arda
 *
 */
public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		StoreController s = new StoreController();
		myScene scene = new myScene(primaryStage, s);

	}

	public static void main(String[] args) {
		launch(args);
	}
}
