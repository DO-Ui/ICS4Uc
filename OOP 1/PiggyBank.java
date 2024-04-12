
/**
 * @file PiggyBank.java
 * @brief This Java file describes the PiggyBank class used in OOP1.
 */

import java.util.Map; // Using a java Map to allow for key to value associations

public class PiggyBank {

	/*
	 * Declare a map initalized with each coin type and how many of them are present
	 * (0 to start)
	 */
	private Map<String, Integer> coinsInBank = Map.ofEntries(
			Map.entry("PENNY", 0),
			Map.entry("NICKEL", 0),
			Map.entry("DIME", 0),
			Map.entry("QUARTER", 0),
			Map.entry("LOONIE", 0),
			Map.entry("TOONIE", 0));

	public double getBalance() {
		double total = 0.0;
		for (String coinType : coinsInBank.keySet()) {
			total += coinsInBank.get(coinType) * Coins.valueOf(coinType).getValue();
		}

		return total;
	}

	public boolean addCoins(Coins coinType, int numCoins) {
		if (numCoins <= 0) {
			return false;
		}

		System.err.println(coinType.name());

		// Increment the number of coins of the given type in the bank
		coinsInBank.put(coinType.name(), coinsInBank.get(coinType.name()) + numCoins);


		return true;

	}

	public boolean subCoins(Coins coinType, int numCoins) {
		if (numCoins >= 0) {
			return false;
		}
		

		return true;

	}

}