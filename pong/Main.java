// Mainklassens syfte �r prim�rt att lagra de olika objekten och knyta dem samman f�r att f� spelet att fungera.

import java.util.ArrayList;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application{

	//anv�nds f�r att f� smoth input, (jaok l�rde oss detta)
	ArrayList<KeyCode> keysPressed = new ArrayList<KeyCode>();
	
	public void start(Stage primaryStage) throws Exception {
		Group root = new Group();
		Scene scene = new Scene(root,800,500,Color.BLACK);
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
		//skapar ett h�ger och v�nster racket samt placerar dem p� r�tt plats
		paddle right = new paddle();
		root.getChildren().add(right);
		right.setTranslateX(760);
		right.setTranslateY(210);
		
		paddle left = new paddle();
		root.getChildren().add(left);
		left.setTranslateX(40);
		left.setTranslateY(210);
		
		//skapar en boll..
		ball boll = new ball();
		root.getChildren().add(boll);
		
		//skapar po�ngm�taren
		scoreboard score = new scoreboard();
		root.getChildren().add(score);
		score.setTranslateX(400);
		score.setTranslateY(50);
		
		//detta �r en animationtimer och fungerar lite som en while loop fast f�r javafx
		AnimationTimer at = new AnimationTimer() {
			
			@Override
			public void handle(long now) {
				
				//hanterar input och d�rmed racketen
				for (KeyCode key : keysPressed) {

					switch (key) {
					
					case UP:
						right.up();
						break;
					case DOWN:
						right.down();
						break;
						
					case W:
						left.up();
						break;
					case S:
						left.down();
						break;

					default:
						break;
					}

				}
				
				//aktiverar metoder
				boll.move();
				boll.bounce(left.getBoundsInParent(), right.getBoundsInParent());
				
				//kollar om bollen g�tt i m�l med hj�lp av en klass och aktiverar is�fall en annan
				if (boll.leftgoal()) {
					score.addleft();
				}
				if (boll.rightgoal()) {
					score.addright();
				}
				
			}
		};
		
		
		at.start();			
		
		//tar input
		scene.setOnKeyPressed(e -> {
			KeyCode key = e.getCode();
			if (!keysPressed.contains(key))
				keysPressed.add(key);
		});

		scene.setOnKeyReleased(e -> {
			KeyCode key = e.getCode();
			if (keysPressed.contains(key))
				keysPressed.remove(key);
		});
		
		
		
	}
	
	public static void main(String[] args) {
		launch();
	}

}