
/**
 * @file OOP1.java
 * @brief This Java application is for the OOP 1 assignment.
 */

import java.util.ArrayList;
import java.util.Scanner;

/* 
 * Ryan Yang
 * ICS4Uc
 * April 13th, 2024
 */

/**
 * This is the class which contains all the functions for the OOP 1 assignment.
 */
public class OOP1 {

	private static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		boolean programRunning = true;
		// Main loop to prompt user for program selection
		while (programRunning) {

			System.out.println("Welcome to the Java Program Selector:");
			System.out.println("1. Piggy bank Simulator");
			System.out.println("2. Lunch Order app");
			System.out.println("3. Adder Game");
			System.out.println("4. Exit");
			System.out.print("Which program would you like to run (1-4): ");

			int program = input.nextInt();

			// Switch case
			switch (program) {
				case 1:
					mySavingsApp();
					break;
				case 2:
					lunchOrder();
					break;
				case 3:
					adderApp();
					break;
				case 4:
					programRunning = false;
					break;
			}

			System.out.println("\n\n\n");

		}
		input.close();
	}

	/**
	 * This function runs the Adder game.
	 */
	public static void adderApp() {
		AdderGame game = new AdderGame();
		boolean programRunning = true;
		while (programRunning) {
			int a = game.getRandomNumber();
			int b = game.getRandomNumber();
			int correctAnswer = a + b;
			System.out.format("What is %d + %d? (Enter 999 to exit) ", a, b);
			int userAnswer = input.nextInt();
			if (userAnswer == 999) {
				System.out.format("Your score is %d\n", game.getPoints());
				programRunning = false;
				continue;
			}

			if (userAnswer == correctAnswer) {
				System.out.println("Correct!");
				game.roundWin(5);
			} else {
				System.out.println("Incorrect!");
				System.out.print("Wrong answer. Enter another answer: ");
				userAnswer = input.nextInt();
				if (userAnswer == correctAnswer) {
					System.out.println("Correct!");
					game.roundWin(3);
				} else {
					System.out.println("Incorrect!");
					System.out.print("Wrong answer. Enter another answer: ");
					userAnswer = input.nextInt();
					if (userAnswer == correctAnswer) {
						System.out.println("Correct!");
						game.roundWin(1);
					} else {
						System.out.println("Incorrect!");
						System.out.format("The correct answer was %d\n", correctAnswer);
					}
				}
			}

		}
	}

	/**
	 * This function runs the lunch order app.
	 */
	public static void lunchOrder() {
		Food[] menu = new Food[4];
		menu[0] = new Food("Hamburger", 1.85, 9.0, 33.0, 1.0);
		menu[1] = new Food("Salad", 2.00, 1.0, 11.0, 5.0);
		menu[2] = new Food("French Fries", 1.30, 11.0, 36.0, 4.0);
		menu[3] = new Food("Soda", 0.95, 0.0, 38.0, 0.0);

		boolean programRunning = true;

		// Create an array list to store the order
		ArrayList<Food> order = new ArrayList<Food>();

		while (programRunning) {
			System.out.println("Menu:");
			for (int i = 0; i < menu.length; i++) {
				System.out.format("%d. %s - $%.2f\n", i + 1, menu[i].getFoodName(), menu[i].getPrice());
				System.out.format("   Fat: %.2fg, Carbohydrates: %.2fg, Fiber: %.2fg\n", menu[i].getFat(),
						menu[i].getCarbohydrates(), menu[i].getFiber());
			}
			System.out.print("Enter the number of the item you would like to order (0 to finish order): ");
			int menuSelection = input.nextInt();

			// Exit the loop if the user enters 0
			if (menuSelection == 0) {
				programRunning = false;
				continue;
			}

			if (menuSelection < 1 || menuSelection > menu.length) {
				System.out.println("Invalid selection");
				continue;
			}

			Food selectedFood = menu[menuSelection - 1];
			System.out.format("You have ordered a %s for $%.2f\n", selectedFood.getFoodName(), selectedFood.getPrice());

			order.add(selectedFood);
		}

		double total = 0.0;
		System.out.println("Your order:");
		for (Food food : order) {
			System.out.format("%s - $%.2f\n", food.getFoodName(), food.getPrice());
			total += food.getPrice();
		}
		System.out.format("Total: $%.2f\n", total);
	}

	/**
	 * This function runs the piggy bank simulator.
	 */
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

			// Switch case to handle user input
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

			// If the user selected a coin and it is not the first option
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
				System.out.print("Which coin would you like to take out? (PENNY, NICKEL, DIME, QUARTER, LOONIE, TOONIE) ");
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
