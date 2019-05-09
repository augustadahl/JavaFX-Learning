package Drifting;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcTo;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.shape.FillRule;
import javafx.scene.shape.HLineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.transform.Rotate;

public class Turn extends Group{

	double angle;
	double degrees;
	double centerRadius;
	boolean inverted;
	
	public Turn(boolean inverted, double width, double centerRadius, double degrees, double angle, Color backgroundColor) {
		
		this.angle = angle;	
		this.degrees = degrees;
		this.centerRadius = centerRadius;
		this.inverted = inverted;
		
		double stripewidth = 5;
		
		Arc outer = new Arc();
		outer.setRadiusX(centerRadius+width/2 + stripewidth);
		outer.setRadiusY(centerRadius+width/2 + stripewidth);
		outer.setLength(degrees);
		outer.setType(ArcType.ROUND);
		outer.setFill(Color.WHITE);	
		
		
		Arc asphalt = new Arc();
		asphalt.setRadiusX(centerRadius+width/2);
		asphalt.setRadiusY(centerRadius+width/2);
		asphalt.setLength(degrees);
		asphalt.setType(ArcType.ROUND);
		asphalt.setFill(Color.DIMGRAY);
		
		
		Arc inner = new Arc();
		inner.setRadiusX(centerRadius-width/2);
		inner.setRadiusY(centerRadius-width/2);
		inner.setLength(degrees);
		inner.setType(ArcType.ROUND);
		inner.setFill(Color.WHITE);
		

		Circle background = new Circle();
		background.setRadius(centerRadius-width/2 - stripewidth);
		background.setFill(backgroundColor);
		
		if (inverted) {
			outer.setTranslateX(-centerRadius);
			asphalt.setTranslateX(-centerRadius);
			inner.setTranslateX(-centerRadius);
			background.setTranslateX(-centerRadius);
		} else {
			outer.setTranslateX(centerRadius);
			asphalt.setTranslateX(centerRadius);
			inner.setTranslateX(centerRadius);
			background.setTranslateX(centerRadius);
		}
		
		this.getChildren().addAll(outer, asphalt, inner, background);
		
		
		Rotate rt = new Rotate();
		rt.setAngle(angle);	
		this.getTransforms().add(rt);
	}
	
	public double getEndpointX() {
		if (inverted) {
			return -Math.cos(Math.toRadians(angle + degrees)) * centerRadius;
		} else {
			return Math.cos(Math.toRadians(angle + degrees)) * centerRadius;
		}
		
	}
	
	public double getEndpointY() {
		if (inverted) {
			return -Math.sin(Math.toRadians(angle + degrees)) * centerRadius;
		} else {
			return Math.sin(Math.toRadians(angle + degrees)) * centerRadius;
		}
	}
	
	public double getStartangleToNext() {
		return angle - degrees;
	}
	
	
	
}
