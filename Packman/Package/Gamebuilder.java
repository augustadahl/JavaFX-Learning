package Package;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

//X = wall
//0 = Snack
//' ' = empty
//S = power snack
//G = ghost
//P = player
//F = gate

//Ta in en fil och outputta en arraylist..

public class Gamebuilder {
	ArrayList<Object> hej = new ArrayList<Object>();
	
	public Gamebuilder() {
		hej.add(new Packman());
		hej.add(new Snack());
	}
	
	public static ArrayList<String> FileReader(){
		ArrayList<String> layout = new ArrayList<String>();
		try {
			Scanner file = new Scanner(new File("C:\\Users\\August Ådahl\\Documents\\GitHub\\JavaFX-Learning\\Packman\\Package\\Board.txt"));
			
			while (file.hasNextLine()) {
				layout.add(file.nextLine());
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("wong");
		}
		return layout;
	}
	
}
