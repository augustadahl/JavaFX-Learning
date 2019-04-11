package Text_experiments;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Background extends Group{

	public Background(int size) {
		
		Rectangle back = new Rectangle();
		back.setWidth(110 * size + 10);
		back.setHeight(110 * size + 10);
		back.setFill(Color.GRAY);
		this.getChildren().add(back);
		
		
//		for (int i = 1; i <= size; i++) {
//			for (int j = 1; j <= size; i++) {
//				Rectangle tile = new Rectangle();
//				tile.setWidth(100);
//				tile.setHeight(100);
//				tile.setArcHeight(15);
//			    tile.setArcWidth(15);
//			    tile.setFill(Color.LIGHTGREY);
//			    tile.setTranslateX(j * 110);
//			    tile.setTranslateY(i * 110);
//			    this.getChildren().add(tile);
//			    
//			}
//		}
		
		
	}
	
	
	
	
}
