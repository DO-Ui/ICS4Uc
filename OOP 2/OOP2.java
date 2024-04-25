
/**
 * @file OOP2.java
 * @brief This Java application is for the OOP 2 assignment.
 */

import java.util.ArrayList;
import java.util.Scanner;

/* 
  * Ryan Yang
  * ICS4Uc
  * April 26th, 2024
  */

/**
 * This is the class which contains all the functions for the OOP 2 assignment.
 */

public class OOP2 {

	private static ArrayList<Account> accounts = new ArrayList<Account>();
	private static Scanner input = new Scanner(System.in);

	// E: 2 & 3 ( Please be detailed)
	public static void main(String[] args) {
		boolean programRunning = true;

		while (programRunning) {
			System.out.println("Welcome to the OOP 2 assignment!");
			System.out.println("What would you like to do?");
			System.out.println("1: Car Creator");
			System.out.println("2: Banking Application");
			System.out.println("3: Exit");
			int choice = input.nextInt();
			switch (choice) {
				case 1:
					carCreator();
					break;
				case 2:
					bankingApplication();
					break;
				case 3:
					System.out.println("Goodbye!");
					programRunning = false;
					break;
				default:
					System.out.println("Invalid choice.");
					break;
			}
		}

	}


	/**
	 * This function is the banking application for the OOP 2 assignment.
	 */
	public static void bankingApplication() {
		if (accounts.size() == 0) {
			System.out.println("There are no accounts in the system.");
			System.out.println("Would you like to add an account? (Y/N)");
			String response = input.next().toUpperCase();
			if (response.equals("Y")) {
				addAccount();
			} else {
				System.out.println("Goodbye!");
				return;
			}
		} else {
			Account selectedAccount;
			System.out.println("Please enter the account number of the account you would like to access.");
			for (int i = 0; i < accounts.size(); i++) {
				System.out.println(i + ": " + accounts.get(i).getCustomer().getFirstName() + " " + accounts.get(i).getCustomer().getLastName());
			}
			int accountNumber = input.nextInt();
			if (accountNumber < 0 || accountNumber >= accounts.size()) {
				System.out.println("Invalid account number.");
				return;
			}
			selectedAccount = accounts.get(accountNumber);
			System.out.println("Please enter the password for the account.");
			int password = input.next().hashCode();
			if (password == selectedAccount.getPasswordHashCode()) {
				System.out.println("What would you like to do?");
				System.out.println("1: Deposit");
				System.out.println("2: Withdraw");
				System.out.println("3: Check Balance");
				System.out.println("4: Modify Account");
				System.out.println("5: Exit");
				int choice = input.nextInt();
				if (choice == 1) {
					System.out.println("Please enter the amount you would like to deposit.");
					double amount = input.nextDouble();
					selectedAccount.deposit(amount);
				} else if (choice == 2) {
					System.out.println("Please enter the amount you would like to withdraw.");
					double amount = input.nextDouble();
					selectedAccount.withdraw(amount);
				} else if (choice == 3) {
					System.out.println("The balance of the account is: " + selectedAccount.getBalance());
				} else if (choice == 4) {
					modifyAccount(selectedAccount);
				} else if (choice == 5) {
					System.out.println("Goodbye!");
					return;
				} else {
					System.out.println("Invalid choice.");
				}
			} else {
				System.out.println("Invalid password.");
			}

		}

	}

	/**
	 * This function is used to modify an account.
	 * @param account The account to modify.
	 */
	private static void modifyAccount(Account account) {
		System.out.println("What would you like to modify?");
		System.out.println("1: Customer Information");
		System.out.println("2: Account Type");
		System.out.println("3: Exit");
		int choice = input.nextInt();
		if (choice == 1) {
			System.out.println("Please enter the first name of the customer.");
			String firstName = input.next();
			System.out.println("Please enter the last name of the customer.");
			String lastName = input.next();
			System.out.println("Please enter the street address of the customer.");
			input.nextLine();
			String street = input.nextLine();
			System.out.println("Please enter the city of the customer.");
			String city = input.nextLine();
			System.out.println("Please enter the state of the customer.");
			String state = input.next();
			System.out.println("Please enter the zip code of the customer.");
			input.nextLine();
			String zip = input.nextLine();
			account.getCustomer().setFirstName(firstName);
			account.getCustomer().setLastName(lastName);
			account.getCustomer().setStreet(street);
			account.getCustomer().setCity(city);
			account.getCustomer().setState(state);
			account.getCustomer().setZip(zip);
		} else if (choice == 2) {
			System.out.println("Please enter the type of account you would like to create. (Personal/Business)");
			String accountType = input.next().toUpperCase();
			if (!accountType.equals("PERSONAL") && !accountType.equals("BUSINESS")) {
				System.out.println("Invalid account type.");
				return;
			}

			// Create a new account of the specified type
			if (accountType.equals("PERSONAL")) {
				accounts.add(new PersonalAcct(account.getCustomer(), account.getBalance(), account.getPasswordHashCode()));
			} else if (accountType.equals("BUSINESS")) {
				accounts.add(new BusinessAcct(account.getCustomer(), account.getBalance(), account.getPasswordHashCode()));
			} else {
				System.out.println("Invalid account type.");
			}

			// Remove the old account from the list
			accounts.remove(account);


		} else if (choice == 3) {
			return;
		} else {
			System.out.println("Invalid choice.");
		}
	}

