/**
 * @file Coins.java
 * @brief This Java file describes the Coins enum used in OOP1.
 */

 public enum Coins {

	PENNY(0.01, 19.05),
	NICKEL(0.05, 21.2),
	DIME(0.10, 18.03),
	QUARTER(0.25, 23.88),
	LOONIE(1.00, 26.5),
	TOONIE(2.00, 28.0),
	NONE(0.0, 0.0);

	private final double value;
	private final double diameterInMillimeters;

	// Constructor
	private Coins(double value, double diameterInMillimeters) {
		this.value = value;
		this.diameterInMillimeters = diameterInMillimeters;
	}

	/**
	 * @brief This method returns the value of the coin
	 * @return The value of the coin
	 */
	public double getValue() {
		return this.value;
	}

	/**
	 * @brief This method returns the diameter of the coin in millimeters
	 * @return The diameter of the coin in millimeters
	 */
	public double getdiameterInMillimeters() {
		return this.diameterInMillimeters;
	}

}