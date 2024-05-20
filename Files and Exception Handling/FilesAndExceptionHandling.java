/**
 * @file FilesAndExceptionHandling.java
 * @brief This Java application is for the Files and Exception handling assignment.
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
 
 /* 
   * Ryan Yang
   * ICS4Uc
   * May 17th, 2024
   */
 
 /**
  * This is the class which contains all the functions for the Files and Exception handling assignment.
  */
public class FilesAndExceptionHandling {
	public static Scanner input = new Scanner(System.in);

	// E: 1, 2, 4, 5
	public static void main(String[] args) {

		boolean programRunning = true;
		// Main loop to prompt user for program selection
		while (programRunning) {

			System.out.println("Welcome to the Java Program Selector:");
			System.out.println("1. Word Count Application");
			System.out.println("2. Word Stats Application (Unsorted)");
			System.out.println("3. Word Stats Application (Sorted)");
			System.out.println("4. Mad Libs Application");
			System.out.println("5. Merge Files Application");
			System.out.println("6. Exit");
			System.out.print("Which program would you like to run (1-6): ");

			int program = input.nextInt();

			// Switch case
			switch (program) {
				case 1:
					wordCount();
					break;
				case 2:
					wordStats(false);
					break;
				case 3:
					wordStats(true);
					break;
				case 4:
					madLibs();
					break;
				case 5:
					mergeFiles();
					System.out.println("Files have been merged.");
					break;
				case 6:
					programRunning = false;
					break;
			}

			System.out.println("\n\n\n");

		}
		input.close();
	}

	/**
	 * Q1: This function reads source.txt in the same folder and prints the number of words and the average word length
	 */
	public static void wordCount() {
		File inputFile = new File("source.txt");
		int wordCount = 0;
		int characterCount = 0;
		try {
			BufferedReader fileReader = new BufferedReader(new FileReader(inputFile));
			String line;
			while ((line = fileReader.readLine()) != null) {
				line += "\n";
				char prevChar = ' ';
				for (char c : line.toCharArray()) {
					if ((65 <= c && c <= 90) || (97 <= c && c <= 122)) {
						characterCount++;
					} else if ((65 <= prevChar && prevChar <= 90) || (97 <= prevChar && prevChar <= 122)){
						wordCount++;
					}
					prevChar = c;
				}
			}
			fileReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
		} catch (IOException e) {
			System.out.println("An error occurred while reading the file.");
			System.out.println(e.getMessage());
		}
		System.out.println("Word count: " + wordCount);
		System.out.format("Avg word length: %.2f\n", (double) characterCount / wordCount);
	}


	/**
	 * Q2: Word Stats function reads a file and prints the number of times each word appears in the file
	 */
	public static void wordStats(boolean sorted) {

		Map<String, Integer> wordCount;
		if (sorted) {
			/**
			 * TreeMap is a sorted version of a hashmap, where the keys are sorted in ascending order
			 */
			wordCount = new TreeMap<String, Integer>();
		} else {
		/**
		  * Hashmap allows for key-value pairs, where the key is the word and the value is the number of times the word appears in the file
		  * Hashmaps do not allow duplicate values so it is perfect for unsorted data
		  */
			wordCount = new HashMap<String, Integer>();
		}
		System.out.println("Enter the name of the file: ");
		input.nextLine(); // Clear the buffer
		String fileName = input.nextLine();
		File inputFile = new File(fileName);
		try {
			BufferedReader fileReader = new BufferedReader(new FileReader(inputFile));
			String line;
			while ((line = fileReader.readLine()) != null) {
				line += "\n";
				String word = "";
				for (char c : line.toCharArray()) {
					if (((65 <= c && c <= 90) || (97 <= c && c <= 122)) || c == '\'') {
						word += c;
					} else {
						if (word.length() > 0) {
							word = word.toLowerCase();
							if (wordCount.containsKey(word)) {
								wordCount.put(word, wordCount.get(word) + 1);
							} else {
								wordCount.put(word, 1);
							}
							word = "";
						}
					}
				}
			}
			fileReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
		} catch (IOException e) {
			System.out.println("An error occurred while reading the file.");
			System.out.println(e.getMessage());
		}
		for (String word : wordCount.keySet()) {
			System.out.println(word + ": " + wordCount.get(word));
		}
	}

