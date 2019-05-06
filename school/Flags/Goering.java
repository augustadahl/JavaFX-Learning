package Flags;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Goering extends Application{

	public void start(Stage primaryStage) throws Exception {
		Group root = new Group();
		Scene scene = new Scene(root,800,600,Color.SKYBLUE);
		primaryStage.setScene(scene);
		primaryStage.show();
		
		Nasse flag = new Nasse(300, 1);
		flag.setTranslateX(primaryStage.getWidth()/2);
		flag.setTranslateY(primaryStage.getHeight()/2);
		root.getChildren().add(flag);
		
		
		
		
	}
	
	public static void main(String[] args) {
		launch();
	}

}