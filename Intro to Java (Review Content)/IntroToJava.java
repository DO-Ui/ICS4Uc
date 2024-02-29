/**
 * @file IntroToJava.java
 * @brief This Java application is for the Intro to Java assignment
 */

import java.util.Scanner;
import java.util.HashMap;
import java.util.InputMismatchException;


/* 
 * Ryan Yang
 * ICS4Uc
 * Feb 16, 2024
 */

/**
 * This is the class which contains all the functions for the Intro to Java assignment.
 */
public class IntroToJava {
	private static Scanner input = new Scanner(System.in); // Let other methods use scanner but not other classes outside this file
	
    public static void main(String[] args) {
        // BingoCard



		boolean program_running = true;

		while (program_running) {
	        System.out.println("Welcome to the Java Program Selector!");
	        System.out.println("1. Print a Bingo Card");
	        System.out.println("2. Read the rules of Bingo");
	        System.out.println("3. Draw rectangle");
	        System.out.println("4. Read the rules of RPS");
	        System.out.println("5. Print a TicTacToe board");
	        System.out.println("6. Read the rules of TicTacToe");
	        System.out.println("7. Draw a smiley face");
	        System.out.println("8. Java terms dictionary");
	        System.out.println("9. Exit Program");
	        System.out.print("Select a program to run (1-9): ");

			int program_number;
			
			try {			
		        program_number = input.nextInt();
			} 
			catch (InputMismatchException e) {
				System.out.println("Please enter a number\n\n\n");
				input.nextLine();
				continue;
			}
			
			switch (program_number) {
				case 1:
					bingoProgram();
					break;
				case 2:
					System.out.println("Bingo Card:\n\n1. The Caller randomly pulls a numbered bingo ball.\n\n2. The number is placed on the bingo board and called out.\n\n3. Players look for the called number on their bingo card.\n\n4. If the number is located, it is marked off.\n\n5. Steps 1 to 4 are repeated until a player matches the BINGO pattern.\n\n6. The winning player yells BINGO.");
					break;
				case 3:
					System.out.println("*".repeat(15));
					for (int i = 0; i < 5; i++) {
						System.out.println("*" + " ".repeat(13) + "*");
					}
					System.out.println("*".repeat(15));
					break;
				case 4:
					System.out.println("RPS Rules:\n\nPlayers decide on different hand signals to represent rock, paper, and scissors.\n\nPlayers make a throw at the same time.\n\nThe ");
					break;
				case 5:
					System.out.println("TicTacToe Board:\n\n   |   |   \n-----------\n   | X |   \n-----------\n   |   |   ");
					break;
				case 6:
					System.out.println("Tic Tac Toe Rules\n\nTic Tac Toe is a game for 2 players.\n\n1. A grid of 9 squares is drawn.\n\n2. The first player draws an X in an empty square.\n\n3. The second player draws an O in an empty square.\n\n4. Steps 2 and 3 are repeated until a Tic Tac Pattern is created:\n\tPatterns can be diagonal, horizontal, or vertical.\n5. A winning pattern is completed by drawing a line through the pattern.");
					break;
				case 7:
					System.out.println("    *****\n   *     *\n  * _   _ *\n *  o   o  *\n*     |     *\n*     |     *\n *  \\___/  *\n  *       *\n    *****");
					break;
				case 8:
					javaDictionary();
					break;
				case 9:
					System.out.println("Bye Bye!");
					program_running = false;
					break;
				default:
					System.out.println("Invalid input, try again");
			}
	

	        
			
		}


    }

    
	/**
	 * This function will prompt the user for a word to search for in the java dictionary. It also allows the user to list all the available words.
	 */
	public static void javaDictionary() {
			String data = "Algorithm: A set of steps that outline how to solve a problem.\nArgument: Data passed to a method for processing.\nBytecode: Compiled Java source code.\nClass: The description of an object.\nCode conventions: A set of guidelines for writing an application.\nComment: Text that provides information to the reader of program code.\nComment block: Multiline comments that describe a program, class, or method.\nCompiling: The process where source code is converted to code the computer understands.\nControlling class: The class in an application that contains the main() method.\nEncapsulation: An object-oriented language feature.\nEscape Sequence: A backslash followed by a symbol that together represent a character.\nExecute: To run a program.\nFlowchart: A visual representation of an algorithm.\nImportable: Package code that can be used by an application.\nInheritance: An object-oriented language feature.\nInterpreter: Software that runs each bytecode instruction of a compiled Java program.\nJava application: A package with a controlling class and possibly other classes.\nJava Virtual Machine (Java VM): The Java bytecode interpreter.\nJust-in-time compiler (JIT): Software that converts bytecode to specific machine code.\nLibrary: see Package.\nMachine code: The most basic computer language, which is comprised of just 1s and 0s.\nMethod: A named set of statements that perform a single, well-defined task. A method is always a member of a class.\nObject: A named entity that consists of related data and instructions for performing actions on that data.\nObject-oriented programming (OOP): A systematic, modular approach to developing complex programs.\nOOP: see Object-oriented programming.\nOutput Stream: Sends data to an output device, typically the computer screen.\nPackage: A group of related classes. Also called a library.\nPlatform-independent application: A program that can be run on any computer regardless of operating system or hardware configuration.\nPolymorphism: An object-oriented language feature.\nPseudocode: An algorithm written in a mix of English and program code.\nRun: see Execute.\nSource code: The code typed by a programmer.\nStatement: An instruction in a program.\nString: A set of characters.\nSyntax error: A statement that violates the rules of Java\n";
			String keys[] = data.split(": .*?\n");
			String values[] = data.split(".*?: ");
			// for (int i = 0; i < values.length; i++) {
			// 	System.out.println(values[i]);
			// }
			HashMap<String, String> Dictionary = new HashMap<String, String>(); // Allows for key-value searching

			for (int i = 0; i < keys.length; i++) {
				Dictionary.put(keys[i].trim(), values[i+1].trim());
				// System.out.println(data_bits[i]);
				// System.out.println(data_bits[i+1]);
			}
			boolean dictionary_running = true;
			while (dictionary_running) {
				System.out.println("Use 'list' to see all terms in the dictionary");
				System.out.println("Enter a Java term to look up or type 'exit' to return to the main menu: ");
				String term = input.next();
				if (term.equals("exit")) {
					dictionary_running = false;
				} 
				else if (term.equals("list")) {
					for (String key : Dictionary.keySet()) {
						System.out.println(key);
					}
				}
				else if (Dictionary.containsKey(term)) {
					System.out.println(term + ": " + Dictionary.get(term));
				}
				else {
					System.out.println("Term not found");
				}
			}
			
	}
	
