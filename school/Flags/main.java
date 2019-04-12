package Flags;

import java.util.Scanner;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class main extends Application{
	
	public static double Width = 0;
	public static double Height = 0;
	public static String FlagName = ""; 

	public void start(Stage primaryStage) throws Exception {
		Group root = new Group();
		Scene scene = new Scene(root,600,600,Color.SKYBLUE);
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter width");
		Width = sc.nextDouble();
//		System.out.println("Enter flagname");
//		FlagName = sc.next();
		
		launch();
	}

}
