import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

//skapar en kvadrat f�r att illustrera racket

public class paddle extends Rectangle{

	public paddle() {
		setHeight(80);
		setWidth(10);
		setFill(Color.WHITE);

	}
	
	//flyttar racketen upp�t om den inte l�mnar rutan
	public void up() {
		if (!getBoundsInParent().intersects(0, 0, 800, 0)) {
			setTranslateY(getTranslateY() -5);
		}
		
	}
	
	//flyttar racketen ner�t tills den b�rjar l�mna rutan
	public void down() {
		if (!getBoundsInParent().intersects(0, 500, 800, 0)) {
			setTranslateY(getTranslateY() +5);
		}
	}
	
	
	
	
	
	
	
	
	
	
}
