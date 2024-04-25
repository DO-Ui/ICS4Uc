public class Minivan extends Vehicle {

    private int numSeats;
    private boolean hasSlidingDoors;

    /**
     * Constructs a minivan with the given name, color, max speed, number of wheels, number of seats, and whether it has sliding doors.
     * @param name The name of the minivan
     * @param color The color of the minivan
     * @param maxSpeed The max speed of the minivan
     * @param numWheels The number of wheels on the minivan
     * @param numSeats The number of seats in the minivan
     * @param hasSlidingDoors Whether the minivan has sliding doors
     */
    public Minivan(String name, String color, int maxSpeed, int numWheels, int numSeats, boolean hasSlidingDoors) {
        this.name = name;
        this.color = color;
        this.maxSpeed = maxSpeed;
        this.numWheels = numWheels;
        this.numSeats = numSeats;
        this.hasSlidingDoors = hasSlidingDoors;
    }

    @Override
    /**
     * Prints a honking message for the minivan.
     */
    public void honk() {
        System.out.println("Honk honk, I'm a minivan!");
    }

    /**
     * Prints a driving message for the minivan.
     */
    @Override
    public void drive() {
        System.out.println("Vroom vroom, I'm a minivan!");
    }

    /**
     * Returns the number of seats in the minivan.
     * @return the number of seats in the minivan
     */
    public int getNumSeats() {
        return numSeats;
    }

    /**
     * Returns whether the minivan has sliding doors.
     * @return whether the minivan has sliding doors
     */
    public boolean getHasSlidingDoors() {
        return hasSlidingDoors;
    }

}