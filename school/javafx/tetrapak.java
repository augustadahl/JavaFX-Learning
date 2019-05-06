package javafx;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

public class tetrapak extends Application{

	public void start(Stage primaryStage) throws Exception {
		Group root = new Group();
		Scene scene = new Scene(root,500,500,Color.SKYBLUE);
		primaryStage.setScene(scene);
		primaryStage.show();
		
		Polygon triangle = new Polygon(100,200-(Math.sqrt(3)*100),0,200,200,200);
		root.getChildren().add(triangle);
		
	}
	
	public static void main(String[] args) {
		launch();
	}

}
