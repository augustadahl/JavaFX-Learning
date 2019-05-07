package Drifting;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;

public class Straight extends Group{

	double angle;
	double lenght;
	
	public Straight(double lenght, double width, double angle) {
		
		this.angle = angle;
		this.lenght = lenght;
		
		double stripewith = 5;
		
		Rectangle asphalt = new Rectangle();
		asphalt.setHeight(lenght);
		asphalt.setWidth(width);
		asphalt.setTranslateX(-width/2);
		asphalt.setTranslateY(-lenght);
		asphalt.setFill(Color.DIMGRAY);
		
		Rectangle left = new Rectangle();
		left.setHeight(lenght);
		left.setWidth(stripewith);
		left.setTranslateX(-width/2 - stripewith);
		left.setTranslateY(-lenght);
		left.setFill(Color.WHITE);
		
		Rectangle right = new Rectangle();
		right.setHeight(lenght);
		right.setWidth(stripewith);
		right.setTranslateX(width/2);
		right.setTranslateY(-lenght);
		right.setFill(Color.WHITE);
		
		this.getChildren().addAll(asphalt, left, right);
		
		Rotate rotate = new Rotate();
		this.getTransforms().add(rotate);
		rotate.setAngle(angle);
		
		
	}
	
	public double getEndpointX() {
		return Math.sin(Math.toRadians(angle + 90)) * lenght;
	}
	
	public double getEndpointY() {
		return Math.cos(Math.toRadians(angle + 90)) * lenght;
	}
	
	public double getStartangleToNext() {
		return angle;
	}
}
