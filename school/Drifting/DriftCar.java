package Drifting;

import java.util.ArrayList;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.shape.Rectangle;

public class DriftCar extends Group {

	// skapa här
	Image texture = new Image("Drifting/Car.png");
	ImageView car = new ImageView(texture);

	double reverseMax = -4;

	double size;
	double difference;
	double reverseDiff;

	// steering, handling and grip
	ArrayList<Double> directionHistory = new ArrayList<Double>(); // keeps track of latest carDirections
	double steeringAngle = 0.2; // the "angle of your wheel"
	double maxSteeringAngle = 0.3; // the max "angle of your wheel"
	double carDirection = 0; // the current direction the car is pointing
	double absoluteDirection = 0; // the direction the car will go, calculated by running grip data and such;
	double gripValue = 1; // how good grip the car has
	double currentGrip = 10; // how much grip the car currently has (low is good)
	boolean turning = false;

	// speed, acceleration and braking
	double acceleration = 0.2; // how fast you accelerate
	double maxVelocity = 40; // maximum speed
	double speed = 0; // current speed
	double engineBraking = 0.05; // how much enginebraking the car has
	double brakePower = 0.5; // how good brakes the car has

	public DriftCar(double size) {

		// ställa in bilens storlek
		double height = texture.getHeight();
		double width = texture.getWidth();
		double diff = 1 - (height - size) / height;
		car.setFitHeight(size);
		car.setFitWidth(diff * width);
		this.getChildren().add(car);

		// ställa in differenser
		this.size = size;
		difference = size / 50;
		reverseDiff = 50 / size;

	}

	public String position() {
		return "X: " + Integer.toString((int) car.getTranslateX()) + "Y: "
				+ Integer.toString((int) car.getTranslateY());
	}

	public void rotate(KeyCode key) {

		if (carDirection - absoluteDirection < 90 && absoluteDirection - carDirection < 90) {
			if (key.equals(KeyCode.A)) {
				car.setRotate(car.getRotate() - steeringAngle * reverseDiff * speed);
				carDirection = (car.getRotate() - steeringAngle * reverseDiff * speed);
			}

			if (key.equals(KeyCode.D)) {
				car.setRotate(car.getRotate() + steeringAngle * reverseDiff * speed);
				carDirection = (car.getRotate() + steeringAngle * reverseDiff * speed);
			}
		}
		
		
		
		

//		if (key.equals(KeyCode.A)) {
//			car.setRotate(car.getRotate() - steeringAngle * reverseDiff * speed);
//		}
//		
//		if (key.equals(KeyCode.D)) {
//			car.setRotate(car.getRotate() + steeringAngle  * reverseDiff * speed);
//		}

		//

		// lägg till i array
		// ta bort sista i array
		// skilnaden mellan absolutvärdet och sista avgör hur många som ska användas vid
		// beräkningen
		// heading dirr = medelvärdet för de senaste svängningarna

//		speed -= speed * 0.01;

	}

	public void accelerate() {
		speed += acceleration * difference;
	}

	public void brake() {
		speed -= acceleration * difference;
	}

	public void execute() {
		if (speed > maxVelocity * difference) {
			speed = maxVelocity * difference;
		}
		if (speed < reverseMax * difference) {
			speed = reverseMax * difference;
		}

//		if (speed > (engineBraking + 0.01) * difference) {
//			car.setTranslateX(car.getTranslateX() - Math.cos(Math.toRadians(car.getRotate())) * speed);
//			car.setTranslateY(car.getTranslateY() - Math.sin(Math.toRadians(car.getRotate())) * speed);
//			speed -= engineBraking * difference;
//		} else if (speed < (engineBraking - 0.01) * difference) {
//			car.setTranslateX(car.getTranslateX() - Math.cos(Math.toRadians(car.getRotate())) * speed);
//			car.setTranslateY(car.getTranslateY() - Math.sin(Math.toRadians(car.getRotate())) * speed);
//			speed += engineBraking * difference;
//		} else {
//			speed = 0;
//		}

		directionHistory.add(carDirection);

		for (int i = 0; i < directionHistory.size(); i++) {
			if (directionHistory.size() > 1 + (int) speed * 2) {
				directionHistory.remove(0);
			}
		}

		double all = 0;

		for (int i = 0; i < directionHistory.size(); i++) {
			all += directionHistory.get(i);
		}

		absoluteDirection = all / directionHistory.size();

		absoluteDirection = (absoluteDirection + carDirection) / 2;

		if (speed > (engineBraking + 0.01) * difference) {
			car.setTranslateX(car.getTranslateX() - Math.cos(Math.toRadians(absoluteDirection)) * speed);
			car.setTranslateY(car.getTranslateY() - Math.sin(Math.toRadians(absoluteDirection)) * speed);
			speed -= engineBraking * difference;
		} else if (speed < (engineBraking - 0.01) * difference) {
			car.setTranslateX(car.getTranslateX() - Math.cos(Math.toRadians(absoluteDirection)) * speed);
			car.setTranslateY(car.getTranslateY() - Math.sin(Math.toRadians(absoluteDirection)) * speed);
			speed += engineBraking * difference;
		} else {
			speed = 0;
		}

	}

}
