
/**
 * @file OOP1.java
 * @brief This Java application is for the OOP 1 assignment.
 */

import java.util.Scanner;

/* 
 * Ryan Yang
 * ICS4Uc
 * April 9th, 2024
 */

/**
 * This is the class which contains all the functions for the OOP 1 assignment.
 */
public class OOP1 {

	private static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		mySavingsApp();
	}

	public static void mySavingsApp() {
		boolean programRunning = true;

		PiggyBank bank = new PiggyBank();

		while (programRunning) {
			System.out.print(
					"1. Show total in bank.\n2. Add a penny.\n3. Add a nickel.\n4. Add a dime.\n5. Add a quarter.\n6. Add a loonie.\n7. Add a toonie\n8. Take money out of bank.\nEnter 0 to quit\nEnter your choice: ");
			int menuSelection = input.nextInt();

			if (menuSelection == 0) {
				programRunning = false;
				continue;
			}

			Coins coinSelection = Coins.NONE;

			switch (menuSelection) {
				case 1:
					System.out.format("You have $%.2f in your bank\n\n", bank.getBalance());
					break;
				case 2:
					coinSelection = Coins.PENNY;
					break;
				case 3:
					coinSelection = Coins.NICKEL;
					break;
				case 4:
					coinSelection = Coins.DIME;
					break;
				case 5:
					coinSelection = Coins.QUARTER;
					break;
				case 6:
					coinSelection = Coins.LOONIE;
					break;
				case 7:
					coinSelection = Coins.TOONIE;
					break;
				default:
					System.out.println("Invalid selection");
					break;
			}

			if (coinSelection != Coins.NONE && menuSelection != 1) {

				System.out.print("How many coins would you like to add? ");
				int numCoins = input.nextInt();

				boolean success = bank.addCoins(coinSelection, numCoins);
				if (success) {
					System.out.println("Coin added successfully\n");
				} else {
					System.out.println("Error adding coin (Make sure money is positive)\n");
				}
			} else if (menuSelection == 8) {
				System.out
						.print("Which coin would you like to take out? (PENNY, NICKEL, DIME, QUARTER, LOONIE, TOONIE)");
				String coinName = input.next();
				Coins coin = Coins.valueOf(coinName.toUpperCase());
				System.out.print("How many coins would you like to take out? ");
				int numCoins = input.nextInt();
				boolean success = bank.subCoins(coin, numCoins);
				if (success) {
					System.out.println("Coin taken out successfully\n");
				} else {
					System.out.println("Error taking out coin (Make sure money is positive)\n");
				}
			}

		}
	}

}
