abstract class Vehicle {
    
    protected String name;
    protected String color;
    protected int maxSpeed;
    protected int numWheels;

     
    public void honk() {
        System.out.println("Honk!");
    }

    public void drive() {
        System.out.println("Vroom!");
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public int getNumWheels() {
        return numWheels;
    }

}
