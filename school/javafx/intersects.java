package javafx;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class intersects extends Application{

	public void start(Stage primaryStage) throws Exception {
		Group root = new Group();
		Scene scene = new Scene(root,500,500,Color.SKYBLUE);
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
		Rectangle block = new Rectangle();
		block.setHeight(50);
		block.setWidth(80);
		block.setTranslateX(100);
		block.setTranslateY(150);
		root.getChildren().add(block);
		
		Circle boll = new Circle();
		boll.setRadius(20);
		boll.setFill(Color.AQUA);
		root.getChildren().add(boll);
		
		scene.setOnKeyPressed(e -> {
			KeyCode key = e.getCode();
			
			if (key == KeyCode.DOWN) {
				boll.setTranslateY(boll.getTranslateY() + 10);
			}
			
			if (key == KeyCode.UP) {
				boll.setTranslateY(boll.getTranslateY() - 10);
			}
			
			if (key == KeyCode.LEFT) {
				boll.setTranslateX(boll.getTranslateX() - 10);
			}
			
			if (key == KeyCode.RIGHT) {
				boll.setTranslateX(boll.getTranslateX() + 10);
			}
			
			if (boll.getBoundsInParent().intersects(block.getBoundsInParent())) {
				System.out.println("intersect");
			}
			
			
			
		});
		
		
		
		
		
		
	}
	
	public static void main(String[] args) {
		launch();
	}

}