package main;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class main extends Application {
	
	public static int WindowWidth = 450;
	public static int WindowHeight = 450;

	public void start(Stage primaryStage) throws Exception {

		Group root = new Group();
		Scene scene = new Scene(root, WindowWidth, WindowHeight, Color.SKYBLUE);

		primaryStage.setScene(scene);
		primaryStage.show();

		Background back = new Background(4);
		root.getChildren().add(back);

		Tile tile = new Tile();
		root.getChildren().add(tile);
		tile.setTranslateX(10);
		tile.setTranslateY(10);
		
		Tile tile2 = new Tile();
		root.getChildren().add(tile2);
		tile2.setTranslateX(120);
		tile2.setTranslateY(120);

		scene.setOnKeyPressed(e -> {

			KeyCode key = e.getCode();

			switch (key) {
			case LEFT:
				tile2.move(key);
				tile.move(key);
				break;
			case RIGHT:
				tile2.move(key);
				tile.move(key);
				break;
			case UP:
				tile2.move(key);
				tile.move(key);
				break;
			case DOWN:
				tile2.move(key);
				tile.move(key);
				break;
			case SPACE:
				tile2.increase();
				tile.move(key);
				break;
			default:
				break;
			}

		});

	}

	public static void main(String[] args) {
		launch();
	}

}