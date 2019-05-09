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
	double steeringAngle = 0.4; // the "angle of your wheel"
	double maxSteeringAngle = 0.2; // the max "angle of your wheel"
	double carDirection = 0; // the current direction the car is pointing
	double absoluteDirection = 0; // the direction the car will go, calculated by running grip data and such;
	double gripValue = 1; // how good grip the car has
	double currentGrip = 10; // how much grip the car currently has (low is good)
	boolean turning = false;

	// speed, acceleration and braking
	double acceleration = 0.2; // how fast you accelerate
	double maxVelocity = 20; // maximum speed
	double speed = 0; // current speed
	double engineBraking = 0.1; // how much enginebraking the car has
	double brakePower = 1; // how good brakes the car has

	double positionX = 0;
	double positionY = 0;
	
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
		
		if (key.equals(KeyCode.D)) {
			if (steeringAngle < maxSteeringAngle * difference) {
				steeringAngle += 0.03;
			}
		}
		
		if (key.equals(KeyCode.A)) {
			if (steeringAngle > -maxSteeringAngle * difference) {
				steeringAngle -= 0.03;
			}
		}
		
		if (carDirection - absoluteDirection < 90 && absoluteDirection - carDirection < 90) {

				car.setRotate(car.getRotate() + steeringAngle * reverseDiff * speed);
				carDirection = (car.getRotate() + steeringAngle * reverseDiff * speed);
				
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

		

//		if (speed < 20) {
//			directionHistory.clear();
//		}
		
		directionHistory.add(carDirection);
		
		for (int i = 0; i < directionHistory.size(); i++) {
			if (directionHistory.size() > (int) 1 + (speed * reverseDiff) * ((speed * reverseDiff) /3)) {
				directionHistory.remove(0);
			}
		}

		double all = 0;
		
		int ammount = 0;

		for (int i = 0; i < directionHistory.size(); i++) {
			for (int j = 0; j < i+1; j++) {
				all += directionHistory.get(i);
				ammount++;
			}
		}

		absoluteDirection = all / ammount;

		absoluteDirection = (absoluteDirection + carDirection) / 2;

		
//		absoluteDirection = carDirection;
		
		
		if (speed > (engineBraking + 0.01) * difference) {
			car.setTranslateX(car.getTranslateX() - Math.cos(Math.toRadians(absoluteDirection)) * speed);
			car.setTranslateY(car.getTranslateY() - Math.sin(Math.toRadians(absoluteDirection)) * speed);
			
//			positionX = positionX - Math.cos(Math.toRadians(absoluteDirection)) * speed;
//			positionY = positionY - Math.sin(Math.toRadians(absoluteDirection)) * speed;
			
			speed -= engineBraking * difference;
		} else if (speed < (engineBraking - 0.01) * difference) {
			car.setTranslateX(car.getTranslateX() - Math.cos(Math.toRadians(absoluteDirection)) * speed);
			car.setTranslateY(car.getTranslateY() - Math.sin(Math.toRadians(absoluteDirection)) * speed);
			
//			positionX = positionX - Math.cos(Math.toRadians(absoluteDirection)) * speed;
//			positionY = positionY - Math.sin(Math.toRadians(absoluteDirection)) * speed;
			
			speed += engineBraking * difference;
		} else {
			speed = 0;
		}

		
		
		if (steeringAngle *difference> 0.02 * difference) {
			steeringAngle -= 0.02 * difference;
		} else if (steeringAngle * difference < -0.02 *difference) {
			steeringAngle += 0.02 *difference;
		} else {
			steeringAngle = 0;
		}
			
		
		maxSteeringAngle = 0.5 * (1-speed * reverseDiff/(maxVelocity * reverseDiff));
		
		
		
	}

}
