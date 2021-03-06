package Text_experiments;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class tile_main extends Application {

	public void start(Stage primaryStage) throws Exception {

		Group root = new Group();

		Scene scene = new Scene(root, 500, 500, Color.SKYBLUE);

		primaryStage.setScene(scene);

		primaryStage.show();

		Background back = new Background(4);
		root.getChildren().add(back);

		tile_experimental tile = new tile_experimental();
		root.getChildren().add(tile);
		tile.setTranslateX(10);
		tile.setTranslateY(10);
		
		tile_experimental tile2 = new tile_experimental();
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
