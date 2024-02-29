/**
 * @file ConditionalStructures.java
 * @brief This Java application is for the Conditional Structures assignment
 */

import java.util.Scanner;


/* 
 * Ryan Yang
 * ICS4Uc
 * Feb 23, 2024
 */



/**
 * This is the class which contains all the functions for the Conditional Structures assignment.
 */
class ConditionalStructures {

	private static Scanner input = new Scanner(System.in); /**< Scanner object for all methods in the Main class */ 

	public static void main(String[] args) {
	// E: 1,4,5,6,9

		boolean programRunning = true;
		// Main loop to prompt user for program selection
		while (programRunning) {
			
			System.out.println("Welcome to the Java Program Selector:");
			System.out.println("1. Printing price calculator");
			System.out.println("2. Defective car model checker");
			System.out.println("3. Grade application");
			System.out.println("4. Math tutor");
			System.out.println("5. Guessing game");
			System.out.println("6. Exit");
			System.out.print("Which program would you like to run (1-6): ");
	
			int program = input.nextInt();

			// Switch case
			switch (program) {
				case 1:
					printingPrices();
					break;
				case 2:
					carRecall();
					break;
				case 3:
					gradeCalculator();
					break;
				case 4:
					mathTutor();
					break;
				case 5:
					guessingGame();
					break;
				case 6:
					programRunning = false;
					break;
			}

			System.out.println("\n\n\n");
			
		}
		
	}

    /**
     * This function will input a number of pages to be printed and output the cost per page and total cost.
     */
	public static void printingPrices() {
		System.out.print("Enter the number of copies to be printed: ");
		int copies = input.nextInt();


		// Yes repetition is bad. However, there is simply no other optimal way to do this in Java
		// I discussed this with you and we didn't find another faster way
		if ((0 <= copies) && (copies <= 99)) {
			System.out.println("Price per copy is: $0.30");
			System.out.format("Total cost is: $%.2f", copies*0.3);
		} else if ((100 <= copies) && (copies <= 499)) {
			System.out.println("Price per copy is: $0.28");
			System.out.format("Total cost is: $%.2f", copies*0.28);
		} else if ((500 <= copies) && (copies <= 749)) {
			System.out.println("Price per copy is: $0.27");
			System.out.format("Total cost is: $%.2f", copies*0.27);
		} else if ((750 <= copies) && (copies <= 1000)) {
			System.out.println("Price per copy is: $0.26");
			System.out.format("Total cost is: $%.2f", copies*0.26);
		} else if (1000 < copies) {
			System.out.println("Price per copy is: $0.25");
			System.out.format("Total cost is: $%.2f", copies*0.25);
		}
		System.out.println(); // To add a newline
		
	}
	
	/**
     * This function will determine if your car needs to be recalled, depending on an inputted model number
     */
	public static void carRecall() {
		System.out.print("Enter the car's model number: ");
		int modelNumber = input.nextInt();

		if ((189 <= modelNumber) && (modelNumber <= 195)) { // First check the range of models
			System.out.println("Your car is defective. It must be repaired.");
			return;
		} else {
			int defectiveModels[] = {119, 179, 221, 780};
			for (int i = 0; i < defectiveModels.length; i++) { // Check the rest of the edge cases
				if (modelNumber == defectiveModels[i]) {
					System.out.println("Your car is defective. It must be repaired.");
					return;
				}
			}
		}
		System.out.println("Your car is not defective");
		
	}

	/**
     * This function will input a grade percentage and then output the corresponding letter
     */
	public static void gradeCalculator() {
		System.out.print("Enter the percentage: ");
		double gradePercent = input.nextDouble();

		char letterGrade = ' ';

		// For doubles there is no other way to do this as there are infinite values between two decimal numbers
		if ((90 <= gradePercent) && (gradePercent <= 100)) {
			letterGrade = 'A';
		} else if ((80 <= gradePercent) && (gradePercent <= 89)) {
			letterGrade = 'B';
		} else if ((70 <= gradePercent) && (gradePercent <= 79)) {
			letterGrade = 'C';
		} else if ((60 <= gradePercent) && (gradePercent <= 69)) {
			letterGrade = 'D';
		} else if (gradePercent < 60) {
			letterGrade = 'F';
		}

		System.out.format("The corresponding letter grade is: %c\n", letterGrade);
		
	}

	/**
     * This function has an interactive math problem generator
     * It shows a math problem and checks the user inputted answer
     */
	public static void mathTutor() {
		char operators[] = {'*', '+', '-', '/'}; // Store operatores for easy randomization
		int a = (int)((Math.random()*10)+1);
		int b = (int)((Math.random()*10)+1);
		int operator = (int)(Math.random()*4);
		
		System.out.format("What is %d %c %d? ", a, operators[operator], b);

		double response = Math.round(input.nextDouble() * 100.0) / 100.0; // Round to 2 decimal places to prevent floating point errors

		double answer = 0.0;

		
		switch (operator) {
			case 0: // *
				answer = (double)(a * b);
				break;
			case 1: // +
				answer = (double)(a + b);
				break;
			case 2: // -
				answer = (double)(a - b);
				break;
			case 3: // /
				answer = (double)((double)(a) / (double)(b));
				break;
		}


		answer = Math.round(answer * 100.0) / 100.0; // Round the answer

		
		if (response == answer) {
			System.out.println("Correct!");
		} else {
			System.out.println("Incorrect!");
		}
		
	}

	/**
     * This function is a number guessing game which generates a random number, then waits for user input
     */
	public static void guessingGame() {
		int randomNumber = (int)(Math.random()*20+1); // Pick a random number between 1-20
		System.out.print("Enter a number between 1 and 20: ");
		int guess = input.nextInt();
		System.out.format("Computer's Number: %d\n", randomNumber);
		System.out.format("Player's Number: %d\n", guess);
		if (guess == randomNumber) { // Compare the user's input
			System.out.println("You won!");
		} else {
			System.out.println("Better luck next time.");
		}
	}
	
	
}