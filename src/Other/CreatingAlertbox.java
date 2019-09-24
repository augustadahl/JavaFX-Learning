package Other;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage; 

public class CreatingAlertbox extends Application{

	Stage window;
	Button button;
	
	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		window.setTitle("Val 2022");
		
		button = new Button("Gå till vallokalen");
		button.setOnAction(e -> AlertBox.display("OBSERVERA!", "Stefan Löfven ser dina synder"));
		
		StackPane layout = new StackPane();
		layout.getChildren().add(button);
		Scene scene = new Scene(layout, 350, 250);
		window.setScene(scene);
		
		window.show();
		
	}
	
}
