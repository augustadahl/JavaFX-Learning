package Flags;

import javafx.Star;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class USA extends Group{

	public USA(Double height) {
		
		//background
		Rectangle back = new Rectangle();
		back.setWidth(height * 1.9);
		back.setHeight(height);
		back.setFill(Color.WHITE);
		this.getChildren().add(back);
		
		//0.0769 / 1/13
		//stripes
		for (int i = 0; i < 7; i++) {
			Rectangle stripe = new Rectangle();
			stripe.setWidth(height * 1.9);
			stripe.setHeight(height/13);
			stripe.setTranslateY(i * ((height/13)*2));	
			stripe.setFill(Color.RED);
			this.getChildren().add(stripe);
		}
		
		//square
		double sqwidth = height * 0.76;
		double sqheight = height * 7/13;
		Rectangle square = new Rectangle();
		square.setWidth(sqwidth);
		square.setHeight(sqheight);
		square.setFill(Color.DARKBLUE);
		this.getChildren().add(square);
		
		//stars
		double widthSpacing = sqwidth/12;
		double heightSpacing = sqheight/10;
		double radius = height * (0.0616/2);
		
		for (int i = 0; i < 9; i++) {
			int stars = 6;
			if (i%2 == 1) {
				stars = 5;
			}
			for (int j = 0; j < stars; j++) {
				Star star = new Star(radius, Color.WHITE);
				if (stars == 5) {
					star.setTranslateX(widthSpacing);
				}
				star.setTranslateX(star.getTranslateX() + j * (widthSpacing*2) + widthSpacing);
				star.setTranslateY((i+1) * heightSpacing);
				this.getChildren().add(star);
			}
		}
	}
	
	
}











