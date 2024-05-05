/**
 * @file Food.java
 * @brief This Java file describes the Food class used in OOP1.
 */

 /**
  * This class is used to represent a food item
  */
public class Food {
    
    private String foodName;
    private double price;
    private double fat;
    private double carbohydrates;
    private double fiber;

    // Constructor
    public Food(String foodName, double price, double fat, double carbohydrates, double fiber) {
        this.foodName = foodName;
        this.price = price;
        this.fat = fat;
        this.carbohydrates = carbohydrates;
        this.fiber = fiber;
    }

    /**
     * @brief This method returns the name of the food
     * @return The name of the food
     */
    public String getFoodName() {
        return this.foodName;
    }

    /**
     * @brief This method returns the price of the food
     * @return The price of the food
     */
    public double getPrice() {
        return this.price;
    }

    /**
     * @brief This method returns the fat content of the food
     * @return The fat content of the food
     */
    public double getFat() {
        return this.fat;
    }

    /**
     * @brief This method returns the carbohydrates content of the food
     * @return The carbohydrates content of the food
     */
    public double getCarbohydrates() {
        return this.carbohydrates;
    }

    /**
     * @brief This method returns the fiber content of the food
     * @return The fiber content of the food
     */
    public double getFiber() {
        return this.fiber;
    }


    /**
     * @brief This method sets the name of the food
     * @param foodName The name of the food
     */
    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    /**
     * @brief This method sets the price of the food
     * @param price The price of the food
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * @brief This method sets the fat content of the food
     * @param fat The fat content of the food
     */
    public void setFat(double fat) {
        this.fat = fat;
    }

    /**
     * @brief This method sets the carbohydrates content of the food
     * @param carbohydrates The carbohydrates content of the food
     */
    public void setCarbohydrates(double carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    /**
     * @brief This method sets the fiber content of the food
     * @param fiber The fiber content of the food
     */
    public void setFiber(double fiber) {
        this.fiber = fiber;
    }


}
