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
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;

public class backtobasics extends Application {

	ArrayList<KeyCode> keysPressed = new ArrayList<KeyCode>();

	public void start(Stage primaryStage) throws Exception {
		Group root = new Group();
		Group background = new Group();
		Scene scene = new Scene(root, 1200, 600, Color.WHITE);
		primaryStage.setScene(scene);
		primaryStage.show();

		int tileSize = 100;

		for (int y = 0; y < 100; y++) {
			for (int x = 0; x < 100; x++) {
				Rectangle tile = new Rectangle();
				tile.setWidth(tileSize);
				tile.setHeight(tileSize);
				tile.setTranslateX(tileSize * x * 4);
				tile.setTranslateY(tileSize * y * 4);
				background.getChildren().add(tile);
			}
		}
		
		root.getChildren().add(background);
		
		Circle center = new Circle();
		center.setRadius(40);
		center.setFill(Color.BLUE);
		root.getChildren().add(center);
		

		Rotate rotate = new Rotate();
		background.getTransforms().add(rotate);
		
		
		AnimationTimer at = new AnimationTimer() {
			
			double origoX = primaryStage.getWidth()/2;
			double origoY = primaryStage.getHeight()/2;
			
//			double oldposX = 0;
//			double oldposY = 0;
			
			public void handle(long now) {

				center.setTranslateX(primaryStage.getWidth()/2);
				center.setTranslateY(primaryStage.getHeight()/1.5);
				
				background.setTranslateX(background.getTranslateX() - origoX + primaryStage.getWidth()/2);
				background.setTranslateY(background.getTranslateY() - origoY + primaryStage.getHeight()/2);
				
				rotate.setPivotX(center.getTranslateX() - background.getTranslateX());
				rotate.setPivotY(center.getTranslateY() - background.getTranslateY());
				
				for (KeyCode key : keysPressed) {

					switch (key) {
					case A:
						rotate.setAngle(rotate.getAngle()+3);
						break;
					case D:
						rotate.setAngle(rotate.getAngle()-3);
						break;
					case W:
						background.setTranslateX(background.getTranslateX() + Math.sin(Math.toRadians(rotate.getAngle())) * 20);
						background.setTranslateY(background.getTranslateY() + Math.cos(Math.toRadians(rotate.getAngle())) * 20);
						break;
					case S:
						background.setTranslateX(background.getTranslateX() - Math.sin(Math.toRadians(rotate.getAngle())) * 20);
						background.setTranslateY(background.getTranslateY() - Math.cos(Math.toRadians(rotate.getAngle())) * 20);
						break;
					
						

					default:
						break;
					}

				}
				
//				if (oldposX - background.getTranslateX() > 20 || background.getTranslateX() - oldposX > 20) {
//					System.out.println("X: " + background.getTranslateX());
//				}
//				if (oldposY - background.getTranslateY() > 20 || background.getTranslateY() - oldposY > 20) {
//					System.out.println("Y: " + background.getTranslateY());
//				}
//				
//				oldposX = background.getTranslateX();
//				oldposY = background.getTranslateY();
				
//				System.out.println("X: " + background.getTranslateX() + " Y: " + background.getTranslateY());

				
				origoX = primaryStage.getWidth()/2;
				origoY = primaryStage.getHeight()/2;
				
			
				

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