package Package;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Runner extends Application{

	
	public void start(Stage primaryStage) throws Exception {
		Group root = new Group();
		Scene scene = new Scene(root,1000,600,Color.SKYBLUE);
		primaryStage.setScene(scene);
		primaryStage.show();
		
		Gamebuilder.FileReader();
		
		
	}

	
	public static void main(String[] args) {
		launch(args);
	}
	
	
}
