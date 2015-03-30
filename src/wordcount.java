///////////////////////////////////////////////////////////////
///Name: Fenil Patel 001-15-9661                            ///
///CSC 3410                                                 ///
///Spring 2015                                              ///
///Homework 2: wordcount.java                               ///
///Count lines,words,vowels,chars,sentences and punctuation ///
///Submitted: 01/021/2015                                   ///
///////////////////////////////////////////////////////////////

/* The purpose of this program is to count the number of lines, words, vowels, characters, sentences and punctuation marks in a text file that is inputted/defined by the user. The algorithm used in thisprogram is a simple while loop counter. The while loop first checks if there is a line to be read in the file inputted. Second, we define a regex pattern that we will match in the file. Third, if the pattern matches any character, words or symbols in the file it increase the corresponding counter by 1. The loop continues until there are no more lines to be read in the file. To use this program the user must enter the text file location when prompted by the scanner. If the file is not valid they will be prompted with "File does not exists error". After the file has been inputted, the algorithm consisting of the while loop will run and produce an output indiciating the amount of lines, words, vowels, characters, sentences and punctuation marks and also produce an output.txt file with the count information. Only one class was used in this program consisting of the main method. The class first create a output text file and then prompts the users to enter name of the text file to be examined. The algorithm uses regex pattern matching and a while loop counter to count the number of lines, words, vowels, characters, sentences and punctuations in the text file. It then writes the values to the output.txt file and saves it in the directory of the source file. Afterwards, it prints out the same result in the interactions pane.
*/

import java.util.Scanner;
import java.io.*;
import java.util.regex.*;

public class wordcount{

    //Main method that counts the lines, words, vowels, characters, sentences and punctuations in the text file.
    public static void main (String [] args){

        //Initiazlies the variables to be used in the program to count line, word, vowels, characters, sentences and punctuation marks and sets them to 0.
        int line_count = 0;
        int word_count = 0;
        int vowels_count = 0;
        int alphanumeric_charcters = 1;
        int sentence_count = 0;
        int punctuation_count = 0;

        //Prompts the user to enter in the file name including file type eg.txt.
        Scanner sc = new Scanner(System.in);
        System.out.println("What is the name of the file?");

        //File object with the data from the file inputted by the user.
        File file = new File(sc.nextLine());

        //close the scanner to read the file name/path.
        sc.close();

        try {

            //Uses the print writer class to output the count information to a file called output.txt. The default save location is directory of the source file.
            PrintWriter output = new PrintWriter("output.txt", "UTF-8");

            try {

                //loads the file into the scanner and reads the lines in the text file.
                Scanner scanner = new Scanner(file);

                //While loop that reads the file from the scanner and counts the amount of lines in file.
                while (scanner.hasNextLine()) {
                    line_count ++;
                    String line = scanner.nextLine();

                    //Uses regex to match/count number of words in the file
                    Pattern word_match = Pattern.compile("\\b\\w+\\b");
                    Matcher word_matcher = word_match.matcher(line);
                    while (word_matcher.find()) {
                        word_count ++;
                    }

                    //Uses regex to match/count the number of vowels in the file.
                    Pattern vowels_match = Pattern.compile("([aeiouAEIOU])");
                    Matcher vowels_matcher = vowels_match.matcher(line);
                    while (vowels_matcher.find()) {
                        vowels_count ++;
                    }

                    //Uses regex to match/count alphanumeric characters in the file.
                    Pattern alphanumeric_pattern = Pattern.compile("([a-zA-z])");
                    Matcher alphanumeric_matcher = alphanumeric_pattern.matcher(line);
                    while (alphanumeric_matcher.find()) {
                        alphanumeric_charcters ++;
                    }

                    //Uses regex to match/count the number of sentences in the file.
                    Pattern sentence_pattern = Pattern.compile("[.?!]+");
                    Matcher sentence_matcher = sentence_pattern.matcher(line);
                    while (sentence_matcher.find()) {
                        sentence_count ++;
                    }

                    //Uses regex to match.count punctuation marks in the file.
                    Pattern punctuation_pattern = Pattern.compile("[':,!-().?\";]");
                    Matcher punctuation_matcher = punctuation_pattern.matcher(line);
                    while (punctuation_matcher.find()) {
                        punctuation_count ++;
                    }
                }

                //Prints the count values to the Output.txt file.
                output.println("There are " + line_count + " lines in the file.");
                output.println("There are " + word_count + " words in the file.");
                output.println("There are " + vowels_count + " vowels in the file.");
                output.println("There are " + alphanumeric_charcters + " characters in the file.");
                output.println("There are " + sentence_count + " sentences in the file.");
                output.println("There are " + punctuation_count + " punctuations in the file.");

                //Closes the output file so it cannot be appended or modified.
                output.close();

                //Prints out the number of lines in the file in the interactions pane.
                System.out.println("There are " + line_count + " lines in the file.");
                System.out.println("There are " + word_count + " words in the file.");
                System.out.println("There are " + vowels_count + " vowels in the file.");
                System.out.println("There are " + alphanumeric_charcters + " characters in the file.");
                System.out.println("There are " + sentence_count + " sentences in the file.");
                System.out.println("There are " + punctuation_count + " punctuations in the file.");

            }

      /*Catches exception and informs the user that file does not exists
       * and terminates the program. */
            catch (FileNotFoundException e) {
                System.out.println("File Does not exsist. Terminating Program.");
            }
        }

    /* Catches the exception and informs the user that file was not created and
     * terminates the program. */
        catch (IOException e) {
            System.out.println("File was not created.");
        }
    }
}