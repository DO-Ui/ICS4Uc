public class Truck extends Vehicle {
    
    private float loadCapacity;
    private int numAxles;
    private boolean hasTrailer;

    /**
     * Constructs a truck with the given name, color, max speed, number of wheels, load capacity, number of axles, and whether it has a trailer.
     * @param name The name of the truck
     * @param color The color of the truck
     * @param maxSpeed The max speed of the truck
     * @param numWheels The number of wheels on the truck
     * @param loadCapacity The load capacity of the truck
     * @param numAxles The number of axles on the truck
     * @param hasTrailer Whether the truck has a trailer
     */
    public Truck(String name, String color, int maxSpeed, int numWheels, float loadCapacity, int numAxles, boolean hasTrailer) {
        this.name = name;
        this.color = color;
        this.maxSpeed = maxSpeed;
        this.numWheels = numWheels;
        this.loadCapacity = loadCapacity;
        this.numAxles = numAxles;
        this.hasTrailer = hasTrailer;
    }

    @Override
    /**
     * Prints a honking message for the truck.
     */
    public void honk() {
        System.out.println("Honk honk, I'm a truck!");
    }

    @Override
    /**
     * Prints a driving message for the truck.
     */
    public void drive() {
        System.out.println("Vroom vroom, I'm a truck!");
    }

    /**
     * Returns the load capacity of the truck.
     * @return the load capacity of the truck
     */
    public float getLoadCapacity() {
        return loadCapacity;
    }

    /**
     * Returns the number of axles on the truck.
     * @return the number of axles on the truck
     */
    public int getNumAxles() {
        return numAxles;
    }

    /**
     * Returns whether the truck has a trailer.
     * @return whether the truck has a trailer
     */
    public boolean getHasTrailer() {
        return hasTrailer;
    }

}
