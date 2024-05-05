
/**
 * @file Num.java
 * @brief This Java file describes the Num class used in OOP3.
 */

/**
 * This class is used to extract digits from a number
 */

public class Num {
    private int number;

    /**
     * @brief Constructor for the Num class
     * @param number The number to store
     */
    public Num(int number) {
        setNumber(number);
    }

    /**
     * @brief This method returns the ones digit of the number
     * @return The ones digit of the number
     */
    public int onesDigit() {
        return this.number % 10;
    }

    /**
     * @brief This method returns the tens digit of the number
     * @return The tens digit of the number
     */
    public int tensDigit() {
        return (this.number / 10) % 10;
    }

    /**
     * @brief This method returns the hundreds digit of the number
     * @return The hundreds digit of the number
     */
    public int hundredsDigit() {
        return (this.number / 100) % 10;
    }

    /**
     * @brief This method returns the nth digit of the number
     * @param n The digit to extract
     * @return The nth digit of the number
     */
    public int nthDigit(int n) {
        return (this.number / (int) Math.pow(10, n-1)) % 10;
    }

    /**
     * @brief This method returns the whole number
     * @return The whole number
     */
    public int getNumber() {
        return this.number;
    }

    /**
     * @brief This method sets the number
     * @param number The number to set
     */
    public void setNumber(int number) {
        this.number = number;
    }

}
