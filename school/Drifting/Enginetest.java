package Drifting;

import java.util.ArrayList;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Enginetest extends Application {

	ArrayList<KeyCode> keysPressed = new ArrayList<KeyCode>();

	public void start(Stage primaryStage) throws Exception {
		Group root = new Group();
		Scene scene = new Scene(root, 1200, 600, Color.DIMGREY);
		primaryStage.setScene(scene);
		primaryStage.show();

		Speedometer speedometer = new Speedometer(100);
		speedometer.setTranslateX(primaryStage.getWidth() / 2);
		speedometer.setTranslateY(primaryStage.getHeight() / 2);
		root.getChildren().add(speedometer);

		Text position = new Text(5, 15, "filler");
		root.getChildren().add(position);

		AnimationTimer at = new AnimationTimer() {

			public void handle(long now) {

				for (KeyCode key : keysPressed) {

					switch (key) {
					case RIGHT:
						speedometer.RotRight();
						break;
					case LEFT:
						speedometer.RotLeft();
						break;
					default:
						break;
					}

				}

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