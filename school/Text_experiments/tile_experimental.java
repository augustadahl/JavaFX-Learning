package Text_experiments;

import javafx.scene.Group;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class tile_experimental extends Group {

	int value = 2;
	double fontsize = 55;
	Rectangle background = new Rectangle();
	Text number = new Text(50, 55, Integer.toString(value));

	public tile_experimental() {

		background.setWidth(100);
		background.setHeight(100);
		background.setFill(Color.BEIGE);
		background.setArcHeight(15);
	    background.setArcWidth(15);


		number.setFont(Font.font("Verdana", FontWeight.BOLD, fontsize));

		number.setTranslateX(-number.getBoundsInLocal().getWidth() / 2);
		number.setTranslateY(number.getBoundsInLocal().getHeight() / 4);

		this.getChildren().addAll(background, number);
	}

	public void increase() {
		value += value;

		double oldwidth = number.getBoundsInLocal().getWidth();

		number.setText(Integer.toString(value));

		if (number.getBoundsInLocal().getWidth() > oldwidth) {
			fontsize -= fontsize * 0.18;
			number.setFont(Font.font("Verdana", FontWeight.BOLD, fontsize));
		}

		number.setTranslateX(-number.getBoundsInLocal().getWidth() / 2);
		number.setTranslateY(number.getBoundsInLocal().getHeight() / 4);

		switch (value) {
		case 4:
			background.setFill(Color.BISQUE);
			break;
		case 8:
			background.setFill(Color.ORANGE);
			break;
		case 16:
			background.setFill(Color.DARKORANGE);
			break;
		case 32:
			background.setFill(Color.ORANGERED);
			break;
		case 64:
			background.setFill(Color.DARKGRAY);
			break;
		default:
			break;
		}

	}

	public void move(KeyCode key) {
		switch (key) {
		case LEFT:
			this.setTranslateX(this.getTranslateX() -100);
			break;
		case RIGHT:
			this.setTranslateX(this.getTranslateX() + 100);
			break;
		case UP:
			this.setTranslateY(this.getTranslateY() - 100);
			break;
		case DOWN:
			this.setTranslateY(this.getTranslateY() + 100);
			break;

		default:
			break;
		}
	}

}
