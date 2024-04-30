/**
 * @file Cards.java
 * @brief This Java file describes the Cards enum used in OOP3.
 */

 public enum Cards {

	ACE(1),
	TWO(2),
	THREE(3),
	FOUR(4),
	FIVE(5),
	SIX(6),
	SEVEN(7),
	EIGHT(8),
	NINE(9),
	TEN(10),
	JACK(10),
	QUEEN(10),
	KING(10),
	_ACE_ELEVEN(11);
	

	private final int value;

	// Constructor
	private Cards(int value) {
		this.value = value;
	}

	/**
	 * @brief This method returns the integer value of the card
	 * @return The value of the card
	 */
	public double getValue() {
		return this.value;
	}

}