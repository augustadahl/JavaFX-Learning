package Drifting;

import java.util.ArrayList;
import java.util.Scanner;

public class ArraylistTest {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		ArrayList<Double> list = new ArrayList<Double>();
		
		while (true) {
			
			System.out.println("lägg till antal?");
		
			int antal = sc.nextInt();
			
			for (int i = 0; i < antal; i++) {
				
				
				System.out.println("another one");
				list.add(sc.nextDouble());
			}
			
			System.out.println("this is your list after adding:");
			for (int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i));
			}
			
			
			System.out.println("remove antal?");
			int antal2 = sc.nextInt();
			
			for (int i = 0; i < antal2; i++) {
				System.out.println("another one");
				list.remove(sc.nextInt());
			}
			
			System.out.println("this is your list after removing:");
			
			for (int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i));
			}
			
			
		}
		
		
		
		
		
	}
	
	
}