	/**
	 * Q4: This function emulated Mad-Libs, where the user inputs words to fill in the blanks of a story
	 */
	public static void madLibs() {
		File madlibFile = new File("./MadLibs/story.txt");
		File nounFile = new File("./MadLibs/nouns.txt");
		File verbFile = new File("./MadLibs/verbs.txt");
		try {
			BufferedReader madlibReader = new BufferedReader(new FileReader(madlibFile));
			BufferedReader nounReader = new BufferedReader(new FileReader(nounFile));
			BufferedReader verbReader = new BufferedReader(new FileReader(verbFile));
			
			ArrayList<String> nouns = new ArrayList<String>();
			ArrayList<String> verbs = new ArrayList<String>();
			
			String line;
			while ((line = nounReader.readLine()) != null) {
				nouns.add(line);
			}
			while ((line = verbReader.readLine()) != null) {
				verbs.add(line);
			}
			
			
			String madlib = madlibReader.readLine();
			while (madlib != null) {
				String[] words = madlib.split("[^a-zA-Z'#%]+"); // Split the line by non-alphabetic characters using regex
				for (String word : words) {
					String noun = nouns.get((int) (Math.random() * nouns.size()));
					String verb = verbs.get((int) (Math.random() * verbs.size()));
					if (word.equals("#")) {
						System.out.print(noun + " ");
					} else if (word.equals("%")) {
						System.out.print(verb + " ");
					} else {
						System.out.print(word + " ");
					}
				}
				System.out.println();
				madlib = madlibReader.readLine();
			}
			madlibReader.close();
			nounReader.close();
			verbReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
		} catch (IOException e) {
			System.out.println("An error occurred while reading the file.");
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Q5: Merging two files of sorted integers from low to high into a new file
	 */
	public static void mergeFiles() {
		File file1 = new File("file1.txt");
		File file2 = new File("file2.txt");
		File outputFile = new File("output.txt");

		try {
			BufferedReader file1Reader = new BufferedReader(new FileReader(file1));
			BufferedReader file2Reader = new BufferedReader(new FileReader(file2));
			BufferedWriter outputWriter = new BufferedWriter(new FileWriter(outputFile));

			// Read the first number from each file
			String word1 = readWord(file1Reader);
			String word2 = readWord(file2Reader);
			
			int num1 = Integer.parseInt(word1);
			int num2 = Integer.parseInt(word2);

			// Merge the two files by comparing the first number of each file and writing the smaller number to the output file
			while (!word1.equals("") && !word2.equals("")) {
				if (num1 < num2) {
					outputWriter.write(num1 + " ");
					word1 = readWord(file1Reader);
					if (!word1.equals("")) {
						num1 = Integer.parseInt(word1);
					}
				} else {
					outputWriter.write(num2 + " ");
					word2 = readWord(file2Reader);
					if (!word2.equals("")) {
						num2 = Integer.parseInt(word2);
					}
				}
			}

			// If one file has more numbers than the other file then write the rest of the numbers to the output file
			if (!word1.equals("")) {
				outputWriter.write(num1 + " ");
				while (!word1.equals("")) {
					word1 = readWord(file1Reader);
					if (!word1.equals("")) {
						num1 = Integer.parseInt(word1);
						outputWriter.write(num1 + " ");
					}
				}
			} else if (!word2.equals("")) {
				outputWriter.write(num2 + " ");
				while (!word2.equals("")) {
					word2 = readWord(file2Reader);
					if (!word2.equals("")) {
						num2 = Integer.parseInt(word2);
						outputWriter.write(num2 + " ");
					}
				}
			}

			file1Reader.close();
			file2Reader.close();
			outputWriter.close();

		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
		} catch (IOException e) {
			System.out.println("An error occurred while reading the file.");
			System.out.println(e.getMessage());
		}

	}

	/**
	 * This function reads a word from a file using a BufferedReader
	 * @param reader BufferedReader object
	 * @return The word read from the file
	 */
	public static String readWord(BufferedReader reader) {
		String word = "";
		try {
			int c = reader.read();
			while (c != ' ' && c != -1) {
				word += (char) c;
				c = reader.read();
			}
		} catch (IOException e) {
			System.out.println("An error occurred while reading the file.");
			System.out.println(e.getMessage());
		}
		return word;
	}

}