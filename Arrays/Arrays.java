
/**
 * @file Arrays.java
 * @brief This Java application is for the Arrays assignment.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/* 
 * Ryan Yang
 * ICS4Uc
 * March 29st, 2024
 */

/**
 * This is the class which contains all the functions for the Arrays assignment.
 */
class Arrays {

	// E: 3, 13, 16

	private static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {

		boolean programRunning = true;
		// Main loop to prompt user for program selection
		while (programRunning) {

			System.out.println("Welcome to the Java Program Selector:");
			System.out.println("1. Random number statistics");
			System.out.println("2. Penny pitch");
			System.out.println("3. Inventory app");
			System.out.println("4. Exit");
			System.out.print("Which program would you like to run (1-4): ");

			int program = input.nextInt();

			// Switch case
			switch (program) {
				case 1:
					randomStats();
					break;
				case 2:
					pennyPitch();
					break;
				case 3:
					inventoryApp();
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
	 * This function generates random numbers and counts the number of times each
	 * number appears.
	 * 
	 * @param count The number of random numbers to generate.
	 */
	public static void randomStats(int count) {
		int[] randomNumbers = new int[10];
		for (int i = 0; i < count; i++) {
			randomNumbers[(int) (Math.random() * 10)]++;
		}
		System.out.println("Number\tOccurences");
		for (int i = 0; i < randomNumbers.length; i++) {
			System.out.println(i + "  \t\t" + randomNumbers[i]);
		}

	}

	/**
	 * This function simulates the game of penny pitch.
	 */
	public static void pennyPitch() {

		/*
		 * Values of each prize:
		 * 0: PUZZLE
		 * 1: POSTER
		 * 2: DOLL
		 * 3: GAME
		 * 4: BALL
		 * 5: Empty space
		 */

		String prizes[] = { "| PUZZLE |", "| POSTER |", "|  DOLL  |", "|  GAME  |", "|  BALL  |", "|        |" };

		ArrayList<ArrayList<Integer>> board = new ArrayList<ArrayList<Integer>>();

		// Initalize the arrays and fill with 5's
		for (int i = 0; i < 5; i++) {
			board.add(new ArrayList<Integer>());
			for (int j = 0; j < 5; j++) {
				board.get(i).add(5);
			}
		}

		// 4 types of prizes
		for (int i = 0; i < 5; i++) {
			// 3 of each prize
			for (int j = 0; j < 3; j++) {
				int randomX = (int) (Math.random() * 5);
				int randomY = (int) (Math.random() * 5);
				if (board.get(randomX).get(randomY) == 5) {
					board.get(randomX).set(randomY, i);
				} else {
					j--;
				}
			}
		}

		// Print the board
		System.out.println("Board:");
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.print(prizes[board.get(i).get(j)]);
			}
			System.out.println();
		}

		// Keep track of where the coins landed
		int coinsLanded[][] = new int[5][5];

		// Initalize the arrays and fill with 0's
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				coinsLanded[i][j] = 0;
			}
		}

		// Keep track of the prizes won
		int prizesWon[] = new int[5];

		// 10 coins
		for (int i = 0; i < 10; i++) {
			int randomX = (int) (Math.random() * 5);
			int randomY = (int) (Math.random() * 5);
			// If the coin has not landed there before
			if (coinsLanded[randomX][randomY] == 0 && board.get(randomX).get(randomY) != 5) {
				prizesWon[board.get(randomX).get(randomY)]++;
			}
			coinsLanded[randomX][randomY]++;
		}

		// Print the board with coins
		System.out.println("Board with coins:");
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.print("| " + coinsLanded[i][j] + " |");
			}
			System.out.println();
		}

		// Calculate the prizes won
		System.out.println("Prizes won:");
		for (int i = 0; i < 5; i++) {
			if (prizesWon[i] >= 3) {
				System.out.println(prizes[i]);
			}
		}

	}

	/**
	 * This function is an inventory app which allows the user to add, remove, and
	 * view items.
	 */
	public static void inventoryApp() {
		int currentStockNumber = 1000; // The current stock number which new items will be assigned to
		/*
		 * Hashmap allows for quick retrieval of items based on their stock number
		 * Arraylist allows for details of item to be stored together
		 * Using the Object datatype allows for mixing of different datatypes, in this
		 * case String and Integer
		 */
		HashMap<Integer, ArrayList<Object>> inventory = new HashMap<Integer, ArrayList<Object>>();
		System.out.println("Welcome to the inventory app!");
		boolean running = true;
		while (running) {
			System.out.println("1. Add item");
			System.out.println("2. Remove item");
			System.out.println("3. View inventory");
			System.out.println("4. Exit");
			System.out.print("What would you like to do: ");
			int choice = input.nextInt();
			switch (choice) {
				case 1:
					System.out.print("Enter the name of the item: ");
					String name = input.next();
					System.out.print("Enter the quantity of the item: ");
					int quantity = input.nextInt();
					ArrayList<Object> item = new ArrayList<Object>();
					item.add(name);
					item.add(quantity);
					inventory.put(currentStockNumber, item);
					System.out.println("Item added with stock number " + currentStockNumber);
					// Increment the stock number
					currentStockNumber++;
					break;
				case 2:
					System.out.print("Enter the stock number of the item you would like to remove: ");
					int stockNumber = input.nextInt();
					// Check if the item exists
					if (inventory.containsKey(stockNumber)) {
						inventory.remove(stockNumber);
						System.out.println("Item removed");
					} else {
						System.out.println("Item not found");
					}
					break;
				case 3:
					System.out.println("Stock Number\tName\tQuantity");
					for (int key : inventory.keySet()) {
						ArrayList<Object> itemDetails = inventory.get(key);
						System.out.println(key + "\t\t" + itemDetails.get(0) + "\t" + itemDetails.get(1));
					}
					break;
				case 4:
					running = false;
					break;
			}
		}
	}
}