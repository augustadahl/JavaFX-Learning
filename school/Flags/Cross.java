package Flags;

import javafx.scene.Group;
import javafx.scene.shape.Rectangle;

public class Cross extends Group{

	public Cross(double radius) {
		
			Rectangle base = new Rectangle();
			base.setWidth(radius * 2 * 0.60);
			base.setHeight(radius * 0.20);
			base.setTranslateX(-radius * 0.60);
			base.setTranslateY(-radius * 0.10);
			base.setRotate(90);
			this.getChildren().add(base);
			
			Rectangle right = new Rectangle();
			right.setWidth(radius * 2 * 0.35);
			right.setHeight(radius * 0.2);
			right.setTranslateX(-radius * 0.1);
			right.setTranslateY(-radius * 0.60);
			this.getChildren().add(right);
			
			Rectangle left = new Rectangle();
			left.setWidth(radius * 2 * 0.35);
			left.setHeight(radius * 0.2);
			left.setTranslateX(-radius * 0.60);
			left.setTranslateY(radius * 0.40);
			this.getChildren().add(left);
			
	}
	
}
