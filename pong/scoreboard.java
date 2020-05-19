import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

//scoreboard �r en po�ngm�tare som h�ller koll p� varje spelares po�ng samt visar dem p� varera sida.

public class scoreboard extends Group{

	//skapar 2 texf�lt samt po�ngm�tare
	Text left = new Text(30, 0, "0");
	Text right = new Text(-30, 0, "0");
	int leftscore = 0;
	int rightscore = 0;
	
	public scoreboard() {
		
		//l�gger till textf�llten samt ger dem r�tt storlek och gr�nssnitt.
		left.setFill(Color.WHITE);
		left.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 50));
		getChildren().add(left);
		
		right.setFill(Color.WHITE);
		right.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 50));
		getChildren().add(right);
	}
	
	//l�gger till en po�ng till h�ger spelare och visar upp den samt aktiverar restart metoden.
	public void addright() {
		rightscore++;
		right.setText(Integer.toString(rightscore));
		restart();
	}
	//samma som ovan fast v�nster
	public void addleft() {
		leftscore++;
		left.setText(Integer.toString(leftscore));
		restart();
	}
	//kollar om n�gon spelare har mer �n 9 po�ng och nollst�ller is�fall po�ngen.
	public void restart() {
		if (leftscore > 9 || rightscore > 9) {
			leftscore = -1;
			rightscore = -1;
			addright();
			addleft();
		}
	}
}
