package main;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class main extends Application {

	public static int WindowWidth = 450;
	public static int WindowHeight = 450;
	boolean FullBoard = false;

	public void start(Stage primaryStage) throws Exception {

		Group root = new Group();
		Scene scene = new Scene(root, WindowWidth, WindowHeight, Color.SKYBLUE);

		primaryStage.setScene(scene);
		primaryStage.show();

		Background back = new Background(4);
		root.getChildren().add(back);

		GameController gc = new GameController();

		Tile[][] grid = new Tile[4][4];

		gc.spawn(grid);

		gc.spawn(grid);

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] != null) {
					grid[i][j].setTranslateX(10 + (j * 110));
					grid[i][j].setTranslateY(10 + (i * 110));
					root.getChildren().add(grid[i][j]);
				}
			}
		}

		scene.setOnKeyPressed(e -> {

			if (!FullBoard) {

				KeyCode key = e.getCode();

				if (key == KeyCode.LEFT || key == KeyCode.RIGHT || key == KeyCode.UP || key == KeyCode.DOWN) {
					for (int i = 0; i < grid.length; i++) {
						for (int j = 0; j < grid[i].length; j++) {
							if (grid[i][j] != null) {
								root.getChildren().remove(grid[i][j]);
							}
						}
					}

					Tile[][] comparer = gc.copy(grid);

					gc.move(grid, key);

					if (gc.compare(grid, comparer)) {
						gc.spawn(grid);
					}

					for (int i = 0; i < grid.length; i++) {
						for (int j = 0; j < grid[i].length; j++) {
							if (grid[i][j] != null) {
								grid[i][j].setTranslateX(10 + (j * 110));
								grid[i][j].setTranslateY(10 + (i * 110));
								root.getChildren().add(grid[i][j]);
							}
						}
					}
				}

				Tile[][] testerOrigin = gc.copy(grid);

				Tile[][] testerMoving = gc.copy(grid);

				gc.move(testerMoving, KeyCode.LEFT);
				if (!gc.compare(testerMoving, testerOrigin)) {
					gc.move(testerMoving, KeyCode.RIGHT);
					if (!gc.compare(testerMoving, testerOrigin)) {
						gc.move(testerMoving, KeyCode.UP);
						if (!gc.compare(testerMoving, testerOrigin)) {
							gc.move(testerMoving, KeyCode.DOWN);
							if (!gc.compare(testerMoving, testerOrigin)) {
								System.out.println("impossiburu");
								FullBoard = true;
								Rectangle front = new Rectangle();
								front.setWidth(110 * 4 + 10);
								front.setHeight(110 * 4 + 10);
								front.setFill(Color.rgb(0, 0, 0, 0.5));
								root.getChildren().add(front);
								
								Text lose = new Text(225, 225, "Game Over");
								lose.setFont(Font.font("Verdana", FontWeight.BOLD, 55));

								lose.setTranslateX(-lose.getBoundsInLocal().getWidth() / 2);
								lose.setTranslateY(lose.getBoundsInLocal().getHeight() / 4);
								root.getChildren().add(lose);
								
							}
						}
					}
				}
			}
		});
	}

	public static void main(String[] args) {
		launch();
	}

}