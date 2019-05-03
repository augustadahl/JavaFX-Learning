package Flags;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class Nasse extends Group{

	public Nasse(double height, double rotation) {
		
		Rectangle back = new Rectangle();
		back.setHeight(height);
		back.setWidth(height * 2);
		back.setFill(Color.RED);
		back.setTranslateX(-height);
		back.setTranslateY(-height/2);
		this.getChildren().add(back);
		
		double radius = height/2 * 0.8;
		
		Circle center = new Circle();
		center.setRadius(radius);
		center.setFill(Color.WHITE);
		this.getChildren().add(center);
		
		Cross crossVertical = new Cross(radius);
		this.getChildren().add(crossVertical);
		
		Cross crossHorisontal = new Cross(radius);
		crossHorisontal.setRotate(90);
		this.getChildren().add(crossHorisontal);
		
		crossVertical.setRotate(crossVertical.getRotate() + 45);
		crossHorisontal.setRotate(crossHorisontal.getRotate() + 45);
		
	}
	
	public void rotate(double degre) {

	}
	
	
	
	
	
	
	
	
}
