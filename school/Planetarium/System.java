package Planetarium;

import javafx.Star;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
//import javafx.scene.image.Image;
//import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class System extends Application {

	// timekeeping
	double days = 0;

	int year = 2019;

	// timecontrols
	double speed = 0.001;
	double level = 1;
	int dirr = 1;

	// positionkeeping and kinda timekeeping
	double earthRad = 0;
	double earthDeg = year * 360;
	double moonRad = 0;
	double moonDeg = 0;

	public void start(Stage primaryStage) throws Exception {
		Group root = new Group();
		Scene scene = new Scene(root, 600, 600, Color.BLACK);
		primaryStage.setScene(scene);
		primaryStage.show();

		for (int i = 0; i < 1000; i++) {
//			
			Star star = new Star(Math.random() * 2, Color.WHITE);
			star.setTranslateX(Math.random() * 600);
			star.setTranslateY(Math.random() * 600);
			root.getChildren().add(star);
		}

		Rectangle displays = new Rectangle();
		displays.setWidth(100);
		displays.setHeight(60);
		root.getChildren().add(displays);

		Text dayCount = new Text(5, 45, "hej");
		dayCount.setFill(Color.WHITE);
		root.getChildren().add(dayCount);

		Text yearDisplay = new Text(5, 30, "hej");
		yearDisplay.setFill(Color.WHITE);
		root.getChildren().add(yearDisplay);

		Text levelDisplay = new Text(5, 15, "hej");
		levelDisplay.setFill(Color.WHITE);
		root.getChildren().add(levelDisplay);

		Text hourDisplay = new Text(5, 60, "hej");
		hourDisplay.setFill(Color.WHITE);
		root.getChildren().add(hourDisplay);

		Circle sun = new Circle(40);
		sun.setFill(Color.YELLOW);
		sun.setTranslateX(primaryStage.getWidth() / 2);
		sun.setTranslateY(primaryStage.getHeight() / 2);
		root.getChildren().add(sun);

		double radius = 20;
		Earth earth = new Earth(radius);
		root.getChildren().add(earth);

		Circle moon = new Circle(5);
		moon.setFill(Color.GRAY);
		root.getChildren().add(moon);

		AnimationTimer at = new AnimationTimer() {

			double earthX = 0;
			double earthY = 0;

			double moonX = 0;
			double moonY = 0;

			public void handle(long now) {

				earthDeg += speed;
				earthRad = earthDeg * Math.PI / 180;
				earthX = 200 * Math.cos(earthRad);
				earthY = 200 * Math.sin(earthRad);
				earth.setTranslateX(primaryStage.getWidth() / 2 + earthX);
				earth.setTranslateY(primaryStage.getHeight() / 2 + earthY);
				earth.setRotate(earthDeg * 365.25);

				moonDeg = days * 360 / 29.5;
				moonRad = moonDeg * Math.PI / 180;
				moonX = 50 * Math.cos(moonRad);
				moonY = 50 * Math.sin(moonRad);
				moon.setTranslateX(earth.getTranslateX() - +moonX);
				moon.setTranslateY(earth.getTranslateY() - +moonY);

				days = (earthDeg * 365 / 360);

				dayCount.setText("Day: " + Integer.toString((int) (days % 365)));
				yearDisplay.setText("year: " + Integer.toString((int) (days / 365)));
				levelDisplay.setText("speed: " + Double.toString(level) + "x");
				hourDisplay.setText("time: " + Integer.toString((int) (days * 24) % 24) + ":"
						+ Integer.toString((int) (days * 1440) % 60));
			}
		};

		at.start();

		scene.setOnKeyPressed(e -> {

			KeyCode key = e.getCode();

			if (key.equals(KeyCode.UP)) {
				speed *= 2;
				level *= 2;
			}

			if (key.equals(KeyCode.DOWN)) {
				if (level > 0.25) {
					speed *= 0.5;
					level *= 0.5;
				}
			}

			if (key.equals(KeyCode.SPACE)) {
				speed = 0.001;
				level = 1;
				dirr = 1;
			}

			if (key.equals(KeyCode.LEFT)) {
				if (dirr == 1) {
					level *= -1;
					dirr = -1;
					speed *= -1;
				}
			}

			if (key.equals(KeyCode.RIGHT)) {
				if (dirr == -1) {
					level *= -1;
					speed *= -1;
					dirr = 1;
				}
			}

		});

//		Image planet = new Image("school/Planetarium/PolarEarth.jpg");
//		root.getChildren().add(new ImageView(planet));

	}

	public static void main(String[] args) {
		launch();
	}

}

//Image planet = new Image("school/Planetarium/PolarEarth.jpg");
//root.getChildren().add(new ImageView(planet));

//Text tCount = new Text(5, 15, "hej");
//tCount.setFill(Color.WHITE);
//root.getChildren().add(tCount);
//
//Text posCount = new Text(5, 30, "hej");
//posCount.setFill(Color.WHITE);
//root.getChildren().add(posCount);

//tCount.setText("T = " + Double.toString(earthDeg % 360));
//posCount.setText("Pos = (" + Double.toString(earthX) + ", " + Double.toString(earthY) + ")");
