/**
 * @file VariablesAndConstants.java
 * @brief This Java application is for the Variables and Constants assignment
 */

import java.util.Scanner;


/* 
 * Ryan Yang
 * ICS4Uc
 * Feb 16, 2024
 */

/**
 * This is the class which contains all the functions for the Variables and Constants assignment.
 */
class VariablesAndConstants {
	private static Scanner input = new Scanner(System.in);
	
	public static void pizzaCost() {
		System.out.print("Enter the diameter of the pizza in inches: ");
		float diameter = input.nextFloat();
		System.out.format("The cost of making the pizza is: $%.2f\n", diameter*diameter*0.05f+1.0f+0.75f);
	}

	public static void changeMaking() {
		System.out.print("Enter the amount of change in cents: ");
		int change = input.nextInt();
		int denominations[] = {25, 10, 5, 1};
		int coins[] = {0,0,0,0};

		
		for (int i = 0; i < 4; i++) {
			if (change >= denominations[i]) {
				coins[i]++;
				change-= denominations[i];
				i--;
			}
		}

		System.out.println("The minimum number of coins is:");
		System.out.format("Quarters: %d\n", coins[0]);
		System.out.format("Dimes: %d\n", coins[1]);
		System.out.format("Nickels: %d\n", coins[2]);
		System.out.format("Pennies: %d\n", coins[3]);
	}
	

	public static void divAndMod() {
		System.out.print("Enter an integer: ");
		int first_val = input.nextInt();
		System.out.print("Enter a second integer: ");
		int second_val = input.nextInt();
		System.out.format("%d / %d = %d\n", first_val, second_val, first_val/second_val);
		System.out.format("%d %% %d = %d\n", first_val, second_val, (int)first_val%second_val);
		System.out.println();
		System.out.format("%d / %d = %d\n", second_val, first_val, second_val/first_val);
		System.out.format("%d %% %d = %d\n", second_val, first_val, (int)second_val%first_val);
		
	
		
	}
	

    
	public static void main(String[] args) {
	    // E 2, 6, 8, 11
		
		
		
	}

	
}