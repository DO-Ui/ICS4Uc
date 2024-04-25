public class Car extends Vehicle {
    
    private int passengers;
    private int doors;
    private boolean convertible;

    /**
     * Constructs a car with the given name, color, max speed, number of wheels, number of passengers, number of doors, and whether it is convertible.
     * @param name The name of the car
     * @param color The color of the car
     * @param maxSpeed The max speed of the car
     * @param numWheels The number of wheels on the car
     * @param passengers The number of passengers in the car
     * @param doors The number of doors on the car
     * @param convertible Whether the car is convertible
     */
    public Car(String name, String color, int maxSpeed, int numWheels, int passengers, int doors, boolean convertible) {
        this.name = name;
        this.color = color;
        this.maxSpeed = maxSpeed;
        this.numWheels = numWheels;
        this.passengers = passengers;
        this.doors = doors;
        this.convertible = convertible;
    }

    @Override
    /**
     * Prints a honking message for the car.
     */
    public void honk() {
        System.out.println("Beep beep, I'm a car!");
    }

    /**
     * Prints a driving message for the car.
     */
    @Override
    public void drive() {
        System.out.println("Vroom vroom, I'm a car!");
    }

    /**
     * Returns the number of passengers in the car.
     * @return the number of passengers in the car
     */
    public int getPassengers() {
        return passengers;
    }

    /**
     * Returns the number of doors on the car.
     * @return the number of doors on the car
     */
    public int getDoors() {
        return doors;
    }

    /**
     * Returns whether the car is convertible.
     * @return whether the car is convertible
     */
    public boolean getIsConvertible() {
        return convertible;
    }

}
