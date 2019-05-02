package Planstorlek;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class planstorlek extends Application{

	public void start(Stage primaryStage) throws Exception {
		Group Startingwindow = new Group();
		Scene Startingscene = new Scene(Startingwindow,300,300,Color.SKYBLUE);
		primaryStage.setScene(Startingscene);
		
		primaryStage.setTitle("Sneek");
		primaryStage.setResizable(false);
		primaryStage.show();
		
		primaryStage.minHeightProperty().bind(primaryStage.widthProperty().multiply(0.5));
		primaryStage.maxHeightProperty().bind(primaryStage.widthProperty().multiply(0.5));
		
		Rectangle back = new Rectangle();
		back.setWidth(100);
		back.setHeight(100);
		back.setFill(Color.GRAY);
		Startingwindow.getChildren().add(back);
		back.widthProperty().bind(primaryStage.widthProperty().multiply(0.25));
		back.heightProperty().bind(primaryStage.widthProperty().multiply(0.125));
		
		double distance = 5;
		
		AnimationTimer timer = new AnimationTimer() {
			
			int dirr = 1;
			@Override
			public void handle(long now) {
				if (back.getTranslateX() > primaryStage.getWidth() * 0.75 || back.getTranslateX() < 0) {
					dirr *= -1;
				}
				
				 back.setTranslateX(back.getTranslateX() + 10 * dirr);
			
				 
				 
			}
		}; 
		
		timer.start();
//		AnimationTimer at = new AnimationTimer() {
//			double WindowWidth = primaryStage.getWidth();
//			double WindowHeight = primaryStage.getHeight();
//			
//			
//			public void handle(long now) {
//				if (WindowWidth != primaryStage.getWidth()) {
//					primaryStage.setHeight(primaryStage.getWidth());
//					WindowWidth = primaryStage.getWidth();
//				}
//				
//				
//				
//			}
//			
//		};
//		
//		primaryStage.setWidth(primaryStage.getHeight());
//		
//		
		
//		Group root2 = new Group();
//		Scene scene2 = new Scene(root2,300,500,Color.SKYBLUE);
//		primaryStage.setScene(scene2);
	}
	
	public static void main(String[] args) {
		launch();
	}

}
