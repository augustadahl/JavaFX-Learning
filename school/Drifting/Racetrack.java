package Drifting;

import java.util.ArrayList;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;

public class Racetrack extends Application {

	ArrayList<KeyCode> keysPressed = new ArrayList<KeyCode>();

	public void start(Stage primaryStage) throws Exception {
		Group root = new Group();
//		Group background = new Group();
		Scene scene = new Scene(root, 1200, 600, Color.AQUAMARINE);
		primaryStage.setScene(scene);
		primaryStage.show();

//		int tileSize = 100;
//		int pattern = 0; //
//		for (int y = -50; y < 100; y++) {
//			for (int x = -50 + pattern; x < 100; x += 2) {
//				Rectangle tile = new Rectangle();
//				tile.setWidth(tileSize);
//				tile.setHeight(tileSize);
//				tile.setTranslateX(tileSize * x);
//				tile.setTranslateY(tileSize * y);
//				background.getChildren().add(tile);
//			}
//			
//			if (pattern == 0) {
//				pattern++;
//			}else {
//				pattern--;
//			}
//			
//		}
//		
//		root.getChildren().add(background);

		Straight rak = new Straight(500, 200, 45);
		rak.setTranslateX(primaryStage.getWidth() / 2);
		rak.setTranslateY(primaryStage.getHeight());
		root.getChildren().add(rak);

		Circle waypoint = new Circle();
		waypoint.setRadius(50);
		root.getChildren().add(waypoint);
		waypoint.setTranslateX(primaryStage.getWidth() / 2 + rak.getEndpointX());
		waypoint.setTranslateY(primaryStage.getHeight() + rak.getEndpointY());

		DriftCar car = new DriftCar(20);
		root.getChildren().add(car);

		Text position = new Text(5, 15, "filler");
		position.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
		position.setFill(Color.CADETBLUE);
		root.getChildren().add(position);

//		Rotate backgroundRotate = new Rotate();
//		background.getTransforms().add(backgroundRotate);

		AnimationTimer at = new AnimationTimer() {

			public void handle(long now) {

				for (KeyCode key : keysPressed) {

					switch (key) {
					case W:
						car.accelerate();
						break;
					case S:
						car.brake();
						break;
					case A:
						car.rotate(key);
						break;
					case D:
						car.rotate(key);
						break;

					default:
						break;
					}

				}

				car.execute();

				position.setText(car.position());

//				backgroundRotate.setPivotX(-bil.positionX);
//				backgroundRotate.setPivotY(-bil.positionY);
//				backgroundRotate.setAngle(bil.absoluteDirection);
//				background.setTranslateX(-bil.positionX);
//				background.setTranslateY(-bil.positionY);

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