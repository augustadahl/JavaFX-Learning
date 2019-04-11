package javafx;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class Car extends Group{

	public Car(Color color) {
		
		Rectangle top = new Rectangle();
		top.setWidth(50);
		top.setHeight(25);
		top.setTranslateX(25);
		
		Rectangle body = new Rectangle();
		body.setWidth(100);
		body.setHeight(25);
		body.setTranslateY(25);
		
		Circle tireLeft = new Circle();
		tireLeft.setRadius(12.5);
		tireLeft.setTranslateX(20);
		tireLeft.setTranslateY(50);
		
		Circle tireRight = new Circle();
		tireRight.setRadius(12.5);
		tireRight.setTranslateX(80);
		tireRight.setTranslateY(50);
		
		body.setFill(color);
		top.setFill(color);
		
		this.getChildren().addAll(top,body,tireLeft,tireRight);
		
	}
	
}
