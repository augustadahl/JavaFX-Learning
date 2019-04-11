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

		// n�got grafiskt
		Group root = new Group();

		// fyller f�nstret med n�got grafiskt storlek och bakgrundsf�rg (ej
		// obligatoriskt)
		Scene scene = new Scene(root, 500, 500, Color.SKYBLUE);

		// primarystage �r variabeln f�r v�rt f�nster
		// s�tter scenen till f�nstret
		primaryStage.setScene(scene);

		// visar f�nstret
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
		// kallar p� stage
		launch();
	}

}
