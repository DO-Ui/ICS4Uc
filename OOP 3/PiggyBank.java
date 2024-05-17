/**
 * @file PiggyBank.java
 * @brief This Java file describes the PiggyBank class used in OOP3.
 */

 /**
  * This class is used to simulate a piggy bank
  */
public class PiggyBank implements Bank {
    
    /*
	 * Declare a map initalized with each coin type and how many of them are present
	 * (0 to start)
	 */
	private int[] coinsInBank = {0, 0, 0, 0, 0, 0};

	/**
	 * @brief This method returns the total balance of the piggy bank
	 * @return The total balance of the piggy bank
	 */
	public double getBalance() {
		double total = 0.0;

		for (int i = 0; i < coinsInBank.length; i++) {
			total += coinsInBank[i] * Coins.values()[i].getValue();
		}

		return total;
	}

	/**
	 * @brief This method adds coins to the piggy bank instead of using a setter
	 * @param coinType The type of coin to add
	 * @param numCoins The number of coins to add
	 * @return True if the coins were added successfully, false otherwise
	 */
	public boolean addCoins(Coins coinType, int numCoins) {
		// Check if the number of coins is valid
		if (numCoins <= 0) {
			return false;
		}

		// Add the coins to the bank
		coinsInBank[coinType.ordinal()] += numCoins;

		return true;
	}

	/**
	 * @brief This method removes coins from the piggy bank
	 * @param coinType The type of coin to remove
	 * @param numCoins The number of coins to remove
	 * @return True if the coins were removed successfully, false otherwise
	 */
	public boolean subCoins(Coins coinType, int numCoins) {
		// Check if the number of coins is valid
		if (numCoins <= 0) {
			return false;
		}
		// Check if there are enough coins to remove
		if (coinsInBank[coinType.ordinal()] < numCoins) {
			return false;
		}

		// Remove the coins from the bank
		coinsInBank[coinType.ordinal()] -= numCoins;

		return true;
	}

	/**
	 * @brief this method sets the coins in the bank
	 * @param coinsInBank The coins in the bank
	 */
	public void setCoinsInBank(int[] coinsInBank) {
		this.coinsInBank = coinsInBank;
	}


}
