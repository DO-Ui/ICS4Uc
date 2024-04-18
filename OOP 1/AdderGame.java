/**
 * @file AdderGame.java
 * @brief This Java file describes the AdderGame class used in OOP1.
 */

public class AdderGame {

    private int points;

    // Constructor
    public AdderGame() {
        points = 0;
    }

    /**
     * @brief This method returns the current points of the player
     * @return The current points of the player
     */
    public int getPoints() {
        return points;
    }

    /**
     * @brief This method adds points to the player's total
     * @param points The number of points to add
     */
    public void roundWin(int points) {
        this.points += points;
    }

    /**
     * @brief This method generates a random number between 0 and 20
     * @return A random number between 0 and 20
     */
    public int getRandomNumber() {
        return (int) (Math.random() * 20);
    }

}