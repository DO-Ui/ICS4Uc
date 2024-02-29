/**
 * @file Loop.java
 * @brief This Java application is for the Loop assignment
 */

import java.util.Scanner;

/* 
 * Ryan Yang
 * ICS4Uc
 * March 1st, 2024
 */

 /**
  * This is the class which contains all the functions for the Loop assignment
  */
class Loop {

	//E: 1,5,6,11,18,20


	private static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		primeNumberRangeApp();
	}

	/**
	 * Interface for Exercise 1 a), prompts user for prime number and tells user if number is prime
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
	 * Interface for Exercise 1 b), prompts user for a range of numbers and prints all the primes between the range
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
	 * A helper function to determine the primality of numbers using a mildly optimised prime number checking algorithm with complexity O(sqrt(n))
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
	 * This function prompts the user for a number and displays each digit individually
	 */
	public static void digitDisplay() {
		

	}
	
}