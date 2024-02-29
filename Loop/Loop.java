/**
 * @file Loop.java
 * @brief This Java application is for the Loop assignment.
 */

import java.util.Scanner;

/* 
 * Ryan Yang
 * ICS4Uc
 * March 1st, 2024
 */

 /**
  * This is the class which contains all the functions for the Loop assignment.
  */
class Loop {

	//E: 1,5,6,11,18,20


	private static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		monogram();
		countVowels();
	}

	/**
	 * Interface for Exercise 1 a), prompts user for prime number and tells user if number is prime.
	 */
	public static void primeNumberApp() {
		System.out.print("Enter a number to check the primality of: ");
		int number = input.nextInt();
		if (isPrimeNumber(number)) {
			System.out.println("This number is a prime number.");
		} else {
			System.out.println("This number is not a prime number.");
		}
	}

	/**
	 * Interface for Exercise 1 b), prompts user for a range of numbers and prints all the primes between the range.
	 */
	public static void primeNumberRangeApp() {
		System.out.print("Enter the minimum range to check:");
		int min = input.nextInt();
		System.out.print("Enter the maximum range to check:");
		int max = input.nextInt();
		
		boolean primes[] = primeNumberSieve(max);

		for (int i = min; i <= max; i++) {
			if (primes[i]) {
				System.out.format("%d is a prime number\n", i);
			}
		}

	}

	/**
	 * A helper function to determine the primality of numbers using a mildly optimised prime number checking algorithm with complexity O(sqrt(n)).
	 * @param n The number to check primality of
	 * @return If the number is prime
	 */
	public static boolean isPrimeNumber(int n) {
		if (n == 1) {
			return false;
		}

		int factor = 2;
		while (factor*factor <= n) {
			if (n % factor == 0) {
				return false;
			}
			factor++;
		}
		return true;
	}


	/**
	 * Using the Sieve of Eratosthenes to check primes between a range (https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes)
	 * @param max The maximum value of the range
	 * @return Returns a boolean array indicating prime numbers at index i
	 */
	public static boolean[] primeNumberSieve(int max) {
		boolean primes[] = new boolean[max + 1];

		for (int i = 0; i <= max; i++) {
			primes[i] = true;
		}

		for (int j = 2; j*j <= max; j++) {
			if (primes[j]) {
				for (int i = j*j; i<= max; i+=j) {
					primes[i] = false;
				}
			}
		}
		
		return primes;
	}	

	/**
	 * This function prompts the user for a number and displays each digit individually.
	 */
	public static void digitDisplay() {
		System.out.print("Enter a positive integer: ");
		String numberString = input.next();
		for (int i = 0; i < numberString.length(); i++) {
			System.out.println(numberString.charAt(i));
		}
	}
	
	/**
	 * This function will prompt the user for a number and adds the sum of the digits.
	 */
	public static void digitSum() {
		System.out.print("Enter a positive integer: ");
		int number = input.nextInt();
		int sum = 0;
		while (number != 0) {
			sum += number % 10;
			number /= 10;
		}
		System.out.format("The sum of the digits is: %d\n", sum);
	}

	/**
	 * This function will prompt the user for a time and elapsed hours, it will add the elapsed hours to the time and print it.
	 */
	public static void elapsedTimeCalculator() {
		System.out.print("Enter the starting hour: ");
		int startingHour = input.nextInt();
		System.out.print("Enter am or pm: ");
		String amOrPm = input.next();
		System.out.print("Enter the number of elapsed hours: ");
		int elapsedHours = input.nextInt();
		
		if (amOrPm.toLowerCase().equals("pm")) {
			startingHour += 12; // Convert to 24h time
		}

		startingHour += elapsedHours;
		

		if (startingHour > 24) {
			startingHour -= 24;
			amOrPm = "am";
		}

		if (startingHour >= 12) {
			amOrPm = "pm";
		} else {
			amOrPm = "am";
		}

		if (amOrPm.equals("pm")) {
			startingHour -= 12; // Convert back to 12h time
		}

		System.out.format("%d:00 %s\n", startingHour, amOrPm);

	}

	/**
	 * This function will prompt the user for their name and create a monogram.
	 */
	public static void monogram() {
		System.out.print("Enter your first name: ");
		String firstName = input.next();
		System.out.print("Enter your middle initial: ");
		String middleInitial = input.next();
		System.out.print("Enter your last name: ");
		String lastName = input.next();

		System.out.format("Your monogram is: %s%s%s\n", firstName.toLowerCase().charAt(0), lastName.toUpperCase().charAt(0), middleInitial.toLowerCase().charAt(0));

	}


	/**
	 * This function will prompt the user for a string and output the number of vowels in the string.
	 */
	public static void countVowels() {
		System.out.print("Enter text: ");
		input.nextLine(); // Clear buffer
		String text = input.nextLine();

		int vowelCount = 0;
		char vowels[] = {'e', 'a', 'i', 'o', 'u'}; // Arranged by letter frequency in the English language to reduce average runtime

		for (int i = 0; i < text.length(); i++) {
			for (int j = 0; j < 5; j++) {
				if (text.toLowerCase().charAt(i) == vowels[j]) {
					vowelCount++;
					break;
				}
			}
		}

		System.out.format("The number of vowels in: \"%s\" is: %d\n", text, vowelCount);

	}

}