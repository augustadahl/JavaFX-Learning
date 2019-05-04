package Drifting;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.shape.Rectangle;

public class DriftCar extends Group {

	//skapa här
	Image texture = new Image("Drifting/Car.png");
	ImageView car = new ImageView(texture);
	
//	för size 100
//	double turnSpeed = 0.2;
//	double Power = 0.4;
//	double engineBraking = 0.1;
//	double Brakes = 1;
//	double maxVelocity = 40;
//	double speed = 0;
	
	double turnSpeed = 0.4;
	double Power = 0.2;
	double engineBraking = 0.05;
	double Brakes = 0.5;
	double maxVelocity = 20;
	double speed = 0;
	
	double HeightWindow;
	double WidthWindow;

	public DriftCar(double size, double WidthWindow, double HeightWindow) {

		//initiera här
		double height = texture.getHeight();
		double width = texture.getWidth();
		double diff = 1 - (height - size) / height;

		car.setFitHeight(size);
		car.setFitWidth(diff * width);
		this.getChildren().add(car);
		this.WidthWindow = WidthWindow;
		this.HeightWindow = HeightWindow;

	}
	
	public String position() {
		return "X: " + Integer.toString((int) car.getTranslateX() ) + "Y: " + Integer.toString((int) car.getTranslateY() );
	}
	
	public void rotate(KeyCode key) {
		
		if (key.equals(KeyCode.A)) {
			car.setRotate(car.getRotate() - turnSpeed * speed);
		}
		
		if (key.equals(KeyCode.D)) {
			car.setRotate(car.getRotate() + turnSpeed * speed);
		}
		
		speed -= speed*0.01;
		
	}
	
	public void accelerate() {
		speed += Power;
	}

	public void brake() {
		speed -= Power;
	}
	
	public void execute() {
		if (speed > maxVelocity) {
			speed = maxVelocity;
		}
		if (speed < -4) {
			speed = -4;
		}
		
		if (speed > 0.06) {
			car.setTranslateX(car.getTranslateX() - Math.cos(Math.toRadians(car.getRotate())) * speed);
			car.setTranslateY(car.getTranslateY() - Math.sin(Math.toRadians(car.getRotate())) * speed);
			speed -= engineBraking;
		} else if (speed < -0.06) {
			car.setTranslateX(car.getTranslateX() - Math.cos(Math.toRadians(car.getRotate())) * speed);
			car.setTranslateY(car.getTranslateY() - Math.sin(Math.toRadians(car.getRotate())) * speed);
			speed += engineBraking;
		} else {
			speed = 0;
		}
		
//		if (car.getTranslateX() > WidthWindow + 300) {
//			car.setTranslateX(-10);
//		}
//		
//		if (car.getTranslateX() < -10) {
//			car.setTranslateX( WidthWindow + 300);
//		}
//		
//		if (car.getTranslateY() < HeightWindow + 100) {
//			car.setTranslateY(-10);
//		}
//		
//		if (car.getTranslateY() > 100) {
//			car.setTranslateY(WidthWindow + 100);
//		}
		
	}
	
}
