package Package;

import java.util.ArrayList;

//X = wall
//0 = Snack
//' ' = empty
//S = power snack
//G = ghost
//P = player

//Ta in en fil och outputta en arraylist..

public class Gamebuilder {
	ArrayList<Object> hej = new ArrayList<Object>();
	
	public Gamebuilder() {
		hej.add(new Packman());
		hej.add(new Snack());
	}
	
}
