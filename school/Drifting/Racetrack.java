package Drifting;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

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
	Color backgroundColor = Color.GREEN;
	ArrayList<String> Racetracks = DocReader();
	
	double startRotate = Double.parseDouble(Racetracks.get(1));
	
	
	public void start(Stage primaryStage) throws Exception {
		Racetracks.remove(1);
		Group root = new Group();
		Group background = new Group();
//		Rotate backgroundRotate = new Rotate();
//		background.getTransforms().add(backgroundRotate);
		
		Scene scene = new Scene(root, 1200, 600, backgroundColor);
		primaryStage.setScene(scene);
		primaryStage.show();

		Racetrack_builder track = new Racetrack_builder(Racetracks, backgroundColor);
		background.getChildren().add(track);
		
		root.getChildren().add(background);
		
//		Turn curve = new Turn(false, 200, 150, 70, 90, backgroundColor);
//		curve.setTranslateX(primaryStage.getWidth() / 2);
//		curve.setTranslateY(primaryStage.getHeight() / 2);
//		background.getChildren().add(curve);
//		
//		
//		
//		Straight rak = new Straight(500, 200, curve.getStartangleToNext());
//		rak.setTranslateX(primaryStage.getWidth() / 2 - curve.getEndpointX());
//		rak.setTranslateY(primaryStage.getHeight() / 2 - curve.getEndpointY());
//		background.getChildren().add(rak);
		
		
		DriftCar car = new DriftCar(40);
		car.setRotate(90);
		root.getChildren().add(car);

//		Text position = new Text(5, 15, "filler");
//		position.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
//		position.setFill(Color.CADETBLUE);
//		background.getChildren().add(position);



		AnimationTimer at = new AnimationTimer() {

			double oldposX = primaryStage.getWidth()/2;
			double oldposY = primaryStage.getHeight()/2;
			
			public void handle(long now) {

				car.setTranslateX(primaryStage.getWidth()/2);
				car.setTranslateY(primaryStage.getHeight()/2);
				
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
				if (car.positionX != oldposX || car.positionX != oldposX) {
					background.setTranslateX(primaryStage.getWidth()/2 - car.positionX);
					background.setTranslateY(primaryStage.getHeight()/2 - car.positionY);
				}
				
				
				
//				position.setText(car.position());


				oldposX = primaryStage.getWidth()/2 - car.positionX;
				oldposY = primaryStage.getHeight()/2 - car.positionY;
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

	public static ArrayList<String> DocReader() {
		
		ArrayList<String> tracks = new ArrayList<String>();

		try {
			Scanner file_reader = new Scanner(new File("school/Drifting/Racetracks.txt"));
			while (file_reader.hasNextLine()) {
				tracks.add(file_reader.nextLine());
			}
		} catch (FileNotFoundException e) {
			System.out.println("wong");
			
		}
		
		return tracks;
	}
	
}