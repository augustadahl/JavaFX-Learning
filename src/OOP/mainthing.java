package OOP;

public class mainthing {

	public static void main(String[] args) {

		Secretword Word = new Secretword("August");

		Word.show();

		Word.guess('A');

		Word.show();

		Word.guess('u');

		Word.show();

		Word.guess('t');

		Word.show();
		
		Word.guess('c');

		Word.limbs.show();
	}

}
