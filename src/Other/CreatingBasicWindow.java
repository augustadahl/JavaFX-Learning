package Other;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage; 

// hela f�nstret kallas stage
// det inuti f�nstret kallas scene
//

public class CreatingBasicWindow extends Application {
	
	Button button;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		//best�mmer titeln p� f�nstret
		primaryStage.setTitle("Title of the window");
		
		button = new Button();
		button.setText("Tryck p� mig");
		
		
		//best�mmer var saker ska vara
		StackPane layout = new StackPane();
		layout.getChildren().add(button);
		
		//skapar en scen enligt layout
		Scene scene = new Scene(layout, 300, 250);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
}
