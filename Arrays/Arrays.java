
/**
 * @file Arrays.java
 * @brief This Java application is for the Arrays assignment.
 */

import java.util.ArrayList;
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
			System.out.println("1. Unit conversion calculator");
			System.out.println("2. Change addition calculator");
			System.out.println("3. p3");
			System.out.println("4. Exit");
			System.out.print("Which program would you like to run (1-4): ");

			int program = input.nextInt();

			// Switch case
			// switch (program) {
			// case 1:
			// ();
			// break;
			// case 2:
			// ();
			// break;
			// case 3:
			// ();
			// break;
			// case 4:
			// programRunning = false;
			// break;
			// }

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

	public static void pennyPitch() {
		/*
		 * 0: PUZZLE
		 * 1: POSTER
		 * 2: DOLL
		 * 3: GAME
		 * 4: BALL
		 * 5: Empty space
		 */
		Arraylist<Integer>[] board = new ArrayList<Integer>[5];

		for (int i = 0; i < 5; i++) {
			board[i] = new ArrayList<Integer>(Arrays.asList(5, 5, 5, 5, 5)); // Initalize with Empty spaces
		}

		for (int i = 0; i <= 4; i++) {
			String prize = "";
			switch (i) {
				case 0:
					prize = "PUZZLE";
			}
		}

	}

}