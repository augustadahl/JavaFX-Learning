package Text_experiments;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class tile_main extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {

		// något grafiskt
		Group root = new Group();

		// fyller fönstret med något grafiskt storlek och bakgrundsfärg (ej
		// obligatoriskt)
		Scene scene = new Scene(root, 500, 500, Color.SKYBLUE);

		// primarystage är variabeln för vårt fönster
		// sätter scenen till fönstret
		primaryStage.setScene(scene);

		// visar fönstret
		primaryStage.show();

		Background back = new Background(4);
		root.getChildren().add(back);
		
		tile_experimental tile = new tile_experimental();
		root.getChildren().add(tile);
		tile.setTranslateX(110);
		tile.setTranslateY(110);

		scene.setOnKeyPressed(e -> {

			KeyCode key = e.getCode();

			switch (key) {
			case LEFT:
				tile.move(key);
				break;
			case RIGHT:
				tile.move(key);
				break;
			case UP:
				tile.move(key);
				break;
			case DOWN:
				tile.move(key);
				break;
			case SPACE:
				tile.increase();
				break;
			default:
				break;
			}

		});

	}

	public static void main(String[] args) {
		// kallar på stage
		launch();
	}

}
