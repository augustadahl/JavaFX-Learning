package Drifting;

import javafx.scene.Group;
import javafx.scene.chart.Axis;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;


public class Speedometer extends Group{

	Arc edgetop = new Arc();
	Rectangle edgeBottom = new Rectangle();
	Arc background = new Arc();
	Rotate rot = new Rotate();
	Rectangle needle = new Rectangle();
	int maxRPM = 6;
	
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
		
		this.getChildren().addAll(edgetop, edgeBottom, background, needle);

		for (int i = 0; i < maxRPM+1; i++) {
			Text number = new Text(Integer.toString(i));
			number.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
			number.setTranslateX(number.getTranslateX() - number.getBoundsInLocal().getWidth() / 2);
			number.setTranslateY(number.getTranslateY() + number.getBoundsInLocal().getHeight() / 4);
			number.setTranslateX(number.getTranslateX() + width* 0.78 * Math.sin(Math.toRadians(270 - (i+0.5) * (180/(maxRPM+1)))));
			number.setTranslateY(number.getTranslateY() + width* 0.78 * Math.cos(Math.toRadians(270 - (i+0.5) * (180/(maxRPM+1)))));
			
			this.getChildren().add(number);
		}
		
		
//		edge.setType(ArcType.ROUND);
		
		
		
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
