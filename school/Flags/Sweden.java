package Flags;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Sweden extends Group{
	
	public Sweden() {
		
	}
	
	/**
	 * Returns the correct height according to the aspect ratio of that flag
	 * @param Width
	 * @return Height
	 */
	public double Height(double Width) {
		return (Width/8) * 5;
	}
	
	public void Create(double Width, double Height) {
		Rectangle Background = new Rectangle();
		Background.setWidth(Width);
		Background.setHeight(Height);
		Background.setFill(Color.BLUE);
		
		this.getChildren().add(Background);
		
	}
	
}
