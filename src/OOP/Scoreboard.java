package OOP;

public class Scoreboard {

	public int score = 0;
	
	public Scoreboard() {
		
	}
	
	public void show(){
		System.out.println(score);
	}
	
	public void add() {
		score++;
	}
	
}
