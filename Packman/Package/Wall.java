package Package;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Wall extends Group{

	private int X;
	private int Y;
	Color color = Color.BLACK;
	
	public Wall(int X, int Y, double scale) {
		this.X = X;
		this.Y = Y;
		
		Rectangle wall = new Rectangle(); 
		wall.setWidth(scale);
		wall.setHeight(scale);
		wall.setFill(color);
		
	}
	
	public int getX() {
		return X;
	}
	
	public int getY() {
		return Y;
	}
	
	
}
