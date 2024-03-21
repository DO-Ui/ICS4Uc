/**
 * @file Methods.java
 * @brief This Java application is for the Methods assignment.
 */

import java.util.Scanner;

 /* 
  * Ryan Yang
  * ICS4Uc
  * March 20th, 2024
  */
 
 /**
  * This is the class which contains all the functions for the Methods assignment.
  */
 class Methods {
 
	 // E: 2, 5
 
	 private static Scanner input = new Scanner(System.in);
 
	 public static void main(String[] args) {
 
		 boolean programRunning = true;
		 // Main loop to prompt user for program selection
		 while (programRunning) {
			 
			 System.out.println("Welcome to the Java Program Selector:");
			 System.out.println("1. Unit conversion calculator");
			 System.out.println("2. Change addition calculator");
			 System.out.println("3. Exit");
			 System.out.print("Which program would you like to run (1-3): ");
	 
			 int program = input.nextInt();
 
			 // Switch case
			 switch (program) {
				 case 1:
					 unitConversionApp();
					 break;
				 case 2:
					 addCoinsApp();
					 break;
				 case 3:
					 programRunning = false;
					 break;
			 }
 
			 System.out.println("\n\n\n");
			 
		 }
		 input.close();
	 }
 

	 /**
	  * This function is the interface for the add coins app
	  */
	 public static void addCoinsApp() {
		 System.out.println("Enter your total coins:\n");
		 double total = 0.0;
		 System.out.print("Quarters: ");
		 total += input.nextInt() * 0.25;
		 System.out.print("Dimes: ");
		 total += input.nextInt() * 0.10;
		 System.out.print("Nickels: ");
		 total += input.nextInt() * 0.05;
		 System.out.print("Pennies: ");
		 total += input.nextInt() * 0.01;
 
		 System.out.format("\nTotal: $%.2f\n", total);
 
	 }
 
	 /**
	  * This function is the interface for the unit conversion app
	  */
	 public static void unitConversionApp() {
		 System.out.println(
				 "LIST OF UNITS\n\tCENTIMETER [1]\n\tMETER\t   [2]\n\tKILOMETER  [3]\n\tINCH\t   [4]\n\tYARD\t   [5]\n\tMILE\t   [6]");
		 System.out.print("Select the starting unit (1-6): ");
		 int selectedStartingUnit = input.nextInt();
		 System.out.print("Select the ending unit (1-6): ");
		 int selectedEndingUnit = input.nextInt();
		 System.out.print("Enter the starting value: ");
		 double startingValue = input.nextDouble();
 
		 // Index is 0 based but user input is 1 based
		 Unit startingUnit = Unit.values()[selectedStartingUnit - 1];
		 Unit endingUnit = Unit.values()[selectedEndingUnit - 1];
 
		 double endingValue = convertUnit(startingUnit, endingUnit, startingValue);
 
		 // Using a ternary statement to select plurality if the value is 1 or not
		 String startingUnitName = startingValue == 1 ? startingUnit.name().toLowerCase()
				 : startingUnit.name().toLowerCase() + "s";
		 String endingUnitName = endingValue == 1 ? endingUnit.name().toLowerCase()
				 : endingUnit.name().toLowerCase() + "s";
 
		 System.out.format("%.2f %s equals %.2f %s\n", startingValue, startingUnitName, endingValue, endingUnitName);
 
	 }
 
	 /*
	  * This is a custom enum class for the conversion of units which contains the
	  * conversion factors for each unit.
	  */
	 private static enum Unit {
		 // By converting each unit to a common unit (meters), we can convert between any
		 // two units by converting to meters and then to the desired unit.
		 CENTIMETER(0.01, 100.0),
		 METER(1.0, 1.0),
		 KILOMETER(1000.0, 0.001),
		 INCH(0.0254, 39.37008),
		 YARD(0.9144, 1.093613),
		 MILE(1609.344, 0.0006213712);
 
		 public final double conversionToMeter;
		 public final double conversionFromMeter;
 
		 // Constructor for the enum class
		 private Unit(double conversionToMeter, double conversionFromMeter) {
			 this.conversionToMeter = conversionToMeter;
			 this.conversionFromMeter = conversionFromMeter;
		 }
 
	 }
 
	 /**
	  * This function takes in two units and a value and returns the value converted
	  * 
	  * @param startingUnit The starting unit to convert from
	  * @param endingUnit   The ending unit to convert to
	  * @param value        The value to convert
	  * @return The value converted to the ending unit
	  */
	 public static double convertUnit(Unit startingUnit, Unit endingUnit, double value) {
		 double valueInMeters = value * startingUnit.conversionToMeter;
		 double convertedValue = valueInMeters * endingUnit.conversionFromMeter;
		 return convertedValue;
	 }
 
 }