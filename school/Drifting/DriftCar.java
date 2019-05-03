package Drifting;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

public class DriftCar extends Group {

	Rectangle body;
	double width;
	double height;

	public DriftCar(double size) {

		Image planet = new Image("Drifting/Car.png");
		ImageView iw = new ImageView(planet);
		height = planet.getHeight();
		width = planet.getWidth();
		double diff = 1 - (height - 100) / height;

		iw.setFitHeight(100);
		iw.setFitWidth(diff * width);
		this.getChildren().add(iw);

//		body = new Rectangle();
//		body.setWidth(size);
//		body.setHeight(size/2);
//		this.getChildren().add(body);

	}

}
