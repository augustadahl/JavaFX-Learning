package Drifting;

import java.util.ArrayList;

import javafx.scene.Group;
import javafx.scene.paint.Color;


public class Racetrack_builder extends Group{

	double trackWidth; 
	double StartX = 0;
	double StartY = 0;
	double StartAngle = 0;
	
	public Racetrack_builder(ArrayList<String> Racetracks, Color backgroundColor) {
		
		trackWidth = Double.parseDouble(Racetracks.get(0));
		
		for (int currentEntity = 0; currentEntity < Racetracks.size(); currentEntity++) {
			String[] Entity = Racetracks.get(currentEntity).split(" ");			
			if (Entity[0].charAt(0) == 'S') {
				Straight straight = new Straight(Double.parseDouble(Entity[1]), trackWidth, StartAngle);
				straight.setTranslateX(StartX);
				straight.setTranslateY(StartY);
				this.getChildren().add(straight);
				
				StartX += straight.getEndpointX();
				StartY += straight.getEndpointY();
			}
			
			
			if (Entity[0].charAt(0) == 'T') {
				boolean invert = false;
				if (Entity[1].charAt(0) == 'R') {
					invert = true;
				}
				Turn curve = new Turn(invert, trackWidth, Double.parseDouble(Entity[2]), Double.parseDouble(Entity[3]), StartAngle, backgroundColor);
				curve.setTranslateX(StartX);
				curve.setTranslateY(StartY);
				this.getChildren().add(curve);
				
				StartAngle = curve.getStartangleToNext();
				StartX += curve.getEndpointX();
				StartY += curve.getEndpointY();
			}
		}
		
	}
	
}




//Turn curve = new Turn(true, 200, 150, 180, 0, backgroundColor);
//curve.setTranslateX(primaryStage.getWidth() / 2);
//curve.setTranslateY(primaryStage.getHeight() / 2);
//background.getChildren().add(curve);
//
//
//
//Straight rak = new Straight(500, 200, curve.getStartangleToNext());
//rak.setTranslateX(primaryStage.getWidth() / 2 - curve.getEndpointX());
//rak.setTranslateY(primaryStage.getHeight() / 2 - curve.getEndpointY());
//background.getChildren().add(rak);
//
//Circle waypoint = new Circle();
//waypoint.setRadius(20);
//background.getChildren().add(waypoint);
//waypoint.setTranslateX(primaryStage.getWidth()/2);
//waypoint.setTranslateY(primaryStage.getHeight()/2);