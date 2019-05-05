package Drifting;

import javafx.scene.Group;
import javafx.scene.chart.Axis;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;


public class Speedometer extends Group{

	Arc edgetop = new Arc();
	Rectangle edgeBottom = new Rectangle();
	Arc background = new Arc();
	Rotate rot = new Rotate();
	Rectangle needle = new Rectangle();
	
	public Speedometer(double width) {
		
		edgetop.setRadiusX(width);
		edgetop.setRadiusY(width);
		edgetop.setStartAngle(-1);
		edgetop.setLength(182);
		edgetop.setFill(Color.RED);
		
		edgeBottom.setWidth(width*2);
		edgeBottom.setHeight(width * 0.1);
		edgeBottom.setTranslateX(-width);
		edgeBottom.setFill(Color.RED);
		
		background.setRadiusX(width * 0.9);
		background.setRadiusY(width * 0.9);
		background.setLength(180);
		background.setFill(Color.WHITE);
		
		needle.setWidth(width * 0.025);
		needle.setHeight(width * 0.9);
		needle.setTranslateX(-needle.getWidth()/2);
		needle.setTranslateY(-needle.getWidth()/2);
		
		
		
		
		rot.setPivotX(needle.getWidth()/2);
		rot.setPivotY(0);
		rot.setAngle(90);
		
		needle.getTransforms().add(rot);
		
		
		
//		edge.setType(ArcType.ROUND);
		
		this.getChildren().addAll(edgetop, edgeBottom, background, needle);
		
	}
	
	public void RotLeft() {
		if (rot.getAngle() > 90) {
			rot.setAngle(rot.getAngle() - 6);
		} else {
			rot.setAngle(90);
		}
		
	}
	
	public void RotRight() {
		if (rot.getAngle() < 270) {
			rot.setAngle(rot.getAngle() + 6);
		} else {
			rot.setAngle(270);
		}
	}
	
}
