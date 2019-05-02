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
		Scene scene = new Scene(root,500,500,Color.SKYBLUE);
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
		
		Circle circle = new Circle();
		circle.setRadius(20);
		root.getChildren().add(circle);
		
		AnimationTimer at = new AnimationTimer() {
			
			double X = 100;
			double Y = 0;
			
			int dirrX = 1;
			int dirrY = 1;
			
			public void handle(long now) {
				
				circle.setTranslateX(primaryStage.getWidth()/2 - circle.getRadius() + X);
				circle.setTranslateY(primaryStage.getHeight()/2 - circle.getRadius() + Y);
				
				X += 1 * dirrX;
				Y += 1 * dirrY;
				
				if (X > -100 || X < 100) {
					dirrX *= -1;
				}
				
				if (Y > -100 || Y < 100) {
					dirrY *= -1;
				}
				
			}
		};
		
		at.start();
		
		
		
	}
	
	public static void main(String[] args) {
		launch();
	}

}
