package main;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Background extends Group{

	public Background(int size) {
		Rectangle back = new Rectangle();
		back.setWidth(110 * size + 10);
		back.setHeight(110 * size + 10);
		back.setFill(Color.GRAY);
		back.setArcHeight(15);
		back.setArcWidth(15);
		this.getChildren().add(back);
		
		
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				Rectangle tile = new Rectangle();
				tile.setWidth(100);
				tile.setHeight(100);
				tile.setArcHeight(15);
			    tile.setArcWidth(15);
			    tile.setFill(Color.LIGHTGREY);
				this.getChildren().add(tile);
			    tile.setTranslateX(10 + i * 110);
			    tile.setTranslateY(10 + j * 110);
				
			}
		}
		
		
	}
	
	
	
	
}