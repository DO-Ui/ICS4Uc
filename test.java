import java.util.Scanner;

// Name: Reese So
// Due Date: April 7, 2024
// Title: Loops Assignment
// Verified by: Jonathan Yang 
class Main {
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		// Question 1.
		int numZeros = 0;
		int total = 0;
		int count = 0;
		int divFive = 0;
		int highest = 0;
		int lowest = 1000;
		int num = 0;

		while (true) {
			System.out.println("Enter number: ");
			num = in.nextInt();

			if (num < 0) {
				break;
			}
			if (num == 0) {
				numZeros = numZeros + 1;
			}
			if (num % 5 == 0) {
				divFive = divFive + 1;
			}
			if (num > highest) {
				highest = num;
			}
			if (num < lowest) {
				lowest = num;
			}

			count = count + 1;
			total = total + num;

		}
		System.out.println("Total: " + total);

		double average = total / count;
		System.out.printf("Average: %.2f", average);
		System.out.println("\nNumber of Zeros: " + numZeros);
		System.out.println("Inputs Divisible by 5: " + divFive);
		System.out.println("Highest Number: " + highest);
		System.out.println("Lowest Numnber: " + lowest);

		// Question 2.
		for (int i = 0; i < 3; i = i + 1) {
			System.out.println("Enter username: ");
			String username = in.next();
			System.out.println("Enter password: ");
			String password = in.next();

			if (!username.equals("ReesesUsername") || !password.equals("ReesesPassword")) {
				System.out.println("INTRUDER ALERT");
			}
			if (username.equals("ReesesUsername") && password.equals("ReesesPassword")) {
				System.out.println("WELCOME");
				break;
			}
		}

		// Question 3.

		while (true) {
			System.out.println("Do you want it easy, hard, or custom?: ");
			String difficulty = in.next();

			if (difficulty.equalsIgnoreCase("easy")) {
				int high1 = 100;
				int low1 = 1;
				int numTries1 = 5;

				// int random = (int)(high - low + 1) * Math.random() + low;
				int random = (int) ((high1 - low1 + 1) * Math.random() + low1);

				for (int i = 0; i < numTries1; i++) {
					System.out.println("Enter guess: ");
					int guess = in.nextInt();
					if (guess < random) {
						System.out.println("Too low");
					}
					if (guess > random) {
						System.out.println("Too high");
					}
					if (guess == random) {
						System.out.println("Correct!");
						break;
					}
				}
				System.out.println("Game over! Answer: " + random);
				System.out.println("Do you want to play again? (y/n): ");
				String restart = in.next();

				if (restart.equalsIgnoreCase("n")) {
					break;
				}

			} else if (difficulty.equalsIgnoreCase("hard")) {
				int high2 = 1000;
				int low2 = 1;
				int numTries2 = 10;

				// int random = (int)(high - low + 1) * Math.random() + low;
				int random = (int) ((high2 - low2 + 1) * Math.random() + low2);
				for (int i = 0; i < numTries2; i++) {
					System.out.println("Enter guess: ");
					int guess = in.nextInt();
					if (guess < random) {
						System.out.println("Too low");
					}
					if (guess > random) {
						System.out.println("Too high");
					}
					if (guess == random) {
						System.out.println("Correct!");
						break;
					}
				}
				System.out.println("Game over! ");

				System.out.println("Do you want to play again? (y/n): ");
				String restart = in.next();

				if (restart.equalsIgnoreCase("n")) {
					break;
				}
			}

			else if (difficulty.equalsIgnoreCase("Custom")) {

				System.out.println("Enter highest number: ");
				int high3 = in.nextInt();
				System.out.println("Enter lowest number: ");
				int low3 = in.nextInt();
				System.out.println("Enter number of tries: ");
				int numTries3 = in.nextInt();

				// int random = (int)(high - low + 1) * Math.random() + low;
				int random = (int) ((high3 - low3 + 1) * Math.random() + low3);
				for (int i = 0; i < numTries3; i++) {
					System.out.println("Enter guess: ");
					int guess = in.nextInt();
					if (guess < random) {
						System.out.println("Too low");
					}
					if (guess > random) {
						System.out.println("Too high");
					}
					if (guess == random) {
						System.out.println("Correct!");
						break;
					}
				}
				System.out.println("Game over! Answer: " + random);

				System.out.println("Do you want to play again? (y/n): ");
				String restart = in.next();

				if (restart.equalsIgnoreCase("n")) {
					break;
				}
			}

		}
	}
}
