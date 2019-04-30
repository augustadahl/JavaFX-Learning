package Flags;

import java.util.Scanner;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class main extends Application{

	public void start(Stage primaryStage) throws Exception {
		Group root = new Group();
		Scene scene = new Scene(root,500*1.9,500,Color.SKYBLUE);
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
		
		AnimationTimer at = new AnimationTimer() {
				double size = 100;
				int dirr = 1;
			
			public void handle(long now) {
				root.getChildren().clear();
				USA flagga = new USA(size);
				flagga.setTranslateX(250*1.9 -(size*1.9)/2);
				flagga.setTranslateY(250 - size/2);
				root.getChildren().add(flagga);
				
				//flagga.scaleXProperty()
				
				size += 0.1 * dirr;
				if (size > 500 || size < 100) {
					dirr *= -1;
				}
			}
		};
		
		at.start();
		
	}
	
	public static void main(String[] args) {

		launch();
	}

}
