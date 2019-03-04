package Other;

public class Secretword {

	public String strH;
	
	public String strV;
	
	public Secretword(String in) {
		
		strV = in;
		
		strH = in;
		
	}
	
	public void show() {
		for (int i = 0; i < strV.length(); i++) {
			if (strH.charAt(i) == strV.charAt(i)) {
				System.out.println(strH.charAt(i));
			} else {
				System.out.println("-");
			}
			
		}
	}
	
	public void guess(char c) {
		for (int i = 0; i < strH.length(); i++) {
			if (c == strH.charAt(i)) {
				
			}
		}
	}
	
}
