package OOP;

public class Secretword {

	public String strH;
	
	public String strV;
	
	public Scoreboard limbs = new Scoreboard();
	
	public Secretword(String in) {
		
		strV = in;
		
		strH = in;
		
	}
	
	public void show() {
		for (int i = 0; i < strV.length(); i++) {
			if (strH.charAt(i) == strV.charAt(i)) {
				System.out.print(strH.charAt(i));
			} else {
				System.out.print("-");
			}
			
		}
		System.out.println();
	}
	
	public void guess(char c) {
		String temp = "";
		for (int i = 0; i < strH.length(); i++) {
			if (c == strH.charAt(i)) {
				temp += "-";
			} else {
				temp += strH.charAt(i);
			}
		}
		if (temp.equals(strH)) {
			limbs.add();
		}
		strH = temp;
	}
	
}
