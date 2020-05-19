import java.util.Random;

import javafx.geometry.Bounds;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

//detta �r culan som man passar mellan sig... den sk�ter sin egen utplacering p� spelplanen osv.

public class ball extends Circle{

	//styr i vilken riktning kulan ska r�ra sig.
	int dirrX = 1;
	int dirrY = 1;
	double angle = 30;
	Random r = new Random();
	
	//skapar kulan och placerar ut den p� slumpm�ssig planhalva samt ger den en slumpm�ssig riktning
	public ball() {
		setRadius(10);
		setFill(Color.WHITE);
		if (Math.random() >= 0.5) {
			setTranslateX(150);
			setTranslateY(250);
			dirrX = -1;
		} else {
			setTranslateX(650);
			setTranslateY(250);
			dirrX = 1;
		}
		ydirr();
	}
	
	//flyttar culan enligt r�dande f�reskrifter.
	public void move() {
		setTranslateX(getTranslateX() - Math.cos(Math.toRadians(angle)) * 8 * dirrX);
		setTranslateY(getTranslateY() - Math.sin(Math.toRadians(angle)) * 8 * dirrY);		
	}
	
	//kollar om kulan studsar antingen vid taket eller golvet samt antingen ena eller de andra racket och byter is�fall riktning.
	public void bounce(Bounds a, Bounds b) {
		if (getBoundsInParent().intersects(a)) {
			dirrX = -1;
			angle = 20 + (35 - 20) * r.nextDouble();
		}
		if (getBoundsInParent().intersects(b)) {
			dirrX = 1;
			angle = 20 + (35 - 20) * r.nextDouble();

		}
		if (getBoundsInParent().intersects(0, 0, 800, 0)) {
			dirrY *= -1;
		}
		if (getBoundsInParent().intersects(0, 500, 800, 0)) {
			dirrY *= -1;
		}
	}
	
	//kollar om det gjorts m�l p� v�nster sida och servar is�fall p� nytt samt returnerar ja annars returnerar nej
	public boolean leftgoal() {
		if (getBoundsInParent().intersects(0, 0, 0, 500)) {
			setTranslateX(150);
			setTranslateY(250);
			dirrX = -1;
			ydirr();
			return true;
		} else {
			return false;
		}
		
	}
	
	//kollar om det gjorts m�l p� h�ger sida och servar is�fall p� nytt samt returnerar ja annars returnerar nej
	public boolean rightgoal() {
		if (getBoundsInParent().intersects(800, 0, 0, 500)) {
			setTranslateX(650);
			setTranslateY(250);
			dirrX = 1;
			ydirr();
			return true;
		} else {
			return false;
		}
	}
	
	//s�tter riktningen f�r bollen upp / ner random
	public void ydirr() {
		if (Math.random() >= 0.5) {
			dirrY = 1;
		} else {
			dirrY = -1;
		}
	}
	
	
}
