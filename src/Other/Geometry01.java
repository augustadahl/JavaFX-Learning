package Other;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Geometry01 extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		Group group = new Group();

		Scene scene = new Scene(group, 800, 500, Color.WHITE);

		primaryStage.setTitle("Button");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		Rectangle playbutton = new Rectangle(200, 100);
		playbutton.setFill(Color.RED);
		playbutton.setX(300);
		playbutton.setY(200);
		
		group.getChildren().add(playbutton);
		
		playbutton.setOnMouseClicked(e -> {
			AlertBox.display("hasse", "hasse");
		});
		
		
	}

	public static void main(String[] args) {
		launch(args);
	}
	
}
