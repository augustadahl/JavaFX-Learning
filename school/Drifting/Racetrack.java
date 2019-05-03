package Drifting;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Racetrack extends Application{

	public void start(Stage primaryStage) throws Exception {
		Group root = new Group();
		Scene scene = new Scene(root,800,600,Color.SKYBLUE);
		primaryStage.setScene(scene);
		primaryStage.show();
		
		DriftCar bil = new DriftCar(1.0);
		root.getChildren().add(bil);
		
		
		
		
		Rectangle hej = new Rectangle();
		hej.setHeight(500);
		hej.setWidth(bil.getScaleX());
		root.getChildren().add(hej);
	}
	
	public static void main(String[] args) {
		launch();
	}

}