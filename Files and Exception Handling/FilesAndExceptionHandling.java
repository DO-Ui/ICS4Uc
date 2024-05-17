/**
 * @file OOP3.java
 * @brief This Java application is for the OOP 2 assignment.
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;
 
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

    // E: 1,2, 4, 5
    public static void main(String[] args) {
        wordStats();

    }

    /**
     * This function reads source.txt in the same folder and prints the number of words and the average word length
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


    public static void wordStats() {
        HashMap<String, Integer> wordCount = new HashMap<String, Integer>();
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
                    if ((65 <= c && c <= 90) || (97 <= c && c <= 122)) {
                        word += c;
                    } else {
                        if (word.length() > 0) {
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


}