	/**
	 * This program will generate and print a bingo board with randomized numbers
	 */
    public static void bingoProgram() {
        int bingoBoard[][] = new int[5][5];
        for (int i = 0; i < bingoBoard[0].length; i++) {
            int[] randomNumbers = generateUniqueRandomNumbers(i*15+1, i*15+15, 5);
            for (int j = 0; j < bingoBoard[i].length; j++) {
                bingoBoard[j][i] = randomNumbers[j];
            }
        }

        printBingoCard(bingoBoard);
    }

	/**
	 * This is a helper function to print out the current bingo board
	 * @param bingoBoard The current bingo board
	 */
    public static void printBingoCard(int bingoBoard[][]) {
        System.out.println("B    I    N    G    O");
        for (int i = 0; i < bingoBoard.length; i++) {
            for (int j = 0; j < bingoBoard[i].length; j++) {
                if (i == 2 && j == 2) { // If the current cell is the center cell, print free space
                    System.out.print("FREE ");
                    continue;
                }
                if (bingoBoard[i][j] < 10 && j != 0) { // If the number is a single digit number, add a space to ensure even spacing
                    System.out.print("  ");
                }
                System.out.print(bingoBoard[i][j] + "   "); // Print the number in the row
                if (bingoBoard[i][j] < 10) { // If the number is a double digit number, add a space to ensure even spacing
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

	/**
	 * This is a helper function to generate random numbers within a range
	 * @param min The minimum value in the range
	 * @param max The maximum value in the range
	 * @param count The number of values to be generated
	 * @return Returns an array of randomized integers
	 */
    public static int[] generateUniqueRandomNumbers(int min, int max, int count) {
        int[] randomNumbers = new int[max-min+1];
        for (int i = 0; i <= max-min; i++) {
            randomNumbers[i] = min+i;
        }

        for (int i = 0; i < max-min; i++) {
            int randomIndex = (int) (Math.random() * i);
            int temp = randomNumbers[i];
            randomNumbers[i] = randomNumbers[randomIndex]; // Swap the index with another random value in the array
            randomNumbers[randomIndex] = temp; // Reset the value at the random index to the original value
        }
    
        return randomNumbers;
    }

}