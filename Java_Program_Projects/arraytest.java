///////////////////////////////////////////////////////////////
///Name: Fenil Patel 001-15-9661                            ///
///CSC 3410                                                 ///
///Spring 2015                                              ///
///Homework 3: arraytest.java                               ///
///Test Array Class                                         ///
///Submitted: 02/21/2015                                    ///
///////////////////////////////////////////////////////////////

/*
 * The purpose of this program is to check if all the constructors and methods in the class arraylist
 * are valid. No specific algorithm was used in order to perform this test. There were two arraylist
 * created using the default and custom constructor. Afterwards, all methods were called to verify
 * they were outputting correctly. To verify methods that did not return values, a if satement was used.
 * The if statement checked if the statements were either true or false and printed out the answer accordingly.
 * The data structure used in the class arraylist was Arrays. To verify that the methods were correct, each
 * one was given the integer argument input. The output was dependent on the method that was being called.
 * Most methods returned an integer value or a boolean value. Please check the arraylist class documentation
 * for a breakdown on the methods. The arraylist class was developed to implement the ArrayList data structure
 * that is found in the java library.
 */

public class arraytest {
    public static void main (String [] args){

        //Creates an array list with the size of 10 using the default conscturctor.
        arraylist a1 = new arraylist();

        //Creates an array list
        arraylist a2 = new arraylist(20);

        //Adds an object (integer in this case) to the end of the array list.
        a1.add(14);
        a2.add(8);

        //Verifies that the method a1.add(14) was successfull.
        System.out.println("The element at index 10 in arralylist a1 is: " + a1.get(a1.getSize()-1) + ". Addition method a1.add(14) was sucessful.");

        //Verifies that the method a2.add(8) was successfull.
        System.out.println("The element at index 25 in arralylist a2 is: " + a2.get(a2.getSize()-1) + ". Addition method a2.add(8) was sucessful.");

        //Adds an object at a given index location.
        a1.add(10, 24);
        a2.add(25, 16);

        //Calls the get method to verify a1 has 24 at index 10 and a2 has 16 at index 25.
        System.out.println("The element at index 10 in arralylist a1 is: " + a1.get(10) + ". Addition method a1.add(10, 24) was sucessful.");
        System.out.println("The element at index 25 in arralylist a2 is: " + a2.get(25) + ". Addition method a2.add(25, 16) was sucessful.");

        //Prints out the getSize method to verify method works. a1 and a2 should be both 2.
        System.out.println(a1.getSize());
        System.out.println(a2.getSize());

        //Checks if the arraylist is empty or not. Both a1 and a2 should be false.
        System.out.println(a1.isEmpty());
        System.out.println(a1.isEmpty());

        //Calls the isIn method to check if the given objects are in the array list.
        //Arraylist a1 should be true and a2 should be false.
        System.out.println(a1.isIn(24));
        System.out.println(a2.isIn(10));

        //Calls the find method to determine the first location of the object.
        //Arraylist a1 should be index 10 for 24 and a2 should be index 25 for 16.
        System.out.println(a1.find(24));
        System.out.println(a2.find(16));

        //Calls the remove method to remove the first occurence of an object in the arraylist.
        a1.remove(14);
        a2.remove(8);

        //Verifies that object 14 was removed from a1 and object 8 was removed from a2.
        if(!a1.isIn(14))
            System.out.println("The integer 14 was successfully removed from the arraylist a1.");
        if(!a1.isIn(8))
            System.out.println("The integer 8 was successfully removed from the arraylist a2.");

    }
}