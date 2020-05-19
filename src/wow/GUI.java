package wow;


import java.util.ArrayList;
import java.util.Random;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class GUI extends Application{

	
	//Här lagras alla frågorna, första index är frågan, andra är svaret och resterande är felaktiga alternativ
	public String[][] Questions = 
		{{"Who was the person behind microsoft?", "Bill Gates", "Steve Jobs", "Drake", "Donald Trump"},
		{"When was the eiffel tower built?", "1887", "1825", "1765", "1990"},
		{"When did Donald Trump become president?", "2016", "2020", "2002", "1876"},
		{"When did 9/11 take place?", "2001", "1901", "2002", "2023"}};
	
	TextField text = new TextField();
	Button a = new Button();
	Button b = new Button();
	Button c = new Button();
	Button d = new Button();
	char correct;
	boolean active;
	
	
	public void start(Stage primaryStage) throws Exception {
		Group root = new Group();
		Scene scene = new Scene(root,1000,300,Color.SKYBLUE);
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
		root.getChildren().add(text);
		text.setEditable(false);
		text.setMinSize(1000, 100);
		text.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
		
		
		a.setMinWidth(250);
		a.setMinHeight(200);
		a.setTranslateY(100);
		a.setTranslateX(0);
		root.getChildren().add(a);
		
		
		b.setMinWidth(250);
		b.setMinHeight(200);
		b.setTranslateY(100);
		b.setTranslateX(250);
		root.getChildren().add(b);
		
		
		c.setMinWidth(250);
		c.setMinHeight(200);
		c.setTranslateY(100);
		c.setTranslateX(500);
		root.getChildren().add(c);
		
		
		d.setMinWidth(250);
		d.setMinHeight(200);
		d.setTranslateY(100);
		d.setTranslateX(750);
		root.getChildren().add(d);

		
		reset();
		
		
		
		
		
		
		
		
		
		a.setOnAction(e -> guess('a'));
		b.setOnAction(e -> guess('b'));
		c.setOnAction(e -> guess('c'));
		d.setOnAction(e -> guess('d'));
		
		
		
		
		
		
	}
	
	public void reset() {
		Random rd = new Random();
		int qID = rd.nextInt(4-0)+0;
		active = true;
		correct = ' ';
		text.setText(Questions[qID][0]);
		
		ArrayList<Integer> alternatives = new ArrayList<Integer>();
		for (int i = 0; i < 4; i++) {
			alternatives.add(i);
		}
		
		int index = rd.nextInt(alternatives.size())+0;
		a.setText(Questions[qID][alternatives.get(index) + 1]);
		if (index == 0 && correct == ' ') {
			correct = 'a';
		}
		alternatives.remove(index);
		
		index = rd.nextInt(alternatives.size())+0;
		b.setText(Questions[qID][alternatives.get(index) + 1]);
		if (index == 0 && correct == ' ') {
			correct = 'b';
		}
		alternatives.remove(index);
		
		index = rd.nextInt(alternatives.size())+0;
		c.setText(Questions[qID][alternatives.get(index) + 1]);
		if (index == 0 && correct == ' ') {
			correct = 'c';
		}
		alternatives.remove(index);
		
		index = rd.nextInt(alternatives.size())+0;
		d.setText(Questions[qID][alternatives.get(index)+ 1]);
		if (index == 0 && correct == ' ') {
			correct = 'd';
		}
		
		
		
	}
	
	public void guess(char c) {
		if (active) {
			if (c == correct) {
				text.setText("You won! press any button to restart");
				active = false;
			} else {
				text.setText("You lost! press any button to restart");
				active = false;
			}
		} else {
			reset();
		}
		
		
	}
	
	public static void main(String[] args) {
		launch();
	}

}













































