package Drifting;

import java.util.ArrayList;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;

public class Racetrack extends Application {

	ArrayList<KeyCode> keysPressed = new ArrayList<KeyCode>();

	public void start(Stage primaryStage) throws Exception {
		Group root = new Group();
		Scene scene = new Scene(root, 1200, 600, Color.DIMGREY);
		primaryStage.setScene(scene);
		primaryStage.show();

		DriftCar bil = new DriftCar(40);
		root.getChildren().add(bil);
		
		Text position = new Text(5, 15, "filler");
		root.getChildren().add(position);

		AnimationTimer at = new AnimationTimer() {
			
			
			public void handle(long now) {

				for (KeyCode key : keysPressed) {

					switch (key) {
					case W:
						bil.accelerate();
						break;
					case S:
						bil.brake();
						break;
					case A:
						bil.rotate(key);
						break;
					case D:
						bil.rotate(key);
						break;
						

					default:
						break;
					}

				}
				
				bil.execute();
				
				position.setText(bil.position());

			}
		};

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

		at.start();

	}

	public static void main(String[] args) {
		launch();
	}

}