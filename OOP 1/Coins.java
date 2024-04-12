public enum Coins {
	NONE(0.0, 0.0),
	PENNY(0.01, 19.05),
	NICKEL(0.05, 21.2),
	DIME(0.10, 18.03),
	QUARTER(0.25, 23.88),
	LOONIE(1.00, 26.5),
	TOONIE(2.00, 28.0);

	private final double value;
	private final double diameterInMillimeters;

	private Coins(double value, double diameterInMillimeters) {
		this.value = value;
		this.diameterInMillimeters = diameterInMillimeters;
	}

	public double getValue() {
		return this.value;
	}

	public double getdiameterInMillimeters() {
		return this.diameterInMillimeters;
	}

}