	/**
	 * This function is used to add an account to the system.
	 */
	private static void addAccount() {
		System.out.println("Please enter the type of account you would like to create. (Personal/Business)");
		String accountType = input.next().toUpperCase();
		if (!accountType.equals("PERSONAL") && !accountType.equals("BUSINESS")) {
			System.out.println("Invalid account type.");
			return;
		}
		System.out.println("Please enter the first name of the customer.");
		String firstName = input.next();
		System.out.println("Please enter the last name of the customer.");
		String lastName = input.next();
		System.out.println("Please enter the street address of the customer.");
		input.nextLine();
		String street = input.nextLine();
		System.out.println("Please enter the city of the customer.");
		String city = input.nextLine();
		System.out.println("Please enter the state of the customer.");
		String state = input.next();
		System.out.println("Please enter the zip code of the customer.");
		input.nextLine();
		String zip = input.nextLine();
		System.out.println("Please enter the inital deposit in the account.");
		double balance = input.nextDouble();
		System.out.println("Please enter the password for the account.");
		int passwordHashCode = input.next().hashCode();

		Customer customer = new Customer(firstName, lastName, street, city, state, zip);
		if (accountType.equals("PERSONAL")) {
			accounts.add(new PersonalAcct(customer, balance, passwordHashCode));
		} else if (accountType.equals("BUSINESS")) {
			accounts.add(new BusinessAcct(customer, balance, passwordHashCode));
		} else {
			System.out.println("Invalid account type.");
		}

	}

	/**
	 * This function is used to create a car, truck, or minivan.
	 */
	private static void carCreator() {
		System.out.println("What type of car would you like to create?");
		System.out.println("1: Car");
		System.out.println("2: Truck");
		System.out.println("3: Minivan");
		System.out.println("4: Exit");
		int choice = input.nextInt();

		if (choice == 1) {
			System.out.println("Please enter the name of the car.");
			String name = input.next();
			System.out.println("Please enter the color of the car.");
			String color = input.next();
			System.out.println("Please enter the max speed of the car.");
			int maxSpeed = input.nextInt();
			System.out.println("Please enter the number of wheels on the car.");
			int numWheels = input.nextInt();
			System.out.println("Please enter the number of passengers in the car.");
			int passengers = input.nextInt();
			System.out.println("Please enter the number of doors on the car.");
			int doors = input.nextInt();
			System.out.println("Please enter whether the car is convertible. (true/false)");
			boolean convertible = input.nextBoolean();
			Car car = new Car(name, color, maxSpeed, numWheels, passengers, doors, convertible);
			System.out.println("The car has been created.");
			System.out.println("The car is named: " + car.getName());
			System.out.println("The car is " + car.getColor());
			System.out.println("The car has a max speed of " + car.getMaxSpeed());
			System.out.println("The car has " + car.getNumWheels() + " wheels");
			System.out.println("The car has " + car.getPassengers() + " passengers");
			System.out.println("The car has " + car.getDoors() + " doors");
			System.out.println("The car is " + (car.getIsConvertible() ? "convertible" : "not convertible"));
			car.honk();
			car.drive();
		} else if (choice == 2) {
			System.out.println("Please enter the name of the truck.");
			String name = input.next();
			System.out.println("Please enter the color of the truck.");
			String color = input.next();
			System.out.println("Please enter the max speed of the truck.");
			int maxSpeed = input.nextInt();
			System.out.println("Please enter the number of wheels on the truck.");
			int numWheels = input.nextInt();
			System.out.println("Please enter the load capacity of the truck.");
			float loadCapacity = input.nextFloat();
			System.out.println("Please enter the number of axles on the truck.");
			int numAxles = input.nextInt();
			System.out.println("Please enter whether the truck has a trailer. (true/false)");
			boolean hasTrailer = input.nextBoolean();
			Truck truck = new Truck(name, color, maxSpeed, numWheels, loadCapacity, numAxles, hasTrailer);
			System.out.println("The truck has been created.");
			System.out.println("The truck is named: " + truck.getName());
			System.out.println("The truck is " + truck.getColor());
			System.out.println("The truck has a max speed of " + truck.getMaxSpeed());
			System.out.println("The truck has " + truck.getNumWheels() + " wheels");
			System.out.println("The truck has " + truck.getNumAxles() + " axles");
			System.out.println("The truck has " + (truck.getHasTrailer() ? "a trailer" : "no trailer"));
			truck.honk();
			truck.drive();
		} else if (choice == 3) {
			System.out.println("Please enter the name of the minivan.");
			String name = input.next();
			System.out.println("Please enter the color of the minivan.");
			String color = input.next();
			System.out.println("Please enter the max speed of the minivan.");
			int maxSpeed = input.nextInt();
			System.out.println("Please enter the number of wheels on the minivan.");
			int numWheels = input.nextInt();
			System.out.println("Please enter the number of seats in the minivan.");
			int numSeats = input.nextInt();
			System.out.println("Please enter whether the minivan has sliding doors. (true/false)");
			boolean hasSlidingDoors = input.nextBoolean();
			Minivan minivan = new Minivan(name, color, maxSpeed, numWheels, numSeats, hasSlidingDoors);
			System.out.println("The minivan has been created.");
			System.out.println("The minivan is named: " + minivan.getName());
			System.out.println("The minivan is " + minivan.getColor());
			System.out.println("The minivan has a max speed of " + minivan.getMaxSpeed());
			System.out.println("The minivan has " + minivan.getNumWheels() + " wheels");
			System.out.println("The minivan has " + minivan.getNumSeats() + " seats");
			System.out.println("The minivan has " + (minivan.getHasSlidingDoors() ? "sliding doors" : "no sliding doors"));
			minivan.honk();
			minivan.drive();
		} else if (choice == 4) {
			return;
		} else {
			System.out.println("Invalid choice.");
		}


	}

}
