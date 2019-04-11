package javafx;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class former extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		//n�got grafiskt
		Group root = new Group();
		
		//fyller f�nstret med n�got grafiskt storlek och bakgrundsf�rg (ej obligatoriskt)
		Scene scene = new Scene(root,500,500,Color.SKYBLUE);
		
		//primarystage �r variabeln f�r v�rt f�nster
		//s�tter scenen till f�nstret
		primaryStage.setScene(scene);
		
		//visar f�nstret
		primaryStage.show();
		
		
		//skapar en cirkel
		Circle circle = new Circle();
		circle.setRadius(50);
		
		//positiv y ner�t positiv x h�ger
		circle.setTranslateX(250);
		circle.setTranslateY(250);
		
		//color red
		circle.setFill(Color.RED);
		
		//l�gger till cirkeln till root
		root.getChildren().add(circle);
	
		
		//skapar en rektangel
		Rectangle rectangle = new Rectangle();
		rectangle.setWidth(100);
		rectangle.setHeight(50);
		rectangle.setFill(Color.HOTPINK);
		
		root.getChildren().add(rectangle);
		
		Polygon polygon = new Polygon(0,0,0,100,100,100);
//		
//		polygon.getPoints().add(0.0); //x
//		polygon.getPoints().add(0.0); //y
//		
//		polygon.getPoints().add(0.0);
//		polygon.getPoints().add(100.0);
//		
//		polygon.getPoints().add(100.0);
//		polygon.getPoints().add(100.0);
//		
		root.getChildren().add(polygon);
		
		
		
		
		Star star = new Star(50);
		star.setTranslateX(250);
		star.setTranslateY(250);
		root.getChildren().add(star);
		
		
		Car car = new Car(Color.BLUE);
		root.getChildren().add(car);
		car.setTranslateX(150);
		car.setTranslateY(150);
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		//kallar p� stage
		launch();
	}

}
