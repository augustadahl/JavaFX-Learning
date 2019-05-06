package javafx;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class circles extends Application{

	public void start(Stage primaryStage) throws Exception {
		Group root = new Group();
		Scene scene = new Scene(root,500,500,Color.BLACK);
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
		
		Circle earth = new Circle();
		earth.setRadius(20);
		earth.setFill(Color.BLUE);
		root.getChildren().add(earth);
		
		AnimationTimer at = new AnimationTimer() {
			
			double X = 0;
			double Y = 0;
			
			double t = 0;
			
			public void handle(long now) {
				
				X = 100 * Math.cos(t);
				Y = 100 * Math.sin(t);
				
				
				earth.setTranslateX(primaryStage.getWidth()/2 - earth.getRadius() + X);
				earth.setTranslateY(primaryStage.getHeight()/2 - earth.getRadius() + Y);
				
				t += 0.5;
				
			}
		};
		
		at.start();
		
		
		
	}
	
	public static void main(String[] args) {
		launch();
	}

}
