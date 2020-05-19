package main;

import java.util.Scanner;

public class Stocks {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		double monthSaving = sc.nextDouble();
		
		double Ranta = 1.01;
		
		double total = 0;
		
		double noranta = 0;
		
		for (int years = 1; years < 61; years++) {
			
			for (int month = 0; month < 12; month++) {
				
				total += monthSaving;
				total *= Ranta;
				noranta += monthSaving;
				
			}
			
			System.out.println("Efter" + years + "år! Med ränta: " + (int) total + "kr! Utan Ränta: " + (int) noranta + "kr!");
		}
		
	}

}
