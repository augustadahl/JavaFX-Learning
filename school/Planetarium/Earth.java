package Planetarium;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Earth extends Group{

	public Earth (double radius) {
		
		Circle earth = new Circle();
		earth.setRadius(radius);
		earth.setFill(Color.BLUE);
		this.getChildren().add(earth);
		
//		
		
		double position = 0;
		
		for (int i = 0; i < 60; i++) {
			Circle ground = new Circle();
			ground.setRadius(Math.random() * radius/2);
			
			ground.setFill(Color.GREEN);
			
			
			
			if (Math.random() > 0.5) {
				position = Math.random() * Math.PI;
			} else {
				position = -Math.random() * Math.PI;
			}
			
			
			
			ground.setTranslateX(Math.cos(position) * (Math.random() * (radius - ground.getRadius())));
			ground.setTranslateY(Math.sin(position) * (Math.random() * (radius - ground.getRadius())));
			this.getChildren().add(ground);
			
			
		}
		
		Circle arctic = new Circle();
		arctic.setRadius(radius/2.5);
		arctic.setFill(Color.WHITE);
		arctic.setTranslateX(Math.random() * radius/6);
		arctic.setTranslateY(Math.random() * radius/6);
		this.getChildren().add(arctic);
		
		
	}
	
}
