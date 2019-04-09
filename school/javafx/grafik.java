package javafx;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class grafik extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		//något grafiskt
		Group root = new Group();
		
		//fyller fönstret med något grafiskt storlek och bakgrundsfärg (ej obligatoriskt)
		Scene scene = new Scene(root,500,500,Color.SKYBLUE);
		
		//primarystage är variabeln för vårt fönster
		//sätter scenen till fönstret
		primaryStage.setScene(scene);
		
		//visar fönstret
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		//kallar på stage
		launch();
	}

}
