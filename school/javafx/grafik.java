package javafx;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class grafik extends Application{

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
	}
	
	public static void main(String[] args) {
		//kallar p� stage
		launch();
	}

}
