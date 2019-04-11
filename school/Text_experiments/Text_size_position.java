package Text_experiments;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Text_size_position extends Application{

	int fontsize = 20;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		//n�got grafiskt
		Group root = new Group();
		
		//fyller f�nstret med n�got grafiskt storlek och bakgrundsf�rg (ej obligatoriskt)
		Scene scene = new Scene(root,500,500,Color.SKYBLUE);
		
		//primarystage �r variabeln f�r v�rt f�nster
		//s�tter scenen till f�nstret
		primaryStage.setScene(scene);
		
		//visar f�nstret
		primaryStage.show();
		
		
		
		
		Text text = new Text(250,250,"2048");
		root.getChildren().add(text);
		text.setFont(Font.font("Verdana", FontWeight.BOLD, fontsize));

		
		text.setTranslateX(-text.getBoundsInLocal().getWidth()/2);
		text.setTranslateY(text.getBoundsInLocal().getHeight()/4);
		
		
		scene.setOnKeyPressed(e -> {
			KeyCode key = e.getCode();
			
			switch (key) {
			case UP:
				fontsize += 20;
				text.setFont(Font.font(null ,FontWeight.BOLD, fontsize));
				
				text.setTranslateX(-text.getBoundsInLocal().getWidth()/2);
				text.setTranslateY(text.getBoundsInLocal().getHeight()/4);
				break;
			case DOWN:
				fontsize -= 20;
				text.setFont(Font.font("Verdana", FontWeight.BOLD, fontsize));
				
				text.setTranslateX(-text.getBoundsInLocal().getWidth()/2);
				text.setTranslateY(text.getBoundsInLocal().getHeight()/4);
				break;
			default:
				break;
			}
			
		});
		
		
		tile_experimental tile = new tile_experimental();
		root.getChildren().add(tile);
		tile.setTranslateX(100);
		tile.setTranslateY(100);
		
		scene.setOnKeyPressed(e -> {
			KeyCode key = e.getCode();
			
			switch (key) {
			case UP:
				
				break;
			case DOWN:
				
				break;
			default:
				break;
			}
			
		});
		
		
	}
	
	public static void main(String[] args) {
		//kallar p� stage
		launch();
	}

}
