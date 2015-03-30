///////////////////////////////////////////////////////////////
///Name: Fenil Patel 001-15-9661                            ///
///CSC 3410                                                 ///
///Spring 2015                                              ///
///Homework 1: matrix.java                                  ///
///Multiply Matrices                                        ///
///Submitted: 01/021/2015                                   ///
///////////////////////////////////////////////////////////////

/* The purpose of the program is to prompt the user to input a
 * integer greater than or equal to 50 for the row and column length of a matrix.
 * Next, the matrix elements are assigned with random integer values ranging 1 to 99.
 * Finally, the matrices (array_A & array_B) are multiplied and the result is assigned
 * to elements of a new array (array_C) along with the time for calculation in seconds.
 * The algorithms to multiply matrices consist of 3 nested for loops. For example, the
 * element of the new array would be calculated with the formula
 * array_A(0,0) * array_B(0,0) + array_A(0,1) * array_B(1,0). To calculate the time it
 * takes to multiply the matrices a variable (startTime) is assigned in nano seconds
 * before the multiplication algorithm and a variable (endTime) afterwards. The output
 * is displayed as nano seconds converted into seconds along with a print out of the new
 * matrix (array_C). The data structures used in the program are arrays. To use the program,
 * the user has to input an integer. The algorithm multiplies the matrices and displays
 * the output of the new matrix and the time it took to multiply the matrix. Only one
 * class was used (matrix) to multiply the matrices. */

import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

public class matrix{
    public static void main (String [] args){

        Scanner sc = new Scanner(System.in);

        //Initializes the variables used in the loops.
        Integer user_Input;
        String repeat_Input;

        //Primary loop which multiplies the matrices and ask the user if they want to repeat.
        do{

            /*Prompts the user for the input for the Matrix Dimension that is greater than 50.
            If less is inputted then it prompts user input again. */
            do {
                System.out.println("What is dimension (n) of the Matrix? ((n x n) where n >= 50)");
                user_Input = sc.nextInt();
            }
            while (user_Input < 50);

            //Generates a random integer.
            Random randomValue = new Random();

            //Create two arrays with size inputted by the user.
            int [] [] array_A = new int [user_Input] [user_Input];
            int [] [] array_B = new int [user_Input] [user_Input];
            int [] [] array_C = new int [user_Input] [user_Input];

            //Assigns random values to both Matrices with a number between 1 - 99.
            for(int i = 0; i < user_Input; i++){
                for(int j = 0; j < user_Input; j++){
                    array_A [i][j] = randomValue.nextInt(99) + 1;
                    array_B [i][j] = randomValue.nextInt(99) + 1;
                }
            }

            //Prints out the Array with the random numbers assigned.
            System.out.println("Array A has the elements: " + Arrays.deepToString(array_A));
            System.out.println("Array B has the elements: " + Arrays.deepToString(array_B));

            //Marks the start time. Used nanoTime because its more accurate then currentTimeMillis.
            long startTime = System.nanoTime();

            //For loop that multiplies the matrices.
            for(int i = 0; i < user_Input; i++){
                for(int j = 0; j < user_Input; j++){
                    for(int k = 0; k < user_Input; k++){
                        array_C [i] [j] += array_A [i] [k] * array_B [k] [j];
                    }
                }
            }

            //Marks the stop time.
            long endTime = System.nanoTime();

            //Prints out new array which is the result of multiplication of Array A and Array B.
            System.out.println(" \nArray C has the elements: " + Arrays.deepToString(array_C));

            //Prints out the time it took to mutiply the matrice from nano seconds to seconds. Rounded to 4 decimal places.
            System.out.printf("Elasped time to mutiply matrices: %.4f seconds. %n", ((endTime - startTime)/1000000000.0));

            //Prompts the users to check if they want to repeat the program.
            System.out.println("Would you like to repeat the program? Yes or No?");
            repeat_Input = sc.next();
        }
        while (repeat_Input.equals("Yes"));

    }
}