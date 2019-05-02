package Flags;

import java.util.ArrayList;
import java.util.Scanner;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class main extends Application{

	ArrayList<KeyCode> keysPressed = new ArrayList<KeyCode>();
	
	public void start(Stage primaryStage) throws Exception {
		Group root = new Group();
		Scene scene = new Scene(root,500*1.9,500,Color.SKYBLUE);
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
		
		AnimationTimer at = new AnimationTimer() {
				double size = 500;
				int dirr = 1;
				double speed = 0;
			
			public void handle(long now) {
				for (KeyCode key : keysPressed) {
					switch (key) {
					case UP:
					case W:
						speed = 0.05;
						break;
					case DOWN:
					case S:
						speed = -0.05;
						break;
					default:
						break;

					}
				}
				
				
				if (size < 0.1) {
					size = 0.1;
					speed = 0;
				}
				if (size > 500) {
					size = 500;
					speed = 0;
				}
				
				root.getChildren().clear();
				USA flagga = new USA(size);
				flagga.setTranslateX(250*1.9 -(size*1.9)/2);
				flagga.setTranslateY(250 - size/2);
				root.getChildren().add(flagga);
				
				//flagga.scaleXProperty()
				
				size += size*speed ;
//				primaryStage.setWidth(size*1.9);
//				primaryStage.setHeight(size);
				if (speed > 0) {
					speed -= 0.001;
				}
				if (speed < 0) {
					speed += 0.001;
				}
			}
		};
		
		at.start();
		
		scene.setOnKeyPressed(e -> {
			KeyCode key = e.getCode();
			if (!keysPressed.contains(key))
				keysPressed.add(key);
		});

		scene.setOnKeyReleased(e -> {
			KeyCode key = e.getCode();
			if (keysPressed.contains(key))
				keysPressed.remove(key);
		});
		
		
		
	}
	
	public static void main(String[] args) {

		launch();
	}

}
