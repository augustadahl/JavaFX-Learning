package Other;

import java.util.Iterator;

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

public class AnonymousInnerClassesAndLambda extends Application {

	Button button;

	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage primaryStage) throws Exception {
		// best�mmer titeln p� f�nstret
		primaryStage.setTitle("Title of the window");

		button = new Button();
		button.setText("Poke here");

//		button.setOnAction(new EventHandler<ActionEvent>() {
//
//			public void handle(ActionEvent event) {
//				System.out.println("I'm an anonymous inner class");
//			}
//		
//		
//		});
		
		button.setOnAction(e -> {
			System.out.println("Lambda expression"); 
		});

		// best�mmer var saker ska vara
		StackPane layout = new StackPane();
		layout.getChildren().add(button);

		// skapar en scen enligt layout
		Scene scene = new Scene(layout, 300, 250);
		primaryStage.setScene(scene);
		primaryStage.show();

	}

}
