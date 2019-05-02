package main;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class LaunchClass extends Application{

	public void start(Stage primaryStage) throws Exception {
		Group Startingwindow = new Group();
		Scene Startingscene = new Scene(Startingwindow,300,300,Color.SKYBLUE);
		primaryStage.setScene(Startingscene);
		
		primaryStage.setTitle("Sneek");
		primaryStage.show();
		
		
		
		
//		Group root2 = new Group();
//		Scene scene2 = new Scene(root2,300,500,Color.SKYBLUE);
//		primaryStage.setScene(scene2);
	}
	
	public static void main(String[] args) {
		launch();
	}

}
