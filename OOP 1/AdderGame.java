/**
 * @file AdderGame.java
 * @brief This Java file describes the AdderGame class used in OOP1.
 */

 import java.util.Scanner;

public class AdderGame {

    private int points;
    Scanner input;


    // Constructor
    public AdderGame(Scanner input) {
        points = 0;
        this.input = input;
    }

    /**
     * @brief This method returns the current points of the player
     * @return The current points of the player
     */
    public int getPoints() {
        return points;
    }

    /**
     * @brief This method plays a round of the Adder game
     * @return True if the player wants to continue playing, false otherwise
     */
    public boolean playRound() {
        int num1 = getRandomNumber();
        int num2 = getRandomNumber();
        int answer = num1 + num2;

        System.out.format("What is %d + %d? (Enter 999 to exit) ", num1, num2);
        int userAnswer = input.nextInt();
        if (userAnswer == 999) {
            System.out.format("Your score is %d\n", getPoints());
            return false;
        }
        
        if (userAnswer == answer) {
            System.out.println("Correct!");
            roundWin(5);
        } else {
            System.out.println("Incorrect!");
            System.out.print("Wrong answer. Enter another answer: ");
            userAnswer = input.nextInt();
            if (userAnswer == answer) {
                System.out.println("Correct!");
                roundWin(3);
            } else {
                System.out.println("Incorrect!");
                System.out.print("Wrong answer. Enter another answer: ");
                userAnswer = input.nextInt();
                if (userAnswer == answer) {
                    System.out.println("Correct!");
                    roundWin(1);
                } else {
                    System.out.println("Incorrect!");
                    System.out.format("The correct answer was %d\n", answer);
                }
            }
        }
        return true;
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
    private int getRandomNumber() {
        return (int) (Math.random() * 20);
    }